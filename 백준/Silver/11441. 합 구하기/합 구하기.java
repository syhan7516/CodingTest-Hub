import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        // 숫자 개수 입력
        int numCount = Integer.parseInt(br.readLine());

        // 숫자 배열, 누적합 배열 생성
        int[] nums = new int[numCount+1];
        int[] prefixSum = new int[numCount+1];

        // 숫자 입력
        st = new StringTokenizer(br.readLine());
        for(int index=1; index<=numCount; index++) {
            nums[index] = Integer.parseInt(st.nextToken());
            prefixSum[index] = prefixSum[index-1] + nums[index];
        }

        // 구간 정보 개수 입력
        int rangeCount = Integer.parseInt(br.readLine());

        // 구간 정보 확인
        for(int index=0; index<rangeCount; index++) {
            st = new StringTokenizer(br.readLine());
            int startIndex = Integer.parseInt(st.nextToken());
            int endIndex = Integer.parseInt(st.nextToken());

            // 결과 저장
            int sum = prefixSum[endIndex] - prefixSum[startIndex] + nums[startIndex];
            sb.append(sum).append("\n");
        }

        // 결과 출력
        System.out.println(sb.toString());
    }
}