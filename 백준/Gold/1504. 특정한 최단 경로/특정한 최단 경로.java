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
    int value;

    public Edge(int node, int value) {
        this.node = node;
        this.value = value;
    }

    @Override
    public int compareTo(Edge other) {
        return this.value - other.value;
    }
}

public class Main {

    // 최대 비용
    public static final int MAX = (int)1e9;

    // 결과, 노드, 간선 개수, 경로 포함 노드
    public static int answer, nodeCount, edgeCount, pathNode1, pathNode2;

    // 최단 거리 배열
    public static int path[];

    // 관계 정보 리스트
    public static ArrayList<ArrayList<Edge>> relations;

    // 최단 경로 구하기 메서드
    public static void findShortestPath(int startNode) {

        // 최단 거리 배열 생성 및 초기화
        path = new int[nodeCount+1];
        Arrays.fill(path,MAX);

        // 경로 저장 우선 순위 큐 생성
        PriorityQueue<Edge> queue = new PriorityQueue<>();

        // 시작점 처리
        path[startNode] = 0;
        queue.offer(new Edge(startNode,path[startNode]));

        // 경로 탐색
        while(!queue.isEmpty()) {

            // 현재 위치
            Edge edge = queue.poll();

            // 연결된 경로 확인
            for(int node=0; node<relations.get(edge.node).size(); node++) {

                // 연결 노드
                Edge connect = relations.get(edge.node).get(node);

                // 거리 비교
                if(path[connect.node]>path[edge.node]+connect.value) {
                    path[connect.node] = path[edge.node]+connect.value;
                    queue.offer(new Edge(connect.node,path[connect.node]));
                }
            }
        }
    }

    // 특정한 최단 경로 구하기 메서드
    public static void solve() {

        // 경로 거리 값
        int path1 = MAX;
        int path2 = MAX;

        // 시작점에서 최단 경로 구하기
        findShortestPath(1);
        int startToPathNode1 = path[pathNode1];
        int startToPathNode2 = path[pathNode2];

        // 포함 경로에서 최단 경로 구하기
        findShortestPath(pathNode1);
        int pathNode1ToPathNode2 = path[pathNode2];
        int pathNode1ToDestination = path[nodeCount];

        findShortestPath(pathNode2);
        int pathNode2ToPathNode1 = path[pathNode1];
        int pathNode2ToDestination = path[nodeCount];

        if(startToPathNode1!=MAX && pathNode1ToPathNode2!=MAX && pathNode2ToDestination!=MAX)
            path1 = startToPathNode1+pathNode1ToPathNode2+pathNode2ToDestination;

        if(startToPathNode2!=MAX && pathNode2ToPathNode1!=MAX && pathNode1ToDestination!=MAX)
            path2 = startToPathNode2+pathNode2ToPathNode1+pathNode1ToDestination;

        answer = Math.min(path1,path2);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        // 노드, 간선 개수 입력
        st = new StringTokenizer(br.readLine());
        nodeCount = Integer.parseInt(st.nextToken());
        edgeCount = Integer.parseInt(st.nextToken());

        // 관계 정보 리스트 생성 및 초기화
        relations = new ArrayList<>();
        for(int node=0; node<=nodeCount; node++)
            relations.add(new ArrayList<>());

        // 관계 정보 입력
        for(int edge=0; edge<edgeCount; edge++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int value = Integer.parseInt(st.nextToken());
            relations.get(from).add(new Edge(to, value));
            relations.get(to).add(new Edge(from, value));
        }

        // 경로 포함 두 노드 입력
        st = new StringTokenizer(br.readLine());
        pathNode1 = Integer.parseInt(st.nextToken());
        pathNode2 = Integer.parseInt(st.nextToken());

        // 특정한 최단 경로 구하기
        solve();

        // 결과 출력
        answer = answer==MAX ? -1 : answer;
        System.out.println(answer);
    }
}