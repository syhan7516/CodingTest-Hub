import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {

    // 결과, 정점 개수, 거리
    public static int answer, nodeCount, distance;

    // 사과 정보 배열
    public static int[] hasApple;

    // 방문 여부 배열
    public static boolean[] visited;

    // 연결 관계 리스트
    public static ArrayList<ArrayList<Integer>> relations;

    // 탐색 메서드
    public static void solve(int node, int depth) {

        // 거리가 먼 경우
        if(depth > distance) return;

        // 사과 수확
        answer += hasApple[node];

        // 연결 노드 확인
        for(int index=0; index<relations.get(node).size(); index++) {
            int connectedNode = relations.get(node).get(index);

            // 이미 방문한 경우
            if(visited[connectedNode]) continue;

            // 이동
            visited[connectedNode] = true;
            solve(connectedNode,depth+1);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        // 정점 개수, 거리 입력
        st = new StringTokenizer(br.readLine());
        nodeCount = Integer.parseInt(st.nextToken());
        distance = Integer.parseInt(st.nextToken());

        // 연결 관계 리스트 생성
        relations = new ArrayList<>();
        for(int index=0; index<nodeCount; index++) {
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

        // 사과 정보 배열 생성
        hasApple = new int[nodeCount];
        st = new StringTokenizer(br.readLine());
        for(int index=0; index<nodeCount; index++) {
            hasApple[index] = Integer.parseInt(st.nextToken());
        }

        // 탐색
        answer = 0;
        visited = new boolean[nodeCount];
        visited[0] = true;
        solve(0,0);

        // 결과 출력
        System.out.println(answer);
    }
}