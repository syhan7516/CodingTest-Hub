import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    // 크기
    public static int size;

    // 보드
    public static int[][] board;

    // DP 배열
    public static long[][][] DP;

    // 확인
    public static long solve() {

        // 도착 지점이 막혀있는 경우
        if(board[size][size] == 1) return 0;

        // DP 배열 생성
        DP = new long[size+1][size+1][3];

        // 초기화
        DP[1][2][0] = 1;

        // 수행
        for(int rowIndex=1; rowIndex<=size; rowIndex++) {
            for(int colIndex=3; colIndex<=size; colIndex++) {

                // ' - ' 막혀있는 경우
                if(board[rowIndex][colIndex] == 1) continue;

                // 가로
                DP[rowIndex][colIndex][0] = DP[rowIndex][colIndex-1][0] + DP[rowIndex][colIndex-1][2];

                // 가장 위인 경우
                if(rowIndex == 1) continue;

                // 세로
                DP[rowIndex][colIndex][1] = DP[rowIndex-1][colIndex][1] + DP[rowIndex-1][colIndex][2];

                // - \, / -
                if(board[rowIndex-1][colIndex] == 1 || board[rowIndex][colIndex-1] == 1) continue;

                // 대각선
                DP[rowIndex][colIndex][2] = DP[rowIndex-1][colIndex-1][0] + DP[rowIndex-1][colIndex-1][1] + DP[rowIndex-1][colIndex-1][2];
            }
        }

        return DP[size][size][0] + DP[size][size][1] + DP[size][size][2];
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        // 크기 입력
        size = Integer.parseInt(br.readLine());

        // 보드 생성
        board = new int[size+1][size+1];

        // 보드 정보 입력
        for(int rowIndex=1; rowIndex<=size; rowIndex++) {
            st = new StringTokenizer(br.readLine());
            for(int colIndex=1; colIndex<=size; colIndex++) {
                board[rowIndex][colIndex] = Integer.parseInt(st.nextToken());
            }
        }

        // 결과 출력
        System.out.println(solve());
    }
}