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

    public Node(int h, int y, int x) {
        this.h = h;
        this.y = y;
        this.x = x;
    }
}

public class Main {

    // 상자의 크기, 토마토 전체 개수, 결과
    public static int M, N, H, tomatoCnt, answer;

    // 상자
    public static int box[][][];

    // 토마토 큐
    public static Queue<Node> queue;

    // 방향 벡터
    public static int dy[] = {1,0,-1,0,0,0};
    public static int dx[] = {0,-1,0,1,0,0};
    public static int dh[] = {0,0,0,0,1,-1};

    // 토마토 익히기 메서드
    static void solve() {

        // 일 수
        int day = 0;

        // 토마토 익히기
        while(!queue.isEmpty()) {

            // 일 수 증가
            day++;

            // 하루치 토마토 수 체크
            int size = queue.size();

            // 하루치 토마토 익히기
            while(size-->0) {

                // 현재 기준 토마토
                Node curNode = queue.poll();

                // 여섯 방향 확인
                for(int d=0; d<6; d++) {
                    int ny = curNode.y+dy[d];
                    int nx = curNode.x+dx[d];
                    int nh = curNode.h+dh[d];

                    // 범위를 벗어나 경우
                    if(ny<0 || ny>N-1 || nx<0 || nx>M-1 || nh<0 || nh>H-1)
                        continue;

                    // 토마토가 이미 익었거나, 텅 빈 경우
                    if(box[nh][ny][nx]==1 || box[nh][ny][nx]==-1)
                        continue;

                    // 토마토가 익지 않은 경우
                    queue.offer(new Node(nh,ny,nx));
                    box[nh][ny][nx] = -1;
                    tomatoCnt--;

                    // 토마토가 다 익은 경우
                    if(tomatoCnt==0) {
                        answer = day;
                        return;
                    }
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        // 상자의 크기 입력
        st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        H = Integer.parseInt(st.nextToken());

        // 상자 생성
        box = new int[H][N][M];

        // 토마토 큐 생성
        queue = new LinkedList<>();

        // 토마토 정보 입력
        tomatoCnt = 0;
        answer = 0;

        for(int i=0; i<H; i++) {
            for(int j=0; j<N; j++) {
                st = new StringTokenizer(br.readLine());
                for(int k=0; k<M; k++) {
                    box[i][j][k] = Integer.parseInt(st.nextToken());

                    // 만약 익지 않은 토마토인 경우
                    if(box[i][j][k]==0) {
                        tomatoCnt++;
                    }

                    // 만약 익은 토마토인 경우
                    if(box[i][j][k]==1) {
                        queue.offer(new Node(i,j,k));
                        box[i][j][k] = -1;
                    }
                }
            }
        }

        // 토마토 익히기
        solve();

        // 토마토가 남은 경우
        if(tomatoCnt!=0)
            answer = -1;

        // 결과 출력
        System.out.println(answer);
    }
}