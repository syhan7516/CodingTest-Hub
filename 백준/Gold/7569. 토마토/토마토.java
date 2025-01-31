import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

// 위치 클래스
class Point {
    int f;
    int y;
    int x;

    public Point(int f, int y, int x) {
        this.f = f;
        this.y = y;
        this.x = x;
    }
}

public class Main {

    // 결과, 가로, 세로, 층, 토마토 개수
    public static int answer, rowSize, colSize, floorSize, tomatoCount;

    // 상자
    public static int box[][][];

    // 익은 토마토 위치 저장 큐
    public static Queue<Point> queue;

    // 방향 벡터
    public static int df[] = {1,-1,0,0,0,0};
    public static int dy[] = {0,0,0,1,0,-1};
    public static int dx[] = {0,0,1,0,-1,0};

    // 토마토 확인 메서드
    public static void solve() {

        while(!queue.isEmpty()) {

            int size = queue.size();

            while(size-->0) {

                // 익은 토마토
                Point point = queue.poll();

                // 방향 확인
                for(int dir=0; dir<6; dir++) {

                    int nextF = point.f+df[dir];
                    int nextY = point.y+dy[dir];
                    int nextX = point.x+dx[dir];

                    // 범위를 벗어난 경우
                    if(nextF<0 || nextF>floorSize-1 || nextY<0 || nextY>rowSize-1 || nextX<0 || nextX>colSize-1)
                        continue;

                    // 익은 토마토이거나 아무것도 없는 경우
                    if(box[nextF][nextY][nextX]==1 || box[nextF][nextY][nextX]==-1) continue;

                    // 안익은 토마토 처리
                    box[nextF][nextY][nextX] = 1;
                    queue.add(new Point(nextF,nextY,nextX));
                    tomatoCount--;
                }
            }

            answer++;
        }

        if(tomatoCount!=0)
            answer = -1;
        else answer--;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        // 가로, 세로, 층 입력
        st = new StringTokenizer(br.readLine());
        colSize = Integer.parseInt(st.nextToken());
        rowSize = Integer.parseInt(st.nextToken());
        floorSize = Integer.parseInt(st.nextToken());

        // 상자 생성
        box = new int[floorSize][rowSize][colSize];

        // 위치 저장 큐 생성
        queue = new LinkedList<>();

        // 상자 정보 입력
        for(int floor=0; floor<floorSize; floor++) {
            for(int rowIndex=0; rowIndex<rowSize; rowIndex++) {
                st = new StringTokenizer(br.readLine());
                for(int colIndex=0; colIndex<colSize; colIndex++) {
                    box[floor][rowIndex][colIndex] = Integer.parseInt(st.nextToken());

                    if(box[floor][rowIndex][colIndex]==0) {
                        tomatoCount++;
                    }

                    if(box[floor][rowIndex][colIndex]==1) {
                        queue.add(new Point(floor,rowIndex,colIndex));
                    }
                }
            }
        }

        // 토마토 확인
        answer = 0;
        solve();

        // 결과 출력
        System.out.println(answer);
    }
}