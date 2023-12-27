import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        // 수열의 길이, 차이 범위 입력
        st = new StringTokenizer(br.readLine());
        int numCnt = Integer.parseInt(st.nextToken());
        int range = Integer.parseInt(st.nextToken());

        // 수열 배열 생성
        int nums[] = new int[numCnt];

        // 수열 정보 입력
        for(int i=0; i<numCnt; i++) {
            nums[i] = Integer.parseInt(br.readLine());
        }

        // 수열 정렬
        Arrays.sort(nums);

        // 결과
        int answer = Integer.MAX_VALUE;

        // 두 수의 차 확인
        int left = 0;
        int right = 0;

        while(right<numCnt && left<=right) {

            // 두 수의 차
            int diff = nums[right]-nums[left];

            // 차가 범위와 같거나 큰 경우
            if(diff>=range) {

                // 결과 갱신
                answer = Math.min(answer, diff);
                
                // 왼쪽 인덱스 증가(차이가 작아짐)
                left++;
            }

            // 아닌 경우 오른쪽 값 증가(차이가 커짐)
            else right++;
        }

        // 결과 출력
        System.out.println(answer);
    }
}