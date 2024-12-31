import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    // 정점 개수, 간선 개수
    public static int nodeCount, edgeCount;

    // 집합 배열
    public static int []group;

    // 연결 관계 리스트
    public static ArrayList<ArrayList<Integer>> relations;

    // 이분 그래프 확인 메서드
    public static boolean solve(int node) {

        // 인접 정보 저장 큐 생성
        Queue<Integer> queue = new LinkedList<>();

        // 시작 노드 처리
        group[node] = 1;
        queue.offer(node);

        // 노드 확인
        while(!queue.isEmpty()) {

            // 기준 노드
            int currentNode = queue.poll();

            // 인접 노드 확인
            for(int index=0; index<relations.get(currentNode).size(); index++) {

                // 인접 노드
                int connectNode = relations.get(currentNode).get(index);

                // 미방문 노드인 경우
                if(group[connectNode]==0) {
                    group[connectNode] = group[currentNode]*(-1);
                    queue.offer(connectNode);
                }

                // 방문한 경우
                else {

                    // 같은 집합인 경우
                    if(group[currentNode]==group[connectNode])
                        return false;
                }
            }
        }

        return true;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        // 테스트 케이스 수 입력
        int caseCount = Integer.parseInt(br.readLine());

        // 테스트 케이스 수행
        for(int caseIndex=0; caseIndex<caseCount; caseIndex++) {

            // 정점, 간선 수 입력
            st = new StringTokenizer(br.readLine());
            nodeCount = Integer.parseInt(st.nextToken());
            edgeCount = Integer.parseInt(st.nextToken());

            // 집합 배열 생성
            group = new int[nodeCount+1];

            // 연결 관계 리스트 생성, 초기화
            relations = new ArrayList<>();
            for(int index=0; index<=nodeCount; index++)
                relations.add(new ArrayList<>());

            // 연결 정보 입력
            for(int index=0; index<edgeCount; index++) {
                st = new StringTokenizer(br.readLine());
                int node1 = Integer.parseInt(st.nextToken());
                int node2 = Integer.parseInt(st.nextToken());
                relations.get(node1).add(node2);
                relations.get(node2).add(node1);
            }

            // 이분 그래프 확인
            boolean flag = true;
            for(int index=1; index<=nodeCount; index++) {

                // 방문 여부 확인
                if(group[index]==0)
                    flag = solve(index);

                // 실패한 경우
                if(!flag) break;
            }

            // 결과 저장
            if(flag) sb.append("YES").append("\n");
            else sb.append("NO").append("\n");

        }

        // 결과 출력
        System.out.println(sb.toString());
    }
}