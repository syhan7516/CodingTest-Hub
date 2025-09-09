import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

// 도로 클래스
class Road implements Comparable<Road> {
    int node;
    int cost;

    public Road(int node, int cost) {
        this.node = node;
        this.cost = cost;
    }

    @Override
    public int compareTo(Road other) {
        return this.cost - other.cost;
    }
}

public class Main {

    // 결과, 땅 개수, 도로 개수
    public static int answer, groundCount, roadCount;

    // 친구 집 위치
    public static HashSet<Integer> homes;

    // 연결 정보 리스트
    public static ArrayList<ArrayList<Road>> relations;

    // 최장 거리 배열
    public static int[] morePaths;

    // 거리 구하기 메서드
    public static void solve(int startNode) {

        // 우선 순위 큐 생성
        PriorityQueue<Road> queue = new PriorityQueue<>();

        // 방문 여부 배열 생성
        boolean[] visited = new boolean[groundCount+1];

        // 최단 거리 배열 생성
        int[] paths = new int[groundCount+1];
        Arrays.fill(paths, (int)1e9);

        // 시작 지점 처리
        paths[startNode] = 0;
        queue.offer(new Road(startNode, 0));

        // 탐색
        while(!queue.isEmpty()) {
            Road road = queue.poll();

            // 이미 방문한 경우
            if(visited[road.node]) continue;

            // 방문 처리
            visited[road.node] = true;

            // 연결 정보 확인
            for(int index=0; index<relations.get(road.node).size(); index++) {
                Road connectedRoad = relations.get(road.node).get(index);

                // 이미 방문한 경우
                if(visited[connectedRoad.node]) continue;

                // 최단 거리인 경우
                if(paths[connectedRoad.node] > paths[road.node] + connectedRoad.cost) {
                    paths[connectedRoad.node] = paths[road.node] + connectedRoad.cost;
                    queue.offer(new Road(connectedRoad.node, paths[connectedRoad.node]));
                }
            }
        }

        // 최단 거리 합하기
        for(int index=1; index<=groundCount; index++) {
            morePaths[index] = Math.min(morePaths[index], paths[index]);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        // 땅 개수 입력
        groundCount = Integer.parseInt(br.readLine());

        // 친구 집 위치 입력
        homes = new HashSet<>();
        st = new StringTokenizer(br.readLine());
        for(int index=0; index<3; index++) {
            homes.add(Integer.parseInt(st.nextToken()));
        }

        // 연결 정보 리스트 생성
        relations = new ArrayList<>();
        for(int index=0; index<=groundCount; index++) {
            relations.add(new ArrayList<>());
        }

        // 도로 개수 입력
        roadCount = Integer.parseInt(br.readLine());
        for(int index=0; index<roadCount; index++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());
            relations.get(from).add(new Road(to, cost));
            relations.get(to).add(new Road(from, cost));
        }

        // 친구 집까지 거리 구하기
        morePaths = new int[groundCount+1];
        Arrays.fill(morePaths, (int)1e9);
        for(int home: homes) {
            solve(home);
        }

        // 결과
        int mock = 0;
        for(int index=1; index<=groundCount; index++) {
            if(homes.contains(index)) continue;
            if(mock < morePaths[index]) {
                answer = index;
                mock = morePaths[index];
            }
        }
        System.out.println(answer);
    }
}