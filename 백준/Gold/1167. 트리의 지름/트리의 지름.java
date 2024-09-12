import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
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

    // 결과, 노드의 개수, 루트에서 가장 먼 노드
    public static int answer, nodeCnt, maxNode;

    // 노드 연결 정보 리스트
    public static ArrayList<ArrayList<Edge>> relation;

    // 노드 방문 여부 배열
    public static boolean visited[];

    // 가장 먼 노드 찾기 메서드
    public static void solve(int node, int cost) {

        // 비용 갱신
        if(answer<cost) {
            answer = cost;
            maxNode = node;
        }

        // 연결 노드 확인
        for(int i=0; i<relation.get(node).size(); i++) {

            // 간선 확인
            Edge edge = relation.get(node).get(i);

            // 이미 방문한 경우
            if(visited[edge.node]) continue;

            // 방문하지 않은 경우
            visited[edge.node] = true;
            solve(edge.node,cost+edge.cost);
            visited[edge.node] = false;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        // 노드 개수 입력
        nodeCnt = Integer.parseInt(br.readLine());

        // 노드 연결 정보 리스트 생성 및 초기화
        relation = new ArrayList<>();
        for(int i=0; i<=nodeCnt; i++)
            relation.add(new ArrayList<>());

        // 노드 연결 정보 입력
        for(int i=0; i<nodeCnt; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());

            // 연결 정보 입력
            while(true) {
                int end = Integer.parseInt(st.nextToken());
                if(end==-1) break;
                int cost = Integer.parseInt(st.nextToken());
                relation.get(start).add(new Edge(end,cost));
            }
        }

        // 노드 방문 여부 배열 생성
        visited = new boolean[nodeCnt+1];

        // 루트 노드에서 가장 먼 노드 찾기
        answer = 0;
        visited[1] = true;
        solve(1,0);
        visited[1] = false;

        // 가장 먼 노드에서 가장 먼 노드 찾기
        answer = 0;
        visited[maxNode] = true;
        solve(maxNode,0);
        visited[maxNode] = false;

        // 결과 출력
        System.out.println(answer);
    }
}