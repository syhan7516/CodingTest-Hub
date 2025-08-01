import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {

    // 정점 개수, 루트 노드, 필드 값
    public static int nodeCount, rootNode, value;

    // 관계 정보 리스트
    public static ArrayList<ArrayList<Integer>> relations;

    // 필드 정보 배열
    public static int[][] fields;

    // 방문 여부 배열 생성
    public static boolean[] visited;

    // 탐색 메서드
    public static void solve(int node) {

        // left
        fields[node][0] = value++;

        // 연결 노드 확인
        for(int index=0; index<relations.get(node).size(); index++) {
            int connectedNode = relations.get(node).get(index);
            if(visited[connectedNode]) continue;
            visited[connectedNode] = true;
            solve(connectedNode);
        }

        // right
        fields[node][1] = value++;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        // 정점 개수 입력
        nodeCount = Integer.parseInt(br.readLine());

        // 관계 정보 리스트 생성
        relations = new ArrayList<>();
        for(int index=0; index<=nodeCount; index++) {
            relations.add(new ArrayList<>());
        }

        // 관계 정보 입력
        for(int index=0; index<nodeCount; index++) {
            st = new StringTokenizer(br.readLine());
            int node = Integer.parseInt(st.nextToken());
            while(st.hasMoreTokens()) {
                int connectedNode = Integer.parseInt(st.nextToken());
                if(connectedNode == -1) {
                    Collections.sort(relations.get(node));
                    break;
                }
                relations.get(node).add(connectedNode);
            }
        }

        // 루트 노드 입력
        rootNode = Integer.parseInt(br.readLine());

        // 필드 정보 배열 생성
        fields = new int[nodeCount+1][2];

        // 방문 여부 배열 생성
        visited = new boolean[nodeCount+1];

        // 탐색
        value = 1;
        visited[rootNode] = true;
        solve(rootNode);

        // 결과 저장
        for(int index=1; index<=nodeCount; index++) {
            sb.append(index).append(" ")
                    .append(fields[index][0]).append(" ")
                    .append(fields[index][1]).append("\n");
        }

        // 결과 출력
        System.out.println(sb.toString());
    }
}