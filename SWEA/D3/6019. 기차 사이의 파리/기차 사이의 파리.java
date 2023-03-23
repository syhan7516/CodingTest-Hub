import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        // 테스트 케이스 수 입력
        int caseNum = Integer.parseInt(br.readLine());
        // 케이스 수만큼 수행
        for(int caseIdx=0; caseIdx<caseNum; caseIdx++) {
            // 각 정보 입력
            st = new StringTokenizer(br.readLine());
            int distance = Integer.parseInt(st.nextToken());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());
            int fly = Integer.parseInt(st.nextToken());

            float totalTime = (float)distance/(float)(A+B);
            float result = totalTime * fly;

            // 결과 출력
            System.out.println("#"+(caseIdx+1)+" "+result);
        }
    }
}