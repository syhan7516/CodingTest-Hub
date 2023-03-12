import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 테스트 케이스 수 입력
        int caseNum = Integer.parseInt(br.readLine());

        // 케이스 수만큼 수행
        for(int caseIdx=0; caseIdx<caseNum; caseIdx++) {

            // 자연수 입력
            int number = Integer.parseInt(br.readLine());

            // 아름다움 확인
            int count = 0;
            int point = 1;
            int preSum = 1;
            for(int idx=1; idx<=number; idx++) {
                while(preSum<number) {
                    // 누적합이 작을 경우
                    point++;
                    preSum += point;
                }

                // 찾은 경우
                if(preSum==number) {
                    point++;
                    preSum += point;
                    count += 1;
                }

                preSum -= idx;
            }

            // 결과 출력
            System.out.println("#"+(caseIdx+1)+" "+count);
        }
    }
}
