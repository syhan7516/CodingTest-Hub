import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

// CCTV 클래스
class CCTV {
    private int y;
    private int x;
    private int type;
    ArrayList<Integer> dirs = new ArrayList<Integer>();

    public CCTV(int y, int x, int type) {
        this.y = y;
        this.x = x;
        this.type = type;
    }

    public int getY() {
        return this.y;
    }

    public int getX() {
        return this.x;
    }

    public int getType() {
        return this.type;
    }

    public void addDir(int dir) {
        dirs.add(dir);
    }

    public int dirSize() {
        return dirs.size();
    }
}

public class Main {
    // 사무실
    public static int room[][];
    // 가로, 세로, O개수
    public static int rowSize, colSize, zeroCnt;
    // CCTV 저장 리스트
    public static ArrayList<CCTV> cctvs;
    // 방향별 CCTV 저장 배열
    public static CCTV selected[];
    // 사각지대 검사 배열
    public static boolean visited[][];
    // CCTV 각도 조절 방향 벡터
    public static int dx[] = {0,1,0,-1};
    public static int dy[] = {-1,0,1,0};
    // 결과
    public static int result;

    // 사각지대 개수 검사
    static void checkCount(CCTV[] selected) {
        int count = 0;
        visited = new boolean[rowSize][colSize];
        for(int idx=0; idx<selected.length; idx++) {
            CCTV curCCTV = selected[idx];

            // 방향별 검사
            for(int d=0; d<curCCTV.dirSize(); d++) {
                int direct = curCCTV.dirs.get(d);
                int nextX = curCCTV.getX() + dx[direct];
                int nextY = curCCTV.getY() + dy[direct];
                // 사무실 범위 제한
                while((nextX>=0 && nextX<colSize) && (nextY>=0 && nextY<rowSize)) {
                    // 검사 지역이 0이면서 검사가 안된 경우
                    if(room[nextY][nextX]==0 && !visited[nextY][nextX]) {
                        count++;
                        visited[nextY][nextX] = true;
                    }
                    // 검사 지역이 벽인 경우
                    else if(room[nextY][nextX] == 6) {
                        break;
                    }
                    // 다음 방향으로 설정
                    nextX += dx[direct];
                    nextY += dy[direct];
                }
            }
        }
        
        // 최소 값으로 갱신
        result = Math.min(result, zeroCnt-count);
    }

    // 백트래킹 함수
    static void backTracking(int idx, int size, CCTV selected[]) {

        // CCTV 전부 선택한 경우
        if(idx==size) {
            checkCount(selected);
            return;
        }

        // CCTV 선택
        CCTV cctv = cctvs.get(idx);

        // CCTV 방향 확인
        for(int d=0; d<4; d++) {
            CCTV curCCTV = new CCTV(cctv.getY(), cctv.getX(), cctv.getType());

            // 각 CCTV 번호별 처리
            int curType = cctv.getType();
            switch(curType) {
                case 1:
                    curCCTV.addDir(d);
                    selected[idx] = curCCTV;
                    backTracking(idx+1, size, selected);
                    break;
                case 2:
                    // 2번 CCTV는 방향 2개
                    if(d >= 2)
                        return;
                    curCCTV.addDir(d);
                    curCCTV.addDir(d+2);
                    selected[idx] = curCCTV;
                    backTracking(idx+1, size, selected);
                    break;
                case 3:
                    curCCTV.addDir(d);
                    curCCTV.addDir((d+1)%4);
                    selected[idx] = curCCTV;
                    backTracking(idx+1, size, selected);
                    break;
                case 4:
                    curCCTV.addDir(d);
                    curCCTV.addDir((d+1)%4);
                    curCCTV.addDir((d+2)%4);
                    selected[idx] = curCCTV;
                    backTracking(idx+1, size, selected);
                    break;
                case 5:
                    // 5번 CCTV는 방향 1개
                    if(d >= 1)
                        return;
                    curCCTV.addDir(d);
                    curCCTV.addDir((d+1)%4);
                    curCCTV.addDir((d+2)%4);
                    curCCTV.addDir((d+3)%4);
                    selected[idx] = curCCTV;
                    backTracking(idx + 1, size, selected);
                    break;
            }
        }
    }

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        // 가로, 세로 입력
        st = new StringTokenizer(br.readLine());
        rowSize = Integer.parseInt(st.nextToken());
        colSize = Integer.parseInt(st.nextToken());

        // 기본 초기화
        room = new int[rowSize][colSize];
        cctvs = new ArrayList<CCTV>();
        zeroCnt = 0;

        // 사무실 정보 입력
        for(int r=0; r<rowSize; r++) {
            st = new StringTokenizer(br.readLine());
            for(int c=0; c<colSize; c++) {
                int num = Integer.parseInt(st.nextToken());

                // 입력 숫자가 0인 경우
                if(num==0) {
                    zeroCnt++;
                }

                // 입력 숫자가 1~5인 경우
                else if(num!=6) {
                    cctvs.add(new CCTV(r,c,num));
                }

                // 입력 값 저장
                room[r][c] = num;
            }
        }

        // 백트래킹 수행
        result = Integer.MAX_VALUE;
        selected = new CCTV[cctvs.size()];
        backTracking(0, cctvs.size(), selected);

        // 결과 출력
        System.out.println(result);
    }
}