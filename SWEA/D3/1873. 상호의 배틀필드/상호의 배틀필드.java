import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {

    // 맵의 가로, 세로 크기, 명령어 개수
    public static int rowSize, colSize, orderCnt;
    // 맵
    public static char board[][];
    // 명령
    public static String order;
    // 전차 위치, 방향
    public static int y,x,move;
    // 방향 배열
    public static char dir[] = {'^','v','<','>'};
    // 델타
    public static int dy[] = {-1,1,0,0};
    public static int dx[] = {0,0,-1,1};

    // 포탄 발사하기 메서드
    static void shooting() {

        // 포탄 위치
        int boomY = y;
        int boomX = x;

        // 포탄 일직선으로 발사
        while(true) {

            // 포탄 이동 방향
            int ny = boomY+dy[move];
            int nx = boomX+dx[move];

            // 맵 밖인 경우
            if(ny<0 || ny>rowSize-1 || nx<0 || nx>colSize-1) return;

            // 벽돌인 경우
            if(board[ny][nx]=='*') {
                board[ny][nx] = '.';
                return;
            }

            // 강철벽인 경우
            if(board[ny][nx]=='#') return;

            // 그 외의 경우 포탄 이동
            boomY = ny;
            boomX = nx;
        }
    }

    // 이동 조건 확인
    static void moveCheck() {

        // 진행 방향
        int ny = y+dy[move];
        int nx = x+dx[move];

        // 맵 범위 확인
        if(ny<0 || ny>rowSize-1 || nx<0 || nx>colSize-1) return;

        // 물인 경우
        if(board[ny][nx]=='-') return;

        // 벽인 경우
        if(board[ny][nx]=='*' || board[ny][nx]=='#') return;

        // 모든 조건 만족하는 경우 이동하기
        board[y][x] = '.';
        y = ny;
        x = nx;
    }

    // 명령 수행
    static void solve() {

        // 하나씩 수행하기
        for(int i=0; i<orderCnt; i++) {

            // 명령
            char o = order.charAt(i);

            switch(o) {
                case 'U':
                    move = 0;
                    moveCheck();
                    break;

                case 'D':
                    move = 1;
                    moveCheck();
                    break;

                case 'L':
                    move = 2;
                    moveCheck();
                    break;

                case 'R':
                    move = 3;
                    moveCheck();
                    break;

                case 'S':
                    shooting();
                    break;
            }

            // 전차 방향 전환
            board[y][x] = dir[move];
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        // 테스트 케이스 수 입력
        int caseNum = Integer.parseInt(br.readLine());

        // 케이스 수 만큼 수행
        for(int caseIdx=0; caseIdx<caseNum; caseIdx++) {

            // 맵의 가로, 세로 크기 입력
            st = new StringTokenizer(br.readLine());
            rowSize = Integer.parseInt(st.nextToken());
            colSize = Integer.parseInt(st.nextToken());

            // 맵 생성
            board = new char[rowSize][colSize];

            // 맵 정보 입력
            for (int i = 0; i < rowSize; i++) {
                String line = br.readLine();
                for (int j = 0; j < colSize; j++) {
                    board[i][j] = line.charAt(j);

                    // 전차 위치인 경우
                    if (board[i][j] == 94 || board[i][j] == 118 || board[i][j] == 60 || board[i][j] == 62) {
                        y = i;
                        x = j;
                        for (int d = 0; d < 4; d++) {
                            if (board[i][j] == dir[d]) {
                                move = d;
                                break;
                            }
                        }
                    }
                }
            }

            // 명령어 수 입력
            orderCnt = Integer.parseInt(br.readLine());

            // 명령어 입력
            order = br.readLine();

            // 명령 수행
            solve();

            // 결과 저장
            sb.append("#").append(caseIdx+1).append(" ");
            for(int i=0; i<rowSize; i++) {
                for(int j=0; j<colSize; j++) {
                    sb.append(board[i][j]);
                }
                sb.append("\n");
            }
        }

        // 결과 출력
        System.out.println(sb.toString());
    }
}