import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        // 테스트 케이스 수 입력
        int caseNum = Integer.parseInt(st.nextToken());
        // 케이스 수만큼 수행
        for(int caseIdx=0; caseIdx<caseNum; caseIdx++) {

            // 결과, 적게 받은 사람 쿠기, 많이 받은 사람 쿠기
            int result = 0;

            // 쿠키 수, 사람 수 입력
            st = new StringTokenizer(br.readLine());
            int cookieCnt = Integer.parseInt(st.nextToken());
            int humanCnt = Integer.parseInt(st.nextToken());

            // 쿠키 놔눠주기
            if((cookieCnt % humanCnt) == 0)
                result = 0;
            else
                result = 1;

            // 결과 출력
            System.out.println("#"+(caseIdx+1)+" "+result);
        }
    }
}