import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

// 통로 클래스
class Road implements Comparable<Road> {
    int room;
    int distance;

    public Road(int node, int distance) {
        this.room = node;
        this.distance = distance;
    }

    @Override
    public int compareTo(Road other) {
        return this.distance - other.distance;
    }
}

public class Main {

    // 결과 배열
    public static int[] answer;

    // 방 개수, 통로 개수, 친구 수
    public static int roomCount, roadCount, friendCount;

    // 연결 관계 리스트
    public static ArrayList<ArrayList<Road>> relations;

    // 방문 여부 배열
    public static boolean[] visited;

    // 최단 거리 배열, 최소 거리 합 배열, 친구 배열
    public static int[] path, sums, friends;

    // 우선 순위 큐
    public static PriorityQueue<Road> queue;

    // 최단 거리 구하기 메서드
    public static void solve(int room) {

        // 최단 거리 배열 생성
        path = new int[roomCount+1];
        Arrays.fill(path, (int)1e9);

        // 방문 여부 배열 생성
        visited = new boolean[roomCount+1];

        // 우선 순위 큐 생성
        queue = new PriorityQueue<>();

        // 시작 지점 처리
        path[room] = 0;
        queue.offer(new Road(room, 0));

        // 탐색 수행
        while(!queue.isEmpty()) {

            // 현재 위치
            Road road = queue.poll();

            // 이미 방문한 경우
            if(visited[road.room]) continue;

            // 방문 처리
            visited[road.room] = true;

            // 연결 방 확인
            for(int index=0; index<relations.get(road.room).size(); index++) {
                Road connectedRoad = relations.get(road.room).get(index);

                // 이미 방문한 방인 경우
                if(visited[connectedRoad.room]) continue;

                // 최단 거리인 경우
                if(path[connectedRoad.room] > path[road.room] + connectedRoad.distance) {
                    path[connectedRoad.room] = path[road.room] + connectedRoad.distance;
                    queue.offer(new Road(connectedRoad.room, path[connectedRoad.room]));
                }
            }
        }

        // 거리 합 구하기
        for(int index=1; index<=roomCount; index++) {

            // 거리 합하기
            sums[index] += path[index];
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        // 테스트 케이스 수 입력
        int caseCount = Integer.parseInt(br.readLine());

        // 케이스 수행
        for(int caseNum=0; caseNum<caseCount; caseNum++) {

            // 결과 초기화
            answer = new int[]{roomCount+1, (int)1e9};

            // 방, 통로 수 입력
            st = new StringTokenizer(br.readLine());
            roomCount = Integer.parseInt(st.nextToken());
            roadCount = Integer.parseInt(st.nextToken());

            // 연결 관계 리스트 생성
            relations = new ArrayList<>();
            for(int index=0; index<=roomCount; index++) {
                relations.add(new ArrayList<>());
            }

            // 통로 정보 입력
            for(int index=0; index<roadCount; index++) {
                st = new StringTokenizer(br.readLine());
                int from = Integer.parseInt(st.nextToken());
                int to = Integer.parseInt(st.nextToken());
                int distance = Integer.parseInt(st.nextToken());
                relations.get(from).add(new Road(to, distance));
                relations.get(to).add(new Road(from, distance));
            }

            // 최소 거리 합 배열 생성
            sums = new int[roomCount+1];

            // 친구 수 입력
            friendCount = Integer.parseInt(br.readLine());

            // 친구 배열 생성
            friends = new int[friendCount];

            // 친구 정보 입력
            st = new StringTokenizer(br.readLine());
            for(int index=0; index<friendCount; index++) {

                // 최단 거리 구하기
                solve(Integer.parseInt(st.nextToken()));
            }

            // 최소 거리 확인
            for(int index=1; index<=roomCount; index++) {
                if(answer[1] > sums[index]) {
                    answer[0] = index;
                    answer[1] = sums[index];
                }
            }

            // 결과 저장
            sb.append(answer[0]).append("\n");
        }

        // 결과 출력
        System.out.println(sb.toString());
    }
}