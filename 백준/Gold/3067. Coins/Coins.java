import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    // 동전 종류 개수, 목표 금액
    public static int coinCount, targetMoney;

    // 동전 정보 배열
    public static int[] kinds;

    // DP 배열
    public static int [][] DP;

    // 방법 수 찾기 메서드
    public static void solve() {

        // 동전 순회
        for(int coin=1; coin<=coinCount; coin++) {

            // 금액 확인
            for(int money=1; money<=targetMoney; money++) {
                if(money - kinds[coin] < 0){
                    DP[coin][money] = DP[coin-1][money];
                    continue;
                }

                DP[coin][money] += DP[coin-1][money] + DP[coin][money-kinds[coin]];
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        // 케이스 수 입력
        int caseCount = Integer.parseInt(br.readLine());

        // 케이스 수행
        for(int caseNum=0; caseNum<caseCount; caseNum++) {

            // 동전 종류 개수 입력
            coinCount = Integer.parseInt(br.readLine());

            // 동전 정보 배열 생성
            kinds = new int[coinCount+1];

            // DP 배열 생성
            DP = new int[coinCount+1][10001];

            // 동전 정보 입력
            st = new StringTokenizer(br.readLine());
            for(int coin=1; coin<=coinCount; coin++) {
                kinds[coin] = Integer.parseInt(st.nextToken());
                DP[coin][kinds[coin]]++;
            }

            // 목표 금액 입력
            targetMoney = Integer.parseInt(br.readLine());

            // 방법 수 찾기
            solve();

            // 결과 저장
            sb.append(DP[coinCount][targetMoney]).append("\n");
        }

        // 결과 출력
        System.out.println(sb.toString());
    }
}