import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        // 크기 입력
        int size = Integer.parseInt(br.readLine());

        // 우선 순위 큐 생성
        PriorityQueue<Integer> queue = new PriorityQueue<>(Collections.reverseOrder());

        // 숫자 입력
        for(int i=0; i<size; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<size; j++) {
                queue.offer(Integer.parseInt(st.nextToken()));
            }
        }

        // N번째 큰 수 구하기
        for(int i=0; i<size-1; i++)
            queue.poll();

        // 결과 출력
        System.out.println(queue.poll());
    }
}