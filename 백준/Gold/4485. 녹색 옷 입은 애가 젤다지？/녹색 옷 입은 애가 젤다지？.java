import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

// 노드 클래스
class Node implements Comparable<Node> {
    int y;
    int x;
    int money;

    public Node(int y, int x, int money) {
        this.y = y;
        this.x = x;
        this.money = money;
    }

    public int compareTo(Node other) {
        return this.money-other.money;
    }
}

public class Main {

    // 루피 무한 설정
    public static final int MAX = (int)1e9;

    // 동굴의 크기
    public static int size;

    // 동굴
    public static int map[][];

    // 네 방향 벡터
    public static int dy[] = {0,1,0,-1};
    public static int dx[] = {1,0,-1,0};

    // 최소 비용 배열
    public static int path[][];

    // 동굴 탐색 메서드
    static void solve() {

        // 노드 저장 우선 순위 큐
        PriorityQueue<Node> queue = new PriorityQueue<>();

        // 첫 노드 처리
        path[0][0] = map[0][0];
        queue.offer(new Node(0,0,path[0][0]));

        // 탐색 수행
        while(!queue.isEmpty()) {

            // 현재 노드
            Node current = queue.poll();

            // 네 방향 확인
            for(int d=0; d<4; d++) {
                int ny = current.y + dy[d];
                int nx = current.x + dx[d];

                // 범위 확인
                if(ny<0 || ny>size-1 || nx<0 || nx>size-1) continue;

                // 이미 방문한 경우
                if(path[ny][nx]!=MAX) continue;

                // 탐색 할 노드로 추가
                if(path[ny][nx]>path[current.y][current.x]+map[ny][nx]) {
                    path[ny][nx] = path[current.y][current.x]+map[ny][nx];
                    queue.offer(new Node(ny,nx,path[ny][nx]));
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        // 케이스 수
        int caseNum = 1;

        // 케이스 반복 수행
        while(true) {

            // 동굴 크기 입력
            size = Integer.parseInt(br.readLine());

            // 크기가 0인 경우
            if(size==0) break;

            // 동굴 생성
            map = new int[size][size];

            // 최단 경로 배열 생성
            path = new int[size][size];

            // 동굴 정보 입력
            for(int i=0; i<size;i++) {
                st = new StringTokenizer(br.readLine());
                for(int j=0; j<size; j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());
                    path[i][j] = MAX;
                }
            }

            // 동굴 탐색
            solve();

            // 결과 저장
            sb.append("Problem ").append(caseNum).append(": ")
                    .append(path[size-1][size-1]).append("\n");

            // 케이스 수 증가
            caseNum++;
        }

        // 결과 출력
        System.out.println(sb.toString());
    }
}