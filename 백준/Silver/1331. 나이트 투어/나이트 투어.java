import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

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

    // 보드 사이즈
    public static final int BOARD_WIDTH = 6;
    public static final int BOARD_HEIGHT = 6;

    // 시작 위치, 현재 위치
    public static int startY, startX, currentY, currentX;

    // 방향 벡터
    public static int dy[] = {-1,-2,-2,-1,1,2,2,1};
    public static int dx[] = {-2,-1,1,2,2,1,-1,-2};

    // 성공 여부
    public static boolean possible;

    // 보드
    public static boolean[][] board;

    // 좌표 입력 메서드
    public static Point pointInputHandler(String line) {
        int rowIndex = line.charAt(0) - 'A' + 1;
        int colIndex = line.charAt(1) - '0';
        return new Point(rowIndex, colIndex);
    }

    // 이동 가능 여부 메서드
    public static boolean canMovePoint(int y, int x, int targetY, int targetX) {
        for(int dir=0; dir<8; dir++) {
            int ny = y + dy[dir];
            int nx = x + dx[dir];

            // 범위를 벗어난 경우
            if(ny<1 || ny>BOARD_HEIGHT || nx<1 || nx>BOARD_WIDTH) continue;

            // 이동 가능한 경우
            if(targetY == ny && targetX == nx) return true;
        }
        
        return false;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 보드 생성
        board = new boolean[BOARD_HEIGHT+1][BOARD_WIDTH+1];

        // 이동 정보 입력
        Point point = pointInputHandler(br.readLine());
        board[point.y][point.x] = true;
        startY = currentY = point.y;
        startX = currentX = point.x;
        possible = true;

        for(int index=2; index<=36; index++) {
            point = pointInputHandler(br.readLine());

            // 범위를 벗어난 경우
            if(point.y<1 || point.y>BOARD_HEIGHT || point.x<1 || point.x>BOARD_WIDTH) {
                possible = false;
                break;
            }

            // 이미 방문한 경우, 이동 불가능한 경우
            if(board[point.y][point.x] || !canMovePoint(currentY, currentX, point.y, point.x)) {
                possible = false;
                break;
            }

            // 방문 처리
            board[point.y][point.x] = true;
            currentY = point.y;
            currentX = point.x;
        }

        if(!possible || !canMovePoint(point.y,point.x, startY, startX)) {
            System.out.println("Invalid");
        }

        else System.out.println("Valid");
    }
}