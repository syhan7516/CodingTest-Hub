import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        // 테스트 케이스 수 입력
        int caseNum = Integer.parseInt(br.readLine());

        // 케이스 수만큼 수행
        for(int caseIdx=0; caseIdx<caseNum; caseIdx++) {

            // 박수 정보 문자열 입력
            String clapLetter = br.readLine();

            // 박수 확인
            int result = 0;
            int clapCnt = 0;
            for(int idx=0; idx<clapLetter.length(); idx++) {
                // 박수 조건
                int curClapCnt = clapLetter.charAt(idx) - '0';

                // 박수 조건에 만족하지 않은 겨우
                if (clapCnt<idx) {
                    int hireCnt = idx-clapCnt;
                    result += hireCnt;
                    clapCnt += hireCnt+curClapCnt;
                }
                // 박수 조건에 만족한 경우
                else {
                    clapCnt += curClapCnt;
                }
            }

            // 결과 저장
            sb.append("#"+(caseIdx+1)+" "+result+"\n");
        }

        // 결과 출력
        System.out.println(sb.toString());
    }
}