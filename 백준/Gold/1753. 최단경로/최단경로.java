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

    // 거리 기본 값
    public static final int BASIC_DISTANCE = (int)1e9;

    // 정점 개수, 간선 개수, 시작 정점
    public static int nodeCount, edgeCount, startNode;

    // 거리 배열
    public static int[] path;

    // 연결 관계 리스트
    public static ArrayList<ArrayList<Edge>> relations;

    // 거리 우선 순위 큐
    public static PriorityQueue<Edge> queue;

    // 방문 여부 배열
    public static boolean[] visited;

    // 최단 거리 탐색 메서드
    public static void solve() {

        // 방문 여부 배열 생성
        visited = new boolean[nodeCount+1];

        // 거리 우선 순위 큐 생성
        queue = new PriorityQueue<>(
                (a, b) -> a.distance - b.distance
        );

        // 시작 지점 처리
        path[startNode] = 0;
        queue.offer(new Edge(startNode, path[startNode]));

        // 탐색 수행
        while(!queue.isEmpty()) {

            // 확인 간선
            Edge edge = queue.poll();

            // 이미 방문한 노드인 경우
            if(visited[edge.node]) continue;

            // 방문 처리
            visited[edge.node] = true;

            // 연결된 간선 확인
            for(int index=0; index<relations.get(edge.node).size(); index++) {
                Edge connectedEdge = relations.get(edge.node).get(index);

                // 이미 최단 거리 확인 완료된 노드인 경우
                if(visited[connectedEdge.node]) continue;

                // 거리 확인
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
        StringBuilder sb = new StringBuilder();

        // 정점, 간선 개수 입력
        st = new StringTokenizer(br.readLine());
        nodeCount = Integer.parseInt(st.nextToken());
        edgeCount = Integer.parseInt(st.nextToken());

        // 관계 정보 리스트 생성 및 초기화
        relations = new ArrayList<>();
        for(int index=0; index<=nodeCount; index++) {
            relations.add(new ArrayList<>());
        }

        // 거리 배열 생성 및 초기화
        path = new int[nodeCount+1];
        for(int index=1; index<=nodeCount; index++) {
            path[index] = BASIC_DISTANCE;
        }

        // 시작 정점 입력
        startNode = Integer.parseInt(br.readLine());

        // 간선 정보 입력
        for(int index=0; index<edgeCount; index++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int distance = Integer.parseInt(st.nextToken());
            relations.get(from).add(new Edge(to, distance));
        }

        // 최단 거리 탐색
        solve();

        // 결과 저장
        for(int node=1; node<=nodeCount; node++) {
            if(path[node] == BASIC_DISTANCE) {
                sb.append("INF").append('\n');
            }
            else sb.append(path[node]).append("\n");
        }

        // 결과 출력
        System.out.println(sb.toString());
    }
}