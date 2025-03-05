import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 결과
        int answer = 0;

        // 숫자 개수 입력
        int numCount = Integer.parseInt(br.readLine());

        // 우선 순위 큐 생성
        PriorityQueue<Integer> plusQueue = new PriorityQueue<>(Collections.reverseOrder());
        PriorityQueue<Integer> minusQueue = new PriorityQueue<>();

        // 숫자 입력
        for(int index=0; index<numCount; index++) {
            int number = Integer.parseInt(br.readLine());

            // 1인 경우
            if(number==1) answer++;

            // 양수인 경우
            else if(number>0) plusQueue.offer(number);

            // 음수인 경우
            else minusQueue.offer(number);
        }

        // 숫자 확인
        while(plusQueue.size()>1) {
            int first = plusQueue.poll();
            int second = plusQueue.poll();
            answer += (first*second);
        }

        while(minusQueue.size()>1) {
            int first = minusQueue.poll();
            int second = minusQueue.poll();
            answer += (first*second);
        }

        // 나머지 수 다 더하기
        if(!plusQueue.isEmpty()) answer += plusQueue.poll();
        if(!minusQueue.isEmpty()) answer += minusQueue.poll();

        // 결과 출력
        System.out.println(answer);
    }
}