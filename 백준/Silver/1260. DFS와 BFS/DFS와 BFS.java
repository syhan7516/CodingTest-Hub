import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    // 결과 저장 빌더
    public static StringBuilder sb;

    // 정점의 개수, 간선의 개수, 시작 정점
    public static int nodeCount, edgeCount, startNode;

    // 방문 여부 배열
    public static boolean visited[];

    // 관계 리스트
    public static ArrayList<ArrayList<Integer>> relations;

    public static void solve(int node) {

        // 정렬
        Collections.sort(relations.get(node));
        sb.append(node).append(" ");

        // 연결 노드 확인
        for(int index=0; index<relations.get(node).size(); index++) {

            // 탐색 노드
            int nextNode = relations.get(node).get(index);

            // 방문 여부 확인
            if(!visited[nextNode]) {
                visited[nextNode] = true;
                solve(nextNode);
            }
        }
    }

    // dfs
    public static void dfs() {

        // 빌더 생성
        sb = new StringBuilder();

        // 방문 여부 배열 생성
        visited = new boolean[nodeCount+1];

        // 시작 지점 설정
        visited[startNode] = true;
        solve(startNode);
    }

    // bfs
    public static void bfs() {

        // 빌더 생성
        sb = new StringBuilder();

        // 큐 생성
        Queue<Integer> queue = new LinkedList<>();

        // 방문 여부 배열 생성
        visited = new boolean[nodeCount+1];

        // 시작 지점 설정
        queue.offer(startNode);
        visited[startNode] = true;
        sb.append(startNode).append(" ");

        // 탐색
        while(!queue.isEmpty()) {

            // 현재 노드
            int currentNode = queue.poll();

            // 연결 노드 확인
            for(int index=0; index<relations.get(currentNode).size(); index++) {

                // 탐색 노드
                int nextNode = relations.get(currentNode).get(index);

                // 방문 여부 확인
                if(!visited[nextNode]) {
                    visited[nextNode] = true;
                    sb.append(nextNode).append(" ");
                    queue.offer(nextNode);
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        // 정점의 개수, 간선의 개수 입력
        st = new StringTokenizer(br.readLine());
        nodeCount = Integer.parseInt(st.nextToken());
        edgeCount = Integer.parseInt(st.nextToken());
        startNode = Integer.parseInt(st.nextToken());

        // 관계 리스트 생성 및 초기화
        relations = new ArrayList<>();
        for(int node=0; node<=nodeCount; node++) {
            relations.add(new ArrayList<>());
        }

        // 관계 정보 입력
        for(int edge=0; edge<edgeCount; edge++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            relations.get(from).add(to);
            relations.get(to).add(from);
        }

        // DFS
        dfs();
        System.out.println(sb.toString());

        // BFS
        bfs();
        System.out.println(sb.toString());
    }
}