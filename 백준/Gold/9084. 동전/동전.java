import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        // 테스트 케이스 수 입력
        int caseCount = Integer.parseInt(br.readLine());

        // 케이스 수행
        for(int caseIndex=0; caseIndex<caseCount; caseIndex++) {

            // 동전 종류 개수 입력
            int coinCount = Integer.parseInt(br.readLine());

            // 동전 종류 저장 배열 생성
            int[] coins = new int[coinCount];

            // 동전 종류 입력
            st = new StringTokenizer(br.readLine());
            for(int coinIndex=0; coinIndex<coinCount; coinIndex++) {
                coins[coinIndex] = Integer.parseInt(st.nextToken());
            }

            // 목표 금액 입력
            int target = Integer.parseInt(br.readLine());

            // 방법 수 배열 생성
            int[] DP = new int[target+1];

            // 초기화
            DP[0] = 1;

            // 동전 종류 순회
            for(int coinIndex=0; coinIndex<coinCount; coinIndex++) {

                // 목표 금액까지 순회
                for(int money=0; money<=target; money++) {

                    // 금액이 0보다 작은 경우
                    if(money-coins[coinIndex]<0) continue;

                    // 이전 금액과 방법 수 더하기
                    DP[money] += DP[money-coins[coinIndex]];
                }
            }
            
            // 결과 저장
            sb.append(DP[target]).append("\n");
        }

        // 결과 출력
        System.out.println(sb.toString());
    }
}