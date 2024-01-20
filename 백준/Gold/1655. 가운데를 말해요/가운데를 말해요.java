import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        // 우선 순위 큐 생성
        PriorityQueue<Integer> min = new PriorityQueue<>();
        PriorityQueue<Integer> max = new PriorityQueue<>(Collections.reverseOrder());

        // 숫자 개수 입력
        int cnt = Integer.parseInt(br.readLine());

        // 첫 수
        int num = Integer.parseInt(br.readLine());
        max.offer(num);
        sb.append(num).append("\n");

        // 숫자 입력
        for(int i=1; i<cnt; i++) {
            num = Integer.parseInt(br.readLine());

            // max 값보다 큰 경우
            if(num>max.peek()) {
                min.offer(num);

                // 개수가 홀수인 경우
                if((i+1)%2!=0)
                    max.offer(min.poll());
            }

            // max 값보다 작거나 같은 경우
            else {
                max.offer(num);

                // 개수가 짝수이면서 max 개수가 더 많은 경우
                if((i+1)%2==0 && max.size()>min.size())
                    min.offer(max.poll());
            }

            // 결과 저장
            sb.append(max.peek()).append("\n");
        }

        // 결과 출력
        System.out.println(sb.toString());
    }
}