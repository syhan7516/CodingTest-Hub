import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int count = 1;

        while(true) {
            // 종료 조건
            if(count==11)
                break;

            // 케이스 번호 입력
            int caseNum = Integer.parseInt(br.readLine());

            // 검색 문자열 입력
            String findLetter = br.readLine();

            // 문자열 입력
            String letterResult = br.readLine().replaceAll(findLetter,"^");

            // 결과 저장
            int result = 0;
            for(int s=0; s<letterResult.length(); s++) {
                char alpha = letterResult.charAt(s);
                if(alpha=='^') result++;
            }
            sb.append("#"+caseNum+" "+result+"\n");

            count++;
        }

        // 결과 출력
        System.out.println(sb.toString());
    }
}