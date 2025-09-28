import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    // 악보 개수, 질문 개수
    public static int count, orderCount;

    // 난이도 배열
    public static int[] level;

    // 누적합 배열
    public static int[] prefixSum;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        // 악보 개수 입력
        count = Integer.parseInt(br.readLine());

        // 배열 생성
        level = new int[count+1];
        prefixSum = new int[count+1];

        // 난이도 입력
        st = new StringTokenizer(br.readLine());
        for(int index=1; index<=count; index++) {
            level[index] = Integer.parseInt(st.nextToken());

            // 이전이 더 큰 경우
            if(level[index-1] > level[index]) prefixSum[index] += prefixSum[index-1] + 1;

            // 아닌 경우
            else prefixSum[index] = prefixSum[index-1];
        }

        // 질문 개수 입력
        orderCount = Integer.parseInt(br.readLine());

        // 질문 입력
        for(int index=0; index<orderCount; index++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int value = prefixSum[end] - prefixSum[start];
            sb.append(value).append("\n");
        }
        
        // 결과 출력
        System.out.println(sb.toString());
    }
}