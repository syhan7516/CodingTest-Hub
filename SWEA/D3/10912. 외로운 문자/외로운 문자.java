import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 테스트 케이스 수 입력
        int caseNum = Integer.parseInt(br.readLine());
        // 케이스 수만큼 수행
        for(int caseIdx=0; caseIdx<caseNum; caseIdx++) {
            // 문자열 저장 배열
            int alpha[] = new int[26];
            // 문자열 입력
            String letters = br.readLine();
            // 문자 확인
            for(int idx=0; idx<letters.length(); idx++) {
                alpha[letters.charAt(idx)-97] += 1;
            }
            // 문자 체크
            String result = "";
            for(int idx=0; idx<alpha.length; idx++) {
                alpha[idx] = alpha[idx]%2;
                // 문자가 짝이 맞는 경우
                if(alpha[idx]==0)
                    continue;
                // 아닌 경우
                result += (char)(idx+97);
            }
            // 결과 출력
            System.out.print("#"+(caseIdx+1)+" ");
            if(result.length()==0)
                System.out.println("Good");
            else
                System.out.println(result);
        }
    }
}