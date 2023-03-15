import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 테스트 케이스 수 입력
        int caseNum = Integer.parseInt(br.readLine());

        // 케이스 수만큼 수행
        for(int caseIdx=0; caseIdx<caseNum; caseIdx++) {

            // 알파벳 배열
            boolean isCheck[] = new boolean[26];

            // 제목 개수 입력
            int titleCnt = Integer.parseInt(br.readLine());

            // 제목 목록 입력
            for(int idx=0; idx<titleCnt; idx++) {
                char alpha = br.readLine().charAt(0);
                isCheck[alpha-65] = true;
            }

            // 제목 확인
            int result = 0;
            for(int idx=0; idx<isCheck.length; idx++) {
                if(isCheck[idx]==false)
                    break;
                result += 1;
            }

            // 결과 출력
            System.out.println("#"+(caseIdx+1)+" "+result);
        }
    }
}