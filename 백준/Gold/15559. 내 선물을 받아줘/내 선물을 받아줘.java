import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    // 결과, 가로, 세로 크기
    public static int answer, rowSize, colSize;

    // 보드 배열
    public static char[][] board;

    // 경로 그룹 저장 배열
    public static int[][] groups;

    // 방향 벡터
    public static int[] dy = {-1,1,0,0};
    public static int[] dx = {0,0,1,-1};

    // 탐색 메서드
    public static void solve(int group, int row, int col) {

        // 이동 위치 확인
        char nextMove = board[row][col];
        int nextY = row;
        int nextX = col;

        // 'N'
        if(nextMove == 'N') {
            nextY += dy[0];
            nextX += dx[0];
        }

        // 'S'
        else if(nextMove == 'S') {
            nextY += dy[1];
            nextX += dx[1];
        }

        // 'E'
        else if(nextMove == 'E') {
            nextY += dy[2];
            nextX += dx[2];
        }

        // 'W'
        else {
            nextY += dy[3];
            nextX += dx[3];
        }

        // 이미 그룹이 있는 경우
        if(groups[nextY][nextX] != 0) {

            // 현재 그룹과 동일한 경우
            if(groups[nextY][nextX] == group) {
                answer++;
                return;
            }
        }

        // 그룹이 없는 경우
        else {
            groups[nextY][nextX] = group;
            solve(group, nextY, nextX);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        // 크기 입력
        st = new StringTokenizer(br.readLine());
        rowSize = Integer.parseInt(st.nextToken());
        colSize = Integer.parseInt(st.nextToken());

        // 보드 생성
        board = new char[rowSize][colSize];

        // 보드 정보 입력
        for(int rowIndex=0; rowIndex<rowSize; rowIndex++) {
            String line = br.readLine();
            for(int colIndex=0; colIndex<colSize; colIndex++) {
                board[rowIndex][colIndex] = line.charAt(colIndex);
            }
        }

        // 경로 그룹 저장 배열 생성
        groups = new int[rowSize][colSize];

        // 탐색
        int group = 1;
        for(int rowIndex=0; rowIndex<rowSize; rowIndex++) {
            for(int colIndex=0; colIndex<colSize; colIndex++) {

                // 탐색이 안된 경로인 경우
                if(groups[rowIndex][colIndex] == 0) {
                    groups[rowIndex][colIndex] = group;
                    solve(group, rowIndex, colIndex);
                    group++;
                }
            }
        }

        // 결과 출력
        System.out.println(answer);
    }
}