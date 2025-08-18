import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {

    // 노드 개수, 물, 리프 노드 개수
    public static int nodeCount, water, leafNodeCount;

    // 연결 관계 리스트
    public static ArrayList<ArrayList<Integer>> relations;

    // 방문 여부 배열
    public static boolean[] visited;

    // 탐색 메서드
    public static void solve(int node) {

        // 자식 여부
        boolean isChild = false;

        // 연결 노드 확인
        for(int index=0; index<relations.get(node).size(); index++) {
            int connectedNode = relations.get(node).get(index);

            // 이미 방문한 경우
            if(visited[connectedNode]) continue;

            // 방문 처리
            visited[connectedNode] = true;
            isChild = true;

            // 이동
            solve(connectedNode);
        }

        // 자식이 없는 경우
        if(!isChild) leafNodeCount++;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        // 노드 개수, 물 입력
        st = new StringTokenizer(br.readLine());
        nodeCount = Integer.parseInt(st.nextToken());
        water = Integer.parseInt(st.nextToken());

        // 연결 관계 리스트 생성
        relations = new ArrayList<>();
        for(int node=0; node<=nodeCount; node++) {
            relations.add(new ArrayList<>());
        }

        // 연결 정보 입력
        for(int index=0; index<nodeCount-1; index++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            relations.get(from).add(to);
            relations.get(to).add(from);
        }

        // 방문 여부 배열 생성
        visited = new boolean[nodeCount+1];

        // 탐색 수행
        leafNodeCount = 0;
        visited[1] = true;
        solve(1);

        // 결과 출력
        double answer = (double)water / leafNodeCount;
        System.out.println(answer);
    }
}