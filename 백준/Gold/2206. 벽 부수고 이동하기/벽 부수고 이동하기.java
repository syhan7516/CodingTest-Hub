import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

// 노드 클래스
class Node {
    int y;
    int x;
    int wall;
    int dist;

    public Node(int y, int x, int wall, int dist) {
        this.y = y;
        this.x = x;
        this.wall = wall;
        this.dist = dist;
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

    // 이동하기 메서드
    static void solve() {

        // 경로 저장 큐 생성
        Queue<Node> queue = new LinkedList<>();

        // 첫 노드 처리
        visited[0][0][0] = true;
        queue.offer(new Node(0,0,0,1));

        // 이동하기
        while(!queue.isEmpty()) {

            // 현재 노드
            Node current = queue.poll();

            // 목적지에 도착한 경우
            if(current.y==rowSize-1 && current.x==colSize-1) {
                answer = current.dist;
                return;
            }

            // 네 방향 탐색
            for(int d=0; d<4; d++) {
                int ny = current.y+dy[d];
                int nx = current.x+dx[d];

                // 범위 확인
                if(ny<0 || ny>rowSize-1 || nx<0 || nx>colSize-1) continue;

                // 벽인 경우
                if(map[ny][nx]==1) {

                    // 벽 부순적이 없으면서 방문하지 않은 경우
                    if(current.wall==0 && !visited[1][ny][nx]) {
                        visited[1][ny][nx] = true;
                        queue.offer(new Node(ny,nx,1, current.dist+1));
                    }
                }

                // 벽이 아닌 경우
                else {
                    
                    // 방문하지 않은 경우
                    if(!visited[current.wall][ny][nx]) {
                        visited[current.wall][ny][nx] = true;
                        queue.offer(new Node(ny,nx,current.wall,current.dist+1));
                    }
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        // 가로, 세로 입력
        st = new StringTokenizer(br.readLine());
        rowSize = Integer.parseInt(st.nextToken());
        colSize = Integer.parseInt(st.nextToken());

        // 맵 생성
        map = new int[rowSize][colSize];

        // 맵 정보 입력
        for(int i=0; i<rowSize; i++) {
            String line = br.readLine();
            for(int j=0; j<colSize; j++) {
                map[i][j] = line.charAt(j)-'0';
            }
        }
        
        // 이동하기
        visited = new boolean[2][rowSize][colSize];
        answer = -1;
        solve();
        
        // 결과 출력
        System.out.println(answer);
    }
}
