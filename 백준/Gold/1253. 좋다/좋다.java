import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        // 숫자 개수 입력
        int numCnt = Integer.parseInt(br.readLine());

        // 숫자 정보 배열 생성
        int nums[] = new int[numCnt];

        // 숫자 정보 입력
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<numCnt; i++)
            nums[i] = Integer.parseInt(st.nextToken());

        // 정렬
        Arrays.sort(nums);

        // 좋다 수 찾기
        int answer = 0;
        for(int i=0; i<numCnt; i++) {

            // 범위 지정
            int left = 0;
            int right = numCnt-1;

            while(true) {

                // 자기 자신일 경우
                if(left==i) left++;
                if(right==i) right--;

                // 값이 없는 경우
                if(left>=right) break;

                // 두 수 더하기
                int sum = nums[left]+nums[right];

                // 존재하는 경우
                if(sum==nums[i]) {
                    answer++;
                    break;
                }

                // 존재하지 않으며, 구한 값이 더 큰 경우
                else if(sum>nums[i]) right--;

                // 존재하지 않으며, 구한 값이 더 작은 경우
                else left++;
            }
        }

        // 결과 출력
        System.out.println(answer);
    }
}