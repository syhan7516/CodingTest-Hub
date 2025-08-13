import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    // 명령 길이
    public static int orderLen;

    // 최대 (행,열), 최소 (행,열)
    public static int maxRow, maxCol, minRow, minCol;

    // 명령
    public static String orders;

    // 맵
    public static int[][] map;

    // 방향 벡터 - 동, 남, 서, 북
    public static int[] dy = {0,1,0,-1};
    public static int[] dx = {1,0,-1,0};

    // 방향에 따른 이동 배열
    public static int[] move;

    // 좌표 최대, 최소 값 반영 메서드
    public static void reflectFrom(int row, int col) {
        maxRow = Math.max(maxRow, row);
        maxCol = Math.max(maxCol, col);
        minRow = Math.min(minRow, row);
        minCol = Math.min(minCol, col);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        // 명령 길이 입력
        orderLen = Integer.parseInt(br.readLine());

        // 맵 생성
        map = new int[101][101];

        // 이동 배열 생성
        move = new int[26];

        // 위치 지정
        int row = 50;
        int col = 50;
        int dir = 1;
        map[row][col] = 1;

        // 명령 확인
        orders = br.readLine();
        maxRow = maxCol = minRow = minCol = 50;
        for(int order=0; order<orderLen; order++) {

            // 명령
            char act = orders.charAt(order);

            // 'F'
            if(act == 'F') {
                row += dy[dir];
                col += dx[dir];
                map[row][col] = 1;
                reflectFrom(row, col);
            }

            // 이외
            else {

                // 'L'
                if(act == 'L') dir += 3;

                // 'R'
                else dir += 1;

                // 범위 고려
                dir %= 4;
            }
        }

        // 결과 저장
        for(int rowIndex=minRow; rowIndex<=maxRow; rowIndex++) {
            for(int colIndex=minCol; colIndex<=maxCol; colIndex++) {
                if(map[rowIndex][colIndex] == 1) {
                    sb.append(".");
                }
                else sb.append("#");
            }
            sb.append("\n");
        }

        // 결과 출력
        System.out.println(sb.toString());
    }
}