import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

// 위치 클래스
class Point implements Comparable<Point> {
    int row;
    int col;
    int dir;
    int count;

    public Point(int row, int col, int dir, int count) {
        this.row = row;
        this.col = col;
        this.dir = dir;
        this.count = count;
    }

    @Override
    public int compareTo(Point other) {
        return this.count - other.count;
    }
}

public class Main {

    // 결과, 집 크기
    public static int answer, homeSize;

    // 문 개수, 문 위치
    public static int doorCount, firstDoorRow, firstDoorCol, secondDoorRow, secondDoorCol;

    // 집
    public static char[][] home;

    // 우선 순위 큐
    public static PriorityQueue<Point> queue;

    // 방문 여부 배열
    public static boolean[][][] visited;

    // 방향 벡터
    public static int[] dy = {0,1,0,-1};
    public static int[] dx = {1,0,-1,0};

    // 범위 확인 메서드
    public static boolean isRange(int row, int col) {
        return row >= 0 && row < homeSize && col >= 0 && col < homeSize;
    }

    // 이동 가능 공간 확인 메서드
    public static boolean isMoveToNextArea(int row, int col) {
        return home[row][col] == '.' || home[row][col] == '!' || home[row][col] == '#';
    }

    // 방문 여부 확인 메서드
    public static boolean isVisitToNextPosition(int row, int col, int dir) {
        return visited[row][col][dir];
    }

    // 이동 가능 조건 확인 메서드
    public static boolean isMoveToNextPosition(int row, int col, int dir) {
        return isRange(row, col) && isMoveToNextArea(row, col) && !isVisitToNextPosition(row, col, dir);
    }

    // 탐색 메서드
    public static void solve() {

        // 방문 여부 배열 생성
        visited = new boolean[homeSize][homeSize][4];

        // 우선 순위 큐 생성
        queue = new PriorityQueue<>();

        // 문 주위 탐색 가능한 영역 추가
        for(int dirIndex=0; dirIndex<4; dirIndex++) {
            int nextRow = firstDoorRow + dy[dirIndex];
            int nextCol = firstDoorCol + dx[dirIndex];

            // 범위 확인
            if(isMoveToNextPosition(nextRow, nextCol, dirIndex)) {
                queue.offer(new Point(nextRow, nextCol, dirIndex, 0));
            }
        }

        // 탐색
        while(!queue.isEmpty()) {
            Point point = queue.poll();

            // 다른 문인 경우
            if(point.row == secondDoorRow && point.col == secondDoorCol) {
                answer = point.count;
                return;
            }

            // 이미 방문한 경우
            if(visited[point.row][point.col][point.dir]) continue;

            // 방문 처리
            visited[point.row][point.col][point.dir] = true;

            // 거울 설치가 가능한 위치인 경우
            if(home[point.row][point.col] == '!') {

                // 남쪽, 북쪽 방향인 경우
                if(point.dir == 1 || point.dir == 3) {
                    for(int dirIndex=0; dirIndex<4; dirIndex+=2) {
                        int nextRow = point.row + dy[dirIndex];
                        int nextCol = point.col + dx[dirIndex];
                        if(isMoveToNextPosition(nextRow, nextCol, dirIndex)) {
                            queue.offer(new Point(nextRow, nextCol, dirIndex, point.count + 1));
                        }
                    }
                }

                // 동쪽, 서쪽 방향인 경우
                else {
                    for(int dirIndex=1; dirIndex<4; dirIndex+=2) {
                        int nextRow = point.row + dy[dirIndex];
                        int nextCol = point.col + dx[dirIndex];
                        if(isMoveToNextPosition(nextRow, nextCol, dirIndex)) {
                            queue.offer(new Point(nextRow, nextCol, dirIndex, point.count + 1));
                        }
                    }
                }
            }

            // 거울 설치가 불가능한 경우 또는 거울을 설치하지 않은 경우
            int nextRow = point.row + dy[point.dir];
            int nextCol = point.col + dx[point.dir];
            if(isMoveToNextPosition(nextRow, nextCol, point.dir)) {
                queue.offer(new Point(nextRow, nextCol, point.dir, point.count));
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 집 크기 입력
        homeSize = Integer.parseInt(br.readLine());

        // 집 생성
        home = new char[homeSize][homeSize];

        // 집 정보 입력
        for(int rowIndex=0; rowIndex<homeSize; rowIndex++) {
            String line = br.readLine();
            for(int colIndex=0; colIndex<homeSize; colIndex++) {
                home[rowIndex][colIndex] = line.charAt(colIndex);

                // 위치가 문인 경우
                if(home[rowIndex][colIndex] == '#') {

                    // 첫 번쨰 문 위치 입력
                    if(doorCount == 0) {
                        firstDoorRow = rowIndex;
                        firstDoorCol = colIndex;
                    }

                    // 두 번쨰 문 위치 입력
                    else {
                        secondDoorRow = rowIndex;
                        secondDoorCol = colIndex;
                    }

                    doorCount++;
                }
            }
        }

        // 탐색
        answer = 0;
        solve();

        // 결과 출력
        System.out.println(answer);
    }
}