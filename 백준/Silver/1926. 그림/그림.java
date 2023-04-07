import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class PaperNode {
    private int y;
    private int x;

    public PaperNode(int y, int x) {
        this.y = y;
        this.x = x;
    }

    public int getY() {
        return this.y;
    }

    public int getX() {
        return this.x;
    }
}

public class Main {

    // 가로, 세로
    public static int rowLen, colLen;
    // 도화지
    public static int paper[][];
    // 가장 넓은 그림 넓이, 그림 개수
    public static int result, cnt;
    // 방문 여부 배열
    public static boolean visited[][];

    // 방향 벡터
    public static int dx[] = {1,0,-1,0};
    public static int dy[] = {0,1,0,-1};

    // bfs 함수 정의
    static void bfs(int row, int col) {
        int area = 0;
        Queue<PaperNode> nodes = new LinkedList<>();
        nodes.offer(new PaperNode(row,col));
        visited[row][col] = true;

        // 빌 때까지 수행
        while(!nodes.isEmpty()) {
            PaperNode curNode = nodes.poll();
            area += 1;
            int curY = curNode.getY();
            int curX = curNode.getX();
            for(int dir=0; dir<4; dir++) {
                int nextY = curY+dy[dir];
                int nextX = curX+dx[dir];

                // 이동 방향 제한
                if(nextY<0 || nextY>rowLen-1 || nextX<0 || nextX>colLen-1 || paper[nextY][nextX]!=1 || visited[nextY][nextX])
                    continue;

                // 탐색 가능한 경우
                nodes.offer(new PaperNode(nextY,nextX));
                visited[nextY][nextX] = true;
            }
        }

        // 가장 넓은 그림 저장
        result = Math.max(result,area);
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        // 가로, 세로 입력
        rowLen = Integer.parseInt(st.nextToken());
        colLen = Integer.parseInt(st.nextToken());

        // 도화지 생성
        paper = new int[rowLen][colLen];
        visited = new boolean[rowLen][colLen];

        // 그림 정보 입력
        for(int a=0; a<rowLen; a++) {
            st = new StringTokenizer(br.readLine());
            for(int b=0; b<colLen; b++) {
                paper[a][b] = Integer.parseInt(st.nextToken());
            }
        }

        // 그림 크기 확인
        cnt = 0;
        result = 0;
        for(int a=0; a<rowLen; a++) {
            for(int b=0; b<colLen; b++) {
                // 그림인 부분 확인
                if(paper[a][b]==1 && !visited[a][b]) {
                    bfs(a,b);
                    cnt += 1;
                }
            }
        }

        // 결과 출력
        System.out.println(cnt);
        System.out.println(result);
    }
}