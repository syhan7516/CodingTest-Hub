import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        // 수열의 길이, 삭제 횟수 입력
        st = new StringTokenizer(br.readLine());
        int numCnt = Integer.parseInt(st.nextToken());
        int delCnt = Integer.parseInt(st.nextToken());

        // 수열 배열 생성
        int nums[] = new int[numCnt];

        // 배열 정보 입력
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<numCnt; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
        }

        // 결과
        int answer = 0;

        // 수열 확인
        int left = 0;
        int right = 0;
        int cnt = 0;

        while(left<=right) {

            while(right<numCnt && cnt<=delCnt) {

                // 홀, 짝 확인
                if(nums[right]%2!=0)
                    cnt++;

                // 오른쪽 인덱스 증가
                right++;
            }
            
            // 삭제 횟수가 넘은 경우
            if(cnt>delCnt) {

                // 길이 갱신
                answer = Math.max(answer,right-1-left-delCnt);

                // 현재 왼쪽 인덱스 홀, 짝 확인
                if(nums[left]%2!=0)
                    cnt--;

                // 왼쪽 인덱스 증가
                left++;
            }

            // 범위가 벗어난 경우
            else {
                answer = Math.max(answer,right-left-cnt);
                break;
            }
        }

        // 결과 출력
        System.out.println(answer);
    }
}