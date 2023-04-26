import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

    // 보드 크기, 결과
    public static int boardSize, result;

    // 게임 보드
    public static char board[][];

    // 사탕 방향 벡터
    public static int dx[] = {1,0,-1,0};
    public static int dy[] = {0,1,0,-1};

    // 가로 확인 함수
    static void rowLine() {
        for(int r=0; r<boardSize; r++) {
            // 처음 사탕 개수
            int count = 1;
            // 이전 사탕 색깔
            char preCandy = board[r][0];
            for(int c=1; c<boardSize; c++) {

                // 색깔 여부 확인
                char curCandy = board[r][c];

                // 이전과 색깔이 같은 경우
                if(preCandy==curCandy) {
                    count++;

                    // 마지막일 경우
                    if(c==boardSize-1)
                        // 먹을 수 있는 캔디 갱신
                        result = Math.max(result,count);
                }

                // 이전과 색깔이 다른 경우
                else {

                    // 먹을 수 있는 캔디 갱신
                    result = Math.max(result,count);

                    // 초기화
                    count = 1;
                    preCandy = curCandy;
                }
            }


        }
    }

    // 세로 확인 함수
    static void colLine() {
        for(int c=0; c<boardSize; c++) {
            // 처음 사탕 개수
            int count = 1;
            // 이전 사탕 색깔
            char preCandy = board[0][c];
            for(int r=1; r<boardSize; r++) {

                // 색깔 여부 확인
                char curCandy = board[r][c];

                // 이전과 색깔이 같을 경우
                if(preCandy==curCandy) {
                    count++;

                    // 마지막일 경우
                    if(r==boardSize-1)
                        // 먹을 수 있는 캔디 갱신
                        result = Math.max(result,count);
                }

                // 이전과 색깔이 다른 경우
                else {
                    // 먹을 수 있는 캔디 갱신
                    result = Math.max(result,count);

                    // 초기화
                    count = 1;
                    preCandy = curCandy;
                }
            }

            // 먹을 수 있는 캔디 갱신
            result = Math.max(result,count);
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 게임 보드 크기 입력
        boardSize = Integer.parseInt(br.readLine());

        // 게임 보드판 만들기
        board = new char[boardSize][boardSize];

        // 게임 보드 정보 입력
        for(int a=0; a<boardSize; a++) {
            String line = br.readLine();
            for(int b=0; b<boardSize; b++) {
                board[a][b] = line.charAt(b);
            }
        }

        // 사탕 게임 수행
        for(int a=0; a<boardSize; a++) {
            for(int b=0; b<boardSize; b++) {
                // 현재 캔디
                char candy = board[a][b];
                // 인접 캔디 확인
                for(int dir=0; dir<4; dir++) {
                    int nextY = a+dy[dir];
                    int nextX = b+dx[dir];

                    // 교환 가능 여부 확인 - 보드 범위
                    if(nextX<0 || nextX>boardSize-1 || nextY<0 || nextY>boardSize-1)
                        continue;
                    // 교환 가능 여부 확인 - 캔디 색깔 확인
                    if(candy==board[nextY][nextX])
                        continue;

                    // 캔디 교환
                    char swap = candy;
                    board[a][b] = board[nextY][nextX];
                    board[nextY][nextX] = candy;

                    // 게임판 확인
                    rowLine();
                    colLine();

                    // 사탕 원래 상태로 돌려놓기
                    swap = board[a][b];
                    board[a][b] = board[nextY][nextX];
                    board[nextY][nextX] = swap;
                }
            }
        }

        // 결과 출력
        System.out.println(result);
    }
}