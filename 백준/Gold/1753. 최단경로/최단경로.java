import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

// 노드 클래스
class Node implements Comparable<Node> {
    private int node;
    private int dist;

    public Node(int node, int dist) {
        this.node = node;
        this.dist = dist;
    }

    public int getNode() {
        return this.node;
    }

    public int getDist() {
        return this.dist;
    }

    public int compareTo(Node other) {
        if(this.dist < other.dist)
            return -1;
        return 1;
    }
}

public class Main {

    // 경로 초기값
    public static int MAX_PATH = Integer.MAX_VALUE;
    // 정점의 개수, 간선의 개수, 시작 노드
    public static int nodeCnt, edgeCnt, start;
    // 방문 여부 배열
    public static boolean visited[];
    // 노드별 최단 경로
    public static int path[];
    // 노드 정보 리스트
    public static ArrayList<ArrayList<Node>> nodes;
    // 노드 정렬을 위한 우선순위 큐
    public static PriorityQueue<Node> priQ;

    // 다익스트라
    static void djikstra(int node) {
        // 시작노드 초기화 & 우선 순위 큐 삽입
        path[node] = 0;
        priQ = new PriorityQueue<>();
        priQ.offer(new Node(node,path[node]));

        // 모든 연결 노드 확인
        while(!priQ.isEmpty()) {
            Node nowNode = priQ.poll();
            int nowN = nowNode.getNode();
            int nowD = nowNode.getDist();
            
            // 방문했을 경우
            if(visited[nowN]==true)
                continue;
            
            // 연결된 노드 확인
            for(int n=0; n<nodes.get(nowN).size(); n++) {
                Node conNode = nodes.get(nowN).get(n);
                int conN = conNode.getNode();
                int conD = conNode.getDist();
                // 더 짧은 거리 갱신
                path[conN] = Math.min(path[conN],nowD+conD);
                priQ.offer(new Node(conN,path[conN]));
            }
            visited[nowN] = true;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        // 정점, 간선 수 입력
        st = new StringTokenizer(br.readLine());
        nodeCnt = Integer.parseInt(st.nextToken());
        edgeCnt = Integer.parseInt(st.nextToken());

        // 시작 노드 입력
        start = Integer.parseInt(br.readLine());

        // 기본 셋팅
        visited = new boolean[nodeCnt+1];
        Arrays.fill(visited,false);

        path = new int[nodeCnt+1];
        Arrays.fill(path,MAX_PATH);

        nodes = new ArrayList<>();
        for(int idx=0; idx<=nodeCnt; idx++)
            nodes.add(new ArrayList<>());

        // 인접 노드 정보 입력
        for(int idx=0; idx<edgeCnt; idx++) {
            st = new StringTokenizer(br.readLine());
            int startNode = Integer.parseInt(st.nextToken());
            int endNode = Integer.parseInt(st.nextToken());
            int value = Integer.parseInt(st.nextToken());
            nodes.get(startNode).add(new Node(endNode,value));
        }

        // 다익스트라
        djikstra(start);

        // 결과 출력
        for(int idx=1; idx<=nodeCnt; idx++) {
            if(path[idx]==MAX_PATH)
                System.out.println("INF");
            else
                System.out.println(path[idx]);
        }
    }
}