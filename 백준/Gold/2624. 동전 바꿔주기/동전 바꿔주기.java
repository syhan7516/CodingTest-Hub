import java.io.*;
import java.util.*;

// 동전 클래스
class Coin {
    int money;
    int count;

    public Coin(int money, int count) {
        this.money = money;
        this.count = count;
    }
}

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        // 금액 입력
        int targetMoney = Integer.parseInt(br.readLine());

        // 종류 개수 입력
        int kindCount = Integer.parseInt(br.readLine());

        // 동전 배열 생성
        Coin[] coins = new Coin[kindCount+1];

        // DP 배열 생성
        int[][] DP = new int[targetMoney+1][kindCount+1];

        // 금액, 동전 개수 입력
        for(int coin=1; coin<=kindCount; coin++) {
            st = new StringTokenizer(br.readLine());
            int money = Integer.parseInt(st.nextToken());
            int count = Integer.parseInt(st.nextToken());
            coins[coin] = new Coin(money, count);
        }

        // 확인
        for(int kind=1; kind<=kindCount; kind++) {
            int money = coins[kind].money;
            int count = coins[kind].count;

            // 초기 설정
            DP[0][kind-1] = 1;

            for(int currentCount=1; currentCount<=count; currentCount++) {
                for(int currentMoney=money*currentCount; currentMoney<=targetMoney; currentMoney++) {
                    DP[currentMoney][kind] += DP[currentMoney - (money*currentCount)][kind-1];
                }
            }

            for(int currentMoney=1; currentMoney<=targetMoney; currentMoney++) {
                DP[currentMoney][kind] += DP[currentMoney][kind-1];
            }
        }

        // 결과 출력
        System.out.println(DP[targetMoney][kindCount]);
    }
}