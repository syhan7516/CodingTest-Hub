import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    // 결과, 작업 개수
    public static int answer, jobCount;

    // 진입 차수, 시간 배열
    public static int[] degree, time;

    // 선행 정보 리스트
    public static ArrayList<ArrayList<Integer>> relations;

    // 작업 큐
    public static Queue<Integer> queue;

    // 작업 완료 시간
    public static int completeTime[];

    // 작업 수행 메서드
    public static void solve() {

        while(!queue.isEmpty()) {

            // 현재 작업
            int currentJob = queue.poll();

            // 연관된 작업 확인
            for(int job=0; job<relations.get(currentJob).size(); job++) {

                // 후속 작업
                int afterJob = relations.get(currentJob).get(job);

                // 후속 작업 처리
                degree[afterJob]--;
                completeTime[afterJob] = Math.max(completeTime[afterJob],completeTime[currentJob]+time[afterJob]);

                // 선행 작업이 완료된 경우
                if(degree[afterJob]==0)
                    queue.offer(afterJob);
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        // 작업 개수 입력
        jobCount = Integer.parseInt(br.readLine());

        // 진입 차수, 시간 배열 생성
        degree = new int[jobCount+1];
        time = new int[jobCount+1];

        // 선행 정보 리스트 생성, 초기화
        relations = new ArrayList<>();
        for(int job=0; job<=jobCount; job++)
            relations.add(new ArrayList<>());

        // 각 작업 정보 입력
        for(int job=1; job<=jobCount; job++) {
            st = new StringTokenizer(br.readLine());
            time[job] = Integer.parseInt(st.nextToken());
            int preJobCount = Integer.parseInt(st.nextToken());
            degree[job] = preJobCount;

            // 선행 작업 정보 입력
            for(int preJob=0; preJob<preJobCount; preJob++) {
                int pre = Integer.parseInt(st.nextToken());
                relations.get(pre).add(job);
            }
        }

        // 작업 규 생성
        queue = new LinkedList<>();

        // 작업 완료 시간 배열 생성
        completeTime = new int[jobCount+1];

        // 선행 조건이 없는 작업 확인
        for(int index=1; index<=jobCount; index++) {
            if(degree[index]==0) {
                queue.offer(index);
                completeTime[index] = time[index];
            }
        }

        // 작업 수행
        answer = 0;
        solve();

        // 결과 출력
        for(int result: completeTime)
            answer = Math.max(answer,result);
        System.out.println(answer);
    }
}