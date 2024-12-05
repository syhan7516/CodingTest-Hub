import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

// 간선 클래스
class Edge implements Comparable<Edge> {
    int toNode;
    int value;

    public Edge(int toNode, int value) {
        this.toNode = toNode;
        this.value = value;
    }

    public int compareTo(Edge other) {
        return this.value - other.value;
    }
}

public class Main {

    // 최단 거리 비용 초기화 값
    public static final int MAX_VALUE = 10000000;

    // 결과, 정점 개수, 간선 개수, 거쳐야하는 정점
    public static int answer, nodeCount, edgeCount, passNode1, passNode2;

    // 정점 관계 정보 리스트
    public static ArrayList<ArrayList<Edge>> relations;

    // 최단 거리 배열
    public static int path[];

    // 방문 배열
    public static boolean visited[];

    // 최단 거리 구하기 메서드
    private static int getNodeShortestPath(int startNode, int endNode) {

        // 최단 거리 배열, 방문 배열 초기화
        Arrays.fill(path,MAX_VALUE);
        Arrays.fill(visited,false);

        // 우선 순위 큐 생성
        PriorityQueue<Edge> queue = new PriorityQueue<>();

        // 시작 노드 처리
        path[startNode] = 0;
        queue.offer(new Edge(startNode,path[startNode]));

        // 간선 확인
        while(!queue.isEmpty()) {

            // 확인 간선 꺼내기
            Edge currentEdge = queue.poll();
            int currentNode = currentEdge.toNode;

            // 이미 방문한 노드인 경우
            if(visited[currentNode]) continue;

            // 방문 처리
            visited[currentNode] = true;

            // 연결 정점 확인
            for(int node=0; node<relations.get(currentNode).size(); node++) {
                
                // 연결 간선 정보
                Edge connectEdge = relations.get(currentNode).get(node);
                int connectNode = connectEdge.toNode;
                int connectValue = connectEdge.value;

                // 최단 거리인 경우
                if(path[connectNode]>path[currentNode]+connectValue) {
                    path[connectNode] = path[currentNode]+connectValue;
                    queue.offer(new Edge(connectNode,path[connectNode]));
                }
            }
        }
        
        return path[endNode];
    }


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        // 정점, 간선 개수 입력
        st = new StringTokenizer(br.readLine());
        nodeCount = Integer.parseInt(st.nextToken());
        edgeCount = Integer.parseInt(st.nextToken());

        // 관계 정보 리스트 생성, 초기화
        relations = new ArrayList<>();
        for(int node=0; node<=nodeCount; node++)
            relations.add(new ArrayList<>());

        // 간선 정보 입력
        for(int edge=0; edge<edgeCount; edge++) {
            st = new StringTokenizer(br.readLine());
            int fromNode = Integer.parseInt(st.nextToken());
            int toNode = Integer.parseInt(st.nextToken());
            int value = Integer.parseInt(st.nextToken());
            relations.get(toNode).add(new Edge(fromNode, value));
            relations.get(fromNode).add(new Edge(toNode, value));
        }

        // 거쳐야하는 정점 정보 입력
        st = new StringTokenizer(br.readLine());
        passNode1 = Integer.parseInt(st.nextToken());
        passNode2 = Integer.parseInt(st.nextToken());

        // 최단 거리 배열, 방문 배열 생성
        path = new int[nodeCount+1];
        visited = new boolean[nodeCount+1];

        // 최단 거리 구하기
        int firstPath = getNodeShortestPath(1,passNode1);
        firstPath += getNodeShortestPath(passNode1,passNode2);
        firstPath += getNodeShortestPath(passNode2,nodeCount);

        int secondPath = getNodeShortestPath(1,passNode2);
        secondPath += getNodeShortestPath(passNode2,passNode1);
        secondPath += getNodeShortestPath(passNode1,nodeCount);

        // 결과 저장
        answer = (firstPath>=MAX_VALUE && secondPath>=MAX_VALUE) ? -1 : Math.min(firstPath,secondPath);

        // 결과 출력
        System.out.println(answer);
    }
}