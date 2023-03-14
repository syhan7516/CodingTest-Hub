import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    // 날짜 수, 연속적인 날짜의 수
    public static int days, checkDays, prefixSum;
    // 온도 정보 배열
    public static int temperature[];
    // 온도 누적합 배열
    public static int prefixTemperature[];
    // 최고 온도
    public static int result;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        // 날짜 수, 연속적인 날짜의 수 입력
        days = Integer.parseInt(st.nextToken());
        checkDays = Integer.parseInt(st.nextToken());

        // 온도 정보 입력
        temperature = new int[days+1];
        st = new StringTokenizer(br.readLine());
        for(int idx=1; idx<=days; idx++) {
            temperature[idx] = Integer.parseInt(st.nextToken());
        }

        // 초기 누적 온도
        prefixSum = 0;
        for(int idx=1; idx<checkDays+1; idx++) {
            prefixSum += temperature[idx];
        }

        // 최고 온도 구하기
        result = prefixSum;
        for(int idx=checkDays+1; idx<=days; idx++) {
            prefixSum = prefixSum + temperature[idx] - temperature[idx-checkDays];
            result = Math.max(result,prefixSum);
        }

        // 결과 출력
        System.out.println(result);
    }
}
