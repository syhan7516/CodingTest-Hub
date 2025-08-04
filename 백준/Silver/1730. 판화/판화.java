import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    // 보드 크기, 위치
    public static int size, currentY, currentX;

    // 보드 배열
    public static char[][] board;

    // 방향 벡터
    public static int[] dy = {0,1,0,-1};
    public static int[] dx = {1,0,-1,0};

    // 보드 초기화 메서드
    public static void initBoard() {
        for(int rowIndex=0; rowIndex<size; rowIndex++) {
            for(int colIndex=0; colIndex<size; colIndex++) {
                board[rowIndex][colIndex] = '.';
            }
        }
    }

    // 보드에 표시하기 메서드
    public static void markOnBoard(char type) {

        // 현재 위치 처리 - 이전과 이동 방향이 다른 경우
        if(type != board[currentY][currentX]) {

            // 시작 지점인 경우
            if(board[currentY][currentX] == '.') {
                board[currentY][currentX] = type;
            }

            // 아닌 경우
            else {
                board[currentY][currentX] = '+';
            }
        }
    }

    // 이동 메서드
    public static void moveRobot(char type, int dir) {

        // 다음 이동 칸
        int nextY = currentY + dy[dir];
        int nextX = currentX + dx[dir];

        // 범위 확인
        if(nextY<0 || nextY>size-1 || nextX<0 || nextX>size-1) return;

        // 보드에 표시하기
        markOnBoard(type);

        currentY = nextY;
        currentX = nextX;

        // 보드에 표시하기
        markOnBoard(type);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        // 보드 크기 입력
        size = Integer.parseInt(br.readLine());

        // 보드 생성
        board = new char[size][size];

        // 보드 초기화
        initBoard();

        // 명령 입력
        String orders = br.readLine();
        for(int index=0; index<orders.length(); index++) {

            // 명령 확인
            char order = orders.charAt(index);

            // U
            if(order == 'U') {
                moveRobot('|', 3);
            }

            // D
            else if(order == 'D') {
                moveRobot('|', 1);
            }

            // L
            else if(order == 'L') {
                moveRobot('-', 2);
            }

            // R
            else {
                moveRobot('-', 0);
            }
        }

        // 결과 저장 및 출력
        for(int rowIndex=0; rowIndex<size; rowIndex++) {
            for(int colIndex=0; colIndex<size; colIndex++) {
                sb.append(board[rowIndex][colIndex]);
            }
            sb.append("\n");
        }
        System.out.println(sb.toString());
    }
}