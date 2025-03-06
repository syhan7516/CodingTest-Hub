import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {

    // 결과, 노드 개수, 루트 노드, 제거 노드
    public static int answer, nodeCount, rootNode, removeTargetNode;

    // 관계 정보 리스트
    public static ArrayList<ArrayList<Integer>> relations, parents;

    // 리프노드 찾기 메서드
    public static void solve(int node) {

        // 리프노드인 경우
        if(relations.get(node).isEmpty()) {
            answer++;
            return;
        }

        // 자식 확인
        for(int index=0; index<relations.get(node).size(); index++) {
            solve(relations.get(node).get(index));
        }
    }

    // 관계 정보에서 제거 노드 제거하는 메서드
    public static void removeTargetNodeInRelations() {
        int parentNode = parents.get(removeTargetNode).get(0);
        for(int index=0; index<relations.get(parentNode).size(); index++) {
            if(relations.get(parentNode).get(index)==removeTargetNode) {
                relations.get(parentNode).remove(index);
                return;
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        // 노드 개수 입력
        nodeCount = Integer.parseInt(br.readLine());

        // 관계 정보 리스트 생성
        relations = new ArrayList<>();
        parents = new ArrayList<>();
        for(int index=0; index<=nodeCount; index++) {
            relations.add(new ArrayList<>());
            parents.add(new ArrayList<>());
        }

        // 관계 정보 입력
        st = new StringTokenizer(br.readLine());
        for(int index=0; index<nodeCount; index++) {

            // 부모 정보 입력
            int parent = Integer.parseInt(st.nextToken());

            // 루트 노드인 경우
            if(parent==-1) {
                rootNode = index;
                relations.get(nodeCount).add(index);
                parents.get(index).add(nodeCount);
            }

            // 아닌 경우
            else {
                relations.get(parent).add(index);
                parents.get(index).add(parent);
            }
        }

        // 제거 노드 입력 및 제거
        removeTargetNode = Integer.parseInt(br.readLine());
        removeTargetNodeInRelations();


        // 리프노드 찾기
        answer = 0;
        if(removeTargetNode!=rootNode)
            solve(rootNode);

        // 결과 출력
        System.out.println(answer);
    }
}