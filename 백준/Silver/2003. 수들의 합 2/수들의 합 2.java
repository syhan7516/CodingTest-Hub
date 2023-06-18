import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        // 개수, 목표 수 입력
        st = new StringTokenizer(br.readLine());
        int numCnt = Integer.parseInt(st.nextToken());
        int goal = Integer.parseInt(st.nextToken());

        // 개수 정보 입력
        int nums[] = new int[numCnt];

        st = new StringTokenizer(br.readLine());
        for(int n=0; n<numCnt; n++) {
            nums[n] = Integer.parseInt(st.nextToken());
        }

        // 합 찾기
        int result = 0;
        int point = 0;
        int sumTotal = 0;

        for(int start=0; start<numCnt; start++) {
            while(sumTotal<goal && point<numCnt) {
                sumTotal += nums[point];
                point++;
            }

            // 목표와 합이 같은 경우
            if(sumTotal==goal) result++;

            sumTotal -= nums[start];
        }

        // 결과 출력
        System.out.println(result);
    }
}