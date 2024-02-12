import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    // 맵의 크기, 결과
    public static int mapSize, answer;

    // 맵
    public static int map[][];

    // 파이프 방향 벡터
    public static int dy[] = {0,1,1};
    public static int dx[] = {1,0,1};

    // 파이프 밀기 메서드
    static void solve(int y, int x, int dir) {

        // 파이프가 N-1, N-1에 도달한 경우
        if(y==mapSize-1 && x==mapSize-1) {
            answer++;
            return;
        }

        // 밀 방향
        int ny = 0;
        int nx = 0;

        // 밀기
        switch(dir) {
            case 0:
                for(int d=0; d<3; d+=2) {
                    ny = y+dy[d];
                    nx = x+dx[d];

                    // 범위 확인
                    if(ny<0 || ny>mapSize-1 || nx<0 || nx>mapSize-1) continue;

                    // 해당 위치가 벽이 있는지 확인
                    if(map[ny][nx]==1) continue;

                    // 대각선인 경우
                    if(d==2 && (map[ny][nx-1]==1 || map[ny-1][nx]==1)) continue;

                    // 노드 탐색
                    solve(ny,nx,d);
                }
                break;
            case 1:
                for(int d=1; d<3; d++) {
                    ny = y+dy[d];
                    nx = x+dx[d];

                    // 범위 확인
                    if(ny<0 || ny>mapSize-1 || nx<0 || nx>mapSize-1) continue;

                    // 해당 위치가 벽이 있는지 확인
                    if(map[ny][nx]==1) continue;

                    // 대각선인 경우
                    if(d==2 && (map[ny][nx-1]==1 || map[ny-1][nx]==1)) continue;

                    // 노드 탐색
                    solve(ny,nx,d);
                }

                break;
            case 2:
                for(int d=0; d<3; d++) {
                    ny = y+dy[d];
                    nx = x+dx[d];

                    // 범위 확인
                    if(ny<0 || ny>mapSize-1 || nx<0 || nx>mapSize-1) continue;

                    // 해당 위치가 벽이 있는지 확인
                    if(map[ny][nx]==1) continue;

                    // 대각선인 경우
                    if(d==2 && (map[ny][nx-1]==1 || map[ny-1][nx]==1)) continue;

                    // 노드 탐색
                    solve(ny,nx,d);
                }
                break;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        // 맵의 크기 입력
        mapSize = Integer.parseInt(br.readLine());

        // 맵 생성
        map = new int[mapSize][mapSize];

        // 맵 입력
        for(int i=0; i<mapSize; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<mapSize; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // 파이프 밀기
        answer = 0;
        solve(0,1,0);

        // 결과 출력
        System.out.println(answer);
    }
}