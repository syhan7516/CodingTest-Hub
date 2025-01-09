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

    public Point(int y, int x) {
        this.y = y;
        this.x = x;
    }
}

public class Main {

    // 가로, 세로 크기, 치즈 개수, 시간, 직전 치즈 개수
    public static int rowSize, colSize, cheeseCount, time, beforeCheeseCount;

    // 공간 배열
    public static int area[][];

    // 방문 여부 배열
    public static boolean visited[][];

    // 방향 벡터
    public static int dy[] = {0,1,0,-1};
    public static int dx[] = {1,0,-1,0};

    // 탐색 메서드 수행
    public static void search() {

        // 방문 여부 배열 생성
        visited = new boolean[rowSize][colSize];

        // 위치 탐색 큐 생성
        Queue<Point> queue = new LinkedList<Point>();

        // 시작점 처리
        visited[0][0] = true;
        queue.offer(new Point(0,0));

        // 탐색
        while(!queue.isEmpty()) {

            // 현재 위치
            Point point = queue.poll();

            // 방향 확인
            for(int dir=0; dir<4; dir++) {

                int nextY = point.y+dy[dir];
                int nextX = point.x+dx[dir];

                // 범위 확인
                if(nextY<0 || nextX<0 || nextY>rowSize-1 || nextX>colSize-1) continue;

                // 이미 방문한 경우
                if(visited[nextY][nextX]) continue;

                // 0인 경우
                if(area[nextY][nextX]==0) {
                    visited[nextY][nextX] = true;
                    queue.offer(new Point(nextY,nextX));
                }

                // 1인 경우
                else {
                    area[nextY][nextX] = 0;
                    visited[nextY][nextX] = true;
                    cheeseCount--;
                }
            }
        }

    }

    // 작업 수행 메서드
    public static void solve() {

        // 시간
        time = 0;


        // 치즈가 없을 때 까지 수행
        while(cheeseCount!=0) {

            // 직전 치즈 개수
            beforeCheeseCount = cheeseCount;

            // 탐색
            search();

            // 시간 증가
            time++;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        // 가로, 세로 크기 입력
        st = new StringTokenizer(br.readLine());
        rowSize = Integer.parseInt(st.nextToken());
        colSize = Integer.parseInt(st.nextToken());

        // 공간 배열 생성
        area = new int[rowSize][colSize];

        // 공간 정보 입력
        for(int rowIndex=0; rowIndex<rowSize; rowIndex++) {
            st = new StringTokenizer(br.readLine());
            for(int colIndex=0; colIndex<colSize; colIndex++) {
                area[rowIndex][colIndex] = Integer.parseInt(st.nextToken());
                if(area[rowIndex][colIndex]==1) cheeseCount++;
            }
        }

        // 작업 수행
        solve();

        // 결과
        System.out.println(time+"\n"+beforeCheeseCount);
    }
}