import java.util.*;
import java.io.*;

// 간선 클래스
class Edge implements Comparable<Edge> {
    int to;
    int dist;

    public Edge(int to, int dist) {
        this.to = to;
        this.dist = dist;
    }

    public int compareTo(Edge other) {
        return this.dist - other.dist;
    }
}

public class Main {

    // 노드 수, 간선 수
    public static int nodeCnt, edgeCnt;

    // 연결 관계 리스트
    public static ArrayList<ArrayList<Edge>> relation;

    // 간선 비용 우선 순위 큐
    public static PriorityQueue<Edge> queue;

    // 최단 거리 배열
    public static int path[];

    // 택배 배송하기 메서드
    public static void solve() {

        // 간선 비용 우선 순위 큐 생성
        queue = new PriorityQueue<>();

        // 시작 지점 처리
        path[1] = 0;

        // 시작 지점 삽입
        queue.offer(new Edge(1,path[1]));

        // 최단 거리 구하기
        while(!queue.isEmpty()) {

            // 현재 지점
            Edge current = queue.poll();

            // 현재 지점과 연결된 지점 확인
            for(int i=0; i<relation.get(current.to).size(); i++) {

                // 연결 지점
                Edge connect = relation.get(current.to).get(i);

                // 최단 거리인지 확인
                if(path[connect.to]>path[current.to]+connect.dist) {
                    path[connect.to] = path[current.to]+connect.dist;
                    queue.offer(new Edge(connect.to,path[connect.to]));
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        // 노드, 간선 수 입력
        st = new StringTokenizer(br.readLine());
        nodeCnt = Integer.parseInt(st.nextToken());
        edgeCnt = Integer.parseInt(st.nextToken());

        // 연결 관계 리스트 생성
        relation = new ArrayList<>();
        for(int i=0; i<=nodeCnt; i++)
            relation.add(new ArrayList<>());

        // 연결 정보 입력
        for(int i=0; i<edgeCnt; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int dist = Integer.parseInt(st.nextToken());

            relation.get(from).add(new Edge(to,dist));
            relation.get(to).add(new Edge(from,dist));
        }

        // 최단 거리 배열 생성
        path = new int[nodeCnt+1];
        Arrays.fill(path,(int)1e9);

        // 택배 배송하기
        solve();

        // 결과 출력
        System.out.println(path[nodeCnt]);
    }
}