import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

// 플로우 클래스
class Flow implements Comparable<Flow> {
    int from;
    int to;
    int value;

    public Flow(int from, int to, int value) {
        this.from = from;
        this.to = to;
        this.value = value;
    }

    @Override
    public int compareTo(Flow other) {
        return this.value - other.value;
    }
}

public class Main {

    // 결과
    public static long answer;

    // 행성 개수
    public static int planetCount;

    // 플로우 비용 기준 우선 순위 큐
    public static PriorityQueue<Flow> queue;

    // 집합 배열
    public static int[] parent;

    // find
    public static int find(int planet) {

        if(planet==parent[planet]) {
            return planet;
        }

        return parent[planet] = find(parent[planet]);
    }

    // union
    public static void union(int a, int b) {

        a = find(a);
        b = find(b);

        if(a>b) parent[b] = a;
        else parent[a] = b;
    }

    // 플로우 연결 메서드
    public static void solve() {
        
        // 행성이 하나인 경우
        if(planetCount==1) {
            answer = 0;
            return;
        }

        // 시작 처리
        int connectFlowCount = 1;
        Flow flow = queue.poll();
        union(flow.from,flow.to);
        answer += flow.value;

        // 플로우 확인
        while(!queue.isEmpty() && connectFlowCount<planetCount-1) {

            // 확인 플로우
            flow = queue.poll();

            // 동일한 경우 (이미 연결된 상태)
            if(find(flow.from)==find(flow.to)) continue;

            // 플로우 연결
            union(flow.from,flow.to);
            connectFlowCount++;
            
            // 연결 비용 갱신
            answer += flow.value;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        // 행성 수 입력
        planetCount = Integer.parseInt(br.readLine());

        // 집합 배열 생성
        parent = new int[planetCount+1];
        for(int planetIndex=0; planetIndex<parent.length; planetIndex++) {
            parent[planetIndex] = planetIndex;
        }

        // 우선 순위 큐 생성
        queue = new PriorityQueue<>();

        // 플로우 정보 확인
        for(int rowIndex=1; rowIndex<=planetCount; rowIndex++) {
            st = new StringTokenizer(br.readLine());
            for(int colIndex=1; colIndex<=planetCount; colIndex++) {
                int value = Integer.parseInt(st.nextToken());
                if(rowIndex==colIndex) continue;
                queue.offer(new Flow(rowIndex,colIndex,value));
            }
        }

        // 플로우 연결
        solve();

        // 결과 출력
        System.out.println(answer);
    }
}