import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        // 테스트 케이스 수 입력
        int caseNum = Integer.parseInt(br.readLine());

        // 케이스 수만큼 수행
        for(int caseIdx=0; caseIdx<caseNum; caseIdx++) {

            // 각 빵의 금액, 소유한 금액 입력
            st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());
            int C = Integer.parseInt(st.nextToken());

            // 더 싼 빵 찾고 & 빵 사기
            if(A>B) {
                int swap = A;
                A = B;
                B = swap;
            }

            // 결과 저장
            sb.append("#"+(caseIdx+1)+" "+(C/A)+"\n");
        }

        // 결과 출력
        System.out.println(sb.toString());
    }
}