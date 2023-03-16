import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 테스트 케이스 수 입력
        int caseNum = Integer.parseInt(br.readLine());

        // 케이스 수만큼 수행
        for(int caseIdx=0; caseIdx<caseNum; caseIdx++) {

            // 결과
            int result = 0;

            // 수 저장 배열
            boolean numCheck[] = new boolean[10];

            // 수 입력
            int num = Integer.parseInt(br.readLine());

            // 다양성 확인
            int value;
            while(num!=0) {
                value = num%10;
                // 처음인 경우
                if(!numCheck[value]) {
                    result += 1;
                    numCheck[value] = true;
                }

                num = num/10;
            }

            // 결과 확인
            System.out.println("#"+(caseIdx+1)+" "+result);;
        }
    }
}