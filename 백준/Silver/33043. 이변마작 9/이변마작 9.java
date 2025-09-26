import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        // 개수 입력
        int count = Integer.parseInt(br.readLine());

        // 해시 생성
        Map<String, Queue<Integer>> map = new HashMap<>();


        int answer = Integer.MAX_VALUE;
        st = new StringTokenizer(br.readLine());
        for (int index=1; index<=count; index++) {
            String card = st.nextToken();

            // 패가 없으면 큐 생성
            if(!map.containsKey(card)) {
                map.put(card, new LinkedList<>());
            }

            Queue<Integer> queue = map.get(card);
            queue.offer(index);

            // 같은 카드가 5개인 경우
            if(queue.size() == 5) {

                // 마지막 패 제거
                int prevKind = queue.poll();
                answer = Math.min(answer, index-prevKind+1);
            }
        }

        // 결과 출력
        if(answer == Integer.MAX_VALUE) answer = -1;
        System.out.println(answer);
    }
}