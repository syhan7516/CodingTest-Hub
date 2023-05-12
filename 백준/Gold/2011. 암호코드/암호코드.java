import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    // 범위 초과 나눌 수
    public static int M = 1000000;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        // 숫자 문자열 입력
        String letter = br.readLine();

        // DP 테이블
        int DP[] = new int[letter.length()+1];

        // 테이블 초기화
        DP[0] = 1;

        // 암호 해독 수행
        for(int l=1; l<=letter.length(); l++) {
            // 이전 수 확인
            int preNum = letter.charAt(l-1)-'0';

            // 이전 수가 1~9인 경우
            if(preNum>=1 && preNum<=9) {
                DP[l] = (DP[l] + DP[l-1]) % M;
            }
            
            // 처음 자리 통과
            if(l==1) continue;

            // 이이전 수 확인
            int prePreNum = letter.charAt(l-2)-'0';
            
            // 이이전 수가 0인 경우
            if(prePreNum==0) continue;
            
            // 이이전 수가 10~26인 경우
            int checkNum = Integer.parseInt(prePreNum+""+preNum);
            if(checkNum>=1 && checkNum<=26) {
                DP[l] = (DP[l] + DP[l-2]) % M;
            }
        }
        
        // 결과 출력
        System.out.println(DP[letter.length()]);
    }
}