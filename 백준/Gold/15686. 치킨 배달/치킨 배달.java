import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

// 위치 클래스
class Node {
    int y;
    int x;

    public Node(int y, int x) {
        this.y = y;
        this.x = x;
    }
}

public class Main {

    // 맵 크기, 남길 점포 수, 현재 점포 수, 페점 수, 결과
    public static int mapSize, storeCnt, currentStoreCnt, closedStoreCnt, answer;

    // 맵
    public static int map[][];

    // 치킨 점포, 집 위치 리스트
    public static ArrayList<Node> store;
    public static ArrayList<Node> home;

    // 치킨 점포 페점 배열
    public static int closedStore[];

    // 네 방향 벡터
    public static int dy[] = {0,1,0,-1};
    public static int dx[] = {1,0,-1,0};

    // 치킨 거리 찾기 메서드
    static int searchStore(int y, int x) {

        // 최단 거리를 위한 큐 생성
        Queue<Node> queue = new LinkedList<>();

        // 방문 여부를 위한 배열 생성
        boolean visited[][] = new boolean[mapSize][mapSize];

        // 첫 노드 처리
        queue.offer(new Node(y,x));
        visited[y][x] = true;

        // 탐색 깊이, 거리
        int size = 0;
        int dist = 0;

        // 점포 탐색
        while(!queue.isEmpty()) {

            // 깊이 측정
            size = queue.size();

            // 깊이 만큼 수행
            for(int s=0; s<size; s++) {

                // 현재 탐색 위치
                Node currentPoint = queue.poll();

                // 치킨 점포인 경우
                if(map[currentPoint.y][currentPoint.x]==2)
                    return dist;

                // 네 방향 탐색
                for(int d=0; d<4; d++) {
                    int ny = currentPoint.y+dy[d];
                    int nx = currentPoint.x+dx[d];

                    // 범위를 벗어난 경우
                    if(ny<0 || ny>mapSize-1 || nx<0 || nx>mapSize-1) continue;

                    // 이미 방문한 경우
                    if(visited[ny][nx]) continue;

                    // 방문하지 않은 곳인 경우
                    queue.offer(new Node(ny,nx));
                    visited[ny][nx] = true;
                }
            }

            // 깊이 증가
            dist++;
        }

        return -1;
    }

    // 폐점 선택하기 메서드
    static void solve(int idx, int cnt) {

        // 폐점할 곳을 다 선택한 경우
        if(cnt==closedStoreCnt) {

            // 폐점 시키기
            for(int i=0; i<closedStoreCnt; i++) {
                int point = closedStore[i];
                Node storePoint = store.get(point);
                map[storePoint.y][storePoint.x] = 0;
            }

            // 치킨 거리 구하기
            int dist = 0;
            for(int i=0; i<home.size(); i++) {
                Node homePoint = home.get(i);
                dist += searchStore(homePoint.y,homePoint.x);
            }

            // 결과 갱신
            answer = Math.min(answer,dist);

            // 다시 되돌리기
            for(int i=0; i<closedStoreCnt; i++) {
                int point = closedStore[i];
                Node storePoint = store.get(point);
                map[storePoint.y][storePoint.x] = 2;
            }

            return;
        }

        // 아닌 경우
        for(int i=idx; i<currentStoreCnt; i++) {
            closedStore[cnt] = i;
            solve(i+1,cnt+1);
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        // 맵 크기, 남길 점포 수 입력
        st = new StringTokenizer(br.readLine());
        mapSize = Integer.parseInt(st.nextToken());
        storeCnt = Integer.parseInt(st.nextToken());

        // 치킨 점포, 집 리스트 생성
        store = new ArrayList<>();
        home = new ArrayList<>();

        // 맵 생성
        map = new int[mapSize][mapSize];

        // 맵 정보 입력
        currentStoreCnt = 0;
        for(int i=0; i<mapSize; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<mapSize; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());

                // 치킨 점포인 경우
                if(map[i][j]==2) {
                    store.add(new Node(i,j));
                    currentStoreCnt++;
                }

                // 집인 경우
                if(map[i][j]==1)
                    home.add(new Node(i,j));
            }
        }

        // 페점 점포 수
        closedStoreCnt = currentStoreCnt-storeCnt;

        // 치킨 점포 페점 배열 생성
        closedStore = new int[closedStoreCnt];

        // 폐점 선택하기
        answer = Integer.MAX_VALUE;
        solve(0,0);

        // 결과 출력
        System.out.println(answer);
    }
}