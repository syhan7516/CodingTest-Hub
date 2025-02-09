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
    int value;

    public Point(int y, int x, int value) {
        this.y = y;
        this.x = x;
        this.value = value;
    }
}

public class Main {

    // 가로, 세로 크기, 시작 지점
    public static int rowSize, colSize, startY, startX;

    // 격자 배열
    public static int map[][];

    // 방문 여부 배열
    public static boolean visited[][];

    // 방향 벡터
    public static int dy[] = {0,1,0,-1};
    public static int dx[] = {1,0,-1,0};

    // 거리 구하기 메서드
    public static void solve() {

        // 위치 저장 큐 생성
        Queue<Point> queue = new LinkedList<>();

        // 방문 여부 배열 생성
        visited = new boolean[rowSize][colSize];

        // 시작 위치 저장
        queue.offer(new Point(startY, startX, 0));
        visited[startY][startX] = true;

        // 탐색 수행
        while(!queue.isEmpty()) {

            // 현재 위치
            Point point = queue.poll();
            map[point.y][point.x] = point.value;

            // 주위 탐색
            for(int dir=0; dir<4; dir++) {
                int nextY = point.y+dy[dir];
                int nextX = point.x+dx[dir];

                // 범위 확인
                if(nextY<0 || nextY>rowSize-1 || nextX<0 || nextX>colSize-1) continue;

                // 이동 가능한 구역인지 확인
                if(map[nextY][nextX]==0) continue;

                // 이미 방문한 경우
                if(visited[nextY][nextX]) continue;

                // 경로 추가
                queue.offer(new Point(nextY, nextX, point.value+1));
                visited[nextY][nextX] = true;
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        // 가로, 세로 크기 입력
        st = new StringTokenizer(br.readLine());
        rowSize = Integer.parseInt(st.nextToken());
        colSize = Integer.parseInt(st.nextToken());

        // 격자 배열 생성
        map = new int[rowSize][colSize];

        // 격자 정보 입력
        for(int rowIndex=0; rowIndex<rowSize; rowIndex++) {
            st = new StringTokenizer(br.readLine());
            for(int colIndex=0; colIndex<colSize; colIndex++) {
                map[rowIndex][colIndex] = Integer.parseInt(st.nextToken());
                if(map[rowIndex][colIndex]==2) {
                    startY = rowIndex;
                    startX = colIndex;
                }
            }
        }

        // 거리 구하기
        solve();

        // 결과 저장
        for(int rowIndex=0; rowIndex<rowSize; rowIndex++) {
            for(int colIndex=0; colIndex<colSize; colIndex++) {
                if(!visited[rowIndex][colIndex] && (map[rowIndex][colIndex]==1))
                    sb.append(-1+" ");
                else sb.append(map[rowIndex][colIndex]+" ");
            }
            sb.append("\n");
        }

        // 결과 출력
        System.out.println(sb.toString());
    }
}