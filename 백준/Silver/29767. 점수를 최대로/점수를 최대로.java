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

        // 교실 수, 학생 수 입력
        st = new StringTokenizer(br.readLine());
        int classCount = Integer.parseInt(st.nextToken());
        int studentCount = Integer.parseInt(st.nextToken());

        // 누적합 배열 생성
        long[] prefixSum = new long[classCount];

        // 우선 순위 큐 생성
        PriorityQueue<Long> queue = new PriorityQueue<>(
                Collections.reverseOrder()
        );

        // 점수 입력
        st = new StringTokenizer(br.readLine());
        prefixSum[0] = Integer.parseInt(st.nextToken());
        queue.offer(prefixSum[0]);
        for(int index=1; index<classCount; index++) {
            prefixSum[index] = prefixSum[index-1] + Integer.parseInt(st.nextToken());
            queue.offer(prefixSum[index]);
        }

        // 점수 확인
        long answer = 0;
        while(!queue.isEmpty() && studentCount-->0) {
            answer += queue.poll();
        }

        // 결과 출력
        System.out.println(answer);
    }
}