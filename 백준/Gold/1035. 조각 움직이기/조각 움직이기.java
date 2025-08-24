import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

// 좌표 클래스
class Point {
    int y;
    int x;

    public Point(int y, int x) {
        this.y = y;
        this.x = x;
    }
}

public class Main {

    // 결과
    public static int answer;

    // 좌표 저장 리스트
    public static ArrayList<Point> points;

    // 좌표 배치 정보 배열
    public static Point[] locations;

    // 보드 배열
    public static char[][] board;

    // 방향 벡터
    public static int[] dy = {0,1,0,-1};
    public static int[] dx = {1,0,-1,0};

    // 이동 거리 확인 메서드
    public static void checkMoveCount() {
        int moveCount = 0;

        // 위치 거리 확인
        for(int index=0; index<locations.length; index++) {
            Point basicPoint = points.get(index);
            Point movePoint = locations[index];
            moveCount += Math.abs(movePoint.x - basicPoint.x) + Math.abs(movePoint.y - basicPoint.y);
        }

        // 결과 갱신
        answer = Math.min(answer, moveCount);
    }

    // 연결 정보 확인 메서드
    public static void checkConnectPoints() {

        // 위치 저장 큐 생성
        Queue<Point> queue = new LinkedList<>();

        // 방문 여부 배열 생성
        boolean[][] visited = new boolean[25][25];

        // 시작 위치 처리
        Point point = locations[0];
        queue.offer(new Point(point.y, point.x));
        visited[point.y][point.x] = true;

        // 연결 위치 개수
        int connectedCount = 1;

        // 탐색
        while(!queue.isEmpty() && connectedCount < points.size()) {

            // 현재 위치
            point = queue.poll();

            // 연결 위치 확인
            for(int dir=0; dir<4; dir++) {
                int nextY = point.y + dy[dir];
                int nextX = point.x + dx[dir];

                // 범위를 벗어난 경우
                if(nextY<0 || nextY>4 || nextX<0 || nextX>4) continue;

                // 이미 방문한 경우
                if(visited[nextY][nextX]) continue;

                // 조각이 아닌 경우
                if(board[nextY][nextX] == '.') continue;

                // 조각 위치 처리
                visited[nextY][nextX] = true;
                connectedCount++;
                queue.offer(new Point(nextY, nextX));
            }
        }

        // 이동 거리 확인
        if(connectedCount == points.size()) {
            checkMoveCount();
        }
    }

    // 조각 위치 설정
    public static void solve(int selectedCount) {

        // 조각 배치가 완료된 경우
        if(selectedCount == points.size()) {

            // 연결 정보 확인
            checkConnectPoints();
            return;
        }

        // 배치
        for(int index=0; index<25; index++) {
            if(board[index/5][index%5] == '*') continue;
            board[index/5][index%5] = '*';
            locations[selectedCount] = new Point(index/5, index%5);
            solve(selectedCount + 1);
            board[index/5][index%5] = '.';
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 보드 배열 생성
        board = new char[5][5];

        // 좌표 저장 리스트 생성
        points = new ArrayList<>();

        // 보드 정보 입력
        int num = 0;
        for(int rowIndex=0; rowIndex<5; rowIndex++) {
            String line = br.readLine();
            for(int colIndex=0; colIndex<5; colIndex++) {
                board[rowIndex][colIndex] = line.charAt(colIndex);
                if(board[rowIndex][colIndex] == '*') {
                    points.add(new Point(rowIndex, colIndex));
                    board[rowIndex][colIndex] = '.';
                }
            }
        }

        // 좌표 배치 정보 배열 생성
        locations = new Point[points.size()];

        // 조각 위치 설정
        answer = Integer.MAX_VALUE;
        solve(0);

        // 결과 출력
        System.out.println(answer);
    }
}