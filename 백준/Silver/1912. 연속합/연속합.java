import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        // 수열 개수 입력
        int number = Integer.parseInt(br.readLine());
        
        // 수열 생성
        int nums[] = new int[number];

        // 결과
        long answer = -(int)1e9;

        // 수열 정보 입력
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<number; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
            answer = Math.max(answer,nums[i]);
        }

        // 최고 합 구하기
        long sum = 0;

        for(int i=0; i<number; i++) {
            sum += nums[i];
            if(sum<0) sum = 0;
            else answer = Math.max(answer,sum);
        }

        // 결과 출력
        System.out.println(answer);
    }
}