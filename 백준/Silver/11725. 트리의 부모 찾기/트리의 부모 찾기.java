import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    // 노드 개수
    public static int nodeCnt;
    // 노드 연결 관계 배열
    public static ArrayList<ArrayList<Integer>> tree = new ArrayList<>();
    // 부모 배열
    public static int parent[];
    // 큐
    public static Queue<Integer> treeNode = new LinkedList<>();

    public static void main(String args[]) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        // 노드 개수 입력
        nodeCnt = Integer.parseInt(br.readLine());
        // 트리 생성
        for(int idx=0; idx<=nodeCnt; idx++) {
            tree.add(new ArrayList<>());
        }

        // 노드 입력 & 연결
        for(int idx=0; idx<nodeCnt-1; idx++) {
            st = new StringTokenizer(br.readLine());
            int firNode = Integer.parseInt(st.nextToken());
            int secNode = Integer.parseInt(st.nextToken());
            tree.get(firNode).add(secNode);
            tree.get(secNode).add(firNode);
        }

        // 부모 찾기
        parent = new int[nodeCnt+1];
        for(int rootNode=0; rootNode<tree.get(1).size(); rootNode++) {
            int node = tree.get(1).get(rootNode);
            parent[node] = 1;
            treeNode.offer(node);
        }

        while(!treeNode.isEmpty()) {
            int curNode = treeNode.poll();
            for(int idx=0; idx<tree.get(curNode).size(); idx++) {
                int node = tree.get(curNode).get(idx);
                if(parent[node]==0) {
                    parent[node] = curNode;
                    treeNode.offer(node);
                }
            }
        }

        // 결과 출력
        for(int idx=2; idx<=nodeCnt; idx++)
            System.out.println(parent[idx]);
    }
}