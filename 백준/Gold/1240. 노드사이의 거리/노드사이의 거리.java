import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

// 간선 클래스
class Edge {
    int node;
    int value;

    public Edge(int node, int value) {
        this.node = node;
        this.value = value;
    }
}

public class Main {

    // 결과, 노드 개수, 쌍의 개수
    public static int answer, nodeCount, pairCount;

    // 관계 정보 리스트
    public static ArrayList<ArrayList<Edge>> relations;

    // 방문 여부 배열
    public static boolean visited[];

    // 노드 사이 거리 구하기 메서드
    public static void solve(int target, int currentNode, int value) {

        // 찾은 경우
        if(currentNode==target) {
            answer = Math.min(answer,value);
            return;
        }

        // 노드 탐색
        for(int index=0; index<relations.get(currentNode).size(); index++) {

            // 탐색 간선
            Edge edge = relations.get(currentNode).get(index);

            // 미방문한 노드인 경우
            if(!visited[edge.node]) {
                visited[edge.node] = true;
                solve(target,edge.node,edge.value+value);
                visited[edge.node] = false;
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        // 노드의 개수, 쌍의 개수 입력
        st = new StringTokenizer(br.readLine());
        nodeCount = Integer.parseInt(st.nextToken());
        pairCount = Integer.parseInt(st.nextToken());

        // 관계 정보 리스트 생성
        relations = new ArrayList<>();
        for(int node=0; node<=nodeCount; node++)
            relations.add(new ArrayList<>());

        // 거리 정보 입력
        for(int index=0; index<nodeCount-1; index++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int value = Integer.parseInt(st.nextToken());
            relations.get(from).add(new Edge(to, value));
            relations.get(to).add(new Edge(from, value));
        }

        // 쌍 정보 입력
        for(int pair=0; pair<pairCount; pair++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            
            // 초기 시작 설정
            visited = new boolean[nodeCount+1];
            visited[start] = true;
            answer = Integer.MAX_VALUE;
            
            // 노드 탐색
            solve(end,start,0);
            
            // 결과 출력
            System.out.println(answer);
        }
    }
}