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

            // 결과
            long result = 0;

            // 자연수 입력
            long number = Long.parseLong(br.readLine());

            // 각 자리 수 더하기
            while(true) {

                // 종료 조건
                if(number==0) {
                    
                    // 결과 값이 한 자리 수인 경우
                    if(result/10==0)
                        break;
                    
                    // 결과 값이 한 자리 수 초과한 경우
                    else {
                        number = result;
                        result = 0;
                    }
                }

                result += number%10;
                number/=10;
            }

            // 결과 저장
            sb.append("#"+(caseIdx+1)+" "+result+"\n");
        }

        // 결과 출력
        System.out.println(sb.toString());
    }
}