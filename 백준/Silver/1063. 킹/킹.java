import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    // 움직임 횟수, 킹 위치, 돌 위치
    public static int moveCount, kingPositionY, kingPositionX, stonePositionY, stonePositionX;

    // 보드
    public static int[][] board;

    // 방향 벡터 - R, L, B, T, RT, LT, RB, LB
    public static int[] dy = {0,0,-1,1,1,1,-1,-1};
    public static int[] dx = {1,-1,0,0,1,-1,1,-1};

    // 범위 확인 메서드
    public static boolean isNotMoveToNextPosition(int row, int col) {
        return row<0 || row>7 || col<0 || col>7;
    }

    // 킹 이동 메서드
    public static void solve(int moveType) {

        // 이동 위치
        int nextY = kingPositionY + dy[moveType];
        int nextX = kingPositionX + dx[moveType];

        // 범위 확인
        if(isNotMoveToNextPosition(nextY,nextX)) return;

        // 해당 위치에 돌이 있는 경우
        if(nextY == stonePositionY && nextX == stonePositionX) {

            // 돌 위치 이동이 불가능한 경우
            if(isNotMoveToNextPosition(nextY + dy[moveType], nextX + dx[moveType])) return;

            // 돌 위치 갱신
            stonePositionY = nextY + dy[moveType];
            stonePositionX = nextX + dx[moveType];
        }

        // 킹 위치 갱신
        kingPositionY = nextY;
        kingPositionX = nextX;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        // 킹 위치, 돌 위치, 움직임 횟수 입력
        st = new StringTokenizer(br.readLine());
        String kingPosition = st.nextToken();
        String stonePosition = st.nextToken();
        moveCount = Integer.parseInt(st.nextToken());

        // 보드 생성
        board = new int[9][9];

        // 위치 정수화
        kingPositionX = kingPosition.charAt(0) - 'A';
        kingPositionY = kingPosition.charAt(1) - '1';
        stonePositionX = stonePosition.charAt(0) - 'A';
        stonePositionY = stonePosition.charAt(1) - '1';

        // 움직임 입력
        for(int index=0; index<moveCount; index++) {
            String move = br.readLine();
            int moveType = -1;

            // 움직임 확인
            switch(move) {
                case "R":
                    moveType = 0;
                    break;
                case "L":
                    moveType = 1;
                    break;
                case "B":
                    moveType = 2;
                    break;
                case "T":
                    moveType = 3;
                    break;
                case "RT":
                    moveType = 4;
                    break;
                case "LT":
                    moveType = 5;
                    break;
                case "RB":
                    moveType = 6;
                    break;
                case "LB":
                    moveType = 7;
                    break;
                default:
                    break;
            }

            // 킹 이동
            solve(moveType);
        }

        // 결과 출력
        sb.append((char)(kingPositionX+'A')).append(kingPositionY+1).append('\n');
        sb.append((char)(stonePositionX+'A')).append(stonePositionY+1);
        System.out.println(sb.toString());
    }
}