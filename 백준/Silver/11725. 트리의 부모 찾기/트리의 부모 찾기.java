import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {

    // 노드의 개수
    public static int nodeCount;

    // 관계 정보 리스트
    public static ArrayList<ArrayList<Integer>> relations;

    // 부모 배열
    public static int parent[];

    // 방문 여부 배열
    public static boolean visited[];

    public static void findParent(int node) {

        // 연결 노드 확인
        for(int index=0; index<relations.get(node).size(); index++) {

            // 연결 노드
            int currentNode = relations.get(node).get(index);

            // 방문 여부 확인
            if(!visited[currentNode]) {
                visited[currentNode] = true;
                parent[currentNode] = node;
                findParent(currentNode);
            }
        }
    }

    // 부모 찾기 메서드
    public static void solve() {

        // 부모 배열 생성
        parent = new int[nodeCount+1];

        // 방문 여부 배열 생성
        visited = new boolean[nodeCount+1];

        // 부모 찾기
        visited[1] = true;
        findParent(1);
    }

    // 결과 저장 메서드
    public static String resultSave(StringBuilder sb) {
        for(int index=2; index<=nodeCount; index++) {
            sb.append(parent[index]).append("\n");
        }

        return sb.toString();
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        // 노드 개수 입력
        nodeCount = Integer.parseInt(br.readLine());

        // 관계 정보 리스트 생성
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

        // 부모 찾기
        solve();

        // 결과 저장
        System.out.println(resultSave(new StringBuilder()));
    }
}