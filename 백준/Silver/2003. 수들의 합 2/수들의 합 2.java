import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        // 숫자 개수, 목표 수 입력
        st = new StringTokenizer(br.readLine());
        int numCnt = Integer.parseInt(st.nextToken());
        int target = Integer.parseInt(st.nextToken());

        // 숫자 정보 배열 생성
        int nums[] = new int[numCnt];

        // 숫자 정보 입력
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<numCnt; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
        }

        // 결과
        int answer = 0;

        // 합 구하기
        int point = 0;
        long sum = 0;

        for(int start=0; start<numCnt; start++) {
            while(point<numCnt && sum<target) {
                sum += nums[point];
                point++;
            }

            // 경우의 수를 구한 경우
            if(sum==target) {
                answer++;
            }

            // 맨 앞 수 빼기
            sum -= nums[start];
        }

        // 결과 출력
        System.out.println(answer);
    }
}