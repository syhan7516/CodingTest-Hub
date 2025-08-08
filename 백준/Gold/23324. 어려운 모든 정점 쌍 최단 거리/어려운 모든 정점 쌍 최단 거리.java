import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

// 간선 클래스
class Edge implements Comparable<Edge> {
    int fromNode;
    int toNode;
    int distance;

    public Edge(int fromNode, int toNode, int distance) {
        this.fromNode = fromNode;
        this.toNode = toNode;
        this.distance = distance;
    }

    @Override
    public int compareTo(Edge other) {
        return this.distance - other.distance;
    }
}

public class Main {

    // 결과
    public static long answer;

    // 정점, 간선 개수, 가중치 순서
    public static int nodeCount, edgeCount, valueEdgeOrder;

    // 그룹 정보 배열
    public static int[] parent;

    // 그룹 개수 배열
    public static int[] counts;

    // 그룹 해시 셋
    public static HashSet<Integer> set;

    // 우선 순위 큐
    public static PriorityQueue<Edge> queue;

    // find
    public static int find(int node) {
        if(parent[node] == node) {
            return node;
        }

        return parent[node] = find(parent[node]);
    }

    // union
    public static void union(int a, int b) {
        a = find(a);
        b = find(b);

        if(a < b) parent[b] = a;
        else parent[a] = b;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        // 정점, 간선 개수, 가중치 순서 입력
        st = new StringTokenizer(br.readLine());
        nodeCount = Integer.parseInt(st.nextToken());
        edgeCount = Integer.parseInt(st.nextToken());
        valueEdgeOrder = Integer.parseInt(st.nextToken());

        // 그룹 해시 셋 생성
        set = new HashSet<>();

        // 그룹 정보 배열, 그룹 개수 배열 생성
        counts = new int[nodeCount+1];
        parent = new int[nodeCount+1];
        for(int index=1; index<=nodeCount; index++) {
            parent[index] = index;
        }

        // 우선 순위 큐 생성
        queue = new PriorityQueue<>();

        // 간선 정보 입력
        for(int index=1; index<=edgeCount; index++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());

            if(index == valueEdgeOrder) {
                queue.offer(new Edge(from, to, 1));
            }

            else queue.offer(new Edge(from, to, 0));
        }

        // 간선 연결
        while(queue.peek().distance == 0) {
            Edge edge = queue.poll();
            union(edge.fromNode, edge.toNode);
        }

        // 그룹 확인
        for(int index=1; index<=nodeCount; index++) {
            int group = find(parent[index]);
            counts[group]++;
            set.add(group);
        }

        answer = 1;
        if(set.size() > 1) {
            for(int group: set) answer *= counts[group];
        }

        else answer = 0;

        // 결과 출력
        System.out.println(answer);
    }
}