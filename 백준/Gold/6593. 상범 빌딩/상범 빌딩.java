import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Node {
    int h;
    int y;
    int x;
    int dist;

    public Node(int h, int y, int x, int dist) {
        this.h = h;
        this.y = y;
        this.x = x;
        this.dist = dist;
    }
}

public class Main {

    // 층, 가로, 세로, 결과
    public static int floor, row, col, answer;

    // 시작 위치, 도착 위치
    public static int startH, startY, startX, endH, endY, endX;

    // 노드 큐
    public static Queue<Node> queue;

    // 방향 벡터
    public static int dy[] = {1,0,-1,0,0,0};
    public static int dx[] = {0,-1,0,1,0,0};
    public static int dh[] = {0,0,0,0,1,-1};

    // 건물
    public static char building[][][];

    // 건물 탈출
    static void solve() {

        // 빌딩 탐색
        while(!queue.isEmpty()) {

            // 현재 위치
            Node curNode = queue.poll();

            // 탈출구인 경우
            if(curNode.h==endH && curNode.y==endY && curNode.x==endX) {
                answer = curNode.dist;
                return;
            }

            // 여섯 방향 확인
            for(int d=0; d<6; d++) {
                int ny = curNode.y+dy[d];
                int nx = curNode.x+dx[d];
                int nh = curNode.h+dh[d];

                // 범위를 벗어난 경우
                if(ny<0 || ny>row-1 || nx<0 || nx>col-1 || nh<0 || nh>floor-1)
                    continue;

                // 이미 방문하거나 벽인 경우
                if(building[nh][ny][nx]=='#')
                    continue;

                // 아닌 경우
                queue.offer(new Node(nh,ny,nx,curNode.dist+1));
                building[nh][ny][nx] = '#';
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        while(true) {

            // 층, 가로, 세로 입력
            st = new StringTokenizer(br.readLine());
            floor = Integer.parseInt(st.nextToken());
            row = Integer.parseInt(st.nextToken());
            col = Integer.parseInt(st.nextToken());

            // 모두 0인 경우
            if(floor==0 && row==0 && col==0)
                break;

            // 건물 만들기
            building = new char[floor][row][col];

            // 큐 생성
            queue = new LinkedList<>();

            // 건물 정보 입력
            for(int i=0; i<floor; i++) {
                for(int j=0; j<row; j++) {
                    String line = br.readLine();
                    for(int k=0; k<col; k++) {
                        building[i][j][k] = line.charAt(k);

                        if(building[i][j][k]=='S') {
                            startH = i;
                            startY = j;
                            startX = k;
                            queue.offer(new Node(i,j,k,0));
                            building[i][j][k] = '#';
                        }

                        if(building[i][j][k]=='E') {
                            endH = i;
                            endY = j;
                            endX = k;
                        }
                    }
                }

                br.readLine();
            }

            // 건물
            answer = 0;
            solve();

            // 결과 출력
            if(answer==0)
                System.out.println("Trapped!");
            else
                System.out.println("Escaped in "+answer+" minute(s).");
        }
    }
}