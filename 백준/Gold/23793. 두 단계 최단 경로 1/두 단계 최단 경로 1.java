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
    int distance;

    public Edge(int node, int distance) {
        this.node = node;
        this.distance = distance;
    }

    @Override
    public int compareTo(Edge other) {
        return this.distance - other.distance;
    }
}

public class Main {

    // 무한 거리
    public static final int MAX_DISTANCE = (int)1e9;

    // 정점 개수, 간선 개수
    public static int nodeCount, edgeCount;

    // 시작 지점, 중간 지점, 도착 지점
    public static int start, mid, end;

    // 시작 지점 ~ 중간 지점 거리, 중간 지점 ~ 도착 지점 거리, 시작 지점 ~ 도착 지점 거리
    public static int startToMidDistance, midToEndDistance, startToEndDistance;

    // 연결 정보 리스트
    public static ArrayList<ArrayList<Edge>> relations;

    // 최단 거리 배열
    public static int[] path;

    // 최단 거리 구하기 메서드
    public static void solve(int startNode, int endNode, int passNode) {

        // 우선 순위 큐 생성
        PriorityQueue<Edge> queue = new PriorityQueue<>();

        // 방문 여부 배열 생성
        boolean[] visited = new boolean[nodeCount+1];

        // 최단 거리 배열 생성
        path = new int[nodeCount+1];
        Arrays.fill(path, MAX_DISTANCE);

        // 시작 지점 처리
        path[startNode] = 0;
        queue.offer(new Edge(startNode, path[startNode]));

        // 탐색
        while(!queue.isEmpty()) {
            Edge edge = queue.poll();

            // 통과 노드인 경우
            if(edge.node == passNode) continue;

            // 이미 방문한 경우
            if(visited[edge.node]) continue;

            // 방문 처리
            visited[edge.node] = true;

            // 연결 정보 확인
            for(int index=0; index<relations.get(edge.node).size(); index++) {
                Edge connectedEdge = relations.get(edge.node).get(index);

                // 이미 방문한 경우
                if(visited[connectedEdge.node]) continue;

                // 거리가 더 짧은 경우
                if(path[connectedEdge.node] > path[edge.node] + connectedEdge.distance) {
                    path[connectedEdge.node] = path[edge.node] + connectedEdge.distance;
                    queue.offer(new Edge(connectedEdge.node, path[connectedEdge.node]));
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        // 정점 개수, 간선 개수 입력
        st = new StringTokenizer(br.readLine());
        nodeCount = Integer.parseInt(st.nextToken());
        edgeCount = Integer.parseInt(st.nextToken());

        // 연결 정보 리스트 생성
        relations = new ArrayList<>();
        for(int index=0; index<=nodeCount; index++) {
            relations.add(new ArrayList<>());
        }

        // 간선 정보 입력
        for(int index=0; index<edgeCount; index++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int distance = Integer.parseInt(st.nextToken());
            relations.get(from).add(new Edge(to, distance));
        }

        // 시작 지점, 중간 지점, 도착 지점 입력
        st = new StringTokenizer(br.readLine());
        start = Integer.parseInt(st.nextToken());
        mid = Integer.parseInt(st.nextToken());
        end = Integer.parseInt(st.nextToken());

        // 시작 지점에서 중간 지점 최단 거리 구하기
        solve(start, mid, 0);
        startToMidDistance = path[mid];

        // 중간 지점에서 도착 지점 최단 거리 구하기
        solve(mid, end, 0);
        midToEndDistance = path[end];

        // 시작 지점에서 도착 지점 최단 거리 구하기
        solve(start, end, mid);
        startToEndDistance = path[end];

        // 결과 저장
        if(startToMidDistance == MAX_DISTANCE || midToEndDistance == MAX_DISTANCE) sb.append(-1);
        else sb.append(startToMidDistance+midToEndDistance);
        sb.append(" ");

        if(startToEndDistance == MAX_DISTANCE) sb.append(-1);
        else sb.append(startToEndDistance);

        // 결과 출력
        System.out.println(sb.toString());
    }
}