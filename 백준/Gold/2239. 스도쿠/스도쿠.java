import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    // 결과
    public static String answer;

    // 보드
    public static int[][] board;

    // 가로, 세로, 3*3 숫자 방문 여부 배열
    public static boolean[][] visitRow, visitCol, visitSquare;

    // 결과 저장 메서드
    public static void save() {
        StringBuilder sb = new StringBuilder();
        for(int rowIndex=0; rowIndex<9;rowIndex++) {
            for(int colIndex=0; colIndex<9; colIndex++) {
                sb.append(board[rowIndex][colIndex]);
            }
            sb.append("\n");
        }

        answer = sb.toString();
    }

    // 탐색 메서드
    public static void solve(int position) {

        // 보드를 모두 채운 경우
        if(position >= 81) {

            // 결과 저장
            save();

            // 결과 출력
            System.out.println(answer);
            System.exit(0);
        }

        // 확인 위치
        int currentRow = position / 9;
        int currentCol = position % 9;

        // 이미 숫자가 있는 경우
        if(board[currentRow][currentCol] > 0) {
            solve(position + 1);
        }

        // 숫자가 없는 경우
        else {
            for(int num=1; num<=9; num++) {

                // 가로, 세로, 3*3 확인
                if(visitRow[currentRow][num]) continue;
                if(visitCol[currentCol][num]) continue;
                if(visitSquare[3*(currentRow/3)+(currentCol/3)][num]) continue;

                // 숫자 선택
                visitRow[currentRow][num] = true;
                visitCol[currentCol][num] = true;
                visitSquare[3*(currentRow/3)+(currentCol/3)][num] = true;
                board[currentRow][currentCol] = num;

                // 이동
                solve(position + 1);

                // 숫자 제거
                visitRow[currentRow][num] = false;
                visitCol[currentCol][num] = false;
                visitSquare[3*(currentRow/3)+(currentCol/3)][num] = false;
                board[currentRow][currentCol] = 0;
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 보드 생성
        board = new int[9][9];

        // 방문 여부 배열 생성
        visitRow = new boolean[9][10];
        visitCol = new boolean[9][10];
        visitSquare = new boolean[9][10];

        // 보드 정보 입력
        for(int rowIndex=0; rowIndex<9; rowIndex++) {
            String line = br.readLine();
            for(int colIndex=0; colIndex<9; colIndex++) {

                // 입력
                board[rowIndex][colIndex] = line.charAt(colIndex) - '0';

                // 방문 여부
                visitRow[rowIndex][board[rowIndex][colIndex]] = true;
                visitCol[colIndex][board[rowIndex][colIndex]] = true;
                visitSquare[3*(rowIndex/3)+(colIndex/3)][board[rowIndex][colIndex]] = true;
            }
        }

        // 탐색
        solve(0);
    }
}