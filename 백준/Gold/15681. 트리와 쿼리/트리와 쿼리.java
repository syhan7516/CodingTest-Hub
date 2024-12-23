import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    // 정점의 수, 루트 번호, 쿼리 수
    public static int nodeCount, rootNumber, queryCount;

    // 부분 집합 개수 배열
    public static int parent[];

    // 방문 여부 배열
    public static boolean visited[];

    // 연결 정보 리스트
    public static ArrayList<ArrayList<Integer>> relations;

    // 부분 집합 구하기 메서드
    public static int solve(int node) {

        // 포함 개수
        int count = 1;

        // 연결 관계 확인
        for(int edge=0; edge<relations.get(node).size(); edge++) {

            // 확인 노드
            int connection = relations.get(node).get(edge);

            // 이미 방문한 경우
            if(visited[connection])
                count += parent[connection];

            // 아닌 경우
            else {
                visited[connection] = true;
                parent[connection] = solve(connection);
                count += parent[connection];
            }
        }

        return parent[node] = count;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        // 정점의 수, 루트 번호, 쿼리 수 입력
        st = new StringTokenizer(br.readLine());
        nodeCount = Integer.parseInt(st.nextToken());
        rootNumber = Integer.parseInt(st.nextToken());
        queryCount = Integer.parseInt(st.nextToken());

        // 연결 정보 리스트 생성
        relations = new ArrayList<>();
        for(int node=0; node<=nodeCount; node++)
            relations.add(new ArrayList<>());

        // 연결 정보 입력
        for(int edge=0; edge<nodeCount-1; edge++) {
            st = new StringTokenizer(br.readLine());
            int node1 = Integer.parseInt(st.nextToken());
            int node2 = Integer.parseInt(st.nextToken());
            relations.get(node1).add(node2);
            relations.get(node2).add(node1);
        }

        // 방문 여부 배열 생성
        visited = new boolean[nodeCount+1];

        // 부분 집합 구하기
        parent = new int[nodeCount+1];
        visited[rootNumber] = true;
        parent[rootNumber] = solve(rootNumber);

        // 쿼리 입력
        for(int query=0; query<queryCount; query++) {
            int point = Integer.parseInt(br.readLine());
            sb.append(parent[point]).append("\n");
        }

        // 결과 출력
        System.out.println(sb.toString());
    }
}