import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.StringTokenizer;

// 간선 클래스
class Edge {
    int node;
    int cost;

    public Edge(int node, int cost) {
        this.node = node;
        this.cost = cost;
    }
}

public class Main {

    // 결과
    public static int answer;

    // 연결 정보 리스트 생성
    public static ArrayList<ArrayList<Edge>> relations;

    // 리프 노드 저장 해시
    public static HashMap<Integer, Boolean> map;

    // 방문 여부 배열
    public static boolean[] visited;

    // 노드 차수 갱신 메서드
    public static void updateDegree(int node) {
        if(map.containsKey(node)) {
            map.remove(node);
        }
        else map.put(node, true);
    }

    // 탐색 메서드
    public static void search() {
        visited = new boolean[10001];
        for(int node: map.keySet()) {
            visited[node] = true;
            solve(node, 0);
            visited[node] = false;
        }
    }

    public static void solve(int node, int totalDistance) {

        // 거리 갱신
        answer = Math.max(answer, totalDistance);

        // 연결 간선 확인
        for(int index=0; index<relations.get(node).size(); index++) {
            Edge connectedEdge = relations.get(node).get(index);

            // 이미 방문한 경우
            if(visited[connectedEdge.node]) continue;

            // 탐색 수행
            visited[connectedEdge.node] = true;
            solve(connectedEdge.node, totalDistance + connectedEdge.cost);
            visited[connectedEdge.node] = false;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        // 연결 정보 리스트 생성
        relations = new ArrayList<>();
        for(int index=0; index<=10000; index++) {
            relations.add(new ArrayList<>());
        }

        // 리프 노드 저장 해시 생성
        map = new HashMap<>();

        // 입력
        String line;

        // 연결 정보 입력
        while((line = br.readLine()) != null && !line.isEmpty()) {

            // 간선 정보 저장
            st = new StringTokenizer(line);
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());
            relations.get(from).add(new Edge(to, cost));
            relations.get(to).add(new Edge(from, cost));

            // 노드 차수 갱신
            updateDegree(from);
            updateDegree(to);
        }

        // 리프 노드 기준으로 탐색
        if(!map.isEmpty()) {
            search();
        }

        // 결과 출력
        System.out.println(answer);
    }
}