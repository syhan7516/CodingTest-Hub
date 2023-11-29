import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        // 구하려는 값
        int total = (1<<10)-1;

        // 테스트 케이스 수 입력
        int caseNum = Integer.parseInt(br.readLine());

        // 케이스 수 만큼 수행
        for(int caseIdx=0; caseIdx<caseNum; caseIdx++) {

            // 현재까지 구한 값
            int current = 0;

            // 정수 입력
            int number = Integer.parseInt(br.readLine());

            // 현재 배수
            int count = 0;
            for(count=1; ; count++) {
                char arr[] = String.valueOf(number*count).toCharArray();
                for(char data: arr) {
                    int currentNumber = data-'0';
                    current = current|(1<<currentNumber);
                }

                // 구하려는 값과 비교
                if(current==total) break;
            }

            // 결과 저장
            sb.append("#").append(caseIdx+1).append(" ").append(number*count).append("\n");
        }

        // 결과 출력
        System.out.println(sb.toString());
    }
}