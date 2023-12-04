import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        // 일 가능한 일 수 입력
        int days = Integer.parseInt(br.readLine());

        // 시간, 비용 배열 생성
        int time[] = new int[days+2];
        int money[] = new int[days+2];

        // 최대 수입 정보 배열
        int DP[] = new int[days+2];

        // 시간, 비용 정보 입력
        for(int d=1; d<=days; d++) {
            st = new StringTokenizer(br.readLine());
            int t = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());
            time[d] = t;
            money[d] = m;
        }

        // 최대 수입 구하기
        for(int d=1; d<=days+1; d++) {

            // 이전 수입이 현재보다 클 경우
            DP[d] = Math.max(DP[d],DP[d-1]);

            // 일 끝나는 날
            int nextDay = d+time[d];

            // 끝나는 날이 퇴사 일 이전인 경우
            if(nextDay<=days+1) {
                DP[nextDay] = Math.max(DP[nextDay],DP[d]+money[d]);
            }
        }

        // 결과 출력
        System.out.println(DP[days+1]);
    }
}