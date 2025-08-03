import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        // 상자 수, 아이들 수 입력
        st = new StringTokenizer(br.readLine());
        int boxCount = Integer.parseInt(st.nextToken());
        int childCount = Integer.parseInt(st.nextToken());

        // 선물 개수 내림차순 우선 순위 큐 생성
        PriorityQueue<Integer> queue = new PriorityQueue<>(
                Collections.reverseOrder()
        );

        // 선물 개수 입력
        st = new StringTokenizer(br.readLine());
        for(int index=0; index<boxCount; index++) {
            queue.offer(Integer.parseInt(st.nextToken()));
        }

        // 원하는 선물 개수 입력
        boolean possible = true;
        st = new StringTokenizer(br.readLine());
        for(int index=0; index<childCount; index++) {

            int want = Integer.parseInt(st.nextToken());
            
            // 선물이 없거나, 원하는 개수만큼 못받을 경우
            if(queue.isEmpty() || queue.peek() < want) {
                possible = false;
                break;
            }

            // 선물이 남는 경우
            int exist = queue.poll() - want;
            if(exist > 0) {
                queue.offer(exist);
            }
        }

        // 결과 출력
        System.out.println(possible ? 1 : 0);
    }
}