import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

// 노드 클래스
class Node implements Comparable<Node> {
    int y;
    int x;
    int room;

    public Node(int y, int x, int room) {
        this.y = y;
        this.x = x;
        this.room = room;
    }

    public int compareTo(Node other) {
        return this.room-other.room;
    }
}

public class Main {

    // 방의 크기, 결과
    public static int size, answer;

    // 방
    public static int room[][];

    // 방문 여부 배열
    public static boolean visited[][][];

    // 네 방향 벡터
    public static int dy[] = {0,1,0,-1};
    public static int dx[] = {1,0,-1,0};

    // 방 탈출하기 메서드
    static void solve() {

        // 노드를 저장을 위한 우선 순위 큐 생성
        PriorityQueue<Node> queue = new PriorityQueue<>();

        // 첫 노드 처리
        queue.offer(new Node(0,0,0));
        visited[0][0][0] = true;

        // 미로 탐색 수행
        while(!queue.isEmpty()) {

            // 탐색 노드 가져오기
            Node current = queue.poll();

            // 해당 노드가 도착점인 경우
            if(current.y==size-1 && current.x==size-1) {
                answer = current.room;
                return;
            }

            // 네 방향 탐색
            for(int d=0; d<4; d++) {
                int ny = current.y+dy[d];
                int nx = current.x+dx[d];

                // 범위 확인
                if(ny<0 || ny>size-1 || nx<0 || nx>size-1) continue;

                // 어두운 방인 경우
                if(room[ny][nx]==0) {

                    // 이미 방문한 경우
                    if(visited[current.room+1][ny][nx]) continue;

                    // 어두운 방 방문한 상태 방문 처리
                    visited[current.room+1][ny][nx] = true;

                    // 큐에 추가
                    queue.offer(new Node(ny,nx,current.room+1));
                }

                // 밝은 방인 경우
                else {

                    // 이미 방문한 경우
                    if(visited[current.room][ny][nx]) continue;

                    // 밝은 방 방문한 상태 방문 처리
                    visited[current.room][ny][nx] = true;

                    // 큐에 추가
                    queue.offer(new Node(ny,nx,current.room));
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 방 크기 입력
        size = Integer.parseInt(br.readLine());

        // 방 생성
        room = new int[size][size];
        visited = new boolean[size*size][size][size];

        // 방 정보 입력
        for(int i=0; i<size; i++) {
            String line = br.readLine();
            for(int j=0; j<size; j++) {
                room[i][j] = line.charAt(j)-'0';
            }
        }

        // 방 탈출하기
        answer = 0;
        solve();

        // 결과 출력
        System.out.println(answer);
    }
}