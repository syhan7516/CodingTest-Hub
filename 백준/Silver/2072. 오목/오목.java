import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    // 크기
    public static final int MAX_SIZE = 19;

    // 결과, 턴 수
    public static int answer, turnCount;

    // 사용자
    public static char client;

    // 보드
    public static char[][] board;

    // 범위 확인
    public static boolean isNotRange(int row, int col) {
        return row < 1 || row > MAX_SIZE || col < 1 || col > MAX_SIZE;
    }

    // 가로 확인
    public static boolean isFiveStoneInRow(char client, int rowIndex) {
        int count = 0;
        boolean isFiveStone = false;

        for(int colIndex=1; colIndex<=MAX_SIZE; colIndex++) {
            char stone = board[rowIndex][colIndex];

            // 동일한 돌인 경우
            if(client == stone) count++;

            // 다른 돌인 경우
            else {
                if(count == 5) isFiveStone = true;
                count = 0;
            }
        }

        return (count == 5) || isFiveStone;
    }

    // 세로 확인
    public static boolean isFiveStoneInCol(char client, int colIndex) {
        int count = 0;
        boolean isFiveStone = false;

        for(int rowIndex=1; rowIndex<=MAX_SIZE; rowIndex++) {
            char stone = board[rowIndex][colIndex];

            // 동일한 돌인 경우
            if(client == stone) count++;

            // 다른 돌인 경우
            else {
                if(count == 5) isFiveStone = true;
                count = 0;
            }
        }

        return (count == 5) || isFiveStone;
    }

    // 왼쪽 대각선 확인
    public static boolean isFiveStoneInLeftCross(char client, int rowIndex, int colIndex) {
        int count = 0;
        boolean isFiveStone = false;

        while(rowIndex != 0 && colIndex != 0) {
            rowIndex--;
            colIndex--;
        }

        for(int index=1; index<=MAX_SIZE; index++) {
            rowIndex++;
            colIndex++;

            if(isNotRange(rowIndex, colIndex)) break;
            char stone = board[rowIndex][colIndex];

            // 동일한 돌인 경우
            if(client == stone) count++;

                // 다른 돌인 경우
            else {
                if(count == 5) isFiveStone = true;
                count = 0;
            }
        }

        return (count == 5) || isFiveStone;
    }

    // 오른쪽 대각선 확인
    public static boolean isFiveStoneInRightCross(char client, int rowIndex, int colIndex) {
        int count = 0;
        boolean isFiveStone = false;

        while(rowIndex != 0 && colIndex <= MAX_SIZE) {
            rowIndex--;
            colIndex++;
        }

        for(int index=1; index<=MAX_SIZE; index++) {
            rowIndex++;
            colIndex--;

            if(isNotRange(rowIndex, colIndex)) break;
            char stone = board[rowIndex][colIndex];

            // 동일한 돌인 경우
            if(client == stone) count++;

                // 다른 돌인 경우
            else {
                if(count == 5) isFiveStone = true;
                count = 0;
            }
        }

        return (count == 5) || isFiveStone;
    }

    // 대각선 확인 (왼쪽, 오른쪽)
    public static boolean isFiveStoneInCross(char client, int rowIndex, int colIndex) {
        return isFiveStoneInLeftCross(client, rowIndex, colIndex) || isFiveStoneInRightCross(client, rowIndex, colIndex);
    }

    // 승리 여부 확인
    public static boolean isEndGame(char client, int rowIndex, int colIndex) {
        return isFiveStoneInRow(client, rowIndex) || isFiveStoneInCol(client, colIndex) || isFiveStoneInCross(client, rowIndex, colIndex);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        // 턴 수 입력
        turnCount = Integer.parseInt(br.readLine());

        // 보드 생성
        board = new char[MAX_SIZE+1][MAX_SIZE+1];

        // 턴 정보 입력
        answer = -1;
        client = 'B';
        for(int turn=1; turn<=turnCount; turn++) {
            st = new StringTokenizer(br.readLine());
            int rowIndex = Integer.parseInt(st.nextToken());
            int colIndex = Integer.parseInt(st.nextToken());
            board[rowIndex][colIndex] = client;
            if(answer == -1 && isEndGame(client, rowIndex, colIndex)) {
                answer = turn;
            }
            client = client == 'B' ? 'W' : 'B';
        }

        // 결과 출력
        System.out.println(answer);
    }
}