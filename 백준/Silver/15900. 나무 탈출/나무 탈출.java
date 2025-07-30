import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {

    // 결과, 정점의 개수
    public static int answer, nodeCount;

    // 연결 관계 리스트
    public static ArrayList<ArrayList<Integer>> relations;

    // 방문 여부 배열
    public static boolean[] visited;

    // 리프 노드까지의 거리 합 구하기 메서드
    public static void solve(int node, int distance) {

        // 자식 여부
        boolean hasChildren = false;

        // 연결된 노드 확인
        for(int index=0; index<relations.get(node).size(); index++) {

            // 연결 노드
            int connectedNode = relations.get(node).get(index);

            // 이미 방문한 경우
            if(visited[connectedNode]) continue;

            visited[connectedNode] = true;
            hasChildren = true;
            solve(connectedNode,distance+1);
        }

        // 리프 노드인 경우
        if(!hasChildren) {
            answer += distance;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        // 정점의 개수 입력
        nodeCount = Integer.parseInt(br.readLine());

        // 연결 관계 리스트 생성
        relations = new ArrayList<>();
        for(int index=0; index<=nodeCount; index++) {
            relations.add(new ArrayList<>());
        }

        // 관계 정보 입력
        for(int index=0; index<nodeCount-1; index++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            relations.get(from).add(to);
            relations.get(to).add(from);
        }

        // 방문 여부 배열 생성
        visited = new boolean[nodeCount+1];

        // 리프 노드까지의 거리 합 구하기
        visited[1] = true;
        solve(1,0);

        // 결과 출력
        System.out.println(answer%2==1 ? "Yes":"No");
    }
}