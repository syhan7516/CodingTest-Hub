import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

// 다리 클래스
class Bridge implements Comparable<Bridge> {
    int from;
    int to;
    int weight;

    public Bridge(int from, int to, int weight) {
        this.from = from;
        this.to = to;
        this.weight = weight;
    }

    @Override
    public int compareTo(Bridge other) {
        return other.weight - this.weight;
    }
}

public class Main {

    // 결과, 집 개수, 다리 수, 시작 지점, 도착 지점
    public static int answer, houseCount, bridgeCount, start, end;

    // 연결 정보 리스트
    public static ArrayList<ArrayList<Bridge>> relations;

    // 우선 순위 큐
    public static PriorityQueue<Bridge> queue;

    // 그룹 배열
    public static int[] groups;

    // find
    public static int find(int house) {
        if(groups[house] == house) {
            return house;
        }

        return groups[house] = find(groups[house]);
    }

    // union
    public static void union(int a, int b) {
        a = find(a);
        b = find(b);

        if(a < b) groups[b] = a;
        else groups[a] = b;
    }

    // 탐색 메서드
    public static void solve() {

        // 탐색
        while(!queue.isEmpty()) {
            Bridge bridge = queue.poll();

            // 경로에 추가
            union(bridge.from, bridge.to);

            // 도착 지점과 연결된 경우
            if(find(start) == find(end)) {
                answer = bridge.weight;
                return;
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        // 집 개수, 다리 수 입력
        st = new StringTokenizer(br.readLine());
        houseCount = Integer.parseInt(st.nextToken());
        bridgeCount = Integer.parseInt(st.nextToken());

        // 시작 지점, 도착 지점 입력
        st = new StringTokenizer(br.readLine());
        start = Integer.parseInt(st.nextToken());
        end = Integer.parseInt(st.nextToken());

        // 연결 정보 리스트 생성
        relations = new ArrayList<>();
        for(int index=0; index<=houseCount; index++) {
            relations.add(new ArrayList<>());
        }

        // 우선 순위 큐 생성
        queue = new PriorityQueue<>();

        // 다리 정보 입력
        for(int index=0; index<bridgeCount; index++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());
            queue.offer(new Bridge(from, to, weight));
        }

        // 그룹 배열 생성
        groups = new int[houseCount+1];
        for(int index=1; index<=houseCount; index++) {
            groups[index] = index;
        }

        // 탐색
        solve();

        // 결과 출력
        System.out.println(answer);
    }
}