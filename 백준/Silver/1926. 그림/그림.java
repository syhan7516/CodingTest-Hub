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

    // 도화지 크기, 결과, 각 그림 크기, 그림 개수
    public static int row, col, answer, imgSize, imgCnt;

    // 도화지
    public static int paper[][];

    // 방향 벡터
    public static int dy[] = {1,0,-1,0};
    public static int dx[] = {0,-1,0,1};

    // 그림 크기 확인 메서드
    static void solve(int a, int b) {

        // 큐 생성
        Queue<Node> queue = new LinkedList<>();

        // 첫 노드 처리
        queue.offer(new Node(a,b));
        paper[a][b] = 0;
        imgSize++;

        // 탐색 수행
        while(!queue.isEmpty()) {

            // 현재 탐색할 노드
            Node curNode = queue.poll();

            // 네 방향 확인
            for(int d=0; d<4; d++) {
                int ny = curNode.y+dy[d];
                int nx = curNode.x+dx[d];

                // 범위 밖인 경우
                if(ny<0 || ny>row-1 || nx<0 || nx>col-1)
                    continue;

                // 그림이 아닌 경우
                if(paper[ny][nx]!=1)
                    continue;

                // 그림인 경우
                queue.offer(new Node(ny,nx));
                paper[ny][nx] = 0;
                imgSize++;
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        // 도화지 크기 입력
        st = new StringTokenizer(br.readLine());
        row = Integer.parseInt(st.nextToken());
        col = Integer.parseInt(st.nextToken());

        // 도화지 생성
        paper = new int[row][col];

        // 도화지 정보 입력
        for(int i=0; i<row; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<col; j++) {
                paper[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // 도화지 탐색
        answer = 0;
        imgSize = 0;
        imgCnt = 0;

        for(int i=0; i<row; i++) {
            for(int j=0; j<col; j++) {

                // 그림 부분인 경우
                if(paper[i][j]==1) {
                    imgSize = 0;
                    imgCnt++;
                    solve(i,j);
                    answer = Math.max(answer,imgSize);
                }
            }
        }

        // 결과 출력
        System.out.println(imgCnt+"\n"+answer);
    }
}