import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        // 숫자 입력
        int num = Integer.parseInt(br.readLine());

        // 1인 경우
        if(num==1) System.out.println(1);
        
        // 아닌 경우
        else {
            
            // DP
            long DP[] = new long[num+1];

            // 기본 셋팅
            DP[1] = 1;
            DP[2] = 2;

            // 숫자까지 확인
            int range = num+1;
            for (int idx=3; idx<range; idx++) {
                DP[idx] = (DP[idx-2]+DP[idx-1])%15746;
            }
            
            // 결과 출력
            System.out.println(DP[num]);
        }
    }
}