import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Node {
    int y;
    int x;

    public Node(int y, int x) {
        this.y = y;
        this.x = x;
    }
}

public class Main {

    // 밭의 가로, 세로 길이, 배추의 수, 결과
    public static int row,col,cnt,answer;

    // 밭
    public static int ground[][];

    // 방향 벡터
    public static int dy[] = {1,0,-1,0};
    public static int dx[] = {0,-1,0,1};

    // 벌레 이동 메서드
    static void solve(int r, int c) {

        // 이동 큐 생성
        Queue<Node> queue = new LinkedList<>();

        // 첫 노드 처리
        queue.offer(new Node(r,c));
        ground[r][c] = 0;

        // 벌레 버뜨리기
        while(!queue.isEmpty()) {

            // 현재 노드
            Node curNode = queue.poll();

            // 네방향 탐색
            for(int d=0; d<4; d++) {
                int ny = curNode.y+dy[d];
                int nx = curNode.x+dx[d];

                // 범위를 넘은 경우
                if(ny<0 || ny>row-1 || nx<0 || nx>col-1)
                    continue;

                // 배추가 아닌 경우
                if(ground[ny][nx]!=1)
                    continue;

                // 배추인 경우
                queue.offer(new Node(ny,nx));
                ground[ny][nx] = 0;
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        // 테스트 케이스 수 입력
        int caseNum = Integer.parseInt(br.readLine());

        // 케이스 수 만큼 수행
        for(int caseIdx=0; caseIdx<caseNum; caseIdx++) {

            // 가로, 세로, 배추 수 입력
            st = new StringTokenizer(br.readLine());
            row = Integer.parseInt(st.nextToken());
            col = Integer.parseInt(st.nextToken());
            cnt = Integer.parseInt(st.nextToken());

            // 밭 만들기
            ground = new int[row][col];

            // 배추 위치 정보 입력
            for(int i=0; i<cnt; i++) {
                st = new StringTokenizer(br.readLine());
                int y = Integer.parseInt(st.nextToken());
                int x = Integer.parseInt(st.nextToken());
                ground[y][x] = 1;
            }

            // 벌레 심기
            answer = 0;

            for(int i=0; i<row; i++) {
                for(int j=0; j<col; j++) {

                    // 방문하지 않은 배추인 경우
                    if(ground[i][j]==1) {
                        answer++;
                        solve(i,j);
                    }
                }
            }

            // 결과 출력
            System.out.println(answer);
        }
    }
}