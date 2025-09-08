import java.io.*;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

// 간선 클래스
class Edge {
    int from;
    int to;
    int cost;

    public Edge(int from, int to, int cost) {
        this.from = from;
        this.to = to;
        this.cost = cost;
    }
}

public class Main {

    // 노드 개수, 간선 개수, 시작 지점, 목표 지점
    public static int nodeCount, edgeCount, startNode, endNode;

    // 우선 순위 큐
    public static PriorityQueue<Edge> queue;

    // 그룹 배열
    public static int[] groups;

    // find
    public static int find(int node) {
        if(node == groups[node]) {
            return node;
        }

        return groups[node] = find(groups[node]);
    }

    // union
    public static void union(int a, int b) {
        a = find(a);
        b = find(b);

        if(a > b) groups[a] = b;
        else groups[b] = a;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        // 노드 개수, 간선 개수 입력
        st = new StringTokenizer(br.readLine());
        nodeCount = Integer.parseInt(st.nextToken());
        edgeCount = Integer.parseInt(st.nextToken());

        // 시작, 목표 지점 입력
        st = new StringTokenizer(br.readLine());
        startNode = Integer.parseInt(st.nextToken());
        endNode = Integer.parseInt(st.nextToken());

        // 그룹 배열 생성
        groups = new int[nodeCount];
        for(int index=0; index<nodeCount; index++) {
            groups[index] = index;
        }

        // 우선 순위 큐 생성
        queue = new PriorityQueue<>((a, b) -> b.cost - a.cost);

        // 간선 정보 입력
        for(int index=0; index<edgeCount; index++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());
            queue.offer(new Edge(from, to, cost));
        }

        // 탐색
        while(!queue.isEmpty()) {
            Edge edge = queue.poll();
            union(edge.from, edge.to);

            if(find(startNode) == find(endNode)) {
                System.out.println(edge.cost);
                break;
            }
        }
    }
}