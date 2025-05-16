import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        // 수열 개수 입력
        int numCount = Integer.parseInt(br.readLine());
        
        // 수열 생성
        int nums[] = new int[numCount];
        
        // 연속합 배열 생성
        int[] DP = new int[numCount];

        // 수열 정보 입력
        st = new StringTokenizer(br.readLine());
        for(int numIndex=0; numIndex<numCount; numIndex++) {
            nums[numIndex] = Integer.parseInt(st.nextToken());
        }
        
        // 결과
        int answer = nums[0];
        DP[0] = nums[0];

        for(int numIndex=1; numIndex<numCount; numIndex++) {
            DP[numIndex] = Math.max(DP[numIndex-1]+nums[numIndex],nums[numIndex]);
            answer = Math.max(answer,DP[numIndex]);
        }

        // 결과 출력
        System.out.println(answer);
    }
}