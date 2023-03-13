import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        // 테스트 케이스 수 입력
        int caseNum = Integer.parseInt(st.nextToken());
        // 테스트 케이스 수만큼 수행
        for(int caseIdx=0; caseIdx<caseNum; caseIdx++) {

            // 유호기간 입력
            st = new StringTokenizer(br.readLine());
            String dateLetters = st.nextToken();

            // 날짜 분리
            int frontDate = Integer.parseInt(dateLetters.substring(0,2));
            int rearDate = Integer.parseInt(dateLetters.substring(2,4));

            // 날짜 판단 & 출력
            System.out.print("#"+(caseIdx+1)+" ");

            // 모두 MONTH 기간에 들어올 경우
            if(frontDate>0 && frontDate<13 && rearDate>0 && rearDate<13)
                System.out.println("AMBIGUOUS");

            // FRONT는 MONTH, REAR는 YEAR인 경우
            else if(frontDate>0 && frontDate<13 && rearDate>=0 && rearDate<=99)
                System.out.println("MMYY");

            // FRONT는 YEAR, REAR는 MONTH인 경우
            else if(frontDate>=0 && frontDate<=99 && rearDate>0 && rearDate<13)
                System.out.println("YYMM");

            // 양식이 이상한 경우
            else
                System.out.println("NA");
        }
    }
}
