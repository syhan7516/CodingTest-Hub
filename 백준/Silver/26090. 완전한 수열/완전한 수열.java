import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    // 결과, 숫자 개수
    public static int answer, numCount;

    // 숫자 배열, 누적합 배열
    public static int[] nums, prefixSum;

    // 소수 배열
    public static boolean[] isPrime;

    // 소수 구하기 메서드
    public static void initIsPrime() {
        for(int num=2; num*num<=1000000; num++) {
            if(!isPrime[num]) {
                for(int multiNum=num+num; multiNum<=1000000; multiNum+=num) {
                    isPrime[multiNum] = true;
                }
            }
        }
    }

    // 완전한 수열 구하기
    public static void solve() {
        for(int count=2; count<=numCount; count++) {

            // 개수가 소수인 경우
            if(!isPrime[count]) {

                // 합 구하기
                for(int index=count; index<nums.length; index++) {
                    int num = prefixSum[index] - prefixSum[index-count+1] + nums[index-count+1];
                    if(num > 1 && !isPrime[num]) answer++;
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        // 소수 배열 생성
        isPrime = new boolean[1000001];

        // 소수 구하기
        initIsPrime();

        // 숫자 개수 입력
        numCount = Integer.parseInt(br.readLine());

        // 숫자 배열 생성
        nums = new int[numCount+1];

        // 누적합 배열 생성
        prefixSum = new int[numCount+1];

        // 숫자 정보 입력
        st = new StringTokenizer(br.readLine());
        for(int index=1; index<=numCount; index++) {
            nums[index] = Integer.parseInt(st.nextToken());
            prefixSum[index] = prefixSum[index-1] + nums[index];
        }

        // 완전한 수열 구하기
        solve();

        // 결과 출력
        System.out.println(answer);
    }
}