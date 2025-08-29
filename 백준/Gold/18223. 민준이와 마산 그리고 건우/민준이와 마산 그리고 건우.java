import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

// 간선 클래스
class Edge implements Comparable<Edge> {
    int node;
    int weight;

    public Edge(int node, int weight) {
        this.node = node;
        this.weight = weight;
    }

    @Override
    public int compareTo(Edge other) {
        return this.weight - other.weight;
    }
}

public class Main {

    // 정점 개수, 간선 개수, 건우 위치
    public static int nodeCount, edgeCount, geunwo;

    // 민준 <-> 건우 + 목적지, 민준 <-> 목적지
    public static int minjuneToDestinationWithGeunwo, minjuneToDestination;

    // 최단 거리 배열
    public static int[] path;

    // 연결 정보 리스트
    public static ArrayList<ArrayList<Edge>> relations;

    // 우선 순위 큐
    public static PriorityQueue<Edge> queue;

    // 방문 정보 배열
    public static boolean[] visited;

    // 최단 거리 구하기 메서드
    public static void solve(int startNode) {

        // 우선 순위 큐 생성
        queue = new PriorityQueue<>();

        // 최단 거리 배열 생성
        path = new int[nodeCount+1];
        Arrays.fill(path, (int)1e9);

        // 방문 여부 배열 생성
        visited = new boolean[nodeCount+1];

        // 시작 지점 처리
        path[startNode] = 0;
        queue.offer(new Edge(startNode, path[startNode]));

        // 탐색 수행
        while(!queue.isEmpty()) {

            // 현재 위치
            Edge edge = queue.poll();

            // 이미 방문한 경우
            if(visited[edge.node]) continue;

            // 방문 처리
            visited[edge.node] = true;

            // 연결 노드 확인
            for(int index=0; index<relations.get(edge.node).size(); index++) {
                Edge connectedEdge = relations.get(edge.node).get(index);

                // 최단 거리인 경우
                if(path[connectedEdge.node] > path[edge.node] + connectedEdge.weight) {
                    path[connectedEdge.node] = path[edge.node] + connectedEdge.weight;
                    queue.offer(new Edge(connectedEdge.node, path[connectedEdge.node]));
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        // 정점 개수, 간선 개수, 건우 위치 입력
        st = new StringTokenizer(br.readLine());
        nodeCount = Integer.parseInt(st.nextToken());
        edgeCount = Integer.parseInt(st.nextToken());
        geunwo = Integer.parseInt(st.nextToken());

        // 연결 정보 리스트 생성
        relations = new ArrayList<>();
        for(int index=0; index<=nodeCount; index++) {
            relations.add(new ArrayList<>());
        }

        // 연결 정보 입력
        for(int index=0; index<edgeCount; index++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());
            relations.get(from).add(new Edge(to, weight));
            relations.get(to).add(new Edge(from, weight));
        }

        // 최단 거리 구하기
        solve(1);
        minjuneToDestinationWithGeunwo = path[geunwo];
        minjuneToDestination = path[nodeCount];

        solve(geunwo);
        minjuneToDestinationWithGeunwo += path[nodeCount];

        // 결과 출력
        String answer = minjuneToDestinationWithGeunwo > minjuneToDestination
                ? "GOOD BYE" : "SAVE HIM";
        System.out.println(answer);
    }
}