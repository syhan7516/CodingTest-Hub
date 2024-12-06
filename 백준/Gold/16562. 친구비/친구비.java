import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

// 관계 클래스
class Edge implements Comparable<Edge> {
    int friend;
    int value;

    public Edge(int friend, int value) {
        this.friend = friend;
        this.value = value;
    }

    public int compareTo(Edge other) {
        return this.value - other.value;
    }
}

public class Main {

    // 결과, 학생 수, 관계 수, 예산
    public static int answer, studentCount, relationCount, totalMoney;

    // 관계 정보 리스트
    public static ArrayList<ArrayList<Edge>> relations;

    // 친구비 배열
    public static int money[];

    // 방문 여부 배열
    public static boolean visited[];

    // 관계 우선 순위 큐
    public static PriorityQueue<Edge> queue;

    // 정산하기 메서드
    public static void solve() {

        // 친구 확인
        while(!queue.isEmpty()) {

            // 확인 관계
            Edge currentEdge = queue.poll();
            int currentFriend = currentEdge.friend;
            int currentValue = currentEdge.value;

            // 이미 친구인 경우
            if(visited[currentFriend]) continue;

            // 친구하기
            visited[currentFriend] = true;

            // 비용 입금
            answer += currentValue;

            // 친구의 친구 확인
            for(int relation=0; relation<relations.get(currentFriend).size(); relation++) {
                Edge connectEdge = relations.get(currentFriend).get(relation);
                queue.offer(new Edge(connectEdge.friend,0));
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        // 학생 수, 관계 수, 예산 입력
        st = new StringTokenizer(br.readLine());
        studentCount = Integer.parseInt(st.nextToken());
        relationCount = Integer.parseInt(st.nextToken());
        totalMoney = Integer.parseInt(st.nextToken());

        // 관계 정보 리스트 생성, 초기화
        relations = new ArrayList<>();
        for(int relation=0; relation<=studentCount; relation++)
            relations.add(new ArrayList<>());

        // 친구비 배열 생성, 초기화
        money = new int[studentCount+1];
        st = new StringTokenizer(br.readLine());
        for(int m=1; m<=studentCount; m++)
            money[m] = Integer.parseInt(st.nextToken());

        // 관계 우선 순위 큐 생성
        queue = new PriorityQueue<>();

        // 관계 정보 입력
        for(int relation=0; relation<relationCount; relation++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            Edge fromTo = new Edge(to,money[from]);
            Edge toFrom = new Edge(from,money[to]);
            relations.get(from).add(fromTo);
            relations.get(to).add(toFrom);
            queue.offer(fromTo);
            queue.offer(toFrom);
        }

        // 방문 여부 배열 생성
        visited = new boolean[studentCount+1];

        // 정산하기
        answer = 0;
        solve();

        // 남은 친구 확인
        for(int friend=1; friend<=studentCount; friend++) {

            // 친구가 아닌 경우
            if(!visited[friend]) {
                queue.offer(new Edge(friend,money[friend]));
                solve();
            }
        }

        // 결과 출력
        if(answer<=totalMoney) System.out.println(answer);
        else System.out.println("Oh no");
    }
}