import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 테스트 케이스 수 입력
        int caseNum = Integer.parseInt(br.readLine());

        // 케이스 수만큼 수행
        for(int caseIdx=0; caseIdx<caseNum; caseIdx++) {
            // 문자열 길이 입력
            int lettersLen = Integer.parseInt(br.readLine());

            // 받아쓸 문자열 입력
            String problemLetters = br.readLine();

            // 적은 문자열 입력
            String writeLetters = br.readLine();

            // 두 문자열 비교
            int count = 0;
            for(int idx=0; idx<lettersLen; idx++) {
                if(problemLetters.charAt(idx)==writeLetters.charAt(idx))
                    count += 1;
            }

            // 결과 출력
            System.out.println("#"+(caseIdx+1)+" "+count);
        }
    }
}
