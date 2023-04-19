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

            // 사람 수 입력
            int N = Integer.parseInt(br.readLine());

            // 주스 나눠주기
            sb.append("#"+(caseIdx+1)+" ");
            for(int n=1; n<=N; n++)
                sb.append("1/"+N+" ");
            sb.append("\n");
        }

        // 결과 출력
        System.out.println(sb.toString());
    }
}