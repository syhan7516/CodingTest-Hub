import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

// 위치 클래스
class Point implements Comparable<Point> {
    int y;
    int x;
    int coin;

    public Point(int y, int x, int coin) {
        this.y = y;
        this.x = x;
        this.coin = coin;
    }

    @Override
    public int compareTo(Point other) {
        return this.coin - other.coin;
    }
}

public class Main {

    // 결과, 배열 크기
    public static int answer, size;

    // 배열
    public static int[][] arr;

    // 방문 여부 배열
    public static boolean[][] visited;

    // 우선 순위 큐
    public static PriorityQueue<Point> queue;

    // 방향 벡터
    public static int[] dy = {0,1};
    public static int[] dx = {1,0};

    // 배열 탐색 메서드
    public static void solve() {

        // 우선 순위 큐 생성
        queue = new PriorityQueue<>();

        // 방문 여부 배열 생성
        visited = new boolean[size+1][size+1];

        // 시작 지점 처리
        queue.offer(new Point(1,1, 0));

        // 탐색
        while(!queue.isEmpty()) {

            // 현재 위치
            Point point = queue.poll();

            // 도착 지점인 경우
            if(point.y == size && point.x == size) {
                answer = point.coin;
                return;
            }

            // 이미 방문한 경우
            if(visited[point.y][point.x]) continue;

            // 방문 처리
            visited[point.y][point.x] = true;

            // 이동 가능한 위치 확인
            for(int dir=0; dir<2; dir++) {
                int nextY = point.y + dy[dir];
                int nextX = point.x + dx[dir];

                // 이동 조건 확인
                if(point.y == size && point.x < size && dir == 1) continue;
                if(point.y < size && point.x == size && dir == 0) continue;

                // 범위 확인
                if(nextY < 1 || nextY > size || nextX < 1 || nextX > size) continue;

                // 방문 여부 확인
                if(visited[nextY][nextX]) continue;

                // 이동하기 - 버튼 누름
                if(arr[point.y][point.x] <= arr[nextY][nextX]) {
                    int pressCount = arr[nextY][nextX] - arr[point.y][point.x] + 1;
                    queue.offer(new Point(nextY,nextX, point.coin + pressCount));
                }

                // 이동하기 - 버튼 안누름
                else queue.offer(new Point(nextY,nextX, point.coin));
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        // 배열 크기 입력
        size = Integer.parseInt(br.readLine());

        // 배열 생성
        arr = new int[size+1][size+1];

        // 배열 정보 입력
        for(int rowIndex=1; rowIndex<=size; rowIndex++) {
            st = new StringTokenizer(br.readLine());
            for(int colIndex=1; colIndex<=size; colIndex++) {
                arr[rowIndex][colIndex] = Integer.parseInt(st.nextToken());
            }
        }

        // 배열 탐색
        solve();

        // 결과 출력
        System.out.println(answer);
    }
}