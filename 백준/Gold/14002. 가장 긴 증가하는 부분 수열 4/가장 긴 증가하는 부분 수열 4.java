import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        // 수열의 개수 입력
        int numsLen = Integer.parseInt(br.readLine());

        // 수열, DP 저장 배열 선언
        int nums[] = new int[numsLen+1];
        int DP[] = new int[numsLen+1];

        // 수열 요소 입력
        st = new StringTokenizer(br.readLine());
        for(int n=1; n<=numsLen; n++) {
            nums[n] = Integer.parseInt(st.nextToken());
        }

        // 부분 수열 확인
        int maxLen = 0;

        for(int a=1; a<=numsLen; a++) {
            DP[a] = 1;
            for(int b=0; b<a; b++) {
                if(nums[a]>nums[b]) {
                    DP[a] =  Math.max(DP[a],DP[b]+1);
                    maxLen = Math.max(DP[a],maxLen);
                }
            }
        }

        // 최장 길이 저장
        sb.append(maxLen+"\n");

        // 최장 길이 원소들 저장
        Stack<Integer> result = new Stack<>();

        for(int s=numsLen; s>0; s--) {
            if(DP[s]==maxLen) {
                result.push(nums[s]);
                maxLen--;
            }
        }

        // 결과 저장
        while(!result.isEmpty()) {
            sb.append(result.pop()+" ");
        }

        // 결과 출력
        System.out.println(sb.toString());
    }
}