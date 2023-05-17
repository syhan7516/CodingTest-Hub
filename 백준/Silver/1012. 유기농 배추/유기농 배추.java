import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    // 가로, 세로, 배추 개수 입력
    public static int row, col, cnt;
    // 땅
    public static int ground[][];
    // 방문 여부
    public static boolean visited[][];
    // 방향 벡터
    public static int dy[] = {0,-1,0,1};
    public static int dx[] = {1,0,-1,0};

    // dfs
    static void dfs(int a, int b) {

        for(int dir=0; dir<4; dir++) {
            int nextY = a+dy[dir];
            int nextX = b+dx[dir];

            // 범위 확인
            if(nextY<0 || nextY>row-1 || nextX<0 || nextX>col-1)
                continue;
            if(visited[nextY][nextX] || ground[nextY][nextX]==0)
                continue;

            // 탐색 진행
            visited[nextY][nextX] = true;
            dfs(nextY,nextX);
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        // 테스트 케이스 수 입력
        int caseNum = Integer.parseInt(br.readLine());

        // 케이스 수만큼 수행
        for(int caseIdx=0; caseIdx<caseNum; caseIdx++) {

            // 가로, 세로, 배추 개수 입력
            st = new StringTokenizer(br.readLine());
            row = Integer.parseInt(st.nextToken());
            col = Integer.parseInt(st.nextToken());
            cnt = Integer.parseInt(st.nextToken());

            // 땅 만들기
            ground = new int[row][col];
            visited = new boolean[row][col];

            // 배추 위치 입력
            for(int c=0; c<cnt; c++) {
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                ground[a][b] = 1;
            }

            // 지렁이 심기
            int result = 0;
            for(int a=0; a<row; a++) {
                for(int b=0; b<col; b++) {
                    if(ground[a][b]==1 && !visited[a][b]) {
                        dfs(a,b);
                        result++;
                    }
                }
            }

            // 결과 저장
            sb.append(result+"\n");
        }

        // 결과 출력
        System.out.println(sb.toString());
    }
}