import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    // 마크
    public static char mark;

    // 마크, 턴 횟수, 이긴 선수
    public static int turnCount, winner;

    // 종이
    public static char[][] paper;

    // 종이 배열 생성 및 초기화 메서드
    public static void initPaper() {
        paper = new char[4][4];
        for(int rowIndex=1; rowIndex<4; rowIndex++) {
            for(int colIndex=1; colIndex<4; colIndex++) {
                paper[rowIndex][colIndex] = '-';
            }
        }
    }

    // 승부 결과 확인 메서드
    public static int getGameResult() {
        return winner == 0 ? 0 : winner;
    }

    // 승리 선수 확인 메서드
    public static int getGameWinner() {
        return mark == 'O' ? 1 : 2;
    }

    // 가로 확인
    public static boolean verifyRow() {
        for(int colIndex=1; colIndex<4; colIndex++) {
            if(paper[1][colIndex]=='-') continue;
            if(paper[1][colIndex]==paper[2][colIndex] && paper[2][colIndex]==paper[3][colIndex]) {
                return true;
            }
        }

        return false;
    }

    // 세로 확인
    public static boolean verifyCol() {
        for(int rowIndex=1; rowIndex<4; rowIndex++) {
            if(paper[rowIndex][1]=='-') continue;
            if(paper[rowIndex][1]==paper[rowIndex][2] && paper[rowIndex][2]==paper[rowIndex][3]) {
                return true;
            }
        }

        return false;
    }

    // 대각선 왼쪽 방향 확인
    public static boolean verifyLeftCross() {
        return (paper[1][1]!='-') && (paper[1][1]==paper[2][2]) && (paper[2][2]==paper[3][3]);
    }

    // 대각선 오른쪽 방향 확인
    public static boolean verifyRightCross() {
        return (paper[1][3]!='-') && (paper[1][3]==paper[2][2] && paper[2][2]==paper[3][1]);
    }

    // 대각선 확인
    public static boolean verifyCross() {
        return verifyLeftCross() || verifyRightCross();
    }

    // 승리 여부 확인 메서드
    public static boolean isWin() {
        return verifyRow() || verifyCol() || verifyCross();
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        // 종이 배열 생성 및 초기화
        initPaper();

        // 시작 선수 입력
        int firstPlayer = Integer.parseInt(br.readLine());
        mark = firstPlayer == 1 ? 'O' : 'X';
        winner = 0;

        // 게임 수행
        while(turnCount++<9) {

            // 선택 위치 입력
            st = new StringTokenizer(br.readLine());
            int rowIndex = Integer.parseInt(st.nextToken());
            int colIndex = Integer.parseInt(st.nextToken());

            // 위치 표시
            paper[rowIndex][colIndex] = mark;

            // 승리 여부 확인
            if(isWin()) {
                winner = getGameWinner();
                break;
            }

            // 턴 종료
            mark = mark == 'X' ? 'O' : 'X';
        }

        // 결과 출력
        System.out.println(getGameResult());
    }
}