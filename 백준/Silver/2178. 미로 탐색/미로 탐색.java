import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Node {
    private int y;
    private int x;

    public Node(int y, int x) {
        this.y = y;
        this.x = x;
    }

    public int getX() {
        return this.x;
    }

    public int getY() {
        return this.y;
    }
}

public class Main {
    // 결과
    public static int result;
    // 미로 가로, 세로
    public static int row, col;
    // 미로
    public static int miro[][];
    // 방문 테이블
    public static boolean visited[][];
    // 방향 설정
    public static int dx[] = {1,0,-1,0};
    public static int dy[] = {0,1,0,-1};

    // bfs
    static void bfs(int a, int b) {
        // 노드 저장 큐
        Queue<Node> queue = new LinkedList<>();
        // 시작 노드 입력
        queue.offer(new Node(a,b));
        // 방문 처리
        visited[a][b] = true;

        // 모든 노드 탐색할 때까지
        while(!queue.isEmpty()) {
            // 확인 노드
            Node node = queue.poll();
            // 연결된 노드 확인
            for(int dir=0; dir<4; dir++) {
                // 이동 가능한지 확인
                int nextX = node.getX() + dx[dir];
                int nextY = node.getY() + dy[dir];
                if(nextX < 1 || nextX > col || nextY < 1 || nextY > row || visited[nextY][nextX] == true || miro[nextY][nextX] ==0)
                    continue;

                miro[nextY][nextX] = miro[node.getY()][node.getX()]+1;
                queue.offer(new Node(nextY,nextX));
                visited[nextY][nextX] = true;
            }
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        // 가로, 세로 입력
        row = Integer.parseInt(st.nextToken());
        col = Integer.parseInt(st.nextToken());

        // 미로 & 방문 테이블 만들기
        miro = new int[row+1][col+1];
        visited = new boolean[row+1][col+1];

        for(int r=1; r<=row; r++) {
            Arrays.fill(visited[r],false);
            st = new StringTokenizer(br.readLine());
            String letters[] = st.nextToken().split("");
            for(int c=1; c<=col; c++) {
                miro[r][c] = Integer.parseInt(letters[c-1]);
            }
        }

        // 미로 탐색
        bfs(1,1);

        // 결과 출력
        System.out.println(miro[row][col]);
    }
}