import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        // 연산 개수 입력
        int cnt = Integer.parseInt(br.readLine());

        // 우선 순위 큐 생성
        PriorityQueue<Integer> queue = new PriorityQueue<>();

        // 연산 입력
        for(int i=0; i<cnt; i++) {
            int order = Integer.parseInt(br.readLine());

            // 0
            if(order==0) {
                if(!queue.isEmpty())
                    sb.append(queue.poll());
                else sb.append(0);

                sb.append("\n");
            }

            // 숫자
            else {
                queue.offer(order);
            }
        }

        // 결과 출력
        System.out.println(sb.toString());
    }
}