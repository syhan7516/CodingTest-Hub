import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    // 방 크기, 로봇 위치, 바라보는 방향, 결과
    public static int rowSize, colSize, robotRow, robotCol, robotDir, clean;

    // 방
    public static int room[][];

    // 방향 벡터
    public static int dy[] = {-1,0,1,0};
    public static int dx[] = {0,1,0,-1};

    // 뒷 방향 방향 벡터
    public static int back[] = {2,3,0,1};

    // 청소하기 메서드
    static void solve() {

        // 청소 여부
        boolean isClean = false;

        while(true) {

            // 현재 칸 확인
            if(room[robotRow][robotCol]==0) {
                room[robotRow][robotCol]=2;
                clean++;
            }

            // 청소 여부 갱신
            isClean = false;

            // 현재 칸 기준 네 방향 확인
            for(int d=1; d<=4; d++) {

                // 확인 방향
                int move = robotDir-d;
                if(move<0) move += 4;

                int ny = robotRow+dy[move];
                int nx = robotCol+dx[move];

                // 청소 X
                if(room[ny][nx]==0) {

                    // 방향 전환
                    robotDir = move;

                    // 로봇 이동
                    isClean = true;
                    robotRow = ny;
                    robotCol = nx;
                    break;
                }
            }

            // 네 방향 모두 청소된 경우
            if(!isClean) {

                // 후진 방향 좌표
                int rowBack = robotRow+dy[back[robotDir]];
                int colBack = robotCol+dx[back[robotDir]];

                // 벽이 없는 경우 후진
                if(room[rowBack][colBack]!=1) {
                    robotRow = rowBack;
                    robotCol = colBack;
                }

                // 벽이 있는 경우 정지
                else return;
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        // 방의 크기 입력
        st = new StringTokenizer(br.readLine());
        rowSize = Integer.parseInt(st.nextToken());
        colSize = Integer.parseInt(st.nextToken());

        // 로봇 위치, 방향 입력
        st = new StringTokenizer(br.readLine());
        robotRow = Integer.parseInt(st.nextToken());
        robotCol = Integer.parseInt(st.nextToken());
        robotDir = Integer.parseInt(st.nextToken());

        // 방 생성
        room = new int[rowSize][colSize];

        // 방 정보 입력
        for(int i=0; i<rowSize; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<colSize; j++) {
                room[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // 청소하기
        clean = 0;
        solve();

        // 결과 출력
        System.out.println(clean);
    }
}