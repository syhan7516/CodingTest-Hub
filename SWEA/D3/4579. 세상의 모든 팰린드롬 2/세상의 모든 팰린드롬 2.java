import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 테스트 케이스 수 입력
        int caseNum = Integer.parseInt(br.readLine());

        // 케이스 수만큼 반복 수행
        for(int caseIdx=0; caseIdx<caseNum; caseIdx++) {

            // 결과
            boolean result = true;

            // 문자열 입력
            String letter = br.readLine();

            // 문자열 확인
            for(int idx=0; idx<letter.length()/2; idx++) {
                char a = letter.charAt(idx);
                char b = letter.charAt(letter.length()-idx-1);
                if(a=='*' || b=='*') {
                    break;
                }
                else if(a!='*' && b!='*' && a!=b) {
                    result = false;
                    break;
                }
            }

            // 결과 출력
            System.out.print("#"+(caseIdx+1)+" ");
            if(result)
                System.out.println("Exist");
            else
                System.out.println("Not exist");
        }
    }
}
