import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

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
    // 가로, 세로 크기, 사각형 개수, 영역 수
    public static int rowSize, colSize, squareCnt, count;
    // 현재 탐색 중인 사각형 넓이
    public static int curSafeArea;
    // 영역
    public static int area[][];
    // 방향 벡터
    public static int dx[] = {1,0,-1,0};
    public static int dy[] = {0,1,0,-1};
    // 사각형 넓이 저장 리스트
    public static ArrayList<Integer> result;

    // bfs 함수 정의
    static void bfs(int row, int col) {
        int curArea = 0;
        Queue<AreaNode> nodes = new LinkedList<>();
        nodes.offer(new AreaNode(row,col));
        curArea += 1;
        area[row][col] = curArea;

        while(!nodes.isEmpty()) {
            AreaNode curNode = nodes.poll();
            int curY = curNode.getY();
            int curX = curNode.getX();

            for(int dir=0; dir<4; dir++) {
                int nextY = curY + dy[dir];
                int nextX = curX + dx[dir];

                // 탐색 제한 조건
                if(nextY<0 || nextY>rowSize-1 || nextX<0 || nextX>colSize-1 || area[nextY][nextX]!=0)
                    continue;

                nodes.offer(new AreaNode(nextY,nextX));
                curArea += 1;
                area[nextY][nextX] = curArea;
            }
        }

        // 결과 저장
        result.add(curArea);
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        // 사각형 넓이 저장 리스트
        result = new ArrayList<>();

        // 가로, 세로 크기 & 사각형 개수 입력
        rowSize = Integer.parseInt(st.nextToken());
        colSize = Integer.parseInt(st.nextToken());
        squareCnt = Integer.parseInt(st.nextToken());

        // 사각형 정보 입력
        area = new int[rowSize][colSize];
        for(int s=0; s<squareCnt; s++) {
            st = new StringTokenizer(br.readLine());
            int startCol = Integer.parseInt(st.nextToken());
            int startRow = Integer.parseInt(st.nextToken());
            int endCol = Integer.parseInt(st.nextToken());
            int endRow = Integer.parseInt(st.nextToken());

            for(int r=endRow-1; r>=startRow; r--) {
                for(int c=startCol; c<endCol; c++) {
                    area[r][c] = 1;
                }
            }
        }

        // // 분리 영역 구하기
        count = 0;
        for(int a=rowSize-1; a>=0; a--) {
            for(int b=0; b<colSize; b++) {
                // 빈 공간을 발견한 경우
                if(area[a][b]==0) {
                    bfs(a,b);
                    count++;
                }
            }
        }

        // 결과 출력
        System.out.println(count);
        Collections.sort(result);
        for(int element: result)
            System.out.print(element+" ");
    }
}