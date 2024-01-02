import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

// 노드 클래스
class Node {
    int to;
    int w;

    public Node(int to, int w) {
        this.to = to;
        this.w = w;
    }
}

public class Main {

    // 도시 개수, 버스 개수, 출발점, 도착점
    public static int cityCnt, busCnt, start, end;

    // 최단 거리 배열
    public static int path[];

    // 연결 관계 리스트
    public static ArrayList<ArrayList<Node>> graph;

    // 최단 거리 구하기 메서드
    static void solve() {

        // 도시 방문 여부 배열 생성
        boolean visited[] = new boolean[cityCnt+1];

        // 출발점 처리
        path[start] = 0;

        // 모든 노드 확인
        int cnt = 0;
        while(cnt!=cityCnt) {

            int min = (int)1e9;
            int current = -1;

            for(int i=1; i<=cityCnt; i++) {

                // 미방문이면서 최소인 경우
                if(!visited[i] && min>path[i]) {
                    min = path[i];
                    current = i;
                }
            }

            // 만약 없는 경우
            if(current==-1) return;

            // 도착점에 대한 최단 거리를 구한 경우
            if(current==end) return;

            // 방문 처리
            visited[current] = true;

            // 아닌 경우
            for(int i=0; i<graph.get(current).size(); i++) {
                Node connectNode = graph.get(current).get(i);
                path[connectNode.to] = Math.min(path[connectNode.to], path[current]+ connectNode.w);
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        // 도시 개수 입력
        cityCnt = Integer.parseInt(br.readLine());

        // 버스 개수 입력
        busCnt = Integer.parseInt(br.readLine());

        // 연결 관계 리스트 생성
        graph = new ArrayList<>();
        for(int i=0; i<=cityCnt; i++)
            graph.add(new ArrayList<>());

        // 최단 거리 배열 생성
        path = new int[cityCnt+1];
        Arrays.fill(path,(int)1e9);

        // 버스 정보 입력
        for(int i=0; i<busCnt; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            graph.get(from).add(new Node(to,w));
        }

        // 출발점, 도착점 입력
        st = new StringTokenizer(br.readLine());
        start = Integer.parseInt(st.nextToken());
        end = Integer.parseInt(st.nextToken());

        // 최단 거리 구하기
        solve();

        // 결과 출력
        System.out.println(path[end]);
    }
}