import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

// 간선 클래스
class Edge {
    int node;
    int distance;

    public Edge(int node, int distance) {
        this.node = node;
        this.distance = distance;
    }
}

public class Main {

    // 정점 개수, 간선 개수, 목표 노드
    public static int nodeCount, edgeCount, targetNode1, targetNode2;

    // 연결 정보 리스트
    public static ArrayList<ArrayList<Edge>> relations;

    // 방문 여부 배열
    public static boolean[] visited;

    // 우선 순위 큐
    public static PriorityQueue<Edge> queue;

    // 거리 배열
    public static int[] path;

    // 탐색 메서드
    public static void solve() {

        // 우선 순위 큐 생성
        queue = new PriorityQueue<>(
                (a, b) -> a.distance - b.distance
        );

        // 방문 여부 배열 생성
        visited = new boolean[nodeCount+1];

        // 거리 배열 생성
        path = new int[nodeCount+1];

        // 시작 지점 처리
        for(int index=1; index<=nodeCount; index++) {
            path[index] = (int)1e9;
        }
        path[targetNode1] = 0;
        queue.offer(new Edge(targetNode1, 0));

        // 탐색 수행
        while(!queue.isEmpty()) {
            Edge edge = queue.poll();

            // 목표 노드인 경우
            if(edge.node == targetNode2) {
                return;
            }

            // 이미 방문한 경우
            if(visited[edge.node]) continue;

            // 방문 처리
            visited[edge.node] = true;

            // 연결된 간선 확인
            for(int index=0; index<relations.get(edge.node).size(); index++) {
                Edge connectedEdge = relations.get(edge.node).get(index);

                // 이미 방문한 경우
                if(visited[connectedEdge.node]) continue;

                // 최단 경로인 경우
                if(path[connectedEdge.node] > path[edge.node] + connectedEdge.distance) {
                    path[connectedEdge.node] = path[edge.node] + connectedEdge.distance;
                    queue.offer(new Edge(connectedEdge.node, path[connectedEdge.node]));
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        // 정점 개수, 간선 개수 입력
        st = new StringTokenizer(br.readLine());
        nodeCount = Integer.parseInt(st.nextToken());
        edgeCount = Integer.parseInt(st.nextToken());

        // 연결 정보 리스트 생성
        relations = new ArrayList<>();
        for(int index=0; index<=nodeCount; index++) {
            relations.add(new ArrayList<>());
        }

        // 간선 정보 입력
        for(int index=0; index<edgeCount; index++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int distance = Integer.parseInt(st.nextToken());
            relations.get(from).add(new Edge(to, distance));
            relations.get(to).add(new Edge(from, distance));
        }

        // 목표 노드 입력
        st = new StringTokenizer(br.readLine());
        targetNode1 = Integer.parseInt(st.nextToken());
        targetNode2 = Integer.parseInt(st.nextToken());

        // 탐색
        solve();

        // 결과 출력
        System.out.println(path[targetNode2]);
    }
}