import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

// 친구 클래스
class Friend {
    int num;
    int y;
    int x;
    int version;
    int hasImage;

    public Friend(int num, int y, int x, int version, int hasImage) {
        this.num = num;
        this.y = y;
        this.x = x;
        this.version = version;
        this.hasImage = hasImage;
    }
}

public class Main {

    // 친구 수, 최대 거리, 버전 차이
    public static int friendCount, maxDistance, differenceInVersions;

    // 푸앙이 위치, 푸앙이 버전
    public static int puangY, puangX, puangVersion;

    // 친구 저장 배열
    public static Friend[] friends;

    // 방문 여부 배열
    public static boolean[] visited;

    // 결과 리스트
    public static ArrayList<Integer> answer;

    // 탐색 메서드
    public static void solve() {

        // 결과 리스트 생성
        answer = new ArrayList<>();

        // 위치 저장 큐 생성
        Queue<Friend> queue = new LinkedList<>();

        // 푸앙이 위치 처리
        queue.offer(new Friend(0, puangY, puangX, puangVersion, 0));

        // 탐색 수행
        while(!queue.isEmpty()) {

            // 확인 친구
            Friend friend = queue.poll();

            // 에어드롭 가능한 친구 확인
            for(int index=1; index<=friendCount; index++) {

                // 이미 방문한 경우
                if(visited[index]) continue;

                // 연결 친구
                Friend connectedFriend = friends[index];

                // 현재 친구와의 거리, 버전 차이
                double distance = Math.sqrt(Math.pow(friend.y-connectedFriend.y,2) + Math.pow(friend.x-connectedFriend.x,2));
                int version = Math.abs(friend.version - connectedFriend.version);

                // √((x₂ - x₁)² + (y₂ - y₁)² )

                // 거리가 먼 경우
                if(distance > maxDistance) continue;

                // 버전 차이가 큰 경우
                if(version > differenceInVersions) continue;

                // 사진이 존재하면 결과에 추가
                if(connectedFriend.hasImage == 1) {
                    answer.add(connectedFriend.num);
                }

                // 에어드롭 수행
                visited[connectedFriend.num] = true;
                queue.offer(connectedFriend);
            }
        }
    }

    // 결과 저장 메서드
    public static String saveResult() {
        StringBuilder sb = new StringBuilder();

        if(answer.isEmpty()) {
            return "0";
        }

        for(int friend: answer) {
            sb.append(friend).append(" ");
        }

        return sb.toString();
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        // 친구 수, 최대 거리, 버전 차이 입력
        st = new StringTokenizer(br.readLine());
        friendCount = Integer.parseInt(st.nextToken());
        maxDistance = Integer.parseInt(st.nextToken());
        differenceInVersions = Integer.parseInt(st.nextToken());

        // 푸앙이 정보 입력
        st = new StringTokenizer(br.readLine());
        puangY = Integer.parseInt(st.nextToken());
        puangX = Integer.parseInt(st.nextToken());
        puangVersion = Integer.parseInt(st.nextToken());

        // 친구 저장 배열, 방문 여부 배열 생성
        friends = new Friend[friendCount+1];
        visited = new boolean[friendCount+1];

        // 친구 정보 입력
        for(int friend=1; friend<=friendCount; friend++) {
            st = new StringTokenizer(br.readLine());
            int y = Integer.parseInt(st.nextToken());
            int x = Integer.parseInt(st.nextToken());
            int version = Integer.parseInt(st.nextToken());
            int hasImage = Integer.parseInt(st.nextToken());
            friends[friend] = new Friend(friend, y, x, version, hasImage);
        }

        // 탐색
        solve();

        // 결과 리스트 정렬
        Collections.sort(answer);

        // 결과 출력
        System.out.println(saveResult());
    }
}