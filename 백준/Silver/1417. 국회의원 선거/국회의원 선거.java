import java.io.*;
import java.util.*;

public class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 결과
        int answer = 0;

        // 후보 수 입력
        int count = Integer.parseInt(br.readLine());

        // 다솜이가 받을 투표 수 입력
        int voteCount = Integer.parseInt(br.readLine());

        // 다솜이만 후보인 경우
        if(count == 1) System.out.println(answer);

        // 아닌 경우
        else {

            // 투표 수 우선 순위 큐 생성
            PriorityQueue<Integer> queue = new PriorityQueue<>(Collections.reverseOrder());

            // 나머지 투표 수 입력
            for(int index=0; index<count-1; index++) {
                queue.offer(Integer.parseInt(br.readLine()));
            }

            // 투표 매수 수행
            while(!queue.isEmpty() && voteCount <= queue.peek()) {
                int currentVote = queue.poll();
                voteCount++;
                answer++;
                queue.offer(--currentVote);
            }

            // 결과 출력
            System.out.println(answer);
        }
    }
}