import java.io.BufferedReader;
import java.io.InputStreamReader;
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

            // 5명 점수 입력
            int result = 0;
            st = new StringTokenizer(br.readLine());
            for(int idx=0; idx<5; idx++) {
                int score = Integer.parseInt(st.nextToken());

                // 보충 대상
                if(score<40)
                    score = 40;

                // 점수 더하기
                result += score;
            }

            // 결과 저장
            sb.append("#"+(caseIdx+1)+" "+(result/5)+"\n");
        }

        // 결과 출력
        System.out.println(sb.toString());
    }
}