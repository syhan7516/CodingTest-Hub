import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

// 노드 클래스
class Node {
    int y;
    int x;

    public Node(int y, int x) {
        this.y = y;
        this.x = x;
    }
}

public class Main {

    // 미로의 행과 열, 결과
    public static int R, C, answer;

    // 미로
    public static char miro[][];

    // 방향 벡터
    public static int dy[] = {1,0,-1,0};
    public static int dx[] = {0,-1,0,1};

    // 사람 큐, 불 큐
    public static Queue<Node> saram, fire;

    // 불 탈출하기 메서드
    static void solve() {

        // 이동 현황
        int moveCnt = 0;

        while(!saram.isEmpty()) {

            // 탈출한 경우
            if(answer!=-1)
                break;

            // 불 깊이 확인
            int fireSize = fire.size();

            // 불 이동
            while(fireSize-->0) {

                // 불 번짐 기준
                Node curNode = fire.poll();

                for(int dir=0; dir<4; dir++) {
                    int ny = curNode.y+dy[dir];
                    int nx = curNode.x+dx[dir];

                    // 범위 밖인 경우
                    if(ny<0 || ny>R-1 || nx<0 || nx>C-1)
                        continue;

                    // 이미 번지거나 벽인 경우
                    if(miro[ny][nx]=='F' || miro[ny][nx]=='#')
                        continue;

                    // 아닌 경우
                    fire.offer(new Node(ny,nx));
                    miro[ny][nx] = 'F';
                }
            }

            // 사람 깊이 확인
            int saramSize = saram.size();

            while(saramSize-->0) {

                // 사람 이동점 기준
                Node curNode = saram.poll();

                // 가장 자리인 경우
                if(curNode.y==R-1 || curNode.x==C-1 || curNode.y==0 || curNode.x==0) {
                    answer = moveCnt;
                    break;
                }

                for(int dir=0; dir<4; dir++) {
                    int ny = curNode.y+dy[dir];
                    int nx = curNode.x+dx[dir];

                    // 범위 밖인 경우
                    if(ny<0 || ny>R-1 || nx<0 || nx>C-1)
                        continue;

                    // 이동 가능한 경우
                    if(miro[ny][nx]=='.') {
                        saram.offer(new Node(ny,nx));
                        miro[ny][nx] = '!';
                    }
                }
            }

            // 이동
            moveCnt++;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        // 미로의 행과 열 입력
        st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        // 미로 생성
        miro = new char[R][C];

        // 큐 생성
        saram = new LinkedList<>();
        fire = new LinkedList<>();

        // 미로 정보 입력
        for(int i=0; i<R; i++) {
            String line = br.readLine();
            for(int j=0; j<C; j++) {
                miro[i][j] = line.charAt(j);

                // 사람인 경우
                if(miro[i][j]=='J') {
                    saram.offer(new Node(i,j));
                    miro[i][j]='!';
                }

                // 불인 경우
                if(miro[i][j]=='F') {
                    fire.offer(new Node(i,j));
                }
            }
        }

        // 미로 탈출하기
        answer = -1;
        solve();

        // 결과 출력
        if(answer==-1)
            System.out.println("IMPOSSIBLE");
        else
            System.out.println(answer+1);
    }
}