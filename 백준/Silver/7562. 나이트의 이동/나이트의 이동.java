import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

// 노드 클래스
class Node {
    private int y;
    private int x;

    public Node(int y, int x) {
        this.y = y;
        this.x = x;
    }

    public int getY() {
        return y;
    }
    public int getX() {
        return x;
    }
}

public class Main {

    // 체스판 크기
    public static int boardSize;
    // 체스판
    public static int board[][];
    // 출발점 위치
    public static int startY;
    public static int startX;
    // 도착점 위치
    public static int destY;
    public static int destX;
    // 방향 벡터
    public static int dy[] = {2,1,-1,-2,-2,-1,1,2};
    public static int dx[] = {1,2,2,1,-1,-2,-2,-1};

    // 탐색 수행 함수
    static void bfs() {
        Queue<Node> nodes = new LinkedList<>();
        nodes.offer(new Node(startY,startX));
        board[startY][startX] = 1;

        while(!nodes.isEmpty()) {
            Node curNode = nodes.poll();
            int curY = curNode.getY();
            int curX = curNode.getX();

            // 주위 방향 확인
            for(int dir=0; dir<8; dir++) {
                int nextY = curY+dy[dir];
                int nextX = curX+dx[dir];

                // 범위 확인
                if(nextY<0 || nextY>boardSize-1 || nextX<0 || nextX>boardSize-1)
                    continue;

                // 방문 여부
                if(board[nextY][nextX]!=0)
                    continue;

                // 움직임 횟수 저장
                board[nextY][nextX] = board[curY][curX]+1;

                // 도착점 위치일 경우
                if(nextY==destY && nextX==destX) return;

                // 경로 추가
                nodes.offer(new Node(nextY,nextX));
            }
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        // 테스트 케이스 수 입력
        int caseNum = Integer.parseInt(br.readLine());

        // 케이스 수만큼 수행
        for(int caseIdx=0; caseIdx<caseNum; caseIdx++) {

            // 체스판의 크기 입력
            boardSize = Integer.parseInt(br.readLine());
            // 체스판 만들기
            board = new int[boardSize][boardSize];
            // 출발 위치 입력
            st = new StringTokenizer(br.readLine());
            startX = Integer.parseInt(st.nextToken());
            startY = Integer.parseInt(st.nextToken());
            // 목적치 위치 입력
            st = new StringTokenizer(br.readLine());
            destX = Integer.parseInt(st.nextToken());
            destY = Integer.parseInt(st.nextToken());

            // 탐색 수행
            if(startY==destY && startX==destX)
                System.out.println(0);
            else {
                bfs();
                System.out.println(board[destY][destX]-1);
            }
        }
    }
}