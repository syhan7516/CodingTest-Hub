import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        // 수열의 크기 입력
        int size = Integer.parseInt(br.readLine());

        // 수열 정보 배열 생성
        int nums[] = new int[size];

        // 수열 정보 입력
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<size; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
        }

        // LIS 누적합에 대한 배열
        int DP[] = new int[size];

        // 초기 셋팅
        DP[0] = nums[0];

        // LIS 확인
        int max = DP[0];

        for(int i=1; i<size; i++) {

            // 기준 수
            int current = nums[i];

            // 초기 값
            DP[i] = current;

            // 비교 수
            for(int j=i-1; j>=0; j--) {

                // 증가하는 수열인 경우
                if(nums[j]<current) {
                    DP[i] = Math.max(DP[j]+current,DP[i]);
                }
            }

            // 가장 큰 수 누적합 갱신
            max = Math.max(DP[i],max);
        }

        // 결과 출력
        System.out.println(max);
    }
}