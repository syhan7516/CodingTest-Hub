import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        
        // 케이스 수 입력
        int caseNum = Integer.parseInt(br.readLine());
        
        // 수 만큼 수행
        for(int caseIdx=0; caseIdx<caseNum; caseIdx++) {
            
            // 수 입력
            int fibo = Integer.parseInt(br.readLine());
            
            
            // DP 배열
            int[] firFibo = new int[41];
            int[] secFibo = new int[41];
            
            // 기본 셋팅
            firFibo[0] = 1;
            firFibo[1] = 0;
            secFibo[0] = 0;
            secFibo[1] = 1;
            
            // 수까지 확인
            for(int n=2; n<=fibo; n++) {
                firFibo[n] = firFibo[n-1]+firFibo[n-2];
                secFibo[n] = secFibo[n-1]+secFibo[n-2];
            }
            
            // 결과 저장
            sb.append(firFibo[fibo] + " " + secFibo[fibo]+"\n");
        }
        
        // 결과 출력
        System.out.println(sb.toString());
    }
}