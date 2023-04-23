import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    // 수행할 작업 수
    public static int workCnt;
    // 결과
    public static long result;
    // 작업 정보 리스트
    public static ArrayList<ArrayList<Integer>> work;
    // 선 작업 배열
    public static int degree[];
    // 작업 시간 정보 배열
    public static int workTime[];
    // 방문 배열
    public static boolean visited[];
    // 총 작업 시간 DP
    public static long DP[];
    // 작업 큐
    public static Queue<Integer> queue;

    // 작업 수행 함수
    static void startWork() {

        // 모든 작업 마칠 때까지 수행
        while(!queue.isEmpty()) {

            // 현재 작업
            int curWork = queue.poll();

            // 현재 작업을 선 작업으로 하는 작업 처리
            for(int w=0; w<work.get(curWork).size(); w++) {
                int nextWork = work.get(curWork).get(w);
                degree[nextWork] -= 1;
                
                // 작업이 오래 걸리는 경우로 갱신
                DP[nextWork] = Math.max(DP[nextWork],DP[curWork]+workTime[nextWork]);

                // 선 작업이 모두 이루어진 경우
                if(degree[nextWork]==0) {
                    queue.offer(nextWork);
                }
            }
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        // 작업 수 입력
        workCnt = Integer.parseInt(br.readLine());

        // 생성 및 초기화
        work = new ArrayList<>();
        for(int w=0; w<=workCnt; w++)
            work.add(new ArrayList<>());

        degree = new int[workCnt+1];
        workTime = new int[workCnt+1];
        visited = new boolean[workCnt+1];
        DP = new long[workCnt+1];

        // 작업 정보 입력
        for(int w=1; w<=workCnt; w++) {
            st = new StringTokenizer(br.readLine());
            int curTime = Integer.parseInt(st.nextToken());
            int preWorkCnt = Integer.parseInt(st.nextToken());

            // 선 작업 정보 입력
            for(int p=0; p<preWorkCnt; p++) {
                int preWork = Integer.parseInt(st.nextToken());
                work.get(preWork).add(w);
                visited[w] = true;
                degree[w] += 1;
            }
            workTime[w] = curTime;
        }

        // 가장 첫 작업 찾기
        queue = new LinkedList<>();
        for(int w=1; w<=workCnt; w++) {
            if(visited[w]==false) {
                queue.offer(w);
                DP[w] = workTime[w];
            }
        }

        // 작업 수행
        startWork();

        // 결과 저장
        result = 0;
        for(long element: DP)
            result = Math.max(result,element);

        // 결과 출력
        System.out.println(result);
    }
}