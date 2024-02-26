import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

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

    // 가로, 세로, 결과
    public static int rowSize, colSize, answer;

    // 맵
    public static char map[][];

    // 물 위치 저장 큐
    public static Queue<Node> water;

    // 고슴도치 위치 저장 큐
    public static Queue<Node> animal;

    // 네 방향 벡터
    public static int dy[] = {0,1,0,-1};
    public static int dx[] = {1,0,-1,0};

    // 탈출하기 메서드
    static void solve() {

        // 방문 여부 배열 생성
        boolean visited[][] = new boolean[rowSize][colSize];

        // 시작 위치 처리
        visited[animal.peek().y][animal.peek().x] = true;

        // 거리
        int dist = 0;

        // 탈출
        while(!animal.isEmpty()) {

            // 크기 측정
            int waterSize = water.size();
            int animalSize = animal.size();

            // 물 처리
            while(waterSize-->0) {

                // 현재 물
                Node current = water.poll();

                // 네 방향 탐색
                for(int d=0; d<4; d++) {
                    int ny = current.y+dy[d];
                    int nx = current.x+dx[d];

                    // 범위 확인
                    if(ny<0 || ny>rowSize-1 || nx<0 || nx>colSize-1) continue;

                    // 돌, 방문 여부, 비버 굴 확인
                    if(map[ny][nx]=='X' || map[ny][nx]=='*' || map[ny][nx]=='D') continue;

                    // 탐색 노드 추가
                    map[ny][nx] = '*';
                    water.offer(new Node(ny,nx));
                }
            }

            // 고슴도치 처리
            while(animalSize-->0) {

                // 현재 고슴도치
                Node current = animal.poll();

                // 비버 굴 위치인 경우
                if(map[current.y][current.x]=='D') {
                    answer = dist;
                    return;
                }

                // 네 방향 탐색
                for(int d=0; d<4; d++) {
                    int ny = current.y+dy[d];
                    int nx = current.x+dx[d];

                    // 범위 확인
                    if(ny<0 || ny>rowSize-1 || nx<0 || nx>colSize-1) continue;

                    // 방문 여부 확인
                    if(visited[ny][nx]) continue;

                    // 돌, 물인지 확인
                    if(map[ny][nx]=='X' || map[ny][nx]=='*') continue;

                    // 탐색 노드 추가
                    visited[ny][nx] = true;
                    animal.offer(new Node(ny,nx));
                }
            }

            // 거리 증가
            dist++;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        // 가로, 세로 입력
        st = new StringTokenizer(br.readLine());
        rowSize = Integer.parseInt(st.nextToken());
        colSize = Integer.parseInt(st.nextToken());

        // 큐 생성
        water = new LinkedList<>();
        animal = new LinkedList<>();

        // 맵 생성
        map = new char[rowSize][colSize];

        // 맵 정보 입력
        for(int i=0; i<rowSize; i++) {
            String line = br.readLine();
            for(int j=0; j<colSize; j++) {
                map[i][j] = line.charAt(j);

                // 물인 경우
                if(map[i][j]=='*')
                    water.offer(new Node(i,j));

                // 고슴도치인 경우
                if(map[i][j]=='S')
                    animal.offer(new Node(i,j));
            }
        }

        // 탈출하기
        answer = -1;
        solve();

        // 결과 출력
        if(answer==-1)
            System.out.println("KAKTUS");
        else
            System.out.println(answer);
    }
}