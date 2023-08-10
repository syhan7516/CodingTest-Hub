import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        // 숫자 입력
        int number = Integer.parseInt(br.readLine())+1000000;
        
        // DP 테이블 만들기
        long DP[] = new long[2000001];
        
        // 기본 셋팅
        DP[1000001] = 1;
        
        // 넘지 않는 경우
        if(number<1000000) {
            for(int i=999999; i>=number; i--) {
                DP[i]=(DP[i+2]-DP[i+1])%1000000000;
            }
        } 
        
        // 아닌 경우
        else {
            for(int i=1000002; i<=number; i++) {
                DP[i]=(DP[i-1]+DP[i-2])%1000000000;
            }
        }
        
        // 결과 출력
        if(DP[number]>0) System.out.println(1);
        if(DP[number]==0) System.out.println(0);
        if(DP[number]<0) System.out.println(-1);
        System.out.print(Math.abs(DP[number]));
    }
}