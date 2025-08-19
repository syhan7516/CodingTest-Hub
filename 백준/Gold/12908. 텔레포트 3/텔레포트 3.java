import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 위치 클래스
class Point {
    int num;
    int y;
    int x;

    public Point(int num, int y, int x) {
        this.num = num;
        this.y = y;
        this.x = x;
    }
}

public class Main {

    // 위치 저장 배열
    public static Point[] points;

    // 거리 배열
    public static long[][] distances;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        // 위치 저장 배열 생성
        points = new Point[8];

        // 시작 위치, 도착 위치 입력
        for(int index=0; index<2; index++) {
            st = new StringTokenizer(br.readLine());
            int y = Integer.parseInt(st.nextToken());
            int x = Integer.parseInt(st.nextToken());
            points[index] = new Point(index, y, x);
        }

        // 텔레포트 정보 입력
        for(int index=2; index<8; index+=2) {
            st = new StringTokenizer(br.readLine());
            int y1 = Integer.parseInt(st.nextToken());
            int x1 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());
            points[index] = new Point(index, y1, x1);
            points[index+1] = new Point(index+1, y2, x2);
        }

        // 거리 배열 생성
        distances = new long[8][8];

        // 각 노드 거리 계산
        for(int fromNode=0; fromNode<8; fromNode++) {
            for(int toNode=0; toNode<8; toNode++) {
                distances[fromNode][toNode]
                        = Math.abs(points[fromNode].y - points[toNode].y)
                        + Math.abs(points[fromNode].x - points[toNode].x);
            }
        }

        // 텔레포트 간 거리 계산
        for(int node=2; node<8; node+=2) {
            distances[node][node+1] = Math.min(distances[node][node+1], 10);
            distances[node+1][node] = distances[node][node+1];
        }

        // 최단 경로 확인
        for(int midNode=0; midNode<8; midNode++) {
            for(int fromNode=0; fromNode<8; fromNode++) {
                for(int toNode=0; toNode<8; toNode++) {
                    distances[fromNode][toNode]
                            = Math.min(distances[fromNode][toNode], distances[fromNode][midNode] + distances[midNode][toNode]);
                }
            }
        }

        // 결과 출력
        System.out.println(distances[0][1]);
    }
}