import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        // 방문 횟수 입력
        int visitCount = Integer.parseInt(br.readLine());

        // 선물 가치 우선 순위 큐 생성
        PriorityQueue<Integer> queue = new PriorityQueue<>(
                Collections.reverseOrder()
        );

        // 방문 정보 입력
        for(int index=0; index<visitCount; index++) {
            st = new StringTokenizer(br.readLine());
            int order = Integer.parseInt(st.nextToken());

            // 아이를 만난 경우
            if(order==0) {
                if(queue.isEmpty()) {
                    sb.append(-1).append("\n");
                }
                else sb.append(queue.poll()).append("\n");
            }

            else {
                while(st.hasMoreTokens()) {
                    queue.offer(Integer.parseInt(st.nextToken()));
                }
            }
        }

        // 결과 출력
        System.out.println(sb.toString());
    }
}