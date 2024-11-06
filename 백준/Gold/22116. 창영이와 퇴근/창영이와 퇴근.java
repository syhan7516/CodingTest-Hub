import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

// 노드 클래스
class Node {
    int y;
    int x;

    public Node(int y, int x) {
        this.y = y;
        this.x = x;
    }
}

public class Main {

    // 결과, 격자 크기
    public static int answer, size;

    // 퇴큰 길
    public static int road[][];

    // 방향 벡터
    public static int dy[] = {0,1,0,-1};
    public static int dx[] = {1,0,-1,0};

    // 퇴근 수행 메서드
    public static boolean searchRoad(int height) {

        // 길 위치 저장 큐 생성
        LinkedList<Node> queue = new LinkedList<>();

        // 방문 여부 배열
        boolean visited[][] = new boolean[size][size];

        // 첫 위치 처리
        visited[0][0] = true;
        queue.add(new Node(0, 0));

        // 탐색 수행
        while (!queue.isEmpty()) {

            // 기준 노드
            Node current = queue.pollFirst();
            int y = current.y;
            int x = current.x;

            // 목적지에 도착한 경우
            if(y==size-1 && x==size-1)
                return true;

            // 네 방향 탐색
            for(int direct=0; direct<4; direct++) {

                // 다음 위치
                int ny = y+dy[direct];
                int nx = x+dx[direct];

                // 범위 확인
                if(ny<0 || ny>size-1 || nx<0 || nx>size-1) continue;

                // 방문 여부 확인
                if(visited[ny][nx]) continue;

                // 높이 확인
                if(Math.abs(road[ny][nx]-road[y][x])>height) continue;

                // 탐색 위치 추가
                visited[ny][nx] = true;
                queue.add(new Node(ny,nx));
            }
        }

        return false;
    }

    // 퇴근 길 확인 메서드
    public static void solve() {

        // 높이 탐색 범위 설정
        int left = 0;
        int right = 1000000000;

        // 탐색
        while(left<=right) {

            // 기준 설정
            int mid = (left+right)/2;

            // 퇴큰 수행
            if(searchRoad(mid)) {
                answer = mid;
                right = mid-1;
            }

            else left = mid+1;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        // 격자 크기 입력
        size = Integer.parseInt(br.readLine());

        // 퇴근 길 생성
        road = new int[size][size];

        // 길 정보 입력
        for(int rowIndex=0; rowIndex<size; rowIndex++) {
            st = new StringTokenizer(br.readLine());
            for(int colIndex=0; colIndex<size; colIndex++) {
                road[rowIndex][colIndex] = Integer.parseInt(st.nextToken());
            }
        }

        // 퇴근 길 확인
        answer = 0;
        solve();

        // 결과 출력
        System.out.println(answer);
    }
}