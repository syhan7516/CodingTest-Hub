import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    // 결과
    public static double answer;

    // 행동 횟수
    public static int actCount;

    // 방향 확률
    public static double[] percent;

    // 방문 여부 배열
    public static boolean[][] visited;

    // 방향 벡터
    public static int[] dy = {0,0,1,-1};
    public static int[] dx = {1,-1,0,0};

    // 탐색 수행 메서드
    public static void solve(int row, int col, int count, double probability) {

        // 행동을 모두 취한 경우
        if(count == actCount) {
            answer += probability;
            return;
        }

        // 방향 확인
        for(int dir=0; dir<4; dir++) {
            int nextY = row + dy[dir];
            int nextX = col + dx[dir];

            // 확률이 0인 경우
            if(percent[dir] == 0) continue;

            // 이미 방문한 경우
            if(visited[nextY][nextX]) continue;

            // 이동
            visited[nextY][nextX] = true;
            solve(nextY, nextX, count+1, probability * percent[dir]);
            visited[nextY][nextX] = false;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        // 행동 횟수 입력
        st = new StringTokenizer(br.readLine());
        actCount = Integer.parseInt(st.nextToken());

        // 각 방향 확률 입력
        percent = new double[4];
        for(int dir=0; dir<4; dir++) {
            percent[dir] = Double.parseDouble(st.nextToken()) * 0.01;
        }

        // 방문 여부 배열 생성
        visited = new boolean[30][30];

        // 탐색 수행
        visited[14][14] = true;
        solve(14, 14, 0, 1);

        // 결과 출력
        System.out.println(answer);
    }
}