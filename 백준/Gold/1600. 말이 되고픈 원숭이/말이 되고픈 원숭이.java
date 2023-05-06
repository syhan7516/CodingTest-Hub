
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

// 노드 클래스
class TripNode {
    private int y;
    private int x;
    private int count;
    private int hCnt;

    public TripNode(int y, int x, int count, int hCnt) {
        this.y = y;
        this.x = x;
        this.count = count;
        this.hCnt = hCnt;
    }

    public int getY() {
        return this.y;
    }

    public int getX() {
        return this.x;
    }

    public int getCount() {
        return this.count;
    }

    public int gethCnt() {
        return this.hCnt;
    }
}

public class Main {

    // 말처럼 이동 가능한 횟수
    public static int horseCnt;
    // 지도 가로, 세로 크기, 결과
    public static int colSize, rowSize, result;
    // 지도
    public static int graph[][];
    // 방문 여부 배열
    public static boolean visited[][][];
    // 방향 벡터
    public static int hDy[] = {-1, 1, -2, 2, -2, 2, -1, 1};
    public static int hDx[] = {-2, -2, -1, -1, 1, 1, 2, 2};
    public static int dy[] = {1, 0, -1, 0};
    public static int dx[] = {0, 1, 0 ,-1};
    // 경로 저장 큐
    public static Queue<TripNode> nodes;

    // 여행 출발 함수
    static void bfs() {
        nodes = new LinkedList<>();

        // 출발 노드 처리
        nodes.offer(new TripNode(0,0,0,horseCnt));
        visited[0][0][horseCnt] = true;

        // 그 외 노드 처리
        while(!nodes.isEmpty()) {

            // 현재 노드
            TripNode curNode = nodes.poll();
            int curY = curNode.getY();
            int curX = curNode.getX();
            int curCount = curNode.getCount();
            int curHorseCnt = curNode.gethCnt();

            // 목적지인 경우
            if(curY==rowSize-1 && curX==colSize-1) {
                result = curCount;
                return;
            }

            // 일반적인 움직임
            for(int dir=0; dir<4; dir++) {
                int nextX = curX+dx[dir];
                int nextY = curY+dy[dir];
                if(nextY>=0 && nextY<rowSize && nextX>=0 && nextX<colSize && !visited[nextY][nextX][curHorseCnt] && graph[nextY][nextX]==0) {
                    visited[nextY][nextX][curHorseCnt] = true;
                    nodes.offer(new TripNode(nextY,nextX,curCount+1,curHorseCnt));
                }
            }

            // 말 움직임
            if(curHorseCnt>0) {
                for(int dir=0; dir<8; dir++) {
                    int nextX = curX+hDx[dir];
                    int nextY = curY+hDy[dir];
                    if(nextY>=0 && nextY<rowSize && nextX>=0 && nextX<colSize && !visited[nextY][nextX][curHorseCnt-1] && graph[nextY][nextX]==0) {
                        visited[nextY][nextX][curHorseCnt-1] = true;
                        nodes.offer(new TripNode(nextY,nextX,curCount+1,curHorseCnt-1));
                    }
                }
            }
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        // 말처럼 이동 가능한 횟수 입력
        horseCnt = Integer.parseInt(br.readLine());

        // 지도 크기 입력
        st = new StringTokenizer(br.readLine());
        colSize = Integer.parseInt(st.nextToken());
        rowSize = Integer.parseInt(st.nextToken());

        // 지도 만들기
        graph = new int[rowSize][colSize];

        // 지도 정보 입력
        for(int r=0; r<rowSize; r++) {
            st = new StringTokenizer(br.readLine());
            for(int c=0; c<colSize; c++) {
                graph[r][c] = Integer.parseInt(st.nextToken());
            }
        }

        // 여행 출발
        visited = new boolean[rowSize][colSize][horseCnt+1];
        result = Integer.MIN_VALUE;
        bfs();

        // 결과 출력
        if(result==Integer.MIN_VALUE)
            System.out.println(-1);
        else
            System.out.println(result);
    }
}