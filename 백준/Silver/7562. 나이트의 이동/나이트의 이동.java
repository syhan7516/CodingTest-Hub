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
    int cnt;

    public Node(int y, int x, int cnt) {
        this.y = y;
        this.x = x;
        this.cnt = cnt;
    }
}

public class Main {

    // 체스판의 길이, 결과
    public static int boardSize, answer;

    // 목표 위치
    public static int targetY, targetX;

    // 체스판
    public static int board[][];

    // 방향 벡터
    public static int dy[] = {-2,-2,-1,1,2,2,1,-1};
    public static int dx[] = {-1,1,2,2,1,-1,-2,-2};

    // 말 위치 노드 큐
    public static Queue<Node> queue;

    // 말 이동하기 메서드
    static void solve() {

        // 말 이동하기
        while(!queue.isEmpty()) {

            // 현재 위치
            Node curNode = queue.poll();

            // 목표 위치에 도착한 경우
            if(curNode.y==targetY && curNode.x==targetX) {
                answer = curNode.cnt;
                return;
            }

            // 여덟 방향 확인
            for(int d=0; d<8; d++) {
                int ny = curNode.y+dy[d];
                int nx = curNode.x+dx[d];

                // 범위 확인
                if(ny<0 || ny>boardSize-1 || nx<0 || nx>boardSize-1)
                    continue;

                // 이미 방문한 경우
                if(board[ny][nx]==-1)
                    continue;

                // 이동
                queue.offer(new Node(ny,nx, curNode.cnt+1));
                board[ny][nx] = -1;
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        // 테스트 케이스 수 입력
        int caseNum = Integer.parseInt(br.readLine());

        // 케이스 수 만큼 수행
        for(int caseIdx=0; caseIdx<caseNum; caseIdx++) {

            // 큐 생성
            queue = new LinkedList<>();

            // 체스판 크기 입력
            boardSize = Integer.parseInt(br.readLine());

            // 체스판 생성
            board = new int[boardSize][boardSize];

            // 나이트 위치 입력
            st = new StringTokenizer(br.readLine());
            int startY = Integer.parseInt(st.nextToken());
            int startX = Integer.parseInt(st.nextToken());

            queue. offer(new Node(startY, startX,0));
            board[startY][startX] = -1;

            // 목표 위치 입력
            st = new StringTokenizer(br.readLine());
            targetY = Integer.parseInt(st.nextToken());
            targetX = Integer.parseInt(st.nextToken());

            // 말 이동하기
            answer = 0;
            solve();

            // 결과 출력
            System.out.println(answer);
        }
    }
}