import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

// 위치 클래스
class Point implements Comparable<Point> {
    int row;
    int col;
    int value;

    public Point(int row, int col, int value) {
        this.row = row;
        this.col = col;
        this.value = value;
    }

    @Override
    public int compareTo(Point other) {
        return Integer.compare(other.value, this.value);
    }
}

public class Main {

    // 가로, 세로 크기, 이동 횟수
    public static int rowSize, colSize, moveCount;

    // 맵 배열
    public static int[][] map;

    // 방문 여부 배열
    public static boolean[][] visited;

    // 우선 순위 큐
    public static PriorityQueue<Point> queue;

    // 방향 벡터
    public static int[] dy = {0,1,0,-1};
    public static int[] dx = {1,0,-1,0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        // 가로, 세로 크기 입력
        st = new StringTokenizer(br.readLine());
        rowSize = Integer.parseInt(st.nextToken());
        colSize = Integer.parseInt(st.nextToken());

        // 맵 배열 생성
        map = new int[rowSize+1][colSize+1];

        // 방문 여부 배열 생성
        visited = new boolean[rowSize+1][colSize+1];

        // 우선 순위 큐 생성
        queue = new PriorityQueue<>();

        // 맵 정보 입력
        for(int rowIndex=1; rowIndex<=rowSize; rowIndex++) {
            st = new StringTokenizer(br.readLine());
            for(int colIndex=1; colIndex<=colSize; colIndex++) {
                map[rowIndex][colIndex] = Integer.parseInt(st.nextToken());

                // 가장 자리인 경우
                if(rowIndex == rowSize || rowIndex == 1 || colIndex == colSize || colIndex == 1) {
                    queue.offer(new Point(rowIndex, colIndex, map[rowIndex][colIndex]));
                }
            }
        }

        // 이동 횟수 입력
        moveCount = Integer.parseInt(br.readLine());

        // 수확 수행
        while(!queue.isEmpty() && moveCount > 0) {
            Point point = queue.poll();

            // 이미 방문한 경우
            if(visited[point.row][point.col]) continue;

            // 방문 처리
            visited[point.row][point.col] = true;
            moveCount--;
            sb.append(point.row).append(" ").append(point.col).append("\n");

            // 주위 확인
            for(int dir=0; dir<4; dir++) {
                int nextRow = point.row + dy[dir];
                int nextCol = point.col + dx[dir];

                // 범위를 벗어난 경우
                if(nextRow < 1 || nextRow > rowSize || nextCol < 1 || nextCol > colSize) continue;

                // 이미 방문한 경우
                if(visited[nextRow][nextCol]) continue;

                // 탐색 위치 추가
                queue.offer(new Point(nextRow, nextCol, map[nextRow][nextCol]));
            }
        }

        // 결과 출력
        System.out.println(sb.toString());
    }
}