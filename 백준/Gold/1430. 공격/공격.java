import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

// 위치 클래스
class Tower {
    int y;
    int x;
    int count;

    public Tower(int y, int x, int count) {
        this.y = y;
        this.x = x;
        this.count = count;
    }
}

public class Main {

    // 결과, 초기 에너지, 사정 거리
    public static double answer, initialEnergy, range;

    // 탑의 개수, 사정 거리, 적의 좌표
    public static int towerCount, enemyY, enemyX;

    // 탑 저장 배열
    public static Tower[] towers;

    // 방문 여부 배열
    public static boolean[] visited;

    // 사정 거리 확인 메서드
    public static boolean canNotInRange(int y1, int x1, int y2, int x2) {
        return Math.sqrt(Math.pow(y1 - y2, 2) + Math.pow(x1 - x2, 2)) > range;
    }

    // 탐색 수행 메서드
    public static void solve() {

        // 타워 저장 큐 생성
        Queue<Tower> queue = new LinkedList<>();

        // 방문 여부 배열 생성
        visited = new boolean[towerCount];

        // 시작 지점 처리
        queue.offer(new Tower(enemyY, enemyX, 0));

        // 탐색
        while(!queue.isEmpty()) {

            // 현재 위치
            Tower tower = queue.poll();

            // 타워 확인
            for(int index=0; index<towerCount; index++) {
                Tower connectedTower = towers[index];

                // 이미 방문한 경우
                if(visited[index]) continue;

                // 사정 거리 확인
                if(canNotInRange(tower.y, tower.x, connectedTower.y, connectedTower.x)) continue;

                // 에너지 더하기
                answer += initialEnergy / Math.pow(2, tower.count);

                // 처리
                visited[index] = true;
                queue.offer(new Tower(connectedTower.y, connectedTower.x, tower.count + 1));
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        // 탑의 개수, 사정 거리, 초기 에너지, 적의 좌표 입력
        st = new StringTokenizer(br.readLine());
        towerCount = Integer.parseInt(st.nextToken());
        range = Double.parseDouble(st.nextToken());
        initialEnergy = Double.parseDouble(st.nextToken());
        enemyY = Integer.parseInt(st.nextToken());
        enemyX = Integer.parseInt(st.nextToken());

        // 탑 저장 배열 생성
        towers = new Tower[towerCount];

        // 탑 좌표 입력
        for(int index=0; index<towerCount; index++) {
            st = new StringTokenizer(br.readLine());
            int y = Integer.parseInt(st.nextToken());
            int x = Integer.parseInt(st.nextToken());
            towers[index] = new Tower(y, x, 0);
        }

        // 탐색 수행
        solve();

        // 결과 출력
        System.out.println(answer);
    }
}