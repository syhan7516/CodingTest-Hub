import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

// 도로 클래스
class Road implements Comparable<Road> {
    int home;
    int distance;

    public Road(int home, int distance) {
        this.home = home;
        this.distance = distance;
    }

    @Override
    public int compareTo(Road other) {
        return this.distance - other.distance;
    }
}

public class Main {

    // 결과, 집 개수, 도로 개수, 최대 이동 거리, 사는 집
    public static int answer, homeCount, roadCount, maxMoveDistance, myHome;

    // 연결 정보 리스트
    public static ArrayList<ArrayList<Road>> relations;

    // 최단 거리 배열
    public static int[] path;

    // 방문 여부 배열
    public static boolean[] visited;

    // 최단 거리 구하기 메서드
    public static void solve() {

        // 거리 우선 순위 큐 생성
        PriorityQueue<Road> queue = new PriorityQueue<>();

        // 방문 여부 배열 생성
        visited = new boolean[homeCount+1];

        // 최단 거리 배열 생성
        path = new int[homeCount+1];
        Arrays.fill(path, (int)1e9);

        // 시작 지점 처리
        path[0] = 0;
        path[myHome] = 0;
        queue.offer(new Road(myHome, 0));

        // 탐색
        while(!queue.isEmpty()) {

            // 현재 위치
            Road road = queue.poll();

            // 이미 방문한 경우
            if(visited[road.home]) continue;

            // 방문 처리
            visited[road.home] = true;

            // 연결 도로 확인
            for(int index=0; index<relations.get(road.home).size(); index++) {
                Road connectedRoad = relations.get(road.home).get(index);

                // 이미 방문한 경우
                if(visited[connectedRoad.home]) continue;

                // 기존 거리보다 더 짧은 경우
                if(path[connectedRoad.home] > path[road.home] + connectedRoad.distance) {
                    path[connectedRoad.home] = path[road.home] + connectedRoad.distance;
                    queue.offer(new Road(connectedRoad.home, path[connectedRoad.home]));
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        // 집 개수, 도로 개수, 최대 이동 거리, 사는 집 입력
        st = new StringTokenizer(br.readLine());
        homeCount = Integer.parseInt(st.nextToken());
        roadCount = Integer.parseInt(st.nextToken());
        maxMoveDistance = Integer.parseInt(st.nextToken());
        myHome = Integer.parseInt(st.nextToken()) + 1;

        // 연결 정보 리스트 생성
        relations = new ArrayList<>();
        for(int index=0; index<=homeCount; index++) {
            relations.add(new ArrayList<>());
        }

        // 연결 정보 입력
        for(int index=0; index<roadCount; index++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken()) + 1;
            int to = Integer.parseInt(st.nextToken()) + 1;
            int distance = Integer.parseInt(st.nextToken());
            relations.get(from).add(new Road(to, distance));
            relations.get(to).add(new Road(from, distance));
        }

        // 최단 거리 구하기
        solve();

        // 배달하기
        answer = 1;
        int canMoveDistance = maxMoveDistance;
        Arrays.sort(path);
        for(int home=1; home<=homeCount; home++) {
            if(path[home] == 0) continue;

            // 배달 가능한지 확인
            if(path[home] + path[home] > maxMoveDistance) {
                answer = -1;
                break;
            }

            // 당일 배달 가능 여부 확인
            if(path[home] + path[home] > canMoveDistance) {
                answer++;
                canMoveDistance = maxMoveDistance;
            }

            canMoveDistance -= path[home] + path[home];
        }

        // 결과 출력
        System.out.println(answer);
    }
}