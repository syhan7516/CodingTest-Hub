import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    // 결과, 일 수, 인출 수
    public static int answer, days, withdrawal;

    // 이용 금액 저장 배열
    public static int[] spends;

    // 탐색
    public static int solve(int mock) {
        int count = 1;
        int money = mock;

        // 소비 확인
        for(int spend=0; spend<days; spend++) {
            money -= spends[spend];

            // 금액이 적은 경우
            if(money < 0) {
                count++;
                money = mock - spends[spend];
            }
        }

        return count;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        // 일 수, 인출 수 입력
        st = new StringTokenizer(br.readLine());
        days = Integer.parseInt(st.nextToken());
        withdrawal = Integer.parseInt(st.nextToken());

        // 이용 금액 저장 배열 생성
        spends =  new int[days];

        // 이용 금액 입력
        int start = -1;
        int end = 0;
        for(int day=0; day<days; day++) {
            spends[day] = Integer.parseInt(br.readLine());
            end += spends[day];
            start = Math.max(start, spends[day]);
        }

        // 수행
        while(start <= end) {

            // 값 설정
            int mid = (start+end) / 2;

            // 인출 금액이 더 적은 경우
            if(withdrawal >= solve(mid)) {
                answer = mid;
                end = mid - 1;

            }

            else start = mid+1;
        }

        // 결과 출력
        System.out.println(answer);
    }
}