import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {

    // 노드 개수, 트리 레벨
    public static int nodeCount, treeLevel;

    // 노드 정보 배열
    public static int[] nodes;

    // 레벨별 정보 리스트
    public static ArrayList<ArrayList<Integer>> trees;

    // 노드 탐색
    public static void solve(int start, int end, int level) {
        if(level == treeLevel) return;

        // 현재 기준 부모 노드
        int mid = (start + end) / 2;
        trees.get(level).add(nodes[mid]);

        // 탐색
        solve(start, mid-1, level+1);
        solve(mid+1, end, level+1);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        // 트리 레벨 입력
        treeLevel = Integer.parseInt(br.readLine());

        // 노드 개수 확인
        nodeCount = (int) Math.pow(2,treeLevel) - 1;

        // 노드 정보 배열 생성
        nodes = new int[nodeCount];

        // 노드 정보 입력
        st = new StringTokenizer(br.readLine());
        for(int index=0; index<nodeCount; index++) {
            nodes[index] = Integer.parseInt(st.nextToken());
        }

        // 레벨별 정보 리스트 생성
        trees = new ArrayList<>();
        for(int index=0; index<treeLevel; index++) {
            trees.add(new ArrayList<>());
        }

        // 노드 탐색
        solve(0,nodeCount-1,0);

        // 결과 저장
        for(int level=0; level<trees.size(); level++) {
            for(int index=0; index<trees.get(level).size(); index++) {
                sb.append(trees.get(level).get(index)).append(" ");
            }
            sb.append("\n");
        }

        // 결과 출력
        System.out.println(sb.toString());
    }
}