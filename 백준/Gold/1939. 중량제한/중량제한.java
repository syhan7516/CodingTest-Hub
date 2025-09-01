import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

// 다리 클래스
class Bridge implements Comparable<Bridge> {
    int island;
    int weight;

    public Bridge(int island, int weight) {
        this.island = island;
        this.weight = weight;
    }

    @Override
    public int compareTo(Bridge other) {
        return other.weight - this.weight;
    }
}

public class Main {

    // 결과, 섬 개수, 다리 개수, 출발 위치, 목표 위치
    public static int answer, islandCount, bridgeCount, startPoint, targetPoint;

    // 연결 정보 리스트
    public static ArrayList<ArrayList<Bridge>> relations;

    // 방문 여부 배열
    public static boolean[] visited;

    // 탐색 메서드
    public static void solve() {

        // 우선 순위 큐 생성
        PriorityQueue<Bridge> queue = new PriorityQueue<>();

        // 방문 여부 배열 생성
        visited = new boolean[islandCount+1];

        // 시작 지점 처리
        queue.offer(new Bridge(startPoint, answer));

        // 탐색
        while(!queue.isEmpty()) {

            // 현재 다리
            Bridge bridge = queue.poll();

            // 목표 위치인 경우
            if(bridge.island == targetPoint) {
                answer = Math.min(answer, bridge.weight);
                return;
            }

            // 이미 방문한 경우
            if(visited[bridge.island]) continue;

            // 방문 처리
            visited[bridge.island] = true;
            answer = Math.min(answer, bridge.weight);

            // 연결 정보 확인
            for(int index=0; index<relations.get(bridge.island).size(); index++) {
                Bridge connectedBridge = relations.get(bridge.island).get(index);

                // 이미 방문한 경우
                if(visited[connectedBridge.island]) continue;

                // 탐색 대상 추가
                queue.offer(new Bridge(connectedBridge.island, Math.min(bridge.weight, connectedBridge.weight)));
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        // 섬 개수, 다리 개수 입력
        st = new StringTokenizer(br.readLine());
        islandCount = Integer.parseInt(st.nextToken());
        bridgeCount = Integer.parseInt(st.nextToken());

        // 연결 정보 리스트 생성
        relations = new ArrayList<>();
        for(int index=0; index<=islandCount; index++) {
            relations.add(new ArrayList<>());
        }

        // 다리 정보 입력
        for(int index=0; index<bridgeCount; index++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());
            relations.get(from).add(new Bridge(to, weight));
            relations.get(to).add(new Bridge(from, weight));
        }

        // 공장 위치 입력
        st = new StringTokenizer(br.readLine());
        startPoint = Integer.parseInt(st.nextToken());
        targetPoint = Integer.parseInt(st.nextToken());

        // 탐색 수행
        answer = Integer.MAX_VALUE;
        solve();

        // 결과 출력
        System.out.println(answer);
    }
}