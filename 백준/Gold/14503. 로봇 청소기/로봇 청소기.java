import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    // 방 가로, 세로, 청소 칸
    public static int width, height, cleanCnt;
    // 방향 배열
    public static int dy[] = {-1,0,1,0};
    public static int dx[] = {0,1,0,-1};
    // 방 정보 배열
    public static int room[][];

    // 청소 함수
    static void clean(int curR, int curC, int curDir) {
        // 청소안되어있는 경우
        if(room[curR][curC]==0) {
            room[curR][curC] = 2;
            cleanCnt += 1;
        }

        // 주위 방향 확인
        for(int dir=0; dir<4; dir++) {
            curDir -= 1;
            if(curDir==-1) curDir=3;

            int ny = dy[curDir]+curR;
            int nx = dx[curDir]+curC;

            // 탐색 확인
            if(ny>=0 && ny<height && nx>=0 && nx<width && room[ny][nx]==0) {
                clean(ny,nx,curDir);
                return;
            }
        }

        // 청소가된 경우
        int back = (curDir+2)%4;
        int by = curR+dy[back];
        int bx = curC+dx[back];

        // 탐색 확인
        if(by>=0 && by<height && bx>=0 && bx<width && room[by][bx]!=1)
            clean(by, bx, curDir);
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        // 가로, 세로 입력
        st = new StringTokenizer(br.readLine());
        height = Integer.parseInt(st.nextToken());
        width = Integer.parseInt(st.nextToken());
        room = new int[height][width];

        // 로봇 청소기 정보
        st = new StringTokenizer(br.readLine());
        int curR = Integer.parseInt(st.nextToken());
        int curC = Integer.parseInt(st.nextToken());
        int curDir = Integer.parseInt(st.nextToken());

        // 방 정보 입력
        for(int row=0; row<height; row++) {
            st = new StringTokenizer(br.readLine());
            for(int col=0; col<width; col++) {
                room[row][col] = Integer.parseInt(st.nextToken());
            }
        }

        // 청소 시작
        clean(curR,curC,curDir);

        // 결과 출력
        System.out.println(cleanCnt);
    }
}