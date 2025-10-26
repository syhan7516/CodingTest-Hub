import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        // 사람 수 입력
        int accountCount = Integer.parseInt(br.readLine());

        // 계좌 잔액 입력
        st = new StringTokenizer(br.readLine());
        int balance = Integer.parseInt(st.nextToken());
        int totalBalance = balance;

        // 나머지 잔액 입력
        for(int money=1; money<accountCount; money++) {
            totalBalance += Integer.parseInt(st.nextToken());
        }

        // 당첨 금액, 대기 주 입력
        double addMoney = Integer.parseInt(br.readLine());
        double weekCount = Integer.parseInt(br.readLine());

        // 예상 금액
        double answer = balance + (balance*addMoney*weekCount) / totalBalance;

        // 결과 출력
        System.out.printf("%.10f", answer);
    }
}