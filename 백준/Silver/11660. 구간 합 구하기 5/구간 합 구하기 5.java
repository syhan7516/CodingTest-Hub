import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.*;

public class Main {

    // 크기, 횟수
    public static int boardSize, testcase;
    // 범위
    public static int startX, startY, endX, endY;
    // 행렬
    public static int board[][];
    // 누적합 배열
    public static int DP[][];

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        // 보드 크기, 횟수 입력
        st = new StringTokenizer(br.readLine());
        boardSize = Integer.parseInt(st.nextToken());
        testcase = Integer.parseInt(st.nextToken());

        // 보드 만들기
        board = new int[boardSize+1][boardSize+1];

        // 누적합 배열 만들기
        DP = new int[boardSize+1][boardSize+1];

        // 보드 정보 입력
        for(int a=1; a<=boardSize; a++) {
            st = new StringTokenizer(br.readLine());
            for(int b=1; b<=boardSize; b++) {
                board[a][b] = Integer.parseInt(st.nextToken());
                DP[a][b] = DP[a][b-1]+board[a][b];
            }
        }

        // 회수 만큼 수행
        for (int t=0; t<testcase; t++) {

            // 결과
            int result = 0;

            // 범위 입력
            st = new StringTokenizer(br.readLine());
            startX = Integer.parseInt(st.nextToken());
            startY = Integer.parseInt(st.nextToken());
            endX = Integer.parseInt(st.nextToken());
            endY = Integer.parseInt(st.nextToken());

            // 범위 합 구하기
            for (int idx=startX; idx<=endX; idx++) {
                result = result+(DP[idx][endY]-DP[idx][startY-1]);
            }

            // 결과 저장
            sb.append(result+"\n");
        }
        
        // 결과 출력
        System.out.println(sb.toString());
    }
}