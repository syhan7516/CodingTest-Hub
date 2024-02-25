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
        for(int caseIdx=1; caseIdx<=caseNum; caseIdx++) {

            sb.append("#").append(caseIdx).append(" ");

            // 확인 여부
            boolean flag = true;

            // N, M 입력
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());

            // m의 n비트 1인지 확인
            for(int b=0; b<n; b++) {
                if((m&(1<<b)) == 0) {
                    flag = false;
                    sb.append("OFF").append("\n");
                    break;
                }
            }

            // 모두 1인 경우
            if(flag)
                sb.append("ON").append("\n");
        }

        // 결과 출력
        System.out.println(sb.toString());
    }
}