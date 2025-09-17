import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    // 노드 개수, 쌍 개수
    public static int nodeCount, pairCount;

    // 방문 여부 배열
    public static boolean[] visited;

    // 연결 정보 리스트
    public static ArrayList<ArrayList<Integer>> relations;

    // 부모, 깊이 배열
    public static int[] parents, depths;

    // 부모 찾기 메서드
    public static void saveParentAndDepth(int node, int depth) {

        // 연결 정보 확인
        for(int index=0; index<relations.get(node).size(); index++) {
            int connected = relations.get(node).get(index);

            // 이미 방문한 경우
            if(visited[connected]) continue;

            // 방문 처리
            visited[connected] = true;

            // 부모, 깊이 설정
            parents[connected] = node;
            depths[connected] = depth;
            saveParentAndDepth(connected, depth+1);
        }
    }

    // 공통 조상 찾기 메서드
    public static int findCommonAncestor(int node1, int node2) {

        // 깊이 맞추기
        while(depths[node1] > depths[node2]) {
            node1 = parents[node1];
        }

        // 깊이 맞추기
        while(depths[node2] > depths[node1]) {
            node2 = parents[node2];
        }

        // 공통 조상 찾기
        while(node1 != node2) {
            node1 = parents[node1];
            node2 = parents[node2];
        }

        return node1;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        // 노드 개수 입력
        nodeCount = Integer.parseInt(br.readLine());

        // 연결 정보 리스트 생성
        relations = new ArrayList<>();
        for(int index=0; index<=nodeCount; index++) {
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

        // 부모, 깊이 배열 생성
        parents = new int[nodeCount+1];
        depths = new int[nodeCount+1];
        visited = new boolean[nodeCount+1];
        visited[1] = true;
        saveParentAndDepth(1, 1);

        // 쌍 개수 입력
        pairCount = Integer.parseInt(br.readLine());

        // 쌍 정보 입력
        for(int index=0; index<pairCount; index++) {
            st = new StringTokenizer(br.readLine());
            int node1 = Integer.parseInt(st.nextToken());
            int node2 = Integer.parseInt(st.nextToken());
            int commonAncestor = findCommonAncestor(node1 ,node2);
            sb.append(commonAncestor).append("\n");
        }

        // 결과 출력
        System.out.println(sb.toString());
    }
}