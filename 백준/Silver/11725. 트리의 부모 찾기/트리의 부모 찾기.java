import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    // 노드의 개수
    public static int nodeCount;

    // 노드 연결 관계 리스트
    public static ArrayList<ArrayList<Integer>> relation;

    // 부모 정보 배열
    public static int parent[];

    // 부모 노드 찾기 메서드
    public static void solve() {

        // 방문 여부 배열 생성
        boolean visited[] = new boolean[nodeCount+1];

        // 관계 확인 큐 생성
        Queue<Integer> queue = new LinkedList<>();

        // 루트 노드 삽입
        queue.offer(1);
        visited[1] = true;

        // 탐색
        while(!queue.isEmpty()) {

            // 기준 노드
            int currentNode = queue.poll();
            int connectCount = relation.get(currentNode).size();

            // 연결 노드 탐색
            for(int connectNodeIndex=0; connectNodeIndex<connectCount; connectNodeIndex++) {

                // 연결 노드
                int connectNode = relation.get(currentNode).get(connectNodeIndex);

                // 방문하지 않은 경우 자식으로 판단
                if(!visited[connectNode]) {

                    // 큐에 삽입
                    queue.offer(connectNode);
                    visited[connectNode] = true;
                    parent[connectNode] = currentNode;
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        // 노드 개수 입력
        nodeCount = Integer.parseInt(br.readLine());

        // 노드 연결 관계 리스트 생성 및 초기화
        relation = new ArrayList<>();
        for(int node=0; node<=nodeCount; node++)
            relation.add(new ArrayList<>());

        // 노드 연결 정보 입력
        for(int edge=0; edge<nodeCount-1; edge++) {
            st = new StringTokenizer(br.readLine());
            int first = Integer.parseInt(st.nextToken());
            int second = Integer.parseInt(st.nextToken());
            relation.get(first).add(second);
            relation.get(second).add(first);
        }

        // 부모 정보 배열 생성
        parent = new int[nodeCount+1];

        // 부모 노드 찾기
        solve();

        // 결과 저장 및 출력
        for(int node=2; node<=nodeCount; node++)
            sb.append(parent[node]).append("\n");
        System.out.println(sb.toString());
    }
}