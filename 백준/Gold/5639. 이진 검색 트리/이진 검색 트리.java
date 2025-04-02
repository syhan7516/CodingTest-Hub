import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 노드 클래스
class Node {
    int data;
    Node leftNode;
    Node rightNode;

    public Node(int data) {
        this.data = data;
    }

    // 노드 삽입
    public void insert(int data) {

        // 값이 작은 경우
        if(this.data>data) {

            // 왼쪽 자식이 있는 경우
            if(existLeftChild())
                this.leftNode.insert(data);

            // 왼쪽 자식이 없는 경우
            else this.leftNode = new Node(data);
        }

        // 값이 큰 경우
        else {

            // 오른쪽 자식이 있는 경우
            if(existRightChild())
                this.rightNode.insert(data);

            // 오른쪽 자식이 없는 경우
            else this.rightNode = new Node(data);
        }
    }

    // 왼쪽 자식 존재 여부 확인 메서드
    private boolean existLeftChild() {
        return this.leftNode!=null;
    }

    // 오른쪽 자식 존재 여부 확인 메서드
    private boolean existRightChild() {
        return this.rightNode!=null;
    }
}

public class Main {

    // 입출력
    public static BufferedReader br;
    public static StringBuilder sb;

    // 루트 노드
    public static Node root;

    // 트리 정보 입력 메서드
    public static void inputBinarySearchTree() throws IOException {

        // 트리 정보 입력
        String input;
        while((input=br.readLine())!=null) {
            root.insert(Integer.parseInt(input));
        }
    }

    // 트리 생성 메서드
    public static void createBinarySearchTree() throws IOException {
        root = new Node(Integer.parseInt(br.readLine()));
    }

    // 입출력 초기화 메서드
    public static void initIO() {
        br = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuilder();
    }

    // 초기화 메서드
    public static void initialize() throws IOException {

        // 입출력 초기화
        initIO();

        // 트리 생성
        createBinarySearchTree();

        // 트리 정보 입력
        inputBinarySearchTree();
    }

    // 노드 존재 여부 확인 메서드
    public static boolean existNotNode(Node node) {
        return node==null;
    }

    // 후위 순회 메서드
    public static void preOrder(Node node) {

        // 노드가 없는 경우
        if(existNotNode(node)) return;

        // 왼쪽, 오른쪽, 값
        preOrder(node.leftNode);
        preOrder(node.rightNode);
        sb.append(node.data).append(" ");
    }

    public static void main(String[] args) throws IOException {

        // 초기화
        initialize();

        // 후위 순회
        preOrder(root);

        // 결과 출력
        System.out.println(sb.toString());
    }
}