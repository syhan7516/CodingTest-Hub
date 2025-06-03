import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {

    // 결과, 작업 개수, 순서 개수, 목표 작업
    public static int answer, jobCount, orderCount, targetJob;

    // 작업 순서 저장 리스트
    public static ArrayList<ArrayList<Integer>> relations;

    // 작업 방문 여부 배열
    public static boolean[] visited;

    // 작업 순서 확인 메서드
    public static void solve(int job) {

        // 필요한 작업 확인
        for(int beforeJobIndex=0; beforeJobIndex<relations.get(job).size(); beforeJobIndex++) {

            // 필요한 이전 작업
            int beforeJob = relations.get(job).get(beforeJobIndex);

            // 이미 수행한 경우
            if(visited[beforeJob]) continue;

            // 수행하지 않은 경우
            visited[beforeJob] = true;
            answer++;
            solve(beforeJob);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        // 작업 개수, 순서 개수 입력
        st = new StringTokenizer(br.readLine());
        jobCount = Integer.parseInt(st.nextToken());
        orderCount = Integer.parseInt(st.nextToken());

        // 작업 순서 저장 리스트 생성
        relations = new ArrayList<>();
        for(int jobIndex=0; jobIndex<=jobCount; jobIndex++) {
            relations.add(new ArrayList<>());
        }

        // 작업 순서 입력
        for(int orderIndex=0; orderIndex<orderCount; orderIndex++) {
            st = new StringTokenizer(br.readLine());
            int beforeJob = Integer.parseInt(st.nextToken());
            int afterJob = Integer.parseInt(st.nextToken());
            relations.get(afterJob).add(beforeJob);
        }

        // 목표 작업 입력
        targetJob = Integer.parseInt(br.readLine());

        // 작업 방문 여부 배열 생성
        visited = new boolean[jobCount+1];

        // 작업 순서 확인
        solve(targetJob);

        // 결과 출력
        System.out.println(answer);
    }
}