import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    // 값 저장 배열
    public static int DP[][][];

    // 확인
    public static int solve(int a, int b, int c) {

        if(a<=0 || b<=0 || c<=0)
            return 1;

        if(a>20 || b>20 || c>20) {
            if(DP[20][20][20] != -1) return DP[a][b][c] = DP[20][20][20];
            else return DP[a][b][c] = solve(20,20,20);
        }

        if(a<b && b<c) {

            if(DP[a][b][c] != -1) return  DP[a][b][c];
            else return DP[a][b][c] = solve(a,b,c-1)+solve(a,b-1,c-1)-solve(a,b-1,c);
        }

        if(DP[a][b][c] != -1) return  DP[a][b][c];
        else return DP[a][b][c] = solve(a-1,b,c)+solve(a-1,b-1,c)+solve(a-1,b,c-1)-solve(a-1,b-1,c-1);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        // 값 저장 배열 생성
        DP = new int[51][51][51];
        for(int i=0; i<51; i++) {
            for(int j=0; j<51; j++) {
                for(int k=0; k<51; k++) {
                    DP[i][j][k] = -1;
                }
            }
        }

        while(true) {

            // 세 수 입력
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            // 모두 -1인 경우
            if(a==-1 && b==-1 && c==-1) {
                System.out.println(sb.toString());
                break;
            }

            // 문제 저장
            sb.append("w(").append(a+", ").append(b+", ").append(c).append(") = ");
            sb.append(solve(a,b,c)).append("\n");
        }
    }
}
