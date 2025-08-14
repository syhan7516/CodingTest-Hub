import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    // 숫자 개수
    public static int numCount;

    // 숫자 배열, 누적합 배열
    public static int[] nums, prefixSum;

    // 소수 여부 확인 메서드
    public static boolean isPrime(int number) {
        if(number == 0 || number == 1) {
            return false;
        }

        for(int num=2; num<number; num++) {
            if(number % num == 0) {
                return false;
            }
        }

        return true;
    }

    // 소수 찾기 메서드
    public static String solve() {
        StringBuilder sb = new StringBuilder();
        for(int len=2; len<=numCount; len++) {
            for(int index=1; index+len-1<=numCount; index++) {
                int sum = prefixSum[index+len-1] - prefixSum[index] + nums[index];
                if(isPrime(sum)) {
                    sb.append("Shortest primed subsequence is length ").append(len).append(": ");
                    for(int numIndex=index; numIndex<=index+len-1; numIndex++) {
                        sb.append(nums[numIndex]).append(" ");
                    }
                    return sb.toString();
                }
            }
        }

        return "This sequence is anti-primed.";
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        // 테스트 케이스 수 입력
        int caseCount = Integer.parseInt(br.readLine());

        // 케이스 수행
        for(int caseNum=0; caseNum<caseCount; caseNum++) {
            st = new StringTokenizer(br.readLine());

            // 숫자 개수 입력
            numCount = Integer.parseInt(st.nextToken());

            // 배열 생성
            nums = new int[numCount+1];
            prefixSum = new int[numCount+1];

            // 숫자 정보 입력
            for(int num=1; num<=numCount; num++) {
                nums[num] = Integer.parseInt(st.nextToken());
                prefixSum[num] = prefixSum[num-1] + nums[num];
            }

            // 소수 찾기
            System.out.println(solve());
        }
    }
}