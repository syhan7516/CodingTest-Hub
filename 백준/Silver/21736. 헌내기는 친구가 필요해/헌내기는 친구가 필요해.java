import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
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

    // 결과, 가로, 세로
    public static int answer, rowSize, colSize, doyoenY, doyoenX;

    // 캠퍼스 배열
    public static char campus[][];

    // 방향 벡터
    public static int dy[] = {0,1,0,-1};
    public static int dx[] = {1,0,-1,0};

    // 캠퍼스 순회 메서드
    public static void solve() {

        // 위치 저장 큐 생성
        Queue<Point> queue = new LinkedList<>();

        // 방문 여부 배열 생성
        boolean visited[][] = new boolean[rowSize][colSize];

        // 초기 설정
        visited[doyoenY][doyoenX] = true;
        queue.offer(new Point(doyoenY,doyoenX));

        // 캠퍼스 투어
        while(!queue.isEmpty()) {

            // 현재 위치
            Point current = queue.poll();

            // 주변 위치 확인
            for(int dir=0; dir<4; dir++) {
                int ny = current.y+dy[dir];
                int nx = current.x+dx[dir];

                // 범위를 벗어난 경우
                if(ny<0 || ny>rowSize-1 || nx<0 || nx>colSize-1) continue;

                // 이미 방문한 경우
                if(visited[ny][nx]) continue;

                // 벽인 경우
                if(campus[ny][nx]=='X') continue;

                // 사람인 경우
                if(campus[ny][nx]=='P') answer++;

                // 탐색 위치 추가
                visited[ny][nx] = true;
                queue.offer(new Point(ny,nx));
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        // 가로, 세로 입력
        st = new StringTokenizer(br.readLine());
        rowSize = Integer.parseInt(st.nextToken());
        colSize = Integer.parseInt(st.nextToken());

        // 캠퍼스 배열 생성
        campus = new char[rowSize][colSize];

        // 캠퍼스 정보 입력
        for(int i=0; i<rowSize; i++) {
            String line = br.readLine();
            for(int j=0; j<colSize; j++) {
                campus[i][j] = line.charAt(j);

                // 도연이인 경우
                if(campus[i][j]=='I') {
                    doyoenY = i;
                    doyoenX = j;
                }
            }
        }

        // 캠퍼스 순회
        answer = 0;
        solve();

        // 결과 출력
        if(answer==0) System.out.println("TT");
        else System.out.println(answer);
    }
}