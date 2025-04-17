import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    static final int INF = 10_000_001;

    static class Node implements Comparable<Node>{
        int idx;
        int weight;
        Node next;

        public Node(int idx, int weight, Node next) {
            this.idx = idx;
            this.weight = weight;
            this.next = next;
        }

        @Override
        public int compareTo(Node o) {
            return this.weight - o.weight;
        }
    }

    static Node[] graph;
    static int[] cost;
    static int max, count;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PriorityQueue<Node> pq = new PriorityQueue<>();
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());
        while (T-- > 0) {
            st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken()); // 컴퓨터 개수
            int D = Integer.parseInt(st.nextToken()); // 의존성 개수
            int C = Integer.parseInt(st.nextToken()); // 해킹당한 컴퓨터

            graph = new Node[N + 1]; // 의존 관계를 나타내는 그래프
            cost = new int[N + 1]; // 각 걸리는 시간
            max = count = 0; // 최대시간, 해킹당한 컴퓨터의 개수

            Arrays.fill(cost, INF);
            cost[C] = 0; // 해킹당한 컴퓨터의 경과시간은 0

            // Input
            for (int i = 0; i < D; i++) {
                st = new StringTokenizer(br.readLine());
                int to = Integer.parseInt(st.nextToken()); // 의존되는 컴퓨터
                int from = Integer.parseInt(st.nextToken()); // 의존하는 컴퓨터
                int weight = Integer.parseInt(st.nextToken()); // 걸리는 비용(시간)
                graph[from] = new Node(to, weight, graph[from]);
            } // Input End

            pq.offer(new Node(C, 0, null));
            while (!pq.isEmpty()) {
                Node cur = pq.poll();
                // 기존에 더 빠르게 간 기록이 있다면 넘어간다.
                if (cost[cur.idx] < cur.weight) {
                    continue;
                }
                for (Node tmp = graph[cur.idx]; tmp != null; tmp = tmp.next) {
                    // 현재 이 노드를 거쳐서 가는게 더 빠른 경우 갱신 후 큐에 삽입
                    if (cost[tmp.idx] > tmp.weight + cost[cur.idx]) {
                        cost[tmp.idx] = tmp.weight + cost[cur.idx];
                        pq.offer(new Node(tmp.idx, cost[tmp.idx], null));
                    }
                }
            }
            getAnswer(N); // 정답 갱신
            sb.append(count).append(' ').append(max).append('\n');
        }
        System.out.println(sb);
    }

    private static void getAnswer(int n) {
        for (int i = 1; i <= n; i++) {
            if (cost[i] != INF) {
                count++;
                max = Math.max(max, cost[i]);
            }
        }
    }
}