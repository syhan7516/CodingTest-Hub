import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        // 숫자 개수, 질문 개수 입력
        st = new StringTokenizer(br.readLine());
        int numCount = Integer.parseInt(st.nextToken());
        int queryCount = Integer.parseInt(st.nextToken());

        // 숫자 배열 생성
        int[] nums = new int[numCount];
        st = new StringTokenizer(br.readLine());
        for(int index=0; index<numCount; index++) {
            nums[index] = Integer.parseInt(st.nextToken());
        }

        // 정렬
        Arrays.sort(nums);

        // 누적합 배열 생성
        int[] prefixSum = new int[numCount];
        prefixSum[0] = nums[0];
        for(int index=1; index<numCount; index++) {
            prefixSum[index] = prefixSum[index-1] + nums[index];
        }

        // 질문 입력
        for(int index=0; index<queryCount; index++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken())-1;
            int end = Integer.parseInt(st.nextToken())-1;
            sb.append(prefixSum[end]-prefixSum[start]+nums[start]).append("\n");
        }

        // 결과 출력
        System.out.println(sb.toString());
    }
}