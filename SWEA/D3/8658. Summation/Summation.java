import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {

    // 숫자 확인 함수
    static int[] checkNum(int nums[]) {
        // 최대, 최소 담을 배열
        int result[] = {Integer.MIN_VALUE, Integer.MAX_VALUE};

        // 숫자 하나씩 확인
        int numSum = 0;
        int number = 0;
        for(int n=0; n<nums.length; n++) {
            number = nums[n];
            numSum = 0;
            while(number!=0) {
                numSum += number%10;
                number /= 10;
            }

            // 최대, 최소 저장
            if(numSum>result[0])
                result[0] = numSum;

            if(numSum<result[1])
                result[1] = numSum;
        }

        // 결과 반환
        return result;
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        // 테스트 케이스 수 입력
        int caseNum = Integer.parseInt(br.readLine());

        // 케이스 수만큼 수행
        for(int caseIdx=0; caseIdx<caseNum; caseIdx++) {

            // 숫자 입력
            int nums[] = new int[10];
            st = new StringTokenizer(br.readLine());
            for(int n=0; n<10; n++) {
                nums[n] = Integer.parseInt(st.nextToken());
            }

            // 숫자 확인
            int result[] = checkNum(nums);

            // 결과 출력
            System.out.println("#"+(caseIdx+1)+" "+result[0]+" "+result[1]);
        }
    }
}
