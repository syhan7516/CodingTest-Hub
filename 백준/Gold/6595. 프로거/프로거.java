import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

// 노드 클래스
class Edge implements Comparable<Edge> {
    int stone;
    double distance;

    public Edge(int stone, double distance) {
        this.stone = stone;
        this.distance = distance;
    }

    @Override
    public int compareTo(Edge other) {
        return Double.compare(this.distance, other.distance);
    }
}

// 위치 클래스
class Point {
    int y;
    int x;

    public Point(int y, int x) {
        this.y = y;
        this.x = x;
    }
}

public class Main {

    // 결과
    public static double answer;

    // 케이스 번호, 돌의 개수
    public static int caseNum, stoneCount;

    // 돌 위치 배열
    public static Point[] points;

    // 연결 정보 리스트
    public static ArrayList<ArrayList<Edge>> relations;

    // 우선 순위 큐
    public static PriorityQueue<Edge> queue;

    // 탐색 메서드
    public static void solve() {

        // 방문 여부 배열 생성
        boolean[] visited = new boolean[stoneCount];

        // 시작 지점 처리
        queue.offer(new Edge(0, 0));

        // 탐색 수행
        while(!queue.isEmpty()) {

            // 현재 위치
            Edge edge = queue.poll();

            // 목표 지점인 경우
            if(edge.stone == 1) {
                answer = edge.distance;
                return;
            }

            // 이미 방문한 경우
            if(visited[edge.stone]) continue;

            // 방문 처리
            visited[edge.stone] = true;

            // 연결 돌 확인
            for(int index=0; index<relations.get(edge.stone).size(); index++) {
                Edge connectedEdge = relations.get(edge.stone).get(index);

                // 이미 방문한 경우
                if(visited[connectedEdge.stone]) continue;

                // 탐색 대상 추가
                queue.offer(new Edge(connectedEdge.stone, Math.max(edge.distance, connectedEdge.distance)));
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        // 테스트 케이스 수행
        caseNum = 1;
        while(true) {

            // 돌의 개수 입력
            stoneCount = Integer.parseInt(br.readLine());

            // 돌의 개수가 0개인 경우
            if(stoneCount == 0) break;

            // 시나리오 출력 저장
            sb.append("Scenario #").append(caseNum++).append("\n");

            // 좌표 배열 생성
            points = new Point[stoneCount];

            // 돌 좌표 입력
            for(int index=0; index<stoneCount; index++) {
                st = new StringTokenizer(br.readLine());
                int y = Integer.parseInt(st.nextToken());
                int x = Integer.parseInt(st.nextToken());
                points[index] = new Point(y, x);
            }

            // 연결 정보 리스트 생성
            relations = new ArrayList<>();
            for(int index=0; index<stoneCount; index++) {
                relations.add(new ArrayList<>());
            }

            // 우선 순위 큐 생성
            queue = new PriorityQueue<>();

            // 각 돌 거리 구하기
            for(int from=0; from<points.length; from++) {
                for(int to=0; to<points.length; to++) {
                    if(from == to) continue;
                    Point fromPoint = points[from];
                    Point toPoint = points[to];
                    double distanceY = fromPoint.x - toPoint.x;
                    double distanceX = fromPoint.y - toPoint.y;
                    double distance = Math.sqrt(distanceY * distanceY + distanceX * distanceX);
                    relations.get(from).add(new Edge(to, distance));
                    relations.get(to).add(new Edge(from, distance));
                }
            }

            // 탐색
            answer = Double.MAX_VALUE;
            solve();
            sb.append("Frog Distance = ").append(String.format("%.3f", answer)).append("\n").append("\n");
            br.readLine();
        }

        // 결과 출력
        System.out.println(sb.toString());
    }
}