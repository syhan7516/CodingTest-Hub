import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        
        // 수열의 길이 입력
        int numCnt = Integer.parseInt(br.readLine());
        
        // 수열 저장 배열 생성
        int nums[] = new int[numCnt+1];
        
        // 숫자 정보 입력
        st = new StringTokenizer(br.readLine());
        for (int i=1; i<=numCnt; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
        }

        // 결과
        long answer = 0;

        // 위치
        int left = 1;
        int right = 0;

        // 숫자 개수 정보 배열
        int cnt[] = new int[100001];
        
        // 수열 확인
        while(left<=numCnt) {
            
            while(right+1<=numCnt && cnt[nums[right+1]]==0) {
                right++;
                cnt[nums[right]]++;
            }

            answer += (right-left+1);
            cnt[nums[left++]]--;
        }

        // 결과 출력
        System.out.println(answer);
    }
}