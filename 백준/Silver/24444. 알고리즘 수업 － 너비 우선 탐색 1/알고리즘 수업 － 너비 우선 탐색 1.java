import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    // 정점의 수, 간선의 수, 시작 노드
    public static int v, e, start;
    // 방문 배열
    public static int visited[];
    // 인접 리스트
    public static ArrayList<ArrayList<Integer>> nodes;
    // 큐
    public static Queue<Integer> queue;

    // bfs
    static void bfs(int start) {
        // 큐 생성
        queue = new LinkedList<>();
        // 방문 체크, 방문 순서 체크, 큐에 삽입
        int order = 1;
        visited[start] = order;
        order += 1;
        queue.offer(start);

        // 큐가 빌 때까지 수행
        while(!queue.isEmpty()) {
            // 인접 노드 확인할 노드꺼내기
            int node = queue.poll();
            // 오름차순으로 방문을 위한 정렬
            Collections.sort(nodes.get(node));
            // 인접 노드 확인
            for(int n=0; n<nodes.get(node).size(); n++) {
                int checkNode = nodes.get(node).get(n);
                // 인접 노드가 미방문일 경우
                if(visited[checkNode]==0) {
                    visited[checkNode] = order;
                    order += 1;
                    queue.offer(checkNode);
                }
            }
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        // 정점의 수, 간선의 수, 시작 노드 입력
        v = Integer.parseInt(st.nextToken());
        e = Integer.parseInt(st.nextToken());
        start = Integer.parseInt(st.nextToken());

        // 기본 생성 및 초기화
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

        // bfs 탐색
        bfs(start);

        // 결과 출력
        for(int idx=1; idx<=v; idx++) {
            System.out.println(visited[idx]);
        }
    }
}