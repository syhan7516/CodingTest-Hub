import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        // 사람 수, 목표 값 입력
        st = new StringTokenizer(br.readLine());
        int count = Integer.parseInt(st.nextToken());
        int target = Integer.parseInt(st.nextToken());

        // 우선 순위 큐 생성
        PriorityQueue<Integer> queue = new PriorityQueue<>();

        // 현재 불만도
        long currentValue = 0;

        // 파묻튀 먹이기
        int answer = 0;
        st = new StringTokenizer(br.readLine());
        for(int index=0; index<count; index++) {
            int value = Integer.parseInt(st.nextToken());
            currentValue += value;
            queue.offer(-value);

            // 불만도 낮추기
            while(!queue.isEmpty() && currentValue >= target) {
                value = -queue.poll();
                currentValue -= value;
                currentValue -= value;
                answer++;
            }
        }

        // 결과 출력
        System.out.println(answer);
    }
}