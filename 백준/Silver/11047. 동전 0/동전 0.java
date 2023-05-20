import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        // 동전 종류 수, 구할 합 입력
        st = new StringTokenizer(br.readLine());
        int kinds = Integer.parseInt(st.nextToken());
        int money = Integer.parseInt(st.nextToken());

        // 동전 종류 수 입력
        int coin[] = new int[kinds];
        for(int c=0; c<kinds; c++) {
            coin[c] = Integer.parseInt(br.readLine());
        }

        // 동전 수 구하기
        int result = 0;
        int idx = coin.length-1;
        
        while(money>0) {
            // 동전 종류보다 클 경우
            if(coin[idx]>money)
                idx--;
            // 교환 가능한 경우
            else {
                result += money/coin[idx];
                money %= coin[idx];
            }
        }

        // 결과 출력
        System.out.println(result);
    }
}