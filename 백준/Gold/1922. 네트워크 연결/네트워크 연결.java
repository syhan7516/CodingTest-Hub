import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

// 전선 클래스
class Line implements Comparable<Line> {
    int from;
    int to;
    int dist;

    public Line(int from, int to, int dist) {
        this.from = from;
        this.to = to;
        this.dist = dist;
    }

    public int compareTo(Line other) {
        return this.dist-other.dist;
    }
}

public class Main {

    // 컴퓨터 수, 선의 수, 결과
    public static int comCnt, lineCnt, answer;

    // 우선 순위 큐
    public static PriorityQueue<Line> queue;

    // 대표 번호 저장 배열
    public static int parent[];

    // Union
    static void union(int a, int b) {
        a = find(a);
        b = find(b);
        parent[b] = a;
    }

    // Find
    static int find(int com) {

        // 자기 자신과 동일한 경우
        if(com==parent[com])
            return com;

        // 아닌 경우
        return parent[com] = find(parent[com]);
    }

    // 선 연결하기 메서드
    static void solve() {

        // 비용
        int value = 0;

        // 연결 수
        int connect = 1;

        // 선 연결하기
        while(connect!=comCnt) {

            // 선 꺼내기
            Line current = queue.poll();

            // 동일한 집합인지 확인
            if(find(current.from)!=find(current.to)) {

                // 선 연결
                union(current.from, current.to);
                value += current.dist;
                connect++;
            }
        }

        answer = value;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        // 컴퓨터 수 입력
        comCnt = Integer.parseInt(br.readLine());

        // 연결 선 수 입력
        lineCnt = Integer.parseInt(br.readLine());

        // 우선 순위 큐 생성
        queue = new PriorityQueue<>();

        // 관계 정보 입력
        for(int i=0; i<lineCnt; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int dist = Integer.parseInt(st.nextToken());
            queue.offer(new Line(from,to,dist));
        }

        // 대표 번호 배열 초기화
        parent = new int[comCnt+1];
        for(int i=1; i<=comCnt; i++)
            parent[i] = i;

        // 선 연결하기
        answer = 0;
        solve();

        // 결과 출력
        System.out.println(answer);
    }
}