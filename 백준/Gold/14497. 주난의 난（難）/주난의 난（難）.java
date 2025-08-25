import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

// 위치 클래스
class Point {
    int y;
    int x;
    int time;

    public Point(int y, int x, int time) {
        this.y = y;
        this.x = x;
        this.time = time;
    }
}

public class Main {

    // 결과, 가로, 세로 크기
    public static int answer, rowSize, colSize;

    // 시작 위치, 목표 위치
    public static int startY, startX, endY, endX;

    // 교실 배열
    public static char[][] room;

    // 방문 여부 배열
    public static boolean[][] visited;

    // 방향 벡터
    public static int[] dy = {0,1,0,-1};
    public static int[] dx = {1,0,-1,0};

    // 탐색 메서드
    public static void solve() {

        // 방문 여부 배열 생성
        visited = new boolean[rowSize+1][colSize+1];

        // 시간 기준 우선 순위 큐 생성
        PriorityQueue<Point> queue = new PriorityQueue<>(
                (a, b) -> a.time - b.time
        );

        // 시작 지점 처리
        queue.offer(new Point(startY, startX, 1));

        // 탐색 수행
        while(!queue.isEmpty()) {

            // 확인 위치
            Point point = queue.poll();

            // 이미 방문한 경우
            if(visited[point.y][point.x]) continue;

            // 목표 지점인 경우
            if(point.y == endY && point.x == endX) {
                answer = point.time;
                return;
            }

            // 방문 처리
            visited[point.y][point.x] = true;

            // 이동 가능한 방향 확인
            for(int dir=0; dir<4; dir++) {
                int nextY = point.y + dy[dir];
                int nextX = point.x + dx[dir];

                // 범위 확인
                if(nextY<1 || nextY>rowSize || nextX<1 || nextX>colSize) continue;

                // 방문 여부 확인
                if(visited[nextY][nextX]) continue;

                // 이동 - 친구
                if(room[nextY][nextX] == '1') {
                    queue.offer(new Point(nextY, nextX, point.time + 1));
                }
                // 이동 - 빈 곳
                else queue.offer(new Point(nextY, nextX, point.time));
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        // 가로, 세로 크기 입력
        st = new StringTokenizer(br.readLine());
        rowSize = Integer.parseInt(st.nextToken());
        colSize = Integer.parseInt(st.nextToken());

        // 교실 생성
        room = new char[rowSize+1][colSize+1];

        // 시작, 목표 지점 입력
        st = new StringTokenizer(br.readLine());
        startY = Integer.parseInt(st.nextToken());
        startX = Integer.parseInt(st.nextToken());
        endY = Integer.parseInt(st.nextToken());
        endX = Integer.parseInt(st.nextToken());

        // 교실 정보 입력
        for(int rowIndex=1; rowIndex<=rowSize; rowIndex++) {
            String line = br.readLine();
            for(int colIndex=1; colIndex<=colSize; colIndex++) {
                room[rowIndex][colIndex] = line.charAt(colIndex-1);
            }
        }

        // 탐색
        solve();

        // 결과 출력
        System.out.println(answer);
    }
}