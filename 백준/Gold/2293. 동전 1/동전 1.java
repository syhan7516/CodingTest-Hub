import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    // 동전 개수, 가치
    public static int coinCount, target;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        // 동전 개수, 가치 입력
        st = new StringTokenizer(br.readLine());
        coinCount = Integer.parseInt(st.nextToken());
        target = Integer.parseInt(st.nextToken());

        // 동전 종류 저장 배열 생성
        int coins[] = new int[coinCount];

        // DP 배열 생성
        int DP[] = new int[10001];
        DP[0] = 1;

        // 동전 종류 입력
        for(int index=0; index<coinCount; index++) {
            coins[index] = Integer.parseInt(br.readLine());
            for(int value=coins[index]; value<=target; value++) {
                DP[value] += DP[value-coins[index]];
            }
        }

        // 결과 출력
        System.out.println(DP[target]);
    }
}