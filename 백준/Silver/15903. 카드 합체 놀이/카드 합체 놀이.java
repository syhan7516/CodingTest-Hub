import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        // 카드 수, 합칠 수 입력
        st = new StringTokenizer(br.readLine());
        int cardCnt = Integer.parseInt(st.nextToken());
        int plusCnt = Integer.parseInt(st.nextToken());

        // 카드 저장 우선 순위 큐 생성
        PriorityQueue<Long> priQ = new PriorityQueue<>();

        // 카드 정보 입력
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<cardCnt; i++) {
            priQ.offer(Long.parseLong(st.nextToken()));
        }

        // 카드 합치기
        while(plusCnt>0) {

            // 가장 작은 두 수 꺼내기
            long first = priQ.poll();
            long second = priQ.poll();

            // 더하기
            priQ.offer(first+second);
            priQ.offer(first+second);

            // 횟수 감소
            plusCnt--;
        }

        // 카드 모두 더하기
        long answer = 0;
        while(!priQ.isEmpty()) {
            answer += priQ.poll();
        }

        // 결과 출력
        System.out.println(answer);
    }
}