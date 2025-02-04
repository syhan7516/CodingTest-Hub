import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

// 선 클래스
class Line implements Comparable<Line> {
    int start;
    int end;
    int value;

    public Line(int start, int end, int value) {
        this.start = start;
        this.end = end;
        this.value = value;
    }


    @Override
    public int compareTo(Line other) {
        return this.value - other.value;
    }
}

public class Main {

    // 결과, 컴퓨터 개수, 선 개수
    public static int answer, comCount, lineCount;

    // 집합 배열
    public static int parent[];

    // 비용 기준 우선 순위 큐
    public static PriorityQueue<Line> queue;

    // find
    public static int find(int node) {

        if(parent[node]==node)
            return node;

        return parent[node] = find(parent[node]);
    }

    // union
    public static void union(int node1, int node2) {

        node1 = find(node1);
        node2 = find(node2);

        if(node1>node2) parent[node1] = node2;
        else parent[node2] = node1;
    }

    // 최소 비용 찾기 메서드
    public static void solve() {

        // 현재 선 연결 개수
        int connectCount = 1;

        // 선 정보 확인
        while(!queue.isEmpty()) {

            // 확인 선
            Line line = queue.poll();

            // 순환 여부 확인
            if(find(line.start)==find(line.end)) continue;

            // 연결
            union(line.start,line.end);

            // 연결 개수 증가
            connectCount++;
            answer += line.value;

            // 모두 연결한 경우
            if(connectCount==comCount)
                return;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        // 컴퓨터 개수, 선 개수 입력
        comCount = Integer.parseInt(br.readLine());
        lineCount = Integer.parseInt(br.readLine());

        // 비용 기준 우선 순위 큐 생성
        queue = new PriorityQueue<>();

        // 집합 배열 생성 및 초기화
        parent = new int[comCount+1];
        for(int index=0; index<=comCount; index++) {
            parent[index] = index;
        }

        // 선 정보 입력
        for(int index=0; index<lineCount; index++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int value = Integer.parseInt(st.nextToken());
            queue.offer(new Line(start,end,value));
        }

        // 최소 비용 찾기
        answer = 0;
        solve();

        // 결과 출력
        System.out.println(answer);
    }
}