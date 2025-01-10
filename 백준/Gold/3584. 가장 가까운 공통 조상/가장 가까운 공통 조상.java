import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {

    // 결과, 노드 수, 대상 노드
    public static int answer, nodeCount, targetNode1, targetNode2;

    // 관계 정보 리스트
    public static ArrayList<ArrayList<Integer>> relations;

    // 대상 노드 조상 리스트
    public static ArrayList<Integer> targetNode1Parents, targetNode2Parents;

    // 조상 정보 얻기 메서드
    public static void getParents(int node, ArrayList<Integer> parents) {

        // 자기 자신 저장
        parents.add(node);

        // 조상 저장
        while(!relations.get(node).isEmpty()) {
            parents.add(relations.get(node).get(0));
            node = relations.get(node).get(0);
        }
    }

    // 조상 탐색 메서드
    public static void solve() {

        // 대상 노드 조상 리스트 생성
        targetNode1Parents = new ArrayList<>();
        targetNode2Parents = new ArrayList<>();

        // 조상 확인
        getParents(targetNode1,targetNode1Parents);
        getParents(targetNode2,targetNode2Parents);

        // 조상 비교
        while(!targetNode1Parents.isEmpty() && !targetNode2Parents.isEmpty()) {

            // 비교
            int parent1 = targetNode1Parents.remove(targetNode1Parents.size()-1);
            int parent2 = targetNode2Parents.remove(targetNode2Parents.size()-1);

            // 조상이 다른 경우
            if(parent1!=parent2) return;

            // 비교 조상 갱신
            answer = parent1;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        // 테스트 케이스 수 입력
        int caseCount = Integer.parseInt(br.readLine());

        // 케이스 수 만큼 수행
        for(int caseIndex=0; caseIndex<caseCount; caseIndex++) {

            // 노드 수 입력
            nodeCount = Integer.parseInt(br.readLine());

            // 관계 정보 리스트 생성
            relations = new ArrayList<>();
            for(int node=0; node<=nodeCount; node++)
                relations.add(new ArrayList<>());

            // 간선 정보 입력
            for(int edge=0; edge<nodeCount-1; edge++) {
                st = new StringTokenizer(br.readLine());
                int parent = Integer.parseInt(st.nextToken());
                int child = Integer.parseInt(st.nextToken());
                relations.get(child).add(parent);
            }

            // 대상 노드 입력
            st = new StringTokenizer(br.readLine());
            targetNode1 = Integer.parseInt(st.nextToken());
            targetNode2 = Integer.parseInt(st.nextToken());

            // 조상 탐색
            solve();

            // 결과 출력
            System.out.println(answer);
        }
    }
}