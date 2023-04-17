
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        // 출근 일수 입력
        int days = Integer.parseInt(br.readLine());

        // 일 별 정보 배열
        int consultDay[] = new int[16];
        int consultMoney[] = new int[16];
        int result[] = new int[17];

        // 일 별 정보 입력
        for(int d=1; d<=days; d++) {
            st = new StringTokenizer(br.readLine());
            consultDay[d] = Integer.parseInt(st.nextToken());
            consultMoney[d] = Integer.parseInt(st.nextToken());
        }

        // 일하기
        for(int d=1; d<=days; d++) {

            // 이전에 일을 받지 않았을 경우
            // 이전에 번 돈이 더 많은 경우
            result[d] = Math.max(result[d],result[d-1]);

            // 최대 퇴근 날짜 조건 확인
            if((d+consultDay[d])<result.length) {
                int nextDay = d+consultDay[d];
                result[nextDay] = Math.max(result[nextDay],result[d]+consultMoney[d]);
            }
        }

        // 결과 출력
        result[days+1] = Math.max(result[days+1],result[days]);
        System.out.println(result[days+1]);
    }
}