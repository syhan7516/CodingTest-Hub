import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

// 노드 클래스
class Node implements Comparable<Node> {
    private int y;
    private int x;
    private int value;

    public Node(int y, int x, int value) {
        this.y = y;
        this.x = x;
        this.value = value;
    }

    public int getY() {
        return y;
    }

    public int getX() {
        return x;
    }

    public int getValue() {
        return value;
    }

    public int compareTo(Node other) {

        // 비용이 적은 순으로 정렬
        if(this.value<other.value)
            return -1;
        return 1;
    }
}

public class Solution {

    // 지도 크기
    public static int mapSize;
    // 지도, 최단 경로 정보 지도
    public static int[][] map, DP;
    // 경로 최대값
    public static int MAX = (int)1e9;
    // 우선 순위 큐
    public static PriorityQueue<Node> priQ;
    // 방향 벡터
    public static int dy[] = {0,1,0,-1};
    public static int dx[] = {1,0,-1,0};

    // 최단 경로 구하기 함수
    static void solve(int row, int col, int value) {

        // 우선 순위 큐 만들기
        priQ = new PriorityQueue<>();

        // 시작점 처리
        priQ.offer(new Node(row,col,value));

        // 탐색 시작
        while(!priQ.isEmpty()) {

            // 현재 경로
            Node curNode = priQ.poll();
            int curRow = curNode.getY();
            int curCol = curNode.getX();
            int curValue = curNode.getValue();

            // 주위 탐색
            for(int dir=0; dir<4; dir++) {
                int nextY = curRow+dy[dir];
                int nextX = curCol+dx[dir];

                // 진행 방향 범위 확인
                if(nextY<0 || nextY>mapSize-1 || nextX<0 || nextX>mapSize-1)
                    continue;

                // 진행 경로 비용
                int nextValue = curValue+map[nextY][nextX];

                // 경로 갱신 여부 확인
                if(DP[nextY][nextX]>nextValue) {
                    DP[nextY][nextX] = nextValue;
                    priQ.offer(new Node(nextY,nextX,nextValue));
                }
            }
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        // 테스트 케이스 수 입력
        int caseNum = Integer.parseInt(br.readLine());

        // 케이스 수만큼 수행
        for(int caseIdx=0; caseIdx<caseNum; caseIdx++) {

            // 지도 크기 입력
            mapSize = Integer.parseInt(br.readLine());

            // 지도 만들기
            map = new int[mapSize][mapSize];
            DP = new int[mapSize][mapSize];

            // 지도 정보 입력
            for(int a=0; a<mapSize; a++) {
                String line = br.readLine();
                for(int b=0; b<mapSize; b++) {
                    map[a][b] = line.charAt(b)-'0';
                    DP[a][b] = MAX;
                }
            }

            // 최단 경로 구하기
            solve(0,0,0);

            // 결과 저장
            sb.append("#"+(caseIdx+1)+" "+DP[mapSize-1][mapSize-1]+"\n");
        }

        // 결과 출력
        System.out.println(sb.toString());
    }
}