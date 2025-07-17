import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        // 부서 개수 입력
        int departmentCount = Integer.parseInt(br.readLine());

        // 부서 총 면담 시간 저장 우선 순위 큐 생성
        PriorityQueue<Integer> queue = new PriorityQueue<>();

        // 부서 면담 시간 확인
        for(int department=0; department<departmentCount; department++) {

            // 인원 입력
            st = new StringTokenizer(br.readLine());
            int count = Integer.parseInt(st.nextToken());

            // 면담 총 시간
            int totalTime = 0;

            // 면담 시간 입력
            for(int time=0; time<count; time++) {
                totalTime += Integer.parseInt(st.nextToken());
            }

            // 부서 총 면담 시간 저장
            queue.offer(totalTime);
        }

        // 부서별 총 면담 시간 확인
        long answer = 0;
        long waitTime = 0;
        while(!queue.isEmpty()) {
            int progressTime = queue.poll();
            answer += waitTime + progressTime;
            waitTime += progressTime;
        }

        // 결과 출력
        System.out.println(answer);
    }
}