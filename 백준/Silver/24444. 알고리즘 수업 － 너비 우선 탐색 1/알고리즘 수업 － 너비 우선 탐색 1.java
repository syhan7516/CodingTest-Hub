import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    // 정점 개수, 간선 개수, 시작 정점, 순서
    public static int nodeCount, edgeCount, startNode, order;

    // 관계 정보 리스트
    public static ArrayList<ArrayList<Integer>> relations;

    // 방문 여부 배열
    public static boolean[] visited;

    // 순서 배열
    public static int[] orders;

    // 관계 확인 메서드
    public static void solve() {

        // 순서 배열 생성
        order = 1;
        orders = new int[nodeCount+1];

        // 큐 생성
        Queue<Integer> queue = new LinkedList<>();

        // 방문 여부 배열 생성
        visited = new boolean[nodeCount+1];

        // 시작점 처리
        visited[startNode] = true;
        queue.offer(startNode);
        orders[startNode] = 1;
        order++;

        // 탐색
        while(!queue.isEmpty()) {

            // 현재 노드
            int currentNode = queue.poll();

            // 정렬
            Collections.sort(relations.get(currentNode));

            // 관계 확인
            for(int index=0; index<relations.get(currentNode).size(); index++) {

                // 연결 노드
                int connectNode = relations.get(currentNode).get(index);

                // 방문하지 않은 경우
                if(!visited[connectNode]) {
                    visited[connectNode] = true;
                    queue.offer(connectNode);
                    orders[connectNode] = order;
                    order++;
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        // 정점 개수, 간선 개수, 시작 정점 입력
        st = new StringTokenizer(br.readLine());
        nodeCount = Integer.parseInt(st.nextToken());
        edgeCount = Integer.parseInt(st.nextToken());
        startNode = Integer.parseInt(st.nextToken());

        // 관계 정보 리스트 생성
        relations = new ArrayList<>();
        for(int index=0; index<=nodeCount; index++) {
            relations.add(new ArrayList<>());
        }

        // 관게 정보 입력
        for(int index=0; index<edgeCount; index++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            relations.get(from).add(to);
            relations.get(to).add(from);
        }

        // 관계 확인 및 결과 출력
        solve();

        // 결과 저장
        for(int index=1; index<=nodeCount; index++) {
            sb.append(orders[index]).append("\n");
        }

        // 결과 출력
        System.out.println(sb.toString());
    }
}