import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

// 간선 클래스
class Edge implements Comparable<Edge> {
    int node;
    int distance;

    public Edge(int node, int distance) {
        this.node = node;
        this.distance = distance;
    }

    @Override
    public int compareTo(Edge other) {
        return this.distance - other.distance;
    }
}

public class Main {

    // 결과, 팀원의 수, 장소 수, 도로 수
    public static int answer, teamMemberCount, locationCount, roadCount;

    // KIST, 씨알 푸드 위치
    public static int KIST, CR;

    // 팀원 배열
    public static int[] teamMembers;

    // 최단 거리 배열
    public static int[] path;

    // 방문 여부 배열
    public static boolean[] visited;

    // 우선 순위 큐
    public static PriorityQueue<Edge> queue;

    // 연결 정보 리스트
    public static ArrayList<ArrayList<Edge>> relations;

    // 최단 거리 탐색 메서드
    public static void solve(int node) {

        // 최단 거리 배열 생성
        path = new int[locationCount+1];
        Arrays.fill(path, (int)1e9);

        // 방문 여부 배열 생성
        visited = new boolean[locationCount+1];

        // 우선 순위 큐 생성
        queue = new PriorityQueue<>();

        // 시작 지점 처리
        path[node] = 0;
        queue.offer(new Edge(node, 0));

        // 탐색
        while(!queue.isEmpty()) {

            // 현재 노드
            Edge edge = queue.poll();

            // 이미 방문한 경우
            if(visited[edge.node]) continue;

            // 방문 처리
            visited[edge.node] = true;

            // 연결된 노드 확인
            for(int index=0; index<relations.get(edge.node).size(); index++) {
                Edge connectedEdge = relations.get(edge.node).get(index);

                // 이미 방문한 경우
                if(visited[connectedEdge.node]) continue;

                // 최단 거리 비교
                if(path[connectedEdge.node] > path[edge.node] + connectedEdge.distance) {
                    path[connectedEdge.node] = path[edge.node] + connectedEdge.distance;
                    queue.offer(new Edge(connectedEdge.node, path[connectedEdge.node]));
                }
            }
        }

        // 거리 합하기
        for(int index=0; index<teamMemberCount; index++) {
            answer += path[teamMembers[index]] == (int)1e9 ? -1 : path[teamMembers[index]];
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        // 팀원의 수, 장소 수, 도로 수 입력
        st = new StringTokenizer(br.readLine());
        teamMemberCount = Integer.parseInt(st.nextToken());
        locationCount = Integer.parseInt(st.nextToken());
        roadCount = Integer.parseInt(st.nextToken());

        // KIST, 씨알 푸드 위치 입력
        st = new StringTokenizer(br.readLine());
        KIST = Integer.parseInt(st.nextToken());
        CR = Integer.parseInt(st.nextToken());

        // 팀원 배열 생성
        teamMembers = new int[teamMemberCount];

        // 팀원 입력
        st = new StringTokenizer(br.readLine());
        for(int teamMember=0; teamMember<teamMemberCount; teamMember++) {
            teamMembers[teamMember] = Integer.parseInt(st.nextToken());
        }

        // 연결 정보 리스트 생성
        relations = new ArrayList<>();
        for(int index=0; index<=locationCount; index++) {
            relations.add(new ArrayList<>());
        }

        // 연결 정보 입력
        for(int index=0; index<roadCount; index++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int distance = Integer.parseInt(st.nextToken());
            relations.get(from).add(new Edge(to, distance));
            relations.get(to).add(new Edge(from, distance));
        }

        // KIST - 최단 거리 탐색
        solve(KIST);

        // CR - 최단 거리 탐색
        solve(CR);

        // 결과 출력
        System.out.println(answer);
    }
}