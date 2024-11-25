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
    long time;

    public Edge(int toNode, long time) {
        this.toNode = toNode;
        this.time = time;
    }

    @Override
    public int compareTo(Edge otherEdge) {
        return Long.compare(this.time,otherEdge.time);
    }
}

public class Main {

    // 최대 거리 비용
    public static final long MAX_TIME = (long)3e10+1;

    // 정점 개수, 간선 개수
    public static int nodeCount, edgeCount;

    // 관계 정보 리스트
    public static ArrayList<ArrayList<Edge>> relation;

    // 시야 여부 배열
    public static int isViews[];

    // 최단 거리 배열
    public static long path[];

    // 거점 방문 여부 배열
    public static boolean visited[];

    // 최단 거리 확인 메서드
    public static void solve() {

        // 우선 순위 큐 생성
        PriorityQueue<Edge> queue = new PriorityQueue<>();

        // 시작 지점 처리
        queue = new PriorityQueue<>();
        path[0] = 0;
        queue.offer(new Edge(0,path[0]));


        // 연결 간선 확인
        while(!queue.isEmpty()) {

            // 기준 간선
            Edge currentEdge = queue.poll();
            int currentNode = currentEdge.toNode;
            long currentTime = currentEdge.time;

            // 연결된 거점의 비용이 더 적은 경우
            if(currentTime>path[currentNode]) continue;

            // 방문 처리
            visited[currentNode] = true;

            // 이동 가능한 간선 확인
            for(int e=0; e<relation.get(currentNode).size(); e++) {
                Edge connectEdge = relation.get(currentNode).get(e);
                int connectNode = connectEdge.toNode;
                long connectTime = connectEdge.time;

                // 시야가 보이는 경우
                if(isViews[connectNode]==1) continue;

                // 이미 방문한 경우
                if(visited[connectNode]) continue;

                // 거리 비교
                if(path[connectNode]>path[currentNode]+connectTime) {
                    path[connectNode] = path[currentNode]+connectTime;
                    queue.offer(new Edge(connectNode,path[connectNode]));
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        // 정점, 간선 개수 입력
        st = new StringTokenizer(br.readLine());
        nodeCount = Integer.parseInt(st.nextToken());
        edgeCount = Integer.parseInt(st.nextToken());

        // 관계 정보 리스트 생성, 초기화
        relation = new ArrayList<>();
        for(int nodeRelation=0; nodeRelation<nodeCount; nodeRelation++)
            relation.add(new ArrayList<>());

        // 시야 여부 배열 생성
        isViews = new int[nodeCount];

        // 시야 정보 입력
        st = new StringTokenizer(br.readLine());
        for(int view=0; view<nodeCount; view++)
            isViews[view] = Integer.parseInt(st.nextToken());
        isViews[nodeCount-1] = 0;

        // 관계 정보 입력
        for(int e=0; e<edgeCount; e++) {
            st = new StringTokenizer(br.readLine());
            int fromNode = Integer.parseInt(st.nextToken());
            int toNode = Integer.parseInt(st.nextToken());
            int time = Integer.parseInt(st.nextToken());
            relation.get(fromNode).add(new Edge(toNode, time));
            relation.get(toNode).add(new Edge(fromNode, time));
        }

        // 방문 여부 배열 생성
        visited = new boolean[nodeCount];

        // 최단 거리 배열 생성, 초기화
        path = new long[nodeCount];
        Arrays.fill(path,MAX_TIME);

        // 최단 거리 확인
        solve();

        // 결과 출력
        long answer = path[nodeCount-1]==MAX_TIME ? -1 : path[nodeCount-1];
        System.out.println(answer);
    }
}