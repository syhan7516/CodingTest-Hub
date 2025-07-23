import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

// 방 클래스
class Room {
    int node;
    int value;

    public Room(int node, int value) {
        this.node = node;
        this.value = value;
    }
}

public class Main {

    // 결과
    public static long answer;

    // 방 개수
    public static int roomCount;

    // 연결 관계 리스트
    public static ArrayList<ArrayList<Room>> relations;

    // 방문 여부 배열
    public static boolean[] visited;

    // 가장 먼 방 탐색하기 메서드
    public static void solve(int room, long value) {

        // 거리 갱신
        answer = Math.max(answer, value);

        // 탐색
        for(int index=0; index<relations.get(room).size(); index++) {

            // 연결된 방
            Room connectedRoom = relations.get(room).get(index);

            // 이미 방문한 경우
            if(visited[connectedRoom.node]) continue;

            // 아닌 경우
            visited[connectedRoom.node] = true;
            solve(connectedRoom.node,value+connectedRoom.value);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        // 방 개수 입력
        roomCount = Integer.parseInt(br.readLine());

        // 연결 관계 리스트 생성 및 초기화
        relations = new ArrayList<>();
        for(int index=0; index<=roomCount; index++) {
            relations.add(new ArrayList<>());
        }

        // 연결 관계 입력
        for(int index=0; index<roomCount-1; index++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int value = Integer.parseInt(st.nextToken());
            relations.get(from).add(new Room(to, value));
            relations.get(to).add(new Room(from, value));
        }

        // 방문 여부 배열 생성
        visited = new boolean[roomCount+1];

        // 가장 먼 방 탐색하기
        visited[1] = true;
        solve(1,0);

        // 결과 출력
        System.out.println(answer);
    }
}