import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

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

    // 도시 수, 도로 수, 목적지, 결과
    public static int cityCnt, roadCnt, destination, answer;

    // 연결 관계 리스트
    public static ArrayList<ArrayList<Edge>> relation;
    public static ArrayList<ArrayList<Edge>> reverseRelation;

    // 최단 거리 배열
    public static int path[];
    public static int reversePath[];

    // 파티 메서드
    static void party(ArrayList<ArrayList<Edge>> roadRelation, int roadPath[]) {

        // 최단 거리를 위한 우선 순위 큐 생성
        PriorityQueue<Edge> queue = new PriorityQueue<>();

        // 첫 노드 처리
        roadPath[destination] = 0;
        queue.offer(new Edge(destination,roadPath[destination]));

        // 최단 거리 구하기
        while(!queue.isEmpty()) {

            // 현재 위치
            Edge current = queue.poll();

            // 연결된 도로 확인
            for(int r=0; r<roadRelation.get(current.to).size(); r++) {

                Edge connect = roadRelation.get(current.to).get(r);

                // 확인한 거리가 더 짧은 경우
                if(roadPath[connect.to]>roadPath[current.to]+connect.dist) {
                    roadPath[connect.to] = roadPath[current.to]+connect.dist;
                    queue.offer(new Edge(connect.to,roadPath[connect.to]));
                }
            }
        }
    }

    // 파티 열기 메서드
    static int solve() {

        // 파티 가기
        party(reverseRelation,reversePath);

        // 집에 오기
        party(relation,path);

        // 왕복 거리가 가장 긴 학생 구하기
        int maxDist = 0;
        for(int i=1; i<=cityCnt; i++)
            maxDist = Math.max(maxDist,path[i]+reversePath[i]);

        return maxDist;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        // 도시 수, 도로 수 입력
        st = new StringTokenizer(br.readLine());
        cityCnt = Integer.parseInt(st.nextToken());
        roadCnt = Integer.parseInt(st.nextToken());
        destination = Integer.parseInt(st.nextToken());

        // 관계 리스트 생성, 초기화
        relation = new ArrayList<>();
        reverseRelation = new ArrayList<>();
        for(int i=0; i<=cityCnt; i++) {
            relation.add(new ArrayList<>());
            reverseRelation.add(new ArrayList<>());
        }

        // 최단 거리 배열 생성, 초기화
        path = new int[cityCnt+1];
        reversePath = new int[cityCnt+1];
        Arrays.fill(path,(int)1e9);
        Arrays.fill(reversePath,(int)1e9);

        // 도로 정보 입력
        for(int i=0; i<roadCnt; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int value = Integer.parseInt(st.nextToken());
            relation.get(from).add(new Edge(to,value));
            reverseRelation.get(to).add(new Edge(from,value));
        }

        // 파티 열기
        answer = solve();

        // 결과 출력
        System.out.println(answer);
    }
}