import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {

    // 가로 검사 함수
    static long rowCheck(int board[][]) {
        int curSum = 0;
        int maxSum = 0;

        for(int row=0; row<100; row++) {
            curSum = 0;
            for(int col=0; col<100; col++) {
                curSum += board[row][col];
            }
            maxSum = Math.max(maxSum,curSum);
        }

        return maxSum;
    }

    // 세로 검사 함수
    static long colCheck(int board[][]) {
        int curSum = 0;
        int maxSum = 0;

        for(int col=0; col<100; col++) {
            curSum = 0;
            for(int row=0; row<100; row++) {
                curSum += board[row][col];
            }
            maxSum = Math.max(maxSum,curSum);
        }

        return maxSum;
    }

    // 위->아래 대각선 검사 함수
    static long topDownCrossCheck(int board[][]) {
        int curSum = 0;
        int maxSum = 0;

        for(int n=0; n<100; n++) {
            curSum += board[n][n];
        }

        return maxSum = curSum;
    }

    // 아래->위 대각선 검사 함수
    static long bottomUpCrowssCheck(int board[][]) {
        int curSum = 0;
        int maxSum = 0;

        for(int n=0; n<100; n++) {
            curSum += board[n][99-n];
        }

        return maxSum = curSum;
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        // 케이스 수만큼 수행
        for(int caseIdx=0; caseIdx<10; caseIdx++) {

            // 케이스 번호 입력
            br.readLine();

            // 보드 만들기
            int board[][] = new int[100][100];

            // 보드 정보 입력
            for(int row=0; row<100; row++) {
                st = new StringTokenizer(br.readLine());
                for(int col=0; col<100; col++) {
                    board[row][col] = Integer.parseInt(st.nextToken());
                }
            }

            // 가로 검사
            long maxRow = rowCheck(board);
            // 세로 검사
            long maxCol = colCheck(board);
            // 대각선 검사
            long topDown = topDownCrossCheck(board);
            long bottomUp = bottomUpCrowssCheck(board);

            // 결과 저장
            long result = Math.max(Math.max(maxRow,maxCol),Math.max(topDown,bottomUp));
            sb.append("#"+(caseIdx+1)+" "+result+"\n");
        }

        // 결과 출력
        System.out.println(sb.toString());
    }
}