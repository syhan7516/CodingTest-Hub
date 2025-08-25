import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

// 작업 클래스
class Job implements Comparable<Job> {
    int id;
    int time;
    int score;

    public Job(int id, int time, int score) {
        this.id = id;
        this.time = time;
        this.score = score;
    }

    @Override
    public int compareTo(Job other) {
        if(this.score == other.score) {
            return this.id - other.id;
        }

        return other.score - this.score;
    }
}

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        // 시간, 작업 수 입력
        st = new StringTokenizer(br.readLine());
        int totalTime = Integer.parseInt(st.nextToken());
        int jobCount = Integer.parseInt(st.nextToken());

        // 우선 순위 큐 생성
        PriorityQueue<Job> queue = new PriorityQueue<>();

        // 작업 정보 입력
        for(int index=1; index<=jobCount; index++) {
            st = new StringTokenizer(br.readLine());
            int id = Integer.parseInt(st.nextToken());
            int time = Integer.parseInt(st.nextToken());
            int score = Integer.parseInt(st.nextToken());
            queue.offer(new Job(id, time, score));
        }

        // 작업 수행
        while(!queue.isEmpty() && totalTime-->0) {

            // 진행 작업
            Job job = queue.poll();

            // 저장
            sb.append(job.id).append("\n");

            // 시간 감소
            job.time--;

            // 작업이 남은 경우
            if(job.time > 0) {
                job.score--;
                queue.offer(job);
            }
        }

        // 결과 출력
        System.out.println(sb.toString());
    }
}