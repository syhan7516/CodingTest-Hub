import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

// 동굴 노드 클래스
class caveNode implements Comparable<caveNode> {
    private int y;
    private int x;
    private int money;

    public caveNode(int y, int x, int money) {
        this.y = y;
        this.x = x;
        this.money = money;
    }

    public int getY() {
        return this.y;
    }

    public int getX() {
        return this.x;
    }

    public int getMoney() {
        return this.money;
    }

    public int compareTo(caveNode other) {
        if(this.money < other.money)
            return -1;
        return 1;
    }
}

public class Main {

    // 초기 루피값
    public static int MAX_MONEY = Integer.MAX_VALUE;
    // 동굴 크기, 결과
    public static int caveSize;
    // 동굴
    public static int cave[][];
    // 주머니 배열
    public static int bag[][];
    // 방향 벡터
    public static int dx[] = {1,0,-1,0};
    public static int dy[] = {0,1,0,-1};

    // 다익스트라
    static void dijistra(int row, int col) {
        // 우선 순위 큐
        PriorityQueue<caveNode> nodes = new PriorityQueue<>();
        // 시작 지점 주머니
        bag[row][col] = cave[row][col];
        nodes.offer(new caveNode(row,col,bag[row][col]));
        
        while(!nodes.isEmpty()) {
            caveNode curNode = nodes.poll();
            int curY = curNode.getY();
            int curX = curNode.getX();
            int curMoney = curNode.getMoney();

            // 네 방향 확인
            for(int d=0; d<4; d++) {
                int nextY = curY + dy[d];
                int nextX = curX + dx[d];
                // 방향 제한
                if(nextY<0 || nextY>caveSize-1 || nextX<0 || nextX>caveSize-1)
                    continue;

                // 다음 이동할 위치의 기존 잃었던 돈의 값 보다 
                // 현재 잃은 돈 + 다음 위치에서 잃을 돈이 더 작은 경우
                if(bag[nextY][nextX]>cave[nextY][nextX]+curMoney) {
                    bag[nextY][nextX] = cave[nextY][nextX]+curMoney;
                    // 갱신된 위치에서 잃은 돈 및 위치 큐에 저장
                    nodes.offer(new caveNode(nextY,nextX,bag[nextY][nextX]));
                }
            }
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        // 동굴 크기 초기값
        caveSize = -1;

        // 케이스 수
        int caseIdx= 0;

        // 반복 수행
        while(true) {

            // 동굴 크기 입력
            caveSize = Integer.parseInt(br.readLine());
            cave = new int[caveSize][caveSize];
            bag = new int[caveSize][caveSize];

            // 종료 조건
            if(caveSize ==0)
                break;

            // 케이스 증가
            caseIdx += 1;

            // 동굴 정보 입력
            for(int row = 0; row< caveSize; row++) {
                st = new StringTokenizer(br.readLine());
                for(int col = 0; col< caveSize; col++) {
                    cave[row][col] = Integer.parseInt(st.nextToken());
                    bag[row][col] = MAX_MONEY;
                }
            }

            // 동굴 탈출
            dijistra(0,0);

            // 결과 출력
            System.out.println("Problem "+(caseIdx)+": "+bag[caveSize-1][caveSize-1]);
        }
    }
}