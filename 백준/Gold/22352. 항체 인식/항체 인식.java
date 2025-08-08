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

    // 결과
    public static boolean answer;

    // 가로, 세로 크기
    public static int rowSize, colSize;

    // 전, 후 배열
    public static int[][] beforeCells, afterCells;

    // 방문 여부 배열
    public static boolean[][] visited;

    // 방향 벡터
    public static int[] dy = {0,1,0,-1};
    public static int[] dx = {1,0,-1,0};

    // 탐색 수행 메서드
    public static void searchCells() {
        for(int rowIndex=0; rowIndex<rowSize; rowIndex++) {
            for(int colIndex=0; colIndex<colSize; colIndex++) {
                if(beforeCells[rowIndex][colIndex] != afterCells[rowIndex][colIndex]) {
                    searchCellsWithBfs(rowIndex, colIndex, beforeCells[rowIndex][colIndex], afterCells[rowIndex][colIndex]);
                    return;
                }
            }
        }
    }

    // BFS 탐색 수행 메서드
    public static void searchCellsWithBfs(int row, int col, int beforeCell, int afterCell) {

        // 위치 저장 큐 생성
        Queue<Point> queue = new LinkedList<>();

        // 방문 여부 배열 생성
        visited = new boolean[rowSize][colSize];

        // 시작 지점 처리
        visited[row][col] = true;
        beforeCells[row][col] = afterCell;
        queue.offer(new Point(row, col));

        // 탐색
        while(!queue.isEmpty()) {

            // 기준 위치
            Point point = queue.poll();

            // 이동 방향 확인
            for(int dir=0; dir<4; dir++) {
                int nextY = point.y + dy[dir];
                int nextX = point.x + dx[dir];

                // 범위 확인
                if(nextY < 0 || nextY > rowSize-1 || nextX < 0 || nextX > colSize-1) continue;

                // 이미 방문한 경우
                if(visited[nextY][nextX]) continue;

                // 숫자가 다른 경우
                if(beforeCells[nextY][nextX] != beforeCell) continue;

                // 탐색 대상 등록
                visited[nextY][nextX] = true;
                beforeCells[nextY][nextX] = afterCell;
                queue.offer(new Point(nextY, nextX));
            }
        }
    }

    // 셀 비교 메서드
    public static void compareCells() {
        for(int rowIndex=0; rowIndex<rowSize; rowIndex++) {
            for(int colIndex=0; colIndex<colSize; colIndex++) {
                if(beforeCells[rowIndex][colIndex] != afterCells[rowIndex][colIndex]) {
                    answer = false;
                    return;
                }
            }
        }

        answer = true;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        // 가로, 세로 크기 입력
        st = new StringTokenizer(reader.readLine());
        rowSize = Integer.parseInt(st.nextToken());
        colSize = Integer.parseInt(st.nextToken());

        // 전, 후 배열 생성
        beforeCells = new int[rowSize][colSize];
        afterCells = new int[rowSize][colSize];

        // 전, 후 배열 정보 입력
        for(int rowIndex=0; rowIndex<rowSize; rowIndex++) {
            st = new StringTokenizer(reader.readLine());
            for(int colIndex=0; colIndex<colSize; colIndex++) {
                beforeCells[rowIndex][colIndex] = Integer.parseInt(st.nextToken());
            }
        }

        for(int rowIndex=0; rowIndex<rowSize; rowIndex++) {
            st = new StringTokenizer(reader.readLine());
            for(int colIndex=0; colIndex<colSize; colIndex++) {
                afterCells[rowIndex][colIndex] = Integer.parseInt(st.nextToken());
            }
        }

        // 탐색 수행
        searchCells();

        // 셀 비교
        compareCells();

        // 결과 출력
        System.out.println(answer ? "YES" : "NO");
    }
}