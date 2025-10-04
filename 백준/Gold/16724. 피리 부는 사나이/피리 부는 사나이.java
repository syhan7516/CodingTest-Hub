import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    // 결과, 가로, 세로 크기
    public static int answer, rowSize, colSize;

    // 그룹 배열
    public static int[] groups;

    // 보드 배열
    public static char[][] board;

    // 경로 배열
    public static int[][] path;

    // find
    public static int find(int node) {
        if(groups[node] == node) {
            return node;
        }

        return groups[node] = find(groups[node]);
    }

    // union
    public static void union(int a, int b) {
        a = find(a);
        b = find(b);

        if(a < b) groups[b] = a;
        else groups[a] = b;
    }

    // 방향 벡터
    public static int[] dy = {-1,1,0,0};
    public static int[] dx = {0,0,-1,1};

    // 경로 확인 메서드
    public static void solve(int rowIndex, int colIndex, int groupNum) {

        // 다음 이동 정보
        int nextY = -1;
        int nextX = -1;

        // 이동 방향 확인 - U
        if(board[rowIndex][colIndex] == 'U') {
            nextY = rowIndex + dy[0];
            nextX = colIndex + dx[0];
        }

        // D
        else if(board[rowIndex][colIndex] == 'D') {
            nextY = rowIndex + dy[1];
            nextX = colIndex + dx[1];
        }

        // L
        else if(board[rowIndex][colIndex] == 'L') {
            nextY = rowIndex + dy[2];
            nextX = colIndex + dx[2];
        }

        // R
        else {
            nextY = rowIndex + dy[3];
            nextX = colIndex + dx[3];
        }

        // 경로가 없는 경우
        if(path[nextY][nextX] == 0) {
            path[nextY][nextX] = groupNum;
            solve(nextY, nextX, groupNum);
        }

        // 경로가 없는 경우
        else {

            // 해당 경로가 현재 경로와 일치하는 경우
            if(path[nextY][nextX] == groupNum) answer++;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        // 가로, 세로 입력
        st = new StringTokenizer(br.readLine());
        rowSize = Integer.parseInt(st.nextToken());
        colSize = Integer.parseInt(st.nextToken());

        // 보드 배열 생성
        board = new char[rowSize][colSize];

        // 보드 정보 입력
        for(int rowIndex=0; rowIndex<rowSize; rowIndex++) {
            String line = br.readLine();
            for(int colIndex=0; colIndex<colSize; colIndex++) {
                board[rowIndex][colIndex] = line.charAt(colIndex);
            }
        }

        // 경로 배열 생성
        path = new int[rowSize][colSize];

        // 탐색 수행
        int groupNum = 1;
        for(int rowIndex=0; rowIndex<rowSize; rowIndex++) {
            for(int colIndex=0; colIndex<colSize; colIndex++) {

                // 경로가 없었던 경우
                if(path[rowIndex][colIndex] == 0) {
                    path[rowIndex][colIndex] = groupNum;
                    solve(rowIndex, colIndex, groupNum);
                    groupNum++;
                }
            }
        }

        // 결과 출력
        System.out.println(answer);
    }
}