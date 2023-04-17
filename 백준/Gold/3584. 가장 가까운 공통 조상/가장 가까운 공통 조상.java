import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    // 노드의 수, 루트 노드, 결과
    public static int nodeCnt, rootNode, result;
    // 트리
    public static ArrayList<Integer>[] tree;
    // 부모, 깊이 배열
    public static int [] parents, depths;
    // 공통 조상 확인할 두 노드
    public static int firNode, secNode;
    // 방문 배열
    public static boolean visited[];

    // 깊이 및 부모 노드 저장 함수
    static void dfs(int current, int depth, int parent) {
        // 해당 노드 깊이 저장
        depths[current] = depth;
        // 해당 노드 부모 저장
        parents[current] = parent;

        for(int nextNode : tree[current]) {
            dfs(nextNode,depth+1,current);
        }
    }

    // LCA 함수
    static void LCA(int firNode, int secNode) {

        // 각 노드 깊이 확인
        int firDepth = depths[firNode];
        int secDepth = depths[secNode];

        // 깊이 맞춰주기
        while(firDepth>secDepth) {
            firNode = parents[firNode];
            firDepth--;
        }
        while(secDepth>firDepth) {
            secNode = parents[secNode];
            secDepth--;
        }

        // 공통 조상 찾을 때까지 계층 오르기
        while(firNode!=secNode) {
            firNode = parents[firNode];
            secNode = parents[secNode];
        }

        // 결과 저장
        result = firNode;
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        // 테스트 케이스 수 입력
        int caseNum = Integer.parseInt(br.readLine());

        // 테스트 케이스 수만큼 수행
        for(int caseIdx=0; caseIdx<caseNum; caseIdx++) {

            // 노드의 수 입력
            nodeCnt = Integer.parseInt(br.readLine());

            // 트리 만들기
            tree = new ArrayList[nodeCnt+1];
            for(int t=1; t<=nodeCnt; t++)
                tree[t] = new ArrayList<>();

            // 부모, 깊이 배열 만들기
            parents = new int[nodeCnt+1];
            depths = new int[nodeCnt+1];
            visited = new boolean[nodeCnt+1];
            Arrays.fill(depths,-1);
            Arrays.fill(visited,true);

            // 트리 정보 입력
            for(int e=0; e<nodeCnt-1; e++) {
                st = new StringTokenizer(br.readLine());
                int p = Integer.parseInt(st.nextToken());
                int c = Integer.parseInt(st.nextToken());
                tree[p].add(c);
                visited[c] = false;
            }

            // 루트 노드 찾기
            rootNode = 0;
            for(int n=1; n<=nodeCnt; n++) {
                if(visited[n]) rootNode = n;
            }

            // 깊이 및 부모 노드 저장
            dfs(rootNode,1,0);

            // 공통 조상 확인할 두 노드 입력
            st = new StringTokenizer(br.readLine());
            firNode = Integer.parseInt(st.nextToken());
            secNode = Integer.parseInt(st.nextToken());

            // 공통 조상 찾기
            result = 0;
            LCA(firNode,secNode);

            // 결과 저장
            sb.append(result+"\n");
        }

        // 결과 출력
        System.out.println(sb.toString());
    }
}