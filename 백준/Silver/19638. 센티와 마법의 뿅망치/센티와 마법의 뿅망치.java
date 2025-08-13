import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

    // 거인의 수, 망치 수, 센티의 키, 망치 남은 횟수
    public static int giantCount, hammerCount, centi, remainingCount;

    // 우선 순위 큐
    public static PriorityQueue<Integer> queue;

    // 망치 사용 메서드
    public static void solve() {
        remainingCount = 0;
        while(remainingCount < hammerCount && queue.peek() >= centi && queue.peek() > 1) {

            // 키 줄이기
            queue.offer(queue.poll()/2);
            remainingCount++;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        // 거인의 수, 망치 수, 센티의 키 입력
        st = new StringTokenizer(br.readLine());
        giantCount = Integer.parseInt(st.nextToken());
        centi = Integer.parseInt(st.nextToken());
        hammerCount = Integer.parseInt(st.nextToken());

        // 우선 순위 큐 생성
        queue = new PriorityQueue<>(
                Collections.reverseOrder()
        );

        // 거인 정보 입력
        for(int index=0; index<giantCount; index++) {
            queue.offer(Integer.parseInt(br.readLine()));
        }

        // 망치 사용
        solve();

        // 결과 출력
        if(queue.peek() < centi) sb.append("YES").append("\n").append(remainingCount);
        else sb.append("NO").append("\n").append(queue.peek());
        System.out.println(sb.toString());
    }
}