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
        for(int i=0; i<numCnt; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
        }

        // 정렬
        Arrays.sort(nums);

        // 결과
        int answer = 0;

        // 좋다 수 찾기
        for(int i=0; i<numCnt; i++) {

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

                // 비교
                if(sum==nums[i]) {
                    answer++;
                    break;
                }

                else if(sum>nums[i]) right--;

                else left++;
            }
        }

        // 결과 출력
        System.out.println(answer);
    }
}