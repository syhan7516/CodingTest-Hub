import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        // 결과
        int answer = 0;

        // 수열의 크기 입력
        int numCount = Integer.parseInt(br.readLine());

        // 수열 배열 생성
        int[] nums = new int[numCount];

        // 수열 정보 입력
        st = new StringTokenizer(br.readLine());
        for(int index=0; index<numCount; index++) {
            nums[index] = Integer.parseInt(st.nextToken());
        }

        // LDS 배열 생성
        int[] LDS = new int[numCount];

        // LDS 확인
        for(int index=0; index<numCount; index++) {

            // 길이
            int len = 1;

            // 이전 값들 확인
            for(int value=index-1; value>=0; value--) {

                // 나보다 큰 경우
                if(nums[value]>nums[index]) {
                    len = Math.max(len,LDS[value]+1);
                }
            }

            // LDS 갱신
            LDS[index] = len;
            answer = Math.max(answer,len);
        }

        // 결과 출력
        System.out.println(answer);
    }
}