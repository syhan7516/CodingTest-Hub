import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        // 카드 묶음 수 입력
        int cnt = Integer.parseInt(br.readLine());

        // 우선 순위 큐 생성
        PriorityQueue<Long> queue = new PriorityQueue<>();

        // 묶음 수 입력
        for(int i=0; i<cnt; i++)
            queue.offer(Long.parseLong(br.readLine()));

        // 결과
        long answer = 0;

        // 묶음 더하기
        while(queue.size()>1) {

            long group = queue.poll()+queue.poll();
            queue.offer(group);
            answer += group;
        }

        // 결과 출력
        System.out.println(answer);
    }
}