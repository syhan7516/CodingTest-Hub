import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

// 간선 클래스
class Edge implements Comparable<Edge> {
    int start;
    int end;
    int value;

    public Edge(int start, int end, int value) {
        this.start = start;
        this.end = end;
        this.value = value;
    }

    public int compareTo(Edge otherEdge) {
        return this.value - otherEdge.value;
    }
}

public class Main {

    // 결과, 정점 개수, 간선 개수
    public static int answer, nodeCount, edgeCount;

    // 간선 우선 순위 큐
    public static PriorityQueue<Edge> queue;

    // 집합 배열
    public static int parent[];

    // union
    public static void union(int node1, int node2) {

        node1 = find(node1);
        node2 = find(node2);

        if(node1<node2) parent[node2] = node1;
        else parent[node1] = node2;
    }

    // find
    public static int find(int node) {

        if(parent[node]==node)
            return node;

        return parent[node] = find(parent[node]);
    }

    // MST 구하기 메서드
    public static void solve() {

        // 연결 개수
        int connectCount = 1;

        // 연결하기
        while(!queue.isEmpty()) {

            // 연결이 완료된 경우
            if(connectCount==nodeCount) return;

            // 확인 간선
            Edge currentEdge = queue.poll();
            int start = currentEdge.start;
            int end = currentEdge.end;

            // 사이클 여부 확인
            if(find(start)==find(end)) continue;

            // 정점 연결
            union(start,end);
            answer += currentEdge.value;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        // 정점 개수, 간선 개수 입력
        st = new StringTokenizer(br.readLine());
        nodeCount = Integer.parseInt(st.nextToken());
        edgeCount = Integer.parseInt(st.nextToken());

        // 간선 우선 순위 큐 생성
        queue = new PriorityQueue<>();

        // 간선 정보 입력
        for(int edge=0; edge<edgeCount; edge++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int value = Integer.parseInt(st.nextToken());
            queue.offer(new Edge(start,end,value));
        }

        // 집합 배열 생성, 초기화
        parent = new int[nodeCount+1];
        for(int index=1; index<=nodeCount; index++)
            parent[index] = index;

        // MST 구하기
        answer = 0;
        solve();

        // 결과 출력
        System.out.println(answer);
    }
}