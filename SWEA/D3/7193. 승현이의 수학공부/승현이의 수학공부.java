import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        // 테스트 케이스 수 입력
        int caseNum = Integer.parseInt(br.readLine());
        // 케이스 수만큼 수행
        for(int caseIdx=0; caseIdx<caseNum; caseIdx++) {
            // 진법 입력
            st = new StringTokenizer(br.readLine());
            int radix = Integer.parseInt(st.nextToken());
            String nums = st.nextToken();

            // 진법 변환
            int number = 0;
            for(int n=0; n<nums.length(); n++) {
                number += nums.charAt(n)-'0';
            }

            // 결과
            int result = number%(radix-1);

            // 결과 출력
            System.out.println("#"+(caseIdx+1)+" "+result);
        }
    }
}