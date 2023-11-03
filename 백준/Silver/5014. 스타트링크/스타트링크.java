import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    // 건물 층, 현재, 회사, 위, 아래, 결과
    public static int maxFloor, currentFloor, companyFloor, up, down, answer;

    // 방문 정보 배열
    public static int floors[];

    // 회사 가기
    static void solve() {

        // 큐
        Queue<Integer> queue = new LinkedList<>();

        // 이동 가능한 층
        int operation[] = {up, -down};

        // 현재 층 처리
        floors[currentFloor] = 1;
        queue.offer(currentFloor);

        // 층 이동
        while(!queue.isEmpty()) {

            // 현재 층
            int current = queue.poll();

            // 만약 회사인 경우
            if(current==companyFloor) {
                answer = floors[current];
                return;
            }

            // 이동 가능한 층 확인
            for(int f=0; f<2; f++) {

                int nextFloor = current+operation[f];

                // 범위 확인
                if(nextFloor<1 || nextFloor>maxFloor)
                    continue;

                // 이미 방문한 경우
                if(floors[nextFloor]!=0)
                    continue;

                // 이동
                floors[nextFloor] = floors[current]+1;
                queue.offer(nextFloor);
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        // 입력
        st = new StringTokenizer(br.readLine());
        maxFloor = Integer.parseInt(st.nextToken());
        currentFloor = Integer.parseInt(st.nextToken());
        companyFloor = Integer.parseInt(st.nextToken());
        up = Integer.parseInt(st.nextToken());
        down = Integer.parseInt(st.nextToken());

        // 회사가기
        answer = 0;
        floors = new int[maxFloor+1];
        solve();

        // 결과 출력
        if(answer==0)
            System.out.println("use the stairs");
        else
            System.out.println(answer-1);
    }
}