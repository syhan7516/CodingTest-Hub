import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

// 엣지 클래스
class Edge implements Comparable<Edge> {
    private int startNode;
    private int endNode;
    private int value;

    public Edge(int startNode, int endNode, int value) {
        this.startNode = startNode;
        this.endNode = endNode;
        this.value = value;
    }

    public int getStartNode() {
        return this.startNode;
    }

    public int getEndNode() {
        return this.endNode;
    }

    public int getValue() {
        return this.value;
    }

    public int compareTo(Edge other) {
        if(this.value<other.value)
            return -1;
        return 1;
    }
}

public class Main {

    // 정점의 개수, 간선의 개수, 결과
    public static int vCnt, eCnt, result;
    // 우선 순위 큐
    public static PriorityQueue<Edge> priQ;
    // 대표 번호 배열
    public static int path[];

    // union 함수
    static void union(int firNode, int secNode) {
        int firRoot = find(firNode);
        int secRoot = find(secNode);
        path[secRoot] = firRoot;
    }

    // find 함수
    static int find(int node) {
        if(path[node]==node)
            return node;

        return path[node] = find(path[node]);
    }

    // 크루스칼
    static void kruskal() {

        // 유니온 파인트 초기화
        path = new int[vCnt+1];
        for(int p=1; p<=vCnt; p++)
            path[p] = p;

        // 간선의 현재 연결 수, 결과 초기화
        int count = 0;
        result = 0;

        while(!priQ.isEmpty()) {
            // 모든 간선 연결 시 종료
            if(count==vCnt-1)
                break;

            // 간선 꺼내기
            Edge curEdge = priQ.poll();
            int curStartNode = curEdge.getStartNode();
            int curEndNode = curEdge.getEndNode();
            int curValue = curEdge.getValue();

            // 싸이클 확인
            if(find(curStartNode)==find(curEndNode))
                continue;

            // 간선 연결
            union(curStartNode,curEndNode);
            result += curValue;

            // 간선 수 증가
            count += 1;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        // 정점의 개수, 간선의 개수 입력
        vCnt = Integer.parseInt(st.nextToken());
        eCnt = Integer.parseInt(st.nextToken());

        // 간선 정렬
        priQ = new PriorityQueue<>();

        // 간선의 정보 입력
        for(int e=0; e<eCnt; e++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int value = Integer.parseInt(st.nextToken());
            priQ.offer(new Edge(start,end,value));
        }

        // 크루스칼
        kruskal();

        // 결과 출력
        System.out.println(result);
    }
}