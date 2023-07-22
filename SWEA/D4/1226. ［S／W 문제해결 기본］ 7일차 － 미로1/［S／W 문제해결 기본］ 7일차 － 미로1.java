import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

// 노드 클래스
class Node {
    private int y;
    private int x;

    public Node(int y, int x) {
        this.y = y;
        this.x = x;
    }

    public int getY() {
        return this.y;
    }

    public int getX() {
        return this.x;
    }
}

public class Solution {

    // 보드
    public static char board[][];
    // 보드 크기, 케이스 수
    public static final int SIZE = 16, CASE_NUM = 10;
    // 결과, 출발 좌표
    public static int result, startY, startX;
    // 델타
    public static int dy[] = {0,1,0,-1};
    public static int dx[] = {1,0,-1,0};

    // 미로 탐색하기
    static void solve(int y, int x) {

        // 노드 저장 큐
        Queue<Node> queue = new LinkedList<>();
        // 시작점 저장
        queue.offer(new Node(y,x));
        // 방문 표시
        board[y][x] = '1';

        // 탐색
        while(!queue.isEmpty()) {

            // 현재 노드
            Node curNode = queue.poll();
            int curY = curNode.getY();
            int curX = curNode.getX();

            // 방향 탐색
            for(int d=0; d<4; d++) {
                int ny = curY+dy[d];
                int nx = curX+dx[d];

                // 범위 확인
                if(ny<0 || ny>SIZE-1 || nx<0 || nx>SIZE-1) continue;

                // 벽 확인
                if(board[ny][nx]=='1') continue;

                // 도착점인 경우
                if(board[ny][nx]=='3') {
                    result = 1;
                    return;
                }

                // 노드 저장
                queue.offer(new Node(ny,nx));
                // 방문 표시
                board[ny][nx] = '1';
            }
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        // 케이스 수 만큼 수행
        for(int caseIdx=0; caseIdx<CASE_NUM; caseIdx++) {

            // 케이스 숫자 입력
            br.readLine();

            // 보드 만들기
            board = new char[SIZE][SIZE];
            for(int a=0; a<SIZE; a++) {
                String line = br.readLine();
                for(int b=0; b<SIZE; b++) {
                    board[a][b] = line.charAt(b);

                    // 출발점일 경우
                    if(board[a][b]=='2') {
                        startY = a;
                        startX = b;
                    }
                }
            }

            // 미로 탐색
            result = 0;
            solve(startY,startX);

            // 결과 저장
            sb.append("#"+(caseIdx+1)+" "+result+"\n");
        }

        // 결과 출력
        System.out.println(sb.toString());
    }
}