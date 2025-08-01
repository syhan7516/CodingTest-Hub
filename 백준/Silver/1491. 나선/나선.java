import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    // 결과
    public static int[] answer = {-1,-1};

    // 세로, 가로
    public static int colSize, rowSize;

    // 맵 배열
    public static boolean[][] visited;

    // 방향 벡터
    public static int[] dy = {0,-1,0,1};
    public static int[] dx = {1,0,-1,0};

    // 방문 여부 확인 메서드
    public static boolean visited(int y, int x) {
        return visited[y][x];
    }

    // 범위 확인 메서드
    public static boolean isNotRangeInMap(int y, int x) {
        return y<0 || y>rowSize-1 || x<0 || x>colSize-1;
    }

    // 맵 탐색 수행 메서드
    public static void solve() {

        // 시작 지점
        int dir = 0;
        int currentY = rowSize-1;
        int currentX = 0;
        visited[currentY][currentX] = true;
        int visitCount = 1;
        int targetVisitCount = rowSize * colSize;

        while(visitCount<targetVisitCount) {

            // 다음 이동 방향
            int nextY = currentY + dy[dir];
            int nextX = currentX + dx[dir];

            // 범위 확인
            if(isNotRangeInMap(nextY,nextX) || visited(nextY,nextX)) {

                // 방향 전환
                dir++;
                if(dir==4) dir = 0;
                continue;
            }

            // 다음 칸으로 이동
            visited[nextY][nextX] = true;
            currentY = nextY;
            currentX = nextX;
            visitCount++;
        }

        // 결과 저장
        answer[0] = currentX;
        answer[1] = rowSize-1-currentY;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        // 세로, 가로 크기 입력
        st = new StringTokenizer(br.readLine());
        colSize = Integer.parseInt(st.nextToken());
        rowSize = Integer.parseInt(st.nextToken());

        // 맵 생성
        visited = new boolean[rowSize][colSize];

        // 맵 탐색 수행
        solve();

        // 결과 출력
        System.out.println(answer[0]+" "+answer[1]);
    }
}