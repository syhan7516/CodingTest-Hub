import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        // 동전 개수, 금액 입력
        st = new StringTokenizer(br.readLine());
        int coinCnt = Integer.parseInt(st.nextToken());
        int money = Integer.parseInt(st.nextToken());

        // 동전 종류 입력
        int coin[] = new int[coinCnt];
        for(int c=0; c<coinCnt; c++)
            coin[c] = Integer.parseInt(br.readLine());

        // 지갑 만들기
        int poket[] = new int[money+1];
        Arrays.fill(poket,10001);
        poket[0] = 0;
        
        // 동전 조합 만들기
        for(int a=0; a<coinCnt; a++) {
            for(int b=coin[a]; b<=money; b++) {
                poket[b] = Math.min(poket[b],poket[b-coin[a]]+1);
            }
        }
        
        // 결과 출력
        if(poket[money]==10001)
            System.out.println(-1);
        else
            System.out.println(poket[money]);
    }
}