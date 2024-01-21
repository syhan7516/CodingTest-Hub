import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    // 결과 저장
    public static StringBuilder sb = new StringBuilder();

    // 정점의 개수, 간선의 개수, 연결 요소 개수, 시작 정점
    public static int vCnt, eCnt, start;

    // 연결 정보 리스트
    public static ArrayList<ArrayList<Integer>> list;

    // 방문 여부 배열
    public static boolean visited[];

    // 연결 요소 찾기 메서드 - DFS
    static void dfs(int node) {

        // 방문 노드 처리
        visited[node] = true;
        sb.append(node).append(" ");

        // 정렬
        Collections.sort(list.get(node));

        for(int i=0; i<list.get(node).size(); i++) {

            // 연결된 요소가 미방문 정점인 경우
            if(!visited[list.get(node).get(i)]) {
                visited[list.get(node).get(i)] = true;
                dfs(list.get(node).get(i));
            }
        }
    }

    // 연결 요소 찾기 메서드 - BFS
    static void bfs(int node) {

        // 큐 생성
        Queue<Integer> queue = new LinkedList<>();

        // 시작 정점 처리
        sb.append(start).append(" ");
        queue.offer(start);
        visited[start] = true;

        // 연결 요소 확인
        while(!queue.isEmpty()) {

            // 확인 정점
            int current = queue.poll();

            // 정점과 연결된 정점 확인
            for(int i=0; i<list.get(current).size(); i++) {

                // 연결 요소가 미방문인 경우
                if(!visited[list.get(current).get(i)]) {
                    queue.offer(list.get(current).get(i));
                    visited[list.get(current).get(i)] = true;
                    sb.append(list.get(current).get(i)).append(" ");
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        // 정점, 간선 개수 입력
        st = new StringTokenizer(br.readLine());
        vCnt = Integer.parseInt(st.nextToken());
        eCnt = Integer.parseInt(st.nextToken());
        start = Integer.parseInt(st.nextToken());

        // 연결 정보 리스트 생성
        list = new ArrayList<>();
        for(int i=0; i<=vCnt; i++)
            list.add(new ArrayList<>());

        // 연결 정보 입력
        for(int i=0; i<eCnt; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            list.get(from).add(to);
            list.get(to).add(from);
        }

        // 연결 요소 찾기 - DFS
        visited = new boolean[vCnt+1];
        dfs(start);

        sb.append("\n");

        // 연결 요소 찾기 - BFS
        visited = new boolean[vCnt+1];
        bfs(start);

        // 결과 출력
        System.out.println(sb.toString());
    }
}