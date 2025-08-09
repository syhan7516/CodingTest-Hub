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

        // 일의 개수, 중요도, 완료 기준 입력
        st = new StringTokenizer(br.readLine());
        int workCount = Integer.parseInt(st.nextToken());
        int score = Integer.parseInt(st.nextToken());
        int completeScore = Integer.parseInt(st.nextToken());

        // 우선 순위 큐 생성
        PriorityQueue<Integer> works = new PriorityQueue<>(
                Collections.reverseOrder()
        );

        // 일의 중요도 입력
        for(int index=0; index<workCount; index++) {
            works.offer(Integer.parseInt(br.readLine()));
        }

        // 업무 수행
        int dayCount = 0;
        int yesterday = 0;
        while(!works.isEmpty()) {

            // 당일 업무
            int work = works.poll();

            // 만족도 확인
            int degree = yesterday/2 + work;
            yesterday = degree;
            sb.append(degree).append("\n");

            // 업무 수행
            work -= score;

            // 마무리가 덜된 경우
            if(work > completeScore) {
                works.offer(work);
            }

            dayCount++;
        }

        // 결과 출력
        System.out.println(dayCount);
        System.out.println(sb.toString());
    }
}