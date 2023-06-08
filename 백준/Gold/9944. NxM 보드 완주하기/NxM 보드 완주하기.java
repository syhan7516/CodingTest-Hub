import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    // 보드 가로, 세로, 빈 칸 수
    public static int row, col, blankNum;
    // 보드
    public static char board[][];
    // 방문 여부 배열
    public static boolean visited[][];
    // 결과
    public static int result;
    // 방향 벡터
    public static int dy[] = {0,1,0,-1};
    public static int dx[] = {1,0,-1,0};

    // dfs
    static void dfs(int a, int b, boolean [][] visited, int curNum, int curRes) {

        // 종료 조건
        if(curNum==blankNum) {
            result = Math.min(result,curRes);
            return;
        }

        // 방향 확인
        for(int dir=0; dir<4; dir++) {

            // 이동 횟수
            int cnt = 0;
            int tY = a;
            int tX = b;

            // 방향 이동
            while(true) {
                int nextY = tY+dy[dir];
                int nextX = tX+dx[dir];

                // 보드 범위 확인
                if(nextY<0 || nextY>row-1 || nextX<0 || nextX>col-1)
                    break;
                // 장애물 확인, 방문 확인
                if(visited[nextY][nextX] || board[nextY][nextX]=='*')
                    break;

                visited[nextY][nextX] = true;
                tY = nextY;
                tX = nextX;
                cnt++;
            }

            // 움직임이 없었던 경우
            if(tY==a && tX==b) continue;

                // 움직임이 있었던 경우
            else {
                dfs(tY,tX,visited,curNum+cnt,curRes+1);
                // 방문 여부 변경
                for(int back=1; back<=cnt; back++) {
                    int bA = a+dy[dir]*back;
                    int bB = b+dx[dir]*back;
                    visited[bA][bB] = false;
                }
            }
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        // 테스트 케이스
        int caseIdx = 1;
        String lines = "";

        while((lines=br.readLine())!=null) {

            // 기본 설정
            blankNum = 0;
            result = Integer.MAX_VALUE;

            // 보드 크기 입력
            st = new StringTokenizer(lines);
            row = Integer.parseInt(st.nextToken());
            col = Integer.parseInt(st.nextToken());

            // 보드 생성
            board = new char[row][col];
            for(int a=0; a<row; a++) {
                String line = br.readLine();
                for(int b=0; b<col; b++) {
                    board[a][b] = line.charAt(b);
                    // 빈 칸 개수 체크
                    if(board[a][b]=='.') blankNum++;
                }
            }

            // 보드 확인
            for(int a=0; a<row; a++) {
                for(int b=0; b<col; b++) {
                    // 빈 칸인 경우
                    if(board[a][b]=='.') {
                        visited = new boolean[row][col];
                        visited[a][b] = true;
                        dfs(a,b,visited,1,0);
                        visited[a][b] = false;
                    }
                }
            }

            // 결과 출력
            if(result==Integer.MAX_VALUE)
				System.out.println("Case "+caseIdx+": -1");
		    else
				System.out.println("Case " +caseIdx+": "+result);

            caseIdx++;
        }
    }
}