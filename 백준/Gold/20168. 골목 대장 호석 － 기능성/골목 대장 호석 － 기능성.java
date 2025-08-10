import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

// 간선 클래스
class Edge {
    int node;
    int fee;

    public Edge(int node, int fee) {
        this.node = node;
        this.fee = fee;
    }
}

public class Main {

    // 결과, 정점 개수, 간선 개수, 시작 지점, 도착 지점, 보유 금액
    public static int answer, nodeCount, edgeCount, startNode, endNode, money;

    // 연결 정보 리스트
    public static ArrayList<ArrayList<Edge>> relations;

    // 방문 정보 배열
    public static boolean[] visited;

    // 탐색 수행 메서드
    public static void solve(int node, int minFee, int totalFee) {

        // 보유 금액을 넘어선 경우
        if(totalFee > money) return;

        // 도착 지점인 경우
        if(node == endNode) {
            answer = Math.min(answer, minFee);
            return;
        }

        // 연결 지점 확인
        for(int index=0; index<relations.get(node).size(); index++) {
            Edge edge = relations.get(node).get(index);

            // 이미 방문한 경우
            if(visited[edge.node]) continue;

            // 이동
            visited[edge.node] = true;
            solve(edge.node, Math.max(minFee, edge.fee), totalFee + edge.fee);
            visited[edge.node] = false;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        // 정점 개수, 간선 개수, 시작 지점, 도착 지점, 보유 금액 입력
        st = new StringTokenizer(br.readLine());
        nodeCount = Integer.parseInt(st.nextToken());
        edgeCount = Integer.parseInt(st.nextToken());
        startNode = Integer.parseInt(st.nextToken());
        endNode = Integer.parseInt(st.nextToken());
        money = Integer.parseInt(st.nextToken());

        // 연결 정보 리스트 생성
        relations = new ArrayList<>();
        for(int index=0; index<=nodeCount; index++) {
            relations.add(new ArrayList<>());
        }

        // 연결 정보 입력
        for(int index=0; index<edgeCount; index++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int fee = Integer.parseInt(st.nextToken());
            relations.get(from).add(new Edge(to, fee));
            relations.get(to).add(new Edge(from, fee));
        }

        // 방문 정보 배열 생성
        visited = new boolean[nodeCount+1];

        // 탐색
        answer = Integer.MAX_VALUE;
        visited[startNode] = true;
        solve(startNode, 0, 0);

        // 결과 출력
        System.out.println(answer == Integer.MAX_VALUE ? -1 : answer);
    }
}