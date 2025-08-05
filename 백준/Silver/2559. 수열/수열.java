import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        // 일 수, 연속 수 입력
        st = new StringTokenizer(br.readLine());
        int dayCount = Integer.parseInt(st.nextToken());
        int checkDayCount = Integer.parseInt(st.nextToken());

        // 온도 배열 생성
        int[] temperatures = new int[dayCount+1];

        // 누적합 배열 생성
        int[] prefixSum = new int[dayCount+1];

        // 온도 입력
        st = new StringTokenizer(br.readLine());
        for(int index=1; index<=dayCount; index++) {
            prefixSum[index] = prefixSum[index-1] + Integer.parseInt(st.nextToken());
        }

        // 가장 높은 온도 확인
        int answer = Integer.MIN_VALUE;
        for(int index=checkDayCount; index<=dayCount; index++) {
            int sum = prefixSum[index] - prefixSum[index-checkDayCount];
            answer = Math.max(answer, sum);
        }

        // 결과 출력
        System.out.println(answer);
    }
}