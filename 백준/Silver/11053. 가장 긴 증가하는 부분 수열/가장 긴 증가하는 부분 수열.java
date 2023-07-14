import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        // 수열의 크기 입력
        int numCnt = Integer.parseInt(br.readLine());

        // 수열 정보 입력
        int nums[] = new int[numCnt];
        int DP[] = new int[numCnt];

        st = new StringTokenizer(br.readLine());
        for(int n=0; n<numCnt; n++) {
            nums[n] = Integer.parseInt(st.nextToken());
        }

        // 기본 셋팅
        DP[0] = 1;

        // 수열 확인
        for(int a=1; a<numCnt; a++) {

            // 기준 숫자, 길이 지정
            int num = nums[a];
            int numLen = 1;

            // 이전 수열 확인
            for(int b=a-1; b>=0; b--) {

                // 자신보다 작은 수를 찾을 경우
                if(nums[b]<num) {
                    numLen = Math.max(numLen,DP[b]+1);
                }
            }

            // 길이 갱신
            DP[a] = numLen;
        }
        
        // 정렬
        Arrays.sort(DP);

        // 결과 출력
        System.out.println(DP[DP.length-1]);
    }
}