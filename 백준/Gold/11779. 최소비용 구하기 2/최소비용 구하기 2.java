import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

// 간선 클래스
class Edge implements Comparable<Edge> {
    int to;
    int dist;

    public Edge(int to, int dist) {
        this.to = to;
        this.dist = dist;
    }

    public int compareTo(Edge other) {
        return this.dist-other.dist;
    }
}

public class Main {

    // 도시 수, 버스 수, 출발점, 도착점
    public static int cityCnt, busCnt, start, end;

    // 최단 거리 배열
    public static int path[];

    // 관계 정보 리스트
    public static ArrayList<ArrayList<Edge>> relation;

    // 최단 거리를 위한 우선 순위 큐
    public static PriorityQueue<Edge> queue;

    // 방문 여부 배열
    public static boolean visited[];

    // 이전 경로 저장 배열
    public static int prePath[];

    // 최단 경로 구하기 메서드
    static void solve() {

        // 우선 순위 큐 생성
        queue = new PriorityQueue<>();

        // 시작점 처리
        visited[start] = true;
        path[start] = 0;
        queue.offer(new Edge(start,0));

        // 경로 찾기
        while(!queue.isEmpty()) {

            // 가장 빠른 경로 정점 꺼내기
            Edge current = queue.poll();

            // 연결된 버스 경로 확인
            for(int p=0; p<relation.get(current.to).size(); p++) {

                Edge connect = relation.get(current.to).get(p);

                // 기존 경로와 비교
                if(!visited[connect.to] && path[connect.to]>path[current.to]+connect.dist) {
                    path[connect.to] = path[current.to]+connect.dist;
                    queue.offer(new Edge(connect.to, path[connect.to]));
                    prePath[connect.to] = current.to;
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        // 도시 수 입력
        cityCnt = Integer.parseInt(br.readLine());

        // 버스 수 입력
        busCnt = Integer.parseInt(br.readLine());

        // 관계 정보 리스트 생성
        relation = new ArrayList<>();
        for(int i=0; i<=cityCnt; i++)
            relation.add(new ArrayList<>());

        // 버스 정보 입력
        for(int i=0; i<busCnt; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int dist = Integer.parseInt(st.nextToken());
            relation.get(from).add(new Edge(to,dist));
        }

        // 출발점, 도착점 입력
        st = new StringTokenizer(br.readLine());
        start = Integer.parseInt(st.nextToken());
        end = Integer.parseInt(st.nextToken());

        // 경로 배열 초기화
        path = new int[cityCnt+1];
        Arrays.fill(path,(int)1e9);

        // 정렬
        for(int n=1; n<=cityCnt; n++)
            Collections.sort(relation.get(n));

        // 최단 경로 구하기
        prePath = new int[cityCnt+1];
        visited = new boolean[cityCnt+1];
        solve();

        // 결과 출력
        ArrayList<Integer> preDist = new ArrayList<>();
        int find = end;
        while(true) {

            // 시작 정점인 경우
            if(find==start) {
                preDist.add(find);
                break;
            }

            // 아닌 경우
            preDist.add(find);
            find = prePath[find];
        }

        StringBuilder sb = new StringBuilder();
        sb.append(path[end]).append("\n").append(preDist.size()).append("\n");
        for(int i=preDist.size()-1; i>=0; i--)
            sb.append(preDist.get(i)).append(" ");

        System.out.println(sb.toString());
    }
}