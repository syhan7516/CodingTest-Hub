import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

// 노드 클래스
class Node {
    int number;
    int value;

    public Node(int number, int value) {
        this.number = number;
        this.value = value;
    }
}

public class Main {

    // 결과, 노드의 개수, 루트에서 가장 먼 노드
    public static int answer, nodeCount, maxDistanceRootNode;

    // 관계 리스트
    public static ArrayList<ArrayList<Node>> relations;

    // 방문 여부 배열
    public static boolean visited[];

    // 가장 먼 거리 구하기 메서드
    public static void solve(int node, int distance) {

        // 거리 갱신
        if(answer<distance) {
            maxDistanceRootNode = node;
            answer = distance;
        }

        // 연결 노드 확인
        for(int index=0; index<relations.get(node).size(); index++) {

            // 연결 노드
            Node currentNode = relations.get(node).get(index);

            // 미방문인 경우
            if(!visited[currentNode.number]) {
                visited[currentNode.number] = true;
                solve(currentNode.number, currentNode.value+distance);
                visited[currentNode.number] = false;
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        // 노드의 개수 입력
        nodeCount = Integer.parseInt(br.readLine());

        // 관계 리스트 생성
        relations = new ArrayList<>();
        for(int node=0; node<=nodeCount; node++)
            relations.add(new ArrayList<>());

        // 관계 정보 입력
        for(int edge=0; edge<nodeCount-1; edge++) {
            st = new StringTokenizer(br.readLine());
            int parent = Integer.parseInt(st.nextToken());
            int child = Integer.parseInt(st.nextToken());
            int value = Integer.parseInt(st.nextToken());
            relations.get(parent).add(new Node(child, value));
            relations.get(child).add(new Node(parent, value));
        }

        // 루트에서 가장 먼 구간 확인
        answer = 0;
        visited = new boolean[nodeCount+1];
        visited[1] = true;
        solve(1,0);

        // 결과 출력
        answer = 0;
        visited = new boolean[nodeCount+1];
        visited[maxDistanceRootNode] = true;
        solve(maxDistanceRootNode,0);
        System.out.println(answer);
    }
}