import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    // 정점의 수, 간선의 수, 시작 정점
    public static int v, e, start;
    // 방문 배열
    public static int visited[];
    // 인접 리스트
    public static ArrayList<ArrayList<Integer>> nodes;
    // 방문 순서
    public static int order;

    // dfs
    static void dfs(int node) {
        // 이미 방문한 경우
        if(visited[node]!=0)
            return;

        // 방문하지않은 경우
        visited[node] = order;
        order += 1;
        // 인접 노드 확인
        for(int n=0; n<nodes.get(node).size(); n++) {
            int nowNode = nodes.get(node).get(n);
            dfs(nowNode);
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        // 정점의 수, 간선의 수, 시작 정점 입력
        v = Integer.parseInt(st.nextToken());
        e = Integer.parseInt(st.nextToken());
        start = Integer.parseInt(st.nextToken());

        // 기본 생성 및 초기화
        order = 1;
        visited = new int[v+1];
        nodes = new ArrayList<>();
        for(int idx=0; idx<=v; idx++) {
            nodes.add(new ArrayList<>());
            visited[idx] = 0;
        }

        // 노드 연결 정보 입력
        for(int idx=0; idx<e; idx++) {
            st = new StringTokenizer(br.readLine());
            int startNode = Integer.parseInt(st.nextToken());
            int endNode = Integer.parseInt(st.nextToken());
            nodes.get(startNode).add(endNode);
            nodes.get(endNode).add(startNode);
        }

        // 각 노드 오름차순 정렬
        for(int idx=1; idx<=v; idx++) {
            Collections.sort(nodes.get(idx));
        }

        // dfs
        dfs(start);

        // 결과 출력
        for(int idx=1; idx<=v; idx++)
            System.out.println(visited[idx]);
    }
}
