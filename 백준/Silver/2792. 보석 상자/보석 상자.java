import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        // 아이들 수, 색깔 수 입력
        st = new StringTokenizer(br.readLine());
        int childCount = Integer.parseInt(st.nextToken());
        int colorCount = Integer.parseInt(st.nextToken());

        // 색깔 배열 생성
        int[] colors = new int[colorCount];

        // 범위
        int left = 1;
        int right = Integer.MIN_VALUE;

        // 색깔 입력
        for(int colorIndex=0; colorIndex<colorCount; colorIndex++) {
            colors[colorIndex] = Integer.parseInt(br.readLine());
            right = Math.max(right, colors[colorIndex]);
        }
        
        // 확인
        int answer = 0;
        while(left <= right) {

            // 합
            int sum = 0;

            // 값 설정
            int mid = (left+right)/2;

            // 색깔 확인
            for(int colorIndex=0; colorIndex<colorCount; colorIndex++) {
                if(colors[colorIndex] % mid == 0) {
                    sum += colors[colorIndex]/mid;
                }

                else sum += colors[colorIndex] / mid + 1;
            }

            // 합이 더 큰 경우
            if(sum > childCount) left = mid+1;

            // 아닌 경우
            else {
                right = mid-1;
                answer = mid;
            }
        }

        // 결과 출력
        System.out.println(answer);
    }
}