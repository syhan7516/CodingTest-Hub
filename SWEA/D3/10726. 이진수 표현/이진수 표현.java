import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        // 테스트 케이스 수 입력
        int caseNum = Integer.parseInt(br.readLine());

        // 케이스 수 만큼 수행
        for(int caseIdx=0; caseIdx<caseNum; caseIdx++) {

            // N, M 입력
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());

            // 확인하려는 값
            int total = (1<<n)-1;

            // 확인하기
            sb.append("#").append(caseIdx+1).append(" ");

            if((m&total)==total)
                sb.append("ON");
            else
                sb.append("OFF");

            sb.append("\n");
        }

        // 결과 출력
        System.out.println(sb.toString());
    }
}