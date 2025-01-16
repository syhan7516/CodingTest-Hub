import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

// 위치 클래스
class Point {
    int row;
    int col;
    int distance;

    public Point(int row, int col, int distance) {
        this.row = row;
        this.col = col;
        this.distance = distance;
    }
}

public class Main {

    // 결과, 가로, 세로 크기
    public static int answer, rowSize, colSize;

    // 맵
    public static char map[][];

    // 방향 벡터
    public static int dy[] = {0,1,0,-1};
    public static int dx[] = {1,0,-1,0};

    // 방문 여부 배열
    public static boolean visited[][];

    // 맵 탐색 메소드
    public static void solve(int row, int col) {

        // 방문 여부 배열 생성
        visited = new boolean[rowSize][colSize];

        // 위치 저장 큐 생성
        Queue<Point> queue = new LinkedList<>();

        // 시작점 처리
        visited[row][col] = true;
        queue.offer(new Point(row, col,0));

        while(!queue.isEmpty()) {

            // 현재 위치
            Point point = queue.poll();

            // 결과 갱신
            answer = Math.max(answer,point.distance);

            // 주변 위치 탐색
            for(int dir=0; dir<4; dir++) {
                int nextY = point.row+dy[dir];
                int nextX = point.col+dx[dir];

                // 범위 확인
                if(nextY>rowSize-1 || nextX>colSize-1 || nextY<0 || nextX<0) continue;

                // 이미 방문했거나 육지가 아닌 경우
                if(visited[nextY][nextX] || map[nextY][nextX]=='W') continue;

                // 탐색 위치 추가
                queue.offer(new Point(nextY,nextX,point.distance+1));
                visited[nextY][nextX] = true;
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
        map = new char[rowSize][colSize];

        // 맵 정보 입력
        for(int rowIndex=0; rowIndex<rowSize; rowIndex++) {
            String line = br.readLine();
            for(int colIndex=0; colIndex<colSize; colIndex++) {
                map[rowIndex][colIndex] = line.charAt(colIndex);
            }
        }

        // 모든 맵 확인
        answer = -1;
        for(int rowIndex=0; rowIndex<rowSize; rowIndex++) {
            for(int colIndex=0; colIndex<colSize; colIndex++) {

                // 육지인 경우
                if(map[rowIndex][colIndex]=='L')
                    solve(rowIndex,colIndex);
            }
        }

        // 결과 출력
        System.out.println(answer);
    }
}