import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

// 노드 클래스
class Node implements Comparable<Node> {
    int y;
    int x;
    int time;

    public Node(int y, int x, int time) {
        this.y = y;
        this.x = x;
        this.time = time;
    }

    @Override
    public int compareTo(Node other) {
        return this.time - other.time;
    }
}

public class Main {

    // 클링온 개수, 가로, 세로 크기, 시작 위치
    public static int klingonCount,rowSize, colSize, startY, startX;

    // 맵
    public static int[][] map;

    // 방문 여부 배열
    public static boolean[][] visited;

    // 클링온 배열
    public static int[] klingons;

    // 방향 벡터
    public static int[] dy = {0,1,0,-1};
    public static int[] dx = {1,0,-1,0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        // 테스트 케이스 수 입력
        int caseCount = Integer.parseInt(br.readLine());

        // 케이스 수행
        for(int caseNum=0; caseNum<caseCount; caseNum++) {
            st = new StringTokenizer(br.readLine());
            klingonCount = Integer.parseInt(st.nextToken());
            colSize = Integer.parseInt(st.nextToken());
            rowSize = Integer.parseInt(st.nextToken());

            // 클링온 배열 생성
            klingons = new int[26];

            // 클링온 정보 입력
            for(int klingon=0; klingon<klingonCount; klingon++) {
                st = new StringTokenizer(br.readLine());
                char alpha = st.nextToken().charAt(0);
                int time = Integer.parseInt(st.nextToken());
                klingons[alpha-'A'] = time;
            }

            // 맵 생성
            map = new int[rowSize][colSize];

            // 맵 정보 입력
            for(int rowIndex=0; rowIndex<rowSize; rowIndex++) {
                String line = br.readLine();
                for(int colIndex=0; colIndex<colSize; colIndex++) {
                    char alpha = line.charAt(colIndex);
                    map[rowIndex][colIndex] = klingons[alpha-'A'];
                    if(alpha == 'E') {
                        startY = rowIndex;
                        startX = colIndex;
                    }
                }
            }

            // 우선 순위 큐 생성
            PriorityQueue<Node> queue = new PriorityQueue<Node>();

            // 방문 여부 배열 생성
            visited = new boolean[rowSize][colSize];

            // 시작 지점 처리
            queue.offer(new Node(startY, startX, 0));

            // 탐색
            while(!queue.isEmpty()) {

                // 현재 위치
                Node node = queue.poll();

                // 탈출한 경우
                if(node.y == 0 || node.x == 0 || node.y == rowSize - 1 || node.x == colSize - 1) {
                    sb.append(node.time).append("\n");
                    break;
                }

                // 이미 방문한 경우
                if(visited[node.y][node.x]) continue;

                // 방문 처리
                visited[node.y][node.x] = true;

                // 이동 가능한 구간 확인
                for(int dir=0; dir<4; dir++) {
                    int nextY = node.y + dy[dir];
                    int nextX = node.x + dx[dir];

                    // 범위 확인
                    if(nextY < 0 || nextY > rowSize-1 || nextX < 0 || nextX > colSize-1) continue;

                    // 방문 여부 확인
                    if(visited[nextY][nextX]) continue;

                    // 이동
                    queue.offer(new Node(nextY, nextX, node.time + map[nextY][nextX]));
                }
            }
        }

        // 결과 출력
        System.out.println(sb.toString());
    }
}