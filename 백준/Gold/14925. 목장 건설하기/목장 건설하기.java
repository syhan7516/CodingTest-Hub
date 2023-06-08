import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    // 가로, 세로
    public static int row, col;
    // 목장
    public static int farm[][];
    public static int DP[][];
    // 결과
    public static int result;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        // 가로, 세로 입력
        st = new StringTokenizer(br.readLine());
        row = Integer.parseInt(st.nextToken());
        col = Integer.parseInt(st.nextToken());

        // 목장 만들기
        farm = new int[row][col];
        for(int a=0; a<row; a++) {
            st = new StringTokenizer(br.readLine());
            for(int b=0; b<col; b++) {
                farm[a][b] = Integer.parseInt(st.nextToken());
            }
        }

        // 목장 확인
        DP = new int[row+2][col+2];
        for(int a=1; a<=row; a++) {
            for(int b=1; b<=col; b++) {
                // 들판인 경우
                if(farm[a-1][b-1]==0) {
                    DP[a][b] = Math.min(Math.min(DP[a-1][b],DP[a][b-1]),DP[a-1][b-1])+1;
                    result = Math.max(result,DP[a][b]);
                }
            }
        }

        // 결과 출력
        System.out.println(result);
    }
}