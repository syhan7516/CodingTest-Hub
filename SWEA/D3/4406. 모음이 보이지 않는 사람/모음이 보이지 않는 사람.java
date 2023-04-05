import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();


        // 테스트 케이스 수 입력
        int caseNum = Integer.parseInt(br.readLine());

        // 케이스 수만큼 수행
        for(int caseIdx=0; caseIdx<caseNum; caseIdx++) {

            // 실제 문자열
            String letter = br.readLine();

            // 문자열 보기
            sb.append("#"+(caseIdx+1)+" ");
            for(int idx=0; idx<letter.length(); idx++) {

                // 문자가 모음인 경우
                char alpha = letter.charAt(idx);
                if(alpha=='a' || alpha=='e' || alpha=='i' || alpha=='o' || alpha=='u')
                    continue;

                // 결과 저장
                sb.append(alpha);
            }

            sb.append("\n");
        }

        // 결과 출력
        System.out.println(sb.toString());
    }
}