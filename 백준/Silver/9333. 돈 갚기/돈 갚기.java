import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        // 케이스 수 입력
        int caseCount = Integer.parseInt(br.readLine());

        // 케이스 수행
        while(caseCount-- > 0) {

            // 이자, 빌린 돈, 월급 입력
            st = new StringTokenizer(br.readLine());
            double rate = (Double.parseDouble(st.nextToken()) + 100.0) / 100.0;
            double borrowedMoney = Double.parseDouble(st.nextToken());
            double tutoringMoney = Double.parseDouble(st.nextToken());

            // 확인
            int month = 0;
            boolean impossible = false;
            double startBorrowedMoney = borrowedMoney;

            while(month <= 1200 && !impossible && borrowedMoney > 0) {
                borrowedMoney = ((int)((borrowedMoney * rate * 100) + 0.5 + 1e-8) / 100.0) - tutoringMoney;

                // 빚이 더 커지는 경우
                if(borrowedMoney > startBorrowedMoney) {
                    impossible = true;
                }

                // 날짜 갱신
                month++;
            }

            // 결과 저장
            if(impossible || month > 1200) sb.append("impossible").append("\n");
            else sb.append(month).append("\n");
        }

        // 결과 출력
        System.out.println(sb.toString());
    }
}
