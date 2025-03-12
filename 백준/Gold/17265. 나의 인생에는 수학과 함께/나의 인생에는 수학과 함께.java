import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 위치 클래스
class Point {
    int y;
    int x;
    int result;
    int count;
    char operator;

    public Point(int y, int x, int result, int count, char operator) {
        this.y = y;
        this.x = x;
        this.result = result;
        this.count = count;
        this.operator = operator;
    }
}

public class Main {

    // 지도의 크기, 최대, 최소, 최단 거리
    public static int mapSize, minAnswer, maxAnswer, pathLen;

    // 지도
    public static char[][] map;

    // 방문 여부 배열
    public static boolean[][] visited;

    // 방향 벡터
    public static int[] dy = {0,1,0,-1};
    public static int[] dx = {1,0,-1,0};

    // 연산 메서드
    public static int calculation(int num1, int num2, char operator) {

        if(operator=='+') return num1+num2;
        else if(operator=='-') return num1-num2;
        else return num1*num2;
    }

    // 숫자 확인 메서드
    public static boolean isNum(char letter) {
        int number = letter-'0';
        return number>=0 && number<=5;
    }

    // 이동하기 메서드
    public static void solve(Point point) {

        // 최단 거리가 아닌 경우
        if(point.count>pathLen) return;

        // 도착점인 경우
        if(point.y==mapSize-1 && point.x==mapSize-1) {
            minAnswer = Math.min(point.result, minAnswer);
            maxAnswer = Math.max(point.result, maxAnswer);
            pathLen = point.count;
            return;
        }

        // 방향 벡터
        for(int dir=0; dir<4; dir++) {
            int nextY = point.y+dy[dir];
            int nextX = point.x+dx[dir];

            // 범위 확인
            if(nextY<0 || nextY>mapSize-1 || nextX<0 || nextX>mapSize-1) continue;

            // 방문 여부 확인
            if(visited[nextY][nextX]) continue;

            // 이동하기
            visited[nextY][nextX] = true;

            // 숫자인 경우
            if(isNum(map[nextY][nextX])) {
                int result = calculation(point.result,map[nextY][nextX]-'0',point.operator);
                Point nextPoint = new Point(nextY,nextX,result,point.count+1,' ');
                solve(nextPoint);
            }

            // 연산자인 경우
            else {
                Point nextPoint = new Point(nextY,nextX,point.result,point.count+1,map[nextY][nextX]);
                solve(nextPoint);
            }

            visited[nextY][nextX] = false;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        // 지도 크기 입력
        mapSize = Integer.parseInt(br.readLine());

        // 지도 생성
        map = new char[mapSize][mapSize];

        // 지도 정보 입력
        for(int rowIndex=0; rowIndex<mapSize; rowIndex++) {
            st = new StringTokenizer(br.readLine());
            for(int colIndex=0; colIndex<mapSize; colIndex++) {
                map[rowIndex][colIndex] = st.nextToken().charAt(0);
            }
        }

        // 방문 여부 배열 생성
        visited = new boolean[mapSize][mapSize];

        // 이동하기
        pathLen = Integer.MAX_VALUE;
        minAnswer = Integer.MAX_VALUE;
        maxAnswer = Integer.MIN_VALUE;

        Point point = new Point(0,0,map[0][0]-'0',0,' ');
        visited[point.y][point.x] = true;
        solve(point);

        // 결과 출력
        System.out.println(maxAnswer+" "+minAnswer);
    }
}