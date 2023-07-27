import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        Queue<Integer> queue = new LinkedList<>();
        StringBuilder answer = new StringBuilder();
        int cur = 0;

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String order = st.nextToken();
            if (order.equals("push")) {
                cur = Integer.parseInt(st.nextToken());
                queue.offer(cur);
            } else {
                if (order.equals("pop"))  answer.append((queue.isEmpty()) ? -1 : queue.poll());
                else if (order.equals("size"))  answer.append(queue.size());
                else if (order.equals("empty"))  answer.append((queue.isEmpty()) ? 1 : 0);
                else if (order.equals("front"))  answer.append((queue.isEmpty()) ? -1 : queue.peek());
                else if (order.equals("back")) answer.append((queue.isEmpty()) ? -1 : cur);
                answer.append("\n");
            }
        }
        System.out.println(answer);
    }
}