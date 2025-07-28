import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        // 결과
        long answer = 0;

        // 숫자 개수 입력
        int numCount = Integer.parseInt(br.readLine());

        // 누적합 배열 생성
        long[] prefixSum = new long[numCount];

        // 숫자 입력
        st = new StringTokenizer(br.readLine());
        prefixSum[0] = Integer.parseInt(st.nextToken());
        for(int index=1; index<numCount; index++) {
            int num = Integer.parseInt(st.nextToken());
            prefixSum[index] += prefixSum[index-1] + num;
            answer += prefixSum[index - 1] * num;
        }

        // 결과 출력
        System.out.println(answer);
    }
}