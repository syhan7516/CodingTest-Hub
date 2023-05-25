import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

// 위치 클래스
class Point {
    private int y;
    private int x;
    private int time;

    public Point(int y, int x, int time) {
        this.y = y;
        this.x = x;
        this.time = time;
    }

    public int getY() {
        return this.y;
    }

    public int getX() {
        return this.x;
    }

    public int getTime() {
        return this.time;
    }
}

public class Main {

    // 너비, 높이
    public static int width, height;
    // 빌딩
    public static char building[][];
    // 상근이 위치 큐
    public static Queue<Point> human;
    // 불 위치 큐
    public static Queue<Point> fire;
    // 결과
    public static int result;
    // 방향 벡터
    public static int dy[] = {0,1,0,-1};
    public static int dx[] = {1,0,-1,0};

    // 탈출 함수
    static void solve() {
        
        // 개수, 위치
        int fireCnt, humanCnt = 0;
        int curY, curX, curT, nextY, nextX = 0;

        while(!human.isEmpty()) {

            // 불 개수
            fireCnt = fire.size();
            // 불 움직이기
            for(int f=0; f<fireCnt; f++) {
                // 불 정보 가져오기
                Point curFire = fire.poll();
                curY = curFire.getY();
                curX = curFire.getX();

                // 불 확산
                for(int dir=0; dir<4; dir++) {
                    nextY = curY + dy[dir];
                    nextX = curX + dx[dir];

                    // 범위 확인
                    if(nextY<0 || nextY>height-1 || nextX<0 || nextX>width-1)
                        continue;
                    if(building[nextY][nextX]=='#' || building[nextY][nextX]=='*')
                        continue;

                    building[nextY][nextX] = '*';
                    fire.offer(new Point(nextY,nextX,0));
                }
            }

            // 상근이 위치 개수
            humanCnt = human.size();
            // 상근이 움직이기
            for(int h=0; h<humanCnt; h++) {
                // 상근이 정보 가져오기
                Point curHuman = human.poll();
                curY = curHuman.getY();
                curX = curHuman.getX();
                curT = curHuman.getTime();

                // 상근이 이동
                for(int dir=0; dir<4; dir++) {
                    nextY = curY + dy[dir];
                    nextX = curX + dx[dir];

                    // 범위 확인
                    if(nextY<0 || nextY>height-1 || nextX<0 || nextX>width-1) {
                        result = curT+1;
                        return;
                    }

                    if(building[nextY][nextX]=='.') {
                        building[nextY][nextX] = '*';
                        human.offer(new Point(nextY,nextX,curT+1));
                    }
                }
            }
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        // 테스트 케이스 수 입력
        int caseNum = Integer.parseInt(br.readLine());

        // 케이스 수만큼 수행
        for(int caseIdx=0; caseIdx<caseNum; caseIdx++) {

            // 너비, 높이 입력
            st = new StringTokenizer(br.readLine());
            width = Integer.parseInt(st.nextToken());
            height = Integer.parseInt(st.nextToken());

            // 빌딩 만들기
            building = new char[height][width];

            // 빌딩 정보 입력
            human = new LinkedList<>();
            fire = new LinkedList<>();
            for(int h=0; h<height; h++) {
                String line = br.readLine();
                for(int w=0; w<width; w++) {
                    building[h][w] = line.charAt(w);
                    // 상근이 위치
                    if(building[h][w]=='@') {
                        human.offer(new Point(h,w,0));
                    }
                    // 불 위치
                    if(building[h][w]=='*') {
                        fire.offer(new Point(h,w,0));
                    }
                }
            }

            // 탈출하기
            result = 0;
            solve();

            // 결과 저장
            if(result==0)
                sb.append("IMPOSSIBLE"+"\n");
            else
                sb.append(result+"\n");
        }

        // 결과 출력
        System.out.println(sb.toString());
    }
}