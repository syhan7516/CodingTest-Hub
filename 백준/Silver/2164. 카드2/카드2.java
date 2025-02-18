import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 카드 수 입력
        int cardCount = Integer.parseInt(br.readLine());

        // 카드 저장 큐 생성
        Queue<Integer> queue = new LinkedList<>();

        // 카드 삽입
        for(int index=1; index<=cardCount; index++)
            queue.offer(index);

        // 작업 수행
        while(queue.size()>1) {

            // 카드 버리기
            queue.poll();

            // 카드 맨 뒤로 보내기
            queue.offer(queue.poll());
        }

        // 결과 출력
        System.out.println(queue.poll());
    }
}