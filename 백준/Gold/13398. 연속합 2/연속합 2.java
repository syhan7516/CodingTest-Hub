import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    // 결과, 숫자 개수
    public static int answer, numCount;

    // 숫자 배열
    public static int[] nums;

    // 연속합 배열
    public static int[][] sum;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        // 숫자 개수 입력
        numCount = Integer.parseInt(br.readLine());

        // 숫자 배열 생성
        nums = new int[numCount];

        // 숫자 입력
        st = new StringTokenizer(br.readLine());
        for(int numIndex=0; numIndex<numCount; numIndex++) {
            nums[numIndex] = Integer.parseInt(st.nextToken());
        }

        // 연속합 배열 생성
        sum = new int[2][numCount];

        // 초기 설정
        answer = nums[0];
        sum[0][0] = nums[0];
        sum[1][0] = nums[0];

        // 연속합 최대 값 구하기
        for(int numIndex=1; numIndex<numCount; numIndex++) {
            sum[0][numIndex] = Math.max(sum[0][numIndex-1]+nums[numIndex],nums[numIndex]);
            sum[1][numIndex] = Math.max(sum[0][numIndex-1],sum[1][numIndex-1]+nums[numIndex]);
            answer = Math.max(answer,Math.max(sum[0][numIndex],sum[1][numIndex]));
        }

        // 결과 출력
        System.out.println(answer);
    }
}