import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        // 수열의 크기 입력
        int size = Integer.parseInt(br.readLine());

        // 수열 저장 배열
        int nums[] = new int[size];

        // 수열 정보 입력
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<size; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
        }

        // LIS 배열 생성
        int DP[] = new int[size];

        // 이전 수 찾기 배열
        int pre[] = new int[size];

        // 결과
        int len = 1;
        int lastNum = 0;

        // LIS 구하기

        // 초기 값
        DP[0] = 1;
        pre[0] = 0;

        for(int i=1; i<size; i++) {

            // 기준 수
            int current = nums[i];
            DP[i] = 1;
            pre[i] = i;

            // 비교
            for(int j=i-1; j>=0; j--) {

                // 자신보다 작은 수이면서 갱신 가능한 경우
                if(nums[j]<current && DP[i]<DP[j]+1) {
                    DP[i] = DP[j]+1;
                    pre[i] = j;
                }
            }

            // 결과 갱신
            if(len<DP[i]) {
                len = DP[i];
                lastNum = i;
            }
        }

        // 결과 출력
        System.out.println(len);
        Stack<Integer> stack = new Stack<>();
        while(true) {

            if(lastNum==pre[lastNum]) {
                stack.push(nums[lastNum]);
                break;
            }

            stack.push(nums[lastNum]);
            lastNum = pre[lastNum];
        }

        while(!stack.isEmpty()) {
            System.out.print(stack.pop()+" ");
        }
    }
}