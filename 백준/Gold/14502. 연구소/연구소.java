import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

// 노드 클래스
class Node {
    int y;
    int x;

    public Node(int y, int x) {
        this.y = y;
        this.x = x;
    }
}

public class Main {

    // 가로, 세로, 전체 칸 수, 결과
    public static int row, col, totalSize, answer;

    // 맵
    public static int map[][];

    // 조합을 위한 배열
    public static int combination[];

    // 바이러스 위치 큐
    public static ArrayList<Node> virus;

    // 네 방향 벡터
    public static int dy[] = {0,1,0,-1};
    public static int dx[] = {1,0,-1,0};

    // 숫자 검증 메서드
    static boolean check() {

        if(combination[0]==combination[1]
                || combination[0]==combination[2]
                || combination[1]==combination[2])
            return false;

        for(int i=0; i<3; i++) {
            int y = combination[i]/col;
            int x = combination[i]%col;
            if(map[y][x]!=0)
                return false;
        }

        return true;
    }

    // 숫자 뽑기 메서드
    static void solve(int idx, int cnt) {

        // 숫자를 다 뽑은 경우
        if(cnt==3) {

            // 숫자 검증
            if(!check()) return;

            // 벽 세우기
            for(int i=0; i<3; i++) {
                int y = combination[i]/col;
                int x = combination[i]%col;
                map[y][x] = 1;
            }

            // 바이러스 퍼뜨리기
            Queue<Node> queue = new LinkedList<>();
            boolean visited[][] = new boolean[row][col];
            for(int v=0; v<virus.size(); v++) {
                queue.offer(virus.get(v));
                visited[virus.get(v).y][virus.get(v).x] = true;
            }

            while(!queue.isEmpty()) {

                // 현재 바이러스 위치
                Node current = queue.poll();

                // 네 방향 확인
                for(int d=0; d<4; d++) {
                    int ny = current.y+dy[d];
                    int nx = current.x+dx[d];

                    // 범위 확인
                    if(ny<0 || ny>row-1 || nx<0 || nx>col-1) continue;

                    // 방문 & 바이러스거나 벽인 경우
                    if(visited[ny][nx] || map[ny][nx]==1) continue;

                    // 바이러스 위치 추가
                    visited[ny][nx] = true;
                    queue.offer(new Node(ny,nx));
                }
            }

            // 안전 구역 확인
            int safeZone = 0;
            for(int i=0; i<row; i++) {
                for(int j=0; j<col; j++) {
                    if(map[i][j]==0 && !visited[i][j])
                        safeZone++;
                }
            }

            // 최대 안정 영역 갱신
            answer = Math.max(answer,safeZone);

            // 벽 제거
            for(int i=0; i<3; i++) {
                int y = combination[i]/col;
                int x = combination[i]%col;
                map[y][x] = 0;
            }

            return;
        }

        // 숫자를 덜 뽑은 경우
        for(int i=idx; i<totalSize; i++) {
            combination[cnt] = i;
            solve(i+1,cnt+1);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        // 가로, 세로 입력
        st = new StringTokenizer(br.readLine());
        row = Integer.parseInt(st.nextToken());
        col = Integer.parseInt(st.nextToken());

        // 맵 생성
        map = new int[row][col];

        // 맵 정보 입력
        virus = new ArrayList<>();
        for(int i=0; i<row; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<col; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if(map[i][j]==2) virus.add(new Node(i,j));
            }
        }

        // 숫자 뽑기
        totalSize = row*col;
        answer = 0;
        combination = new int[3];
        solve(0,0);

        // 결과 출력
        System.out.println(answer);
    }
}