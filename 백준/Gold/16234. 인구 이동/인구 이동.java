import java.util.*;
import java.io.*;

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

    // 결과, 격자 크기, 인구 범위, 구역, 인구 총합
    public static int answer, size, left, right, areaCnt, people;

    // 인구 이동 여부
    public static boolean move;

    // 격자
    public static int map[][];

    // 격자 방문 여부
    public static boolean visited[][];

    // 방문 위치 저장 리스트
    public static ArrayList<Point> points;

    // 위치 저장 큐
    public static Queue<Point> queue;

    // 방향 벡터
    public static int dy[] = {0,1,0,-1};
    public static int dx[] = {1,0,-1,0};

    // 국경선 열기 메서드
    public static void open(int row, int col) {

        // 구역 및 인구 총합
        areaCnt = 0;
        people = 0;

        // 방문 위치 저장 리스트 생성
        points = new ArrayList<Point>();

        // 위치 저장 큐 생성
        queue = new LinkedList<>();

        // 시작점 처리
        queue.offer(new Point(row,col));
        visited[row][col] = true;
        points.add(new Point(row,col));
        areaCnt++;
        people += map[row][col];

        // 인구 이동
        while(!queue.isEmpty()) {

            // 현재 위치
            Point current = queue.poll();

            // 주위 확인
            for(int d=0; d<4; d++) {
                int ny = current.y+dy[d];
                int nx = current.x+dx[d];

                // 범위 확인
                if(ny<0 || ny>size-1 || nx<0 || nx>size-1) continue;

                // 이미 방문한 경우
                if(visited[ny][nx]) continue;

                // 인구 차이
                int diff = Math.abs(map[current.y][current.x]-map[ny][nx]);

                // 이동 요건이 맞는 경우
                if(diff>=left && diff<=right) {

                    // 확인 구역 추가
                    queue.offer(new Point(ny,nx));

                    // 방문 처리
                    visited[ny][nx] = true;

                    // 방문 위치 저장
                    points.add(new Point(ny,nx));

                    // 인구 저장 및 이동 구역 증가
                    areaCnt++;
                    people += map[ny][nx];

                    // 인구 이동 여부 변경
                    move = true;
                }
            }
        }
    }

    // 인구 평균화 메서드
    public static void moveToArea() {

        // 인구 평균
        int avg = people/areaCnt;

        // 방문 위치 저장 리스트 확인
        for(int i=0; i<points.size(); i++) {

            // 이동 대상 구역
            Point area = points.get(i);

            // 평균화
            map[area.y][area.x] = avg;
        }
    }

    // 인구 이동 메서드
    public static void solve() {

        // 인구 이동 여부
        move = true;

        // 인구 이동 없을 때까지 반복
        while(move) {

            // 인구 이동 여부 초기화
            move = false;

            // 방문 여부 배열 생성
            visited = new boolean[size][size];

            // 모든 지점 확인
            for(int i=0; i<size; i++) {
                for(int j=0; j<size; j++) {

                    // 미방문 구역인 경우
                    if(!visited[i][j]) {

                        // 국경선 열기
                        open(i,j);

                        // 인구 평균화
                        if(move) moveToArea();
                    }
                }
            }

            // 이동이 일어난 경우 일 수 증가
            if(move) answer++;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        // 격자 크기, 인구 범위 입력
        st = new StringTokenizer(br.readLine());
        size = Integer.parseInt(st.nextToken());
        left = Integer.parseInt(st.nextToken());
        right = Integer.parseInt(st.nextToken());

        // 격자 생성
        map = new int[size][size];

        // 격자 정보 입력
        for(int i=0; i<size; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<size; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // 인구 이동
        answer = 0;
        solve();

        // 결과 출력
        System.out.println(answer);
    }
}