import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

// 상황 클래스
class Status implements Comparable<Status> {
    int y;
    int x;
    int wall;

    public Status(int y, int x, int wall) {
        this.y = y;
        this.x = x;
        this.wall = wall;
    }

    public int compareTo(Status other) {
        return this.wall-other.wall;
    }
}

public class Main {

    // 가로, 세로, 결과
    public static int rowSize, colSize, answer;

    // 맵
    public static int map[][];

    // 방문 여부 배열
    public static boolean visited[][][];

    // 네 방향 벡터
    public static int dy[] = {0,1,0,-1};
    public static int dx[] = {1,0,-1,0};

    // 미로 탈출하기 메서드
    static void solve() {

        // 상황을 담을 우선 순위 큐 생성
        PriorityQueue<Status> queue = new PriorityQueue<>();

        // 첫 노드 처리
        visited[0][0][0] = true;
        queue.offer(new Status(0,0,0));

        // 미로 탐색 수행
        while(!queue.isEmpty()) {

            // 현재 상황
            Status current = queue.poll();

            // 목적지인 경우
            if(current.y==rowSize-1 && current.x==colSize-1) {
                answer = current.wall;
                return;
            }

            // 네 방향 확인
            for(int d=0; d<4; d++) {
                int ny = current.y+dy[d];
                int nx = current.x+dx[d];

                // 범위 확인
                if(ny<0 || ny>rowSize-1 || nx<0 || nx>colSize-1) continue;

                // 벽인 경우
                if(map[ny][nx]==1) {
                    if(visited[current.wall+1][ny][nx]) continue;
                    visited[current.wall+1][ny][nx] = true;
                    queue.offer(new Status(ny,nx, current.wall+1));
                }

                // 벽이 아닌 경우
                else {
                    if(visited[current.wall][ny][nx]) continue;
                    visited[current.wall][ny][nx] = true;
                    queue.offer(new Status(ny,nx, current.wall));
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        // 가로, 세로 크기 입력
        st = new StringTokenizer(br.readLine());
        colSize = Integer.parseInt(st.nextToken());
        rowSize = Integer.parseInt(st.nextToken());

        // 맵 생성
        map = new int[rowSize][colSize];

        // 맵 정보 입력
        for(int i=0; i<rowSize; i++) {
            String line = br.readLine();
            for(int j=0; j<colSize; j++) {
                map[i][j] = line.charAt(j)-'0';
            }
        }

        // 미로 탈출하기
        visited = new boolean[rowSize*colSize][rowSize][colSize];
        answer = 0;
        solve();

        // 결과
        System.out.println(answer);
    }
}