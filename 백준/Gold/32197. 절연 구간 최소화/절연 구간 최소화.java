import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

// 간선 클래스
class Edge implements Comparable<Edge> {
    int node;
    int kind;
    int changeCount;

    public Edge(int node, int kind, int changeCount) {
        this.node = node;
        this.kind = kind;
        this.changeCount = changeCount;
    }

    @Override
    public int compareTo(Edge other) {
        return this.changeCount - other.changeCount;
    }
}

public class Main {

    // 결과, 노드 개수, 간선 개수
    public static int answer, nodeCount, edgeCount;

    // 시작 지점, 도착 지점
    public static int startNode, endNode;

    // 연결 정보 리스트
    public static ArrayList<ArrayList<Edge>> relations;

    // 탐색 메서드
    public static void solve() {

        // 방문 여부 배열 생성
        boolean[][] visited = new boolean[nodeCount+1][2];

        // 우선 순위 큐 생성
        PriorityQueue<Edge> queue = new PriorityQueue<>();

        // 시작 지점 처리
        queue.offer(new Edge(startNode,  0, 0));
        queue.offer(new Edge(startNode,  1, 0));

        // 탐색 수행
        while(!queue.isEmpty()) {
            Edge edge = queue.poll();

            // 도착 지점인 경우
            if(edge.node == endNode) {
                answer = edge.changeCount;
                return;
            }

            // 방문 여부 확인
            if(visited[edge.node][edge.kind]) continue;

            // 방문 처리
            visited[edge.node][edge.kind] = true;

            // 연결 정보 확인
            for(int index=0; index<relations.get(edge.node).size(); index++) {
                Edge connectedEdge = relations.get(edge.node).get(index);

                // 이미 방문한 경우
                if(visited[connectedEdge.node][edge.kind]) continue;

                // 절연 - O
                if(edge.kind != connectedEdge.kind) {
                    queue.offer(new Edge(connectedEdge.node, connectedEdge.kind, edge.changeCount + 1));
                }

                // 절연 - X
                else {
                    queue.offer(new Edge(connectedEdge.node, connectedEdge.kind, edge.changeCount));
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        // 노드 개수, 간선 개수 입력
        st = new StringTokenizer(br.readLine());
        nodeCount = Integer.parseInt(st.nextToken());
        edgeCount = Integer.parseInt(st.nextToken());

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
            int kind = Integer.parseInt(st.nextToken());
            relations.get(from).add(new Edge(to, kind, 0));
            relations.get(to).add(new Edge(from, kind, 0));
        }

        // 시작 지점, 도착 지점 입력
        st = new StringTokenizer(br.readLine());
        startNode = Integer.parseInt(st.nextToken());
        endNode = Integer.parseInt(st.nextToken());

        // 탐색
        answer = 0;
        solve();

        // 결과 출력
        System.out.println(answer);
    }
}