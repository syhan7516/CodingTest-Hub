
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

// 노드 클래스
class Node {
    private int y;
    private int x;
    private int cost;
    private int key;

    public Node(int y, int x, int cost, int key) {
        this.y = y;
        this.x = x;
        this.cost = cost;
        this.key = key;
    }

    public int getY() {
        return this.y;
    }

    public int getX() {
        return this.x;
    }

    public int getCost() {
        return this.cost;
    }

    public int getKey() {
        return this.key;
    }
}

public class Main {

    // 미로 가로, 세로 크기
    public static int rowSize, colSize;
    // 미로
    public static char miro[][];
    public static boolean vistited[][][];
    // 미로 큐
    public static Queue<Node> nodes;
    // 방향 벡터
    public static int dy[] = {0,1,0,-1};
    public static int dx[] = {1,0,-1,0};
    // 결과
    public static int result;

    // 미로 탐색 수행
    static void bfs() {

        // 미로 탐색
        while(!nodes.isEmpty()) {
            // 현재 위치
            Node curNode = nodes.poll();
            int curY = curNode.getY();
            int curX = curNode.getX();
            int curCost = curNode.getCost();
            int curKey = curNode.getKey();

            // 도착지인 경우
            if(miro[curY][curX]=='1') {
                result = curCost;
                return;
            }

            // 주위 탐색
            for(int dir=0; dir<4; dir++) {
                int nextY = curY+dy[dir];
                int nextX = curX+dx[dir];
                // 범위 확인
                if(nextY<0 || nextY>rowSize-1 || nextX<0 || nextX>colSize-1)
                    continue;
                // 벽 확인
                if(miro[nextY][nextX]=='#') continue;
                // 방문 여부 확인
                if(vistited[nextY][nextX][curKey]) continue;

                // 열쇠인 경우
                if(miro[nextY][nextX]>='a' && miro[nextY][nextX]<='f') {
                    int nextK = 1<<(miro[nextY][nextX]-'a');
                    nextK = curKey|nextK;
                    vistited[nextY][nextX][nextK] = true;
                    nodes.offer(new Node(nextY,nextX,curCost+1,nextK));
                }
                // 문인 경우
                else if(miro[nextY][nextX]>='A' && miro[nextY][nextX]<='F') {
                    if((curKey&1<<(miro[nextY][nextX]-'A'))==(int)Math.pow(2,miro[nextY][nextX]-'A')) {
                        vistited[nextY][nextX][curKey] = true;
                        nodes.offer(new Node(nextY,nextX,curCost+1,curKey));
                    }
                }
                // 일반적인 길인 경우
                else {
                    vistited[nextY][nextX][curKey] = true;
                    nodes.offer(new Node(nextY,nextX,curCost+1,curKey));
                }
            }
        }

        result = -1;
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        // 미로 크기 입력
        st = new StringTokenizer(br.readLine());
        rowSize = Integer.parseInt(st.nextToken());
        colSize = Integer.parseInt(st.nextToken());

        // 미로 만들기
        miro = new char[rowSize][colSize];
        vistited = new boolean[rowSize][colSize][64];
        nodes = new LinkedList<>();


        // 미로 정보 입력
        for(int r=0; r<rowSize; r++) {
            String line = br.readLine();
            for(int c=0; c<colSize; c++) {
                miro[r][c] = line.charAt(c);
                // 현재 위치 저장
                if(miro[r][c]=='0') {
                    nodes.offer(new Node(r,c,0,0));
                    vistited[r][c][0] = true;
                }
            }
        }

        // 미로 탐색
        result = 0;
        bfs();

        // 결과 출력
        System.out.println(result);
    }
}