import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

// 위치 클래스
class Point {
    int y;
    int x;

    public Point(int y, int x) {
        this.y = y;
        this.x = x;
    }
}

public class Main {

    // 결과
    public static String answer;

    // 복도 크기, 칸 수
    public static int size, pointCount;

    // 복도 배열
    public static char road[][];

    // 선생님, 장애물 위치 리스트
    public static ArrayList<Point> points, blocks;

    // 방향 벡터
    public static int dy[] = {0,1,0,-1};
    public static int dx[] = {1,0,-1,0};

    // 장애물 처리
    public static void setBuild(boolean set) {

        // 세우기
        if(set) {
            for(int p=0; p<blocks.size(); p++) {
                Point point = blocks.get(p);
                road[point.y][point.x] = 'O';
            }
        }

        // 없애기
        else {
            for(int p=0; p<blocks.size(); p++) {
                Point point = blocks.get(p);
                road[point.y][point.x] = 'X';
            }
        }
    }

    // 확인 메서드
    public static boolean isPossible() {

        // 선생님 위치 순회
        for(int p=0; p<points.size(); p++) {

            // 선생님 현재 위치
            Point point = points.get(p);

            // 각 방향 확인
            for(int dir=0; dir<4; dir++) {

                // 임시 위치
                int nextY = point.y;
                int nextX = point.x;

                while(true) {

                    // 다음 방향 선택
                    nextY = nextY+dy[dir];
                    nextX = nextX+dx[dir];

                    // 범위를 벗어난 경우
                    if(nextY>size-1 || nextY<0 || nextX>size-1 || nextX<0) break;

                    // 장애물이거나 선생님인 경우
                    if(road[nextY][nextX]=='O' || road[nextY][nextX]=='T') break;

                    // 학생인 경우
                    if(road[nextY][nextX]=='S') {
                        return false;
                    }
                }
            }
        }

        return true;
    }

    // 장애물 위치 선정 메서드
    public static void solve(int index, int count) {

        // 장애물 위치 선정이 끝난 경우
        if(count==3) {

            // 장애물 처리
            setBuild(true);

            // 확인
            if(isPossible())
                answer = "YES";

            // 장애물 처리
            setBuild(false);

            return;
        }

        // 장애물 위치 선정하기
        for(int point=index; point<pointCount; point++) {

            // 위치 변환
            int row = point/size;
            int col = point%size;

            // 위치에 무언가 없는 경우
            if(road[row][col]=='X') {
                blocks.add(new Point(row,col));
                solve(point+1,count+1);
                blocks.remove(blocks.size()-1);
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        // 복도 크기 입력
        size = Integer.parseInt(br.readLine());

        // 전체 칸 수
        pointCount = size*size;

        // 복도 배열 생성
        road = new char[size][size];

        // 선생님, 장애물 위치 리스트 생성
        points = new ArrayList<>();
        blocks = new ArrayList<>();

        // 복도 정보 입력
        for(int row=0; row<size; row++) {
            st = new StringTokenizer(br.readLine());
            for(int col=0; col<size; col++) {
                road[row][col] = st.nextToken().charAt(0);

                // 선생님인 경우
                if(road[row][col]=='T')
                    points.add(new Point(row,col));
            }
        }

        // 장애물 위치 선정
        answer = "NO";
        solve(0,0);

        // 결과 출력
        System.out.println(answer);
    }
}