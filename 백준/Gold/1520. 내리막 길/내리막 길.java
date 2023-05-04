
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    // 지도 가로, 세로 크기
    public static int rowSize, colSize;

    // 지도
    public static int graph[][];
    public static int path[][];
    public static boolean visited[][];

    // 방향 벡터
    public static int dy[] = {0,1,0,-1};
    public static int dx[] = {1,0,-1,0};

    // 지도 탐색 함수
    static void dfs(int row, int col) {

        // 도착지인 경우
        if(row==rowSize-1 && col==colSize-1)
            return;

        // 방문했을 경우
        if(visited[row][col])
            return;

        // 방문 처리
        visited[row][col] = true;

        // 지도 탐색
        for(int dir=0; dir<4; dir++) {
            int nextY = row+dy[dir];
            int nextX = col+dx[dir];

            // 범위를 벗어난 경우
            if(nextY<0 || nextY>rowSize-1 || nextX<0 || nextX>colSize-1)
                continue;
            // 높이가 조건에 맞지 않을 경우
            if(graph[row][col]<=graph[nextY][nextX])
                continue;

            // 다음 경로에 이미 경로가 존재하는 경우
            if(path[nextY][nextX]!=0) {
                path[row][col] += path[nextY][nextX];
                continue;
            }
            // 다음 경로가 처음 방문하는 경우
            else {
                dfs(nextY,nextX);
                path[row][col] += path[nextY][nextX];
            }
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        // 지도의 크기 입력
        st = new StringTokenizer(br.readLine());
        rowSize = Integer.parseInt(st.nextToken());
        colSize = Integer.parseInt(st.nextToken());

        // 지도 만들기
        graph = new int[rowSize][colSize];
        path = new int[rowSize][colSize];
        visited = new boolean[rowSize][colSize];

        // 지도 정보 입력
        for(int a=0; a<rowSize; a++) {
            st = new StringTokenizer(br.readLine());
            for(int b=0; b<colSize; b++) {
                graph[a][b] = Integer.parseInt(st.nextToken());
            }
        }

        // 지도 탐색 수행
        path[rowSize-1][colSize-1] = 1;
        dfs(0,0);

        // 결과 출력
        System.out.println(path[0][0]);
    }
}