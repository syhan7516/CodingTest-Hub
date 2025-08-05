import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

// 좌표 클래스
class Point {
    int y;
    int x;
    int hp;

    public Point(int y, int x, int hp) {
        this.y = y;
        this.x = x;
        this.hp = hp;
    }
}

public class Main {

    // 결과, 위험 구역 수, 죽음 구역 수
    public static int answer, dangerAreaCount, deadAreaCount;

    // 맵
    public static int[][] map;

    // 방문 여부 배열
    public static boolean[][] visited;

    // 우선 순위 큐
    public static PriorityQueue<Point> queue;

    // 방향 벡터
    public static int[] dy = {0,1,0,-1};
    public static int[] dx = {1,0,-1,0};

    // 구역 표시 메서드
    public static void markOnMap(int y1, int x1, int y2, int x2, int type) {
        for(int rowIndex = Math.min(y1,y2); rowIndex <= Math.max(y1,y2); rowIndex++) {
            for(int colIndex = Math.min(x1,x2); colIndex <= Math.max(x1,x2); colIndex++) {
                map[rowIndex][colIndex] = type;
            }
        }
    }

    // 맵 탐색 메서드
    public static void solve() {

        // 우선 순위 큐 생성
        queue = new PriorityQueue<>(
                (a, b) -> a.hp - b.hp
        );

        // 방문 여부 배열 생성
        visited = new boolean[501][501];

        // 시작점 처리
        queue.offer(new Point(0, 0, 0));

        // 탐색 수행
        while(!queue.isEmpty()) {

            // 기준 위치 확인
            Point point = queue.poll();

            // 목적지인 경우
            if(point.y == 500 && point.x == 500) {
                answer = point.hp;
                return;
            }

            // 이미 방문한 경우
            if(visited[point.y][point.x]) continue;

            // 방문 처리
            visited[point.y][point.x] = true;

            // 이동 가능한 방향 확인
            for(int dir=0; dir<4; dir++) {
                int nextY = point.y + dy[dir];
                int nextX = point.x + dx[dir];

                // 범위 확인
                if(nextY<0 || nextY>500 || nextX<0 || nextX>500) continue;

                // 이미 방문했거나, 죽음 구역인 경우
                if(visited[nextY][nextX] || map[nextY][nextX] == -1) continue;

                // 구역 저장
                queue.offer(new Point(nextY, nextX, point.hp + map[nextY][nextX]));
            }
        }

        answer = -1;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        // 맵 생성
        map = new int[501][501];

        // 위험 구역 수 입력
        dangerAreaCount = Integer.parseInt(br.readLine());

        // 위험 구역 정보 입력
        for(int index=0; index<dangerAreaCount; index++) {
            st = new StringTokenizer(br.readLine());
            int startY = Integer.parseInt(st.nextToken());
            int startX = Integer.parseInt(st.nextToken());
            int endY = Integer.parseInt(st.nextToken());
            int endX = Integer.parseInt(st.nextToken());
            markOnMap(startY, startX, endY, endX, 1);
        }

        // 죽음 구역 수 입력
        deadAreaCount = Integer.parseInt(br.readLine());

        // 죽음 구역 정보 입력
        for(int index=0; index<deadAreaCount; index++) {
            st = new StringTokenizer(br.readLine());
            int startY = Integer.parseInt(st.nextToken());
            int startX = Integer.parseInt(st.nextToken());
            int endY = Integer.parseInt(st.nextToken());
            int endX = Integer.parseInt(st.nextToken());
            markOnMap(startY, startX, endY, endX, -1);
        }

        // 맵 탐색
        solve();

        // 결과 출력
        System.out.println(answer);
    }
}