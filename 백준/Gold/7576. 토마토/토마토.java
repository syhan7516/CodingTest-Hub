import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Node {
    private int x;
    private int y;

    public Node(int y, int x) {
        this.y = y;
        this.x = x;
    }

    public int getX() {
        return this.x;
    }

    public int getY() {
        return this.y;
    }
}


public class Main {

    // 상자의 가로, 세로, 날짜, 토마토 개수
    public static int boxRow, boxCol, day, tomato, tomatoCnt, goodTomato;
    // 상자
    public static int box[][];
    // 큐
    public static Queue<Node> queue = new LinkedList<Node>();
    // 방향 벡터
    public static int dx[] = {1,0,-1,0};
    public static int dy[] = {0,1,0,-1};

    // dfs
    static void bfs() {
        tomatoCnt = 0;
        while(!queue.isEmpty()) {
            Node node = queue.poll();
            int nodeX = node.getX();
            int nodeY = node.getY();
            for(int dir=0; dir<4; dir++) {
                int nextX = nodeX + dx[dir];
                int nextY = nodeY + dy[dir];
                if(nextX < 0 || nextX > boxCol-1 || nextY < 0 || nextY > boxRow-1 || box[nextY][nextX] != 0)
                    continue;

                // 익힘 처리 & 개수 세기 & 큐에 넣기
                box[nextY][nextX] = box[nodeY][nodeX]+1;
                day = box[nextY][nextX];
                tomatoCnt += 1;
                queue.offer(new Node(nextY,nextX));
            }
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        // 가로, 세로 입력
        boxCol = Integer.parseInt(st.nextToken());
        boxRow = Integer.parseInt(st.nextToken());

        // 상자 & 토마토 수 만들기
        tomato = 0;
        box = new int[boxRow][boxCol];
        for(int row=0; row<boxRow; row++) {
            st = new StringTokenizer(br.readLine());
            for(int col=0; col<boxCol; col++) {
                box[row][col] = Integer.parseInt(st.nextToken());

                // 처음 익은 토마토 파악
                if(box[row][col]==1) {
                    queue.offer(new Node(row,col));
                    box[row][col] = 2;
                }

                // 빈 경우
                if(box[row][col]==-1)
                    tomato += 1;
            }
        }

        // 이미 다 익은 경우 O
        goodTomato = queue.size();
        if(boxRow * boxCol == tomato + queue.size()) {
            day = 0;
            System.out.println(day);
        }
        // 이미 다 익은 경우 X
        else {
            tomato = boxRow * boxCol - tomato;
            bfs();

            if(tomatoCnt + goodTomato == tomato)
                System.out.println(day-2);
            else
                System.out.println(-1);
        }
    }
}