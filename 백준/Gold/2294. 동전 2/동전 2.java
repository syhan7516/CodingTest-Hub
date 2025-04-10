import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    public static final int MAX_VALUE = (int)1e9;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        // 동전 종류, 목표 금액 입력
        st = new StringTokenizer(br.readLine());
        int coinCount = Integer.parseInt(st.nextToken());
        int targetMoney = Integer.parseInt(st.nextToken());

        // 동전 종류 저장 리스트 생성
        ArrayList<Integer> coins = new ArrayList<>();

        // 동전 종류 입력
        for(int coinIndex=0; coinIndex<coinCount; coinIndex++) {
            int coin = Integer.parseInt(br.readLine());
            if(!coins.contains(coin)) coins.add(coin);
        }

        // 동전 개수 저장 배열 생성
        int[] DP = new int[targetMoney+1];

        // 동전 개수 저장 배열 초기화
        Arrays.fill(DP,MAX_VALUE);
        DP[0] = 0;

        // 동전 최소 개수 구하기
        for(int money=1; money<=targetMoney; money++) {
            for(int coinIndex=0; coinIndex<coins.size(); coinIndex++) {
                if(money-coins.get(coinIndex)<0) continue;
                DP[money] = Math.min(DP[money],DP[money-coins.get(coinIndex)]+1);
            }
        }

        // 결과 저장
        int answer = DP[targetMoney]==MAX_VALUE ? -1 : DP[targetMoney];
        System.out.println(answer);
    }
}