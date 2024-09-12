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

    // 결과, 노드 개수
    public static int answer, nodeCnt;

    // 노드 관계 리스트
    public static ArrayList<ArrayList<Edge>> relation;

    // 노드 방문 여부 배열
    public static boolean visited[];

    // 노드 순회 메서드
    public static void solve(int node, int len) {

        // 결과 갱신
        answer = Math.max(answer,len);

        // 연결 노드 확인
        for(int i=0; i<relation.get(node).size(); i++) {

            // 연결된 간선
            Edge edge = relation.get(node).get(i);

            // 이미 방문한 경우
            if(visited[edge.node]) continue;

            // 아직 방문하지 않은 경우
            visited[edge.node] = true;
            solve(edge.node,len+edge.value);
            visited[edge.node] = false;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        // 노드 개수 입력
        nodeCnt = Integer.parseInt(br.readLine());

        // 관계 리스트 생성 및 초기화
        relation = new ArrayList<>();
        for(int i=0; i<=nodeCnt; i++)
            relation.add(new ArrayList<>());

        // 노드 정보 입력
        for(int i=1; i<nodeCnt; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int value = Integer.parseInt(st.nextToken());
            relation.get(start).add(new Edge(end,value));
            relation.get(end).add(new Edge(start,value));
        }

        // 방문 여부 배열 생성
        visited = new boolean[nodeCnt+1];

        // 리프 노드 순회
        answer = 0;
        for(int i=nodeCnt; i>nodeCnt/2; i--) {
            visited[i] = true;
            solve(i,0);
            visited[i] = false;
        }

        // 결과 출력
        System.out.println(answer);
    }
}