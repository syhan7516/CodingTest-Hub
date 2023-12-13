import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 수열의 크기 입력
        int size = Integer.parseInt(br.readLine());

        // 수열 정보 우선 순위 큐 생성
        PriorityQueue<Integer> plus = new PriorityQueue<>(Collections.reverseOrder());
        PriorityQueue<Integer> minus = new PriorityQueue<>();

        // 결과
        int answer = 0;

        // 수열 정보 입력
        for(int i=0; i<size; i++) {
            int num = Integer.parseInt(br.readLine());

            // 1, 양수, 0과 음수 따로 저장
            if(num==1) answer += 1;
            else if(num>0) plus.offer(num);
            else minus.offer(num);
        }
        
        // 연산을 수행 할 두 수
        int first = 0;
        int second = 0;

        // 양수 수열 확인
        while(plus.size()>1) {

            // 수 꺼내기
            first = plus.poll();
            second = plus.poll();

            // 곱해서 더하기
            answer += (first*second);
        }

        // 음수 수열 확인
        while(minus.size()>1) {

            // 수 꺼내기
            first = minus.poll();
            second = minus.poll();

            // 곱해서 더하기
            answer += (first*second);
        }

        // 큐에 수가 남은 경우
        if(!plus.isEmpty()) answer += plus.poll();
        if(!minus.isEmpty()) answer += minus.poll();

        // 결과 출력
        System.out.println(answer);
    }
}