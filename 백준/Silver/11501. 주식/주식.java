import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        // 테스트 케이스 수 입력
        int caseNum = Integer.parseInt(br.readLine());

        // 케이스 수 만큼 수행
        for(int caseIdx=0; caseIdx<caseNum; caseIdx++) {

            // 결과
            long answer = 0;

            // 날 수 입력
            int dayCnt = Integer.parseInt(br.readLine());

            // 주식 가격 정보 배열 생성
            int money[] = new int[dayCnt+1];

            // 주식 가격 정보 입력
            st = new StringTokenizer(br.readLine());
            for(int i=1; i<=dayCnt; i++) {
                money[i] = Integer.parseInt(st.nextToken());
            }

            // 주식 확인
            int price = money[dayCnt];

            for(int i=dayCnt; i>=1; i--) {

                // 이전 것보다 큰 경우
                if(price<money[i]) {
                    price = money[i];
                }

                // 이전 것보다 같거나 비쌀 경우
                else {
                    answer += (price-money[i]);
                }
            }

            // 결과 저장
            sb.append(answer).append("\n");
        }

        // 결과 출력
        System.out.println(sb.toString());
    }
}