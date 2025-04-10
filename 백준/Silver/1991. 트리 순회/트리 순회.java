import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 노드 클래스
class Node {
    char data;
    Node left;
    Node right;

    public Node(char data) {
        this.data = data;
    }

    public Node search(char data) {

        // 노드를 찾은 경우
        if(this.data==data) {
            return this;
        }

        Node node = null;

        if(this.left != null) {
            node = this.left.search(data);
            if(node != null) return node;
        }

        if(this.right != null) {
            node = this.right.search(data);
            if(node != null) return node;
        }

        return null;
    }

    public void insertLeft(Node node) {
        this.left = node;
    }

    public void insertRight(Node node) {
        this.right = node;
    }

    public void preOrder(Node node) {

        // 노드가 없는 경우
        if(node==null || node.data=='.')
            return;

        System.out.print(node.data);
        preOrder(node.left);
        preOrder(node.right);
    }

    public void inOrder(Node node) {

        // 노드가 없는 경우
        if(node==null || node.data=='.')
            return;

        inOrder(node.left);
        System.out.print(node.data);
        inOrder(node.right);
    }

    public void postOrder(Node node) {

        // 노드가 없는 경우
        if(node==null || node.data=='.')
            return;

        postOrder(node.left);
        postOrder(node.right);
        System.out.print(node.data);
    }
}

public class Main {

    // 노드 개수
    public static int nodeCount;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        // 노드 개수 입력
        nodeCount = Integer.parseInt(br.readLine());

        // 노드 정보 입력
        Node root = new Node('A');
        for(int nodeOrder=0; nodeOrder<nodeCount; nodeOrder++) {
            st = new StringTokenizer(br.readLine());
            char standard = st.nextToken().charAt(0);
            char left = st.nextToken().charAt(0);
            char right = st.nextToken().charAt(0);
            root.search(standard).insertLeft(new Node(left));
            root.search(standard).insertRight(new Node(right));
        }

        // 전위 순회
        root.preOrder(root);
        System.out.println();

        // 중위 순회
        root.inOrder(root);
        System.out.println();

        // 후위 순회
        root.postOrder(root);
        System.out.println();
    }
}
