import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

// 위치 클래스
class Point {
    int y;
    int x;

    public Point(int y, int x) {
        this.y = y;
        this.x = x;
    }
}

public class Main {

    // 결과, 가로, 세로 크기, 배추 개수
    public static int answer, rowSize, colSize, plantCount;

    // 땅 배열
    public static int ground[][];

    // 방향 벡터
    public static int dy[] = {0,1,0,-1};
    public static int dx[] = {1,0,-1,0};

    // 배추 위치 저장 큐
    public static Queue<Point> queue;

    // 방문 여부 배열
    public static boolean visited[][];

    // 지렁이 개수 확인 메서드
    public static void solve(int rowIndex, int colIndex) {

        // 시작점 처리
        visited[rowIndex][colIndex] = true;
        queue.offer(new Point(rowIndex, colIndex));

        // 배추 확인
        while(!queue.isEmpty()) {

            // 확인 배추
            Point point = queue.poll();

            // 네 방향 확인
            for(int dir=0; dir<4; dir++) {
                int nextY = point.y+dy[dir];
                int nextX = point.x+dx[dir];

                // 범위 확인
                if(nextY<0 || nextY>rowSize-1 || nextX<0 || nextX>colSize-1) continue;

                // 이미 방문했거나, 배추가 아닌 경우
                if(visited[nextY][nextX] || ground[nextY][nextX]!=1) continue;

                // 탐색 대상으로 추가
                visited[nextY][nextX] = true;
                queue.offer(new Point(nextY, nextX));
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        // 테스트 케이스 수 입력
        int caseCount = Integer.parseInt(br.readLine());

        // 케이스 수행
        for(int caseIndex=0; caseIndex<caseCount; caseIndex++) {

            // 가로, 세로, 배추 개수 입력
            st = new StringTokenizer(br.readLine());
            rowSize = Integer.parseInt(st.nextToken());
            colSize = Integer.parseInt(st.nextToken());
            plantCount = Integer.parseInt(st.nextToken());

            // 땅 생성
            ground = new int[rowSize][colSize];

            // 배추 위치 입력
            for(int index=0; index<plantCount; index++) {
                st = new StringTokenizer(br.readLine());
                int rowPoint = Integer.parseInt(st.nextToken());
                int colPoint = Integer.parseInt(st.nextToken());
                ground[rowPoint][colPoint] = 1;
            }

            // 방문 여부 배열 생성
            visited = new boolean[rowSize][colSize];

            // 배추 위치 저장 큐 생성
            queue = new LinkedList<>();

            // 지렁이 개수 확인
            answer = 0;
            for(int rowIndex=0; rowIndex<rowSize; rowIndex++) {
                for(int colIndex=0; colIndex<colSize; colIndex++) {
                    if(!visited[rowIndex][colIndex] && ground[rowIndex][colIndex]==1) {
                        answer++;
                        solve(rowIndex,colIndex);
                    }
                }
            }
            sb.append(answer).append("\n");
        }

        // 결과 출력
        System.out.println(sb.toString());
    }
}