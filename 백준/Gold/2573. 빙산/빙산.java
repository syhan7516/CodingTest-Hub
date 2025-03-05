import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

// 위치 클래스
class Point {
    int y;
    int x;
    int ocean;

    public Point(int y, int x, int ocean) {
        this.y = y;
        this.x = x;
        this.ocean = ocean;
    }
}

public class Main {

    // 결과, 가로, 세로
    public static int answer, rowSize, colSize;

    // 구역
    public static int area[][];

    // 방문 여부 배열
    public static boolean visited[][];

    // 방향 벡터
    public static int dy[] = {0,1,0,-1};
    public static int dx[] = {1,0,-1,0};

    // dfs
    public static void dfs(int row, int col) {

        // 네 방향 탐색
        for(int dir=0; dir<4; dir++) {
            int nextY = row+dy[dir];
            int nextX = col+dx[dir];

            // 범위 확인
            if(nextY<0 || nextY>rowSize-1 || nextX<0 || nextX>colSize-1) continue;

            // 미방문이면서 빙산인 경우
            if(area[nextY][nextX]!=0 && !visited[nextY][nextX]) {
                visited[nextY][nextX] = true;
                dfs(nextY,nextX);
            }
        }
    }

    // 덩어리 개수 확인 메서드
    public static int findCount() {

        // 방문 여부 배열 생성
        visited = new boolean[rowSize][colSize];

        // 덩어리 개수
        int count = 0;

        // 탐색
        for(int rowIndex=0; rowIndex<rowSize; rowIndex++) {
            for(int colIndex=0; colIndex<colSize; colIndex++) {
                if(area[rowIndex][colIndex]!=0 && !visited[rowIndex][colIndex]) {
                    visited[rowIndex][colIndex] = true;
                    dfs(rowIndex,colIndex);
                    count++;
                }
            }
        }

        return count;
    }

    // 빙산 녹이기 메서드
    public static void solve() {

        // 위치 저장 큐 생성
        Queue<Point> queue = new LinkedList<>();

        // 방문 여부 배열 생성
        visited = new boolean[rowSize][colSize];

        // 빙산 확인
        for(int rowIndex=0; rowIndex<rowSize; rowIndex++) {
            for(int colIndex=0; colIndex<colSize; colIndex++) {

                // 빙산이 존재하는 경우
                if(area[rowIndex][colIndex]!=0) {

                    // 탐색 대상
                    queue.offer(new Point(rowIndex,colIndex,0));
                    visited[rowIndex][colIndex] = true;
                }
            }
        }

        // 탐색 수행
        while(!queue.isEmpty()) {

            // 확인 대상
            Point point = queue.poll();

            // 네 방향 확인
            for(int dir=0; dir<4; dir++) {
                int nextY = point.y+dy[dir];
                int nextX = point.x+dx[dir];

                // 범위 확인
                if(nextY>rowSize-1 || nextY<0 || nextX>colSize-1 || nextX<0) continue;

                // 바다 구역인 경우
                if(!visited[nextY][nextX] && area[nextY][nextX]==0) {
                    point.ocean++;
                }
            }

            area[point.y][point.x] = (area[point.y][point.x]-point.ocean)>0 ? area[point.y][point.x]-point.ocean : 0;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        // 가로, 세로 입력
        st = new StringTokenizer(br.readLine());
        rowSize = Integer.parseInt(st.nextToken());
        colSize = Integer.parseInt(st.nextToken());

        // 구역 생성
        area = new int[rowSize][colSize];

        // 빙산 정보 입력
        for(int rowIndex=0; rowIndex<rowSize; rowIndex++) {
            st = new StringTokenizer(br.readLine());
            for(int colIndex=0; colIndex<colSize; colIndex++) {
                area[rowIndex][colIndex] = Integer.parseInt(st.nextToken());
            }
        }

        // 빙산 녹이기
        answer = 0;
        int groupCount = 0;
        while((groupCount = findCount())<2) {
            if(groupCount==0) {
                answer = 0;
                break;
            }

            solve();
            answer++;
        }

        // 결과
        System.out.println(answer);
    }
}