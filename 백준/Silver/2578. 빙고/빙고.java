import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    // 빙고판
    public static int board[][] = new int[5][5];
    // 빙고 수, 사회자 번호 수, 결과
    public static int bingo, curNum, result;
    // 빙고 완료 여부
    public static boolean check = false;

    // 가로 체크
    static void garoLine() {
        for(int r=0; r<5; r++) {
            boolean flag = true;
            for(int c=0; c<5; c++) {
                if(board[r][c]!=0) {
                    flag = false;
                    break;
                }
            }
            // 전부 0이었을 경우
            if(flag) {
                bingo++;
            }
        }
    }

    // 세로 체크
    static void ceroLine() {
        for(int r=0; r<5; r++) {
            boolean flag = true;
            for(int c=0; c<5; c++) {
                if(board[c][r]!=0) {
                    flag = false;
                    break;
                }
            }
            // 전부 0이었을 경우
            if(flag) {
                bingo++;
            }
        }
    }

    // 위 -> 아래 대각선
    static void topDownCross() {
        for(int n=0; n<5; n++) {
            if(board[n][n]!=0)
                return;
        }
        bingo++;
    }

    // 아래 -> 위 대각선 체크
    static void bottomUpCross() {
        for(int n=0; n<5; n++) {
            if(board[n][4-n]!=0)
                return;
        }
        bingo++;
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        // 빙고판 정보 입력
        for(int a=0; a<5; a++) {
            st = new StringTokenizer(br.readLine());
            for(int b=0; b<5; b++) {
                board[a][b] = Integer.parseInt(st.nextToken());
            }
        }

        // 사회자 번호 입력
        curNum = 0;
        for(int a=0; a<5; a++) {
            st = new StringTokenizer(br.readLine());
            for(int b=0; b<5; b++) {
                curNum++;
                int num = Integer.parseInt(st.nextToken());

                // 숫자 지우기
                for(int c=0; c<5; c++) {
                    for(int d=0; d<5; d++) {
                        if(board[c][d]==num) {
                            board[c][d]=0;
                            break;
                        }
                    }
                }

                // 빙고 확인
                bingo = 0;

                // 가로 체크
                garoLine();
                // 세로 체크
                ceroLine();
                // 위 -> 아래 대각선 체크
                topDownCross();
                // 아래 -> 위 대각선 체크
                bottomUpCross();

                // 빙고 3개 확인
                if(bingo>=3) {
                    result = curNum;
                    check = true;
                    break;
                }
            }

            // 빙고 성공 여부 확인
            if(check)
                break;
        }

        // 결과 출력
        System.out.println(result);
    }
}