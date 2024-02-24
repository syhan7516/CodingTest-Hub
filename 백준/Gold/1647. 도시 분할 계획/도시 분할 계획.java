import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

// 노드 클래스
class Node implements Comparable<Node> {
    int from;
    int to;
    int dist;

    public Node(int from, int to, int dist) {
        this.from = from;
        this.to = to;
        this.dist = dist;
    }

    public int compareTo(Node other) {
        return this.dist-other.dist;
    }
}

public class Main {

    // 집의 수, 길의 수, 결과
    public static int homeCnt, roadCnt, answer;

    // 대표 번호 저장 배열
    public static int parent[];

    // 경로를 짧게 하기 위한 우선 순위 큐
    public static PriorityQueue<Node> queue;

    // union
    static void union(int a, int b) {
        a = find(a);
        b = find(b);
        parent[b] = a;
    }

    // find
    static int find(int num) {
        
        // 대표 번호가 자기 자신일 경우
        if(num==parent[num])
            return num;

        return parent[num] = find(parent[num]);
    }

    // 유지비 구하기 메서드
    static void solve() {

        // 연결된 도시 수
        int cnt = 1;

        // 유지비
        int value = 0;

        // 연결하기
        while(!queue.isEmpty()) {

            // 확인 경로
            Node current = queue.poll();

            // 다른 집합인 경우
            if(find(current.from)!=find(current.to)) {

                // 연결하기
                union(current.from, current.to);

                // 유지비 갱신
                value += current.dist;

                // 집 수 증가
                cnt++;

                // 연결이 완료된 경우
                if(homeCnt-1==cnt) {

                    // 결과 저장
                    answer = value;
                    return;
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        // 집의 수, 길의 수 입력
        st = new StringTokenizer(br.readLine());
        homeCnt = Integer.parseInt(st.nextToken());
        roadCnt = Integer.parseInt(st.nextToken());

        // 대표 번호 저장 배열 생성, 초기화
        parent = new int[homeCnt+1];
        for(int i=1; i<=homeCnt; i++)
            parent[i] = i;

        // 우선 순위 큐 생성
        queue = new PriorityQueue<>();

        // 관계 정보 입력
        for(int i=0; i<roadCnt; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int dist = Integer.parseInt(st.nextToken());
            queue.offer(new Node(from,to,dist));
            queue.offer(new Node(to,from,dist));
        }

        // 유지비 구하기
        answer = 0;
        solve();

        // 결과 출력
        System.out.println(answer);
    }
}