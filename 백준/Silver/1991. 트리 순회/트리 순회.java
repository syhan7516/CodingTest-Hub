import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    // 노드 개수
    public static int nodeCnt;
    // 노드 연결 관계 배열 ([부모][자식])
    public static int tree[][] = new int[27][3];

    // 전위 순회
    static void preorder(int node) {
        if(node==0)
            return;

        System.out.print((char)('A'+node-1));
        preorder(tree[node][0]);
        preorder(tree[node][1]);
    }

    // 중위 순회
    static void inorder(int node) {
        if(node==0)
            return;

        inorder(tree[node][0]);
        System.out.print((char)('A'+node-1));
        inorder(tree[node][1]);
    }

    // 후위 순회
    static void postorder(int node) {
        if(node==0)
            return;

        postorder(tree[node][0]);
        postorder(tree[node][1]);
        System.out.print((char)('A'+node-1));
    }

    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // 노드 개수 입력
        nodeCnt = Integer.parseInt(br.readLine());
        // 노드 입력 & 연결
        for(int idx=1; idx<=nodeCnt; idx++) {
            String relLetter = br.readLine();
            char parent = relLetter.charAt(0);
            char left = relLetter.charAt(2);
            char right = relLetter.charAt(4);

            // 자식이 있는 경우
            if(left!='.')
                tree[parent-'A'+1][0] = left-'A'+1;
            if(right!='.')
                tree[parent-'A'+1][1] = right-'A'+1;
        }

        preorder(1);
        System.out.println();
        inorder(1);
        System.out.println();
        postorder(1);
    }
}