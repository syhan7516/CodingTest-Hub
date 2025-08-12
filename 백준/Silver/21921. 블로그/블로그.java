import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        // 일 수, 기간 입력
        st = new StringTokenizer(br.readLine());
        int days = Integer.parseInt(st.nextToken());
        int term = Integer.parseInt(st.nextToken());

        // 방문자 수 배열 생성
        int[] visit = new int[days+1];

        // 누적합 배열 생성
        int[] prefixSum = new int[days+1];

        // 방문자 수 입력
        st = new StringTokenizer(br.readLine());
        for(int index=1; index<=days; index++) {
            visit[index] = Integer.parseInt(st.nextToken());
            prefixSum[index] = prefixSum[index-1] + visit[index];
        }

        // 누적합 배열 확인
        int[] answer = {0,0};
        for(int index=term; index<=days; index++) {
            int visitCount = prefixSum[index] - prefixSum[index-term+1] + visit[index-term+1];
            if(answer[0] <= visitCount) {
                if(answer[0] == visitCount) {
                    answer[1]++;
                }
                else {
                    answer[0] = visitCount;
                    answer[1] = 1;
                }
            }
        }

        // 결과 출력
        if(answer[0] == 0) System.out.println("SAD");
        else {
            System.out.println(answer[0]);
            System.out.println(answer[1]);
        }
    }
}