import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        // 우선순위 큐
        PriorityQueue<Integer> priQ = new PriorityQueue<>();

        // 표의 크기 입력
        int chart = Integer.parseInt(br.readLine());

        // 표의 수 입력
        for(int row=0; row<chart; row++) {
            st = new StringTokenizer(br.readLine());
            for(int col=0; col<chart; col++) {
                int number = Integer.parseInt(st.nextToken());
                priQ.offer(-number);
            }
        }

        // 큰 수 찾기
        int result = 0;
        int count = 0;
        while(true) {

            // 큰 수 꺼내기
            int num = priQ.poll();
            count += 1;

            // 차례인 경우
            if(count == chart) {
                result = -num;
                break;
            }
        }

        // 결과 출력
        System.out.println(result);
    }
}