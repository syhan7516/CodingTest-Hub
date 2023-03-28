import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        // 온도 측정 전체 날 입력
        int days = Integer.parseInt(st.nextToken());
        int daysData[] = new int[days+1];
        int prefixData[] = new int[days+1];

        // 연속된 날 수 입력
        int checkDays = Integer.parseInt(st.nextToken());

        // 온도 정보 입력
        st = new StringTokenizer(br.readLine());
        for(int d=1; d<=days; d++) {
            daysData[d] = Integer.parseInt(st.nextToken());
        }

        // 누적 합 정보 입력
        prefixData[1] = daysData[1];
        for(int p=2; p<=days; p++) {
            prefixData[p] = prefixData[p-1] + daysData[p];
        }

        // 온도 최대 합 구하기
        int startIdx;
        int endIdx;
        int result = Integer.MIN_VALUE;
        for(int idx=1; idx+checkDays-1<=days; idx++) {
            startIdx = idx;
            endIdx = idx+checkDays-1;
            result = Math.max(result,prefixData[endIdx]-prefixData[idx]+daysData[idx]);
        }

        // 결과 출력
        System.out.println(result);
    }
}