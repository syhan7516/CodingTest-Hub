import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class AreaNode {
    private int y;
    private int x;

    public AreaNode(int y, int x) {
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

public class Main {
    // 영역의 크기, 비의 양
    public static int areaSize, rainHeight;
    // 최대 안전 영역 수, 현재 안전 영역 수
    public static int maxSafeArea, curSafeArea;
    // 영역
    public static int area[][];
    // 방문 영역 배열
    public static boolean visited[][];
    // 방향 벡터
    public static int dx[] = {1,0,-1,0};
    public static int dy[] = {0,1,0,-1};

    // bfs 함수 정의
    static void bfs(int row, int col) {
        Queue<AreaNode> nodes = new LinkedList<>();
        nodes.offer(new AreaNode(row,col));
        visited[row][col] = true;

        // 영역 덩어링 만들기
        while(!nodes.isEmpty()) {

            // 검사 기준 영역
            AreaNode curNode = nodes.poll();
            int curY = curNode.getY();
            int curX = curNode.getX();

            // 탐색 범위 제한 조건
            for(int dir=0; dir<4; dir++) {
                int nextY = curY + dy[dir];
                int nextX = curX + dx[dir];

                // 영역 범위를 자체를 벗어난 경우
                if(nextX<0 || nextX>areaSize-1 || nextY<0 || nextY>areaSize-1)
                    continue;
                
                // 영역이 잠긴 경우, 이미 방문한 경우
                if(rainHeight>=area[nextY][nextX] || visited[nextY][nextX])
                    continue;

                // 탐색 조건에 부합하는 영역 추가
                nodes.offer(new AreaNode(nextY,nextX));
                visited[nextY][nextX] = true;
            }
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        // 영역의 크기 입력
        areaSize = Integer.parseInt(br.readLine());

        // 영역의 높이 정보 입력
        int minRain = 101;
        int maxRain = -1;
        area = new int[areaSize][areaSize];
        for(int row=0; row<areaSize; row++) {
            st = new StringTokenizer(br.readLine());
            for(int col=0; col<areaSize; col++) {
                area[row][col] = Integer.parseInt(st.nextToken());
                minRain = Math.min(minRain,area[row][col]);
                maxRain = Math.max(maxRain,area[row][col]);
            }
        }

        // 비의 양 늘리면서 영역 확인
        rainHeight = minRain;
        maxSafeArea = 0;
        while(minRain!=maxRain) {

            // 종료 조건
            if(rainHeight==maxRain)
                break;

            // 안전 영역 확인
            curSafeArea = 0;
            visited = new boolean[areaSize][areaSize];
            for(int a=0; a<areaSize; a++) {
                for(int b=0; b<areaSize; b++) {
                    // 탐색 조건
                    if(area[a][b]>rainHeight && !visited[a][b]) {
                        bfs(a,b);
                        curSafeArea += 1;
                    }
                }
            }

            // 안전 영역 갱신
            maxSafeArea = Math.max(maxSafeArea,curSafeArea);

            // 비의 양 늘리기
            rainHeight++;
        }

        // 결과 출력
        if(minRain==maxRain)
            System.out.println(1);
        else
            System.out.println(maxSafeArea);
    }
}