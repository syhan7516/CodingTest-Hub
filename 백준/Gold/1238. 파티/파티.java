import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

// 시티 노드 클래스
class CityNode implements Comparable<CityNode> {
    private int node;
    private int dist;

    public CityNode(int node, int dist) {
        this.node = node;
        this.dist = dist;
    }

    public int getNode() {
        return this.node;
    }

    public int getDist() {
        return this.dist;
    }

    public int compareTo(CityNode other) {
        if(this.dist < other.dist)
            return -1;
        return 1;
    }
}

public class Main {

    // 도시의 개수, 도로 수, 파티 도시, 최장 거리
    public static int MAX_ROAD = (int)1e9;
    public static int cityCnt, roadCnt, partyCity, result;

    // 도시 최단 거리 배열
    public static int generalPath[];
    public static int reversePath[];

    // 도시 방문 여부 배열
    public static boolean pathVisited[];
    public static boolean reverseVisited[];

    // 거리 정보 인접 리스트
    public static ArrayList<ArrayList<CityNode>> generalNodes;
    public static ArrayList<ArrayList<CityNode>> reverseNodes;

    // 다익스트라 함수
    static void dijistra(int start, int path[], boolean visited[], ArrayList<ArrayList<CityNode>> nodes) {
        PriorityQueue<CityNode> priQ = new PriorityQueue<>();
        path[start] = 0;
        priQ.offer(new CityNode(start,path[start]));

        // 큐가 비었을 때까지 반복
        while(!priQ.isEmpty()) {
            // 큐에서 노드 꺼내기
            CityNode node = priQ.poll();
            int nowNode = node.getNode();
            int nowDist = node.getDist();

            // 이미 방문한 노드인 경우
            if(visited[nowNode]==true)
                continue;

            // 방문 처리
            visited[nowNode] = true;

            // 해당 노드와 인접한 노드 확인
            for(int idx=0; idx<nodes.get(nowNode).size(); idx++) {
                CityNode tempNode = nodes.get(nowNode).get(idx);
                int vertex = tempNode.getNode();
                int cost = tempNode.getDist();

                // 최단 경로 테이블 갱신
                if(path[vertex] > nowDist+cost)
                    path[vertex] = nowDist+cost;

                // 큐에 삽입
                priQ.offer(new CityNode(vertex,path[vertex]));
            }
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        // 도시의 개수, 도로 수, 파티 도시 입력
        cityCnt = Integer.parseInt(st.nextToken());
        roadCnt = Integer.parseInt(st.nextToken());
        partyCity = Integer.parseInt(st.nextToken());

        // 기본 설정 초기화
        generalPath = new int[cityCnt+1];
        reversePath = new int[cityCnt+1];
        Arrays.fill(generalPath,MAX_ROAD);
        Arrays.fill(reversePath,MAX_ROAD);

        pathVisited = new boolean[cityCnt+1];
        reverseVisited = new boolean[cityCnt+1];

        generalNodes = new ArrayList<>();
        reverseNodes = new ArrayList<>();
        for(int idx=0; idx<=cityCnt; idx++) {
            generalNodes.add(new ArrayList<>());
            reverseNodes.add(new ArrayList<>());
        }

        // 도로 정보 입력
        for(int idx=0; idx<roadCnt; idx++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int distance = Integer.parseInt(st.nextToken());
            generalNodes.get(start).add(new CityNode(end,distance));
            reverseNodes.get(end).add(new CityNode(start,distance));
        }

        // 다익스트라 수행
        dijistra(partyCity,generalPath,pathVisited,generalNodes);
        dijistra(partyCity,reversePath,reverseVisited,reverseNodes);

        // 최장 경로 확인
        result = Integer.MIN_VALUE;
        for(int p=1; p<=cityCnt; p++) {
            int total = generalPath[p] + reversePath[p];
            result = Math.max(result, total);
        }

        // 결과 출력
        System.out.println(result);
    }
}