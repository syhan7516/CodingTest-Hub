import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String args[]) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int N = Integer.parseInt(br.readLine());
        
        long DP[] = new long[N+1];
        
        // 기본 셋팅
        DP[0] = 0;
        DP[1] = 1;
        
        // N까지 확인 
        for (int idx=2; idx<=N; idx++){
            DP[idx] = DP[idx-1]+DP[idx-2];
        }
        
        // 결과 출력
        System.out.println(DP[N]);
    }
}