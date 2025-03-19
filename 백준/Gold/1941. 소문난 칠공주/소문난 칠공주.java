import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

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

    // 사람 수, 교실 크기, 그룹 인원, 최소 인원
    public static final int STUDENT_COUNT = 25;
    public static final int CLASS_SIZE = 5;
    public static final int GROUP_COUNT = 7;
    public static final int MIN_COUNT = 4;

    // 결과
    public static int answer;

    // 교실 배열
    public static char[][] room;

    // 방문 여부 배열
    public static boolean[][] selected;

    // 방향 벡터
    public static int dy[] = {0,1,0,-1};
    public static int dx[] = {1,0,-1,0};

    // 우위 조건 확인 메서드
    public static boolean isNotSCount(int selectedCount, int SCount) {
        return GROUP_COUNT-selectedCount+SCount<MIN_COUNT;
    }

    // 이다솜파 확인 메서드
    public static boolean isS(char student) {
        return student=='S';
    }

    // bfs - 인접 여부 확인
    public static int bfs(boolean[][] visited, int row, int col) {

        // 위치 저장 큐 생성
        Queue<Point> queue = new LinkedList<>();

        // 시작점 처리
        int currentCount = 1;
        queue.offer(new Point(row,col));
        visited[row][col] = true;

        // 탐색
        while(!queue.isEmpty()) {

            // 현재 위치
            Point point = queue.poll();

            // 이동 가능한 방향 확인
            for(int dir=0; dir<4; dir++) {
                int ny = point.y + dy[dir];
                int nx = point.x + dx[dir];

                // 범위 확인
                if(ny<0 || ny>CLASS_SIZE-1 || nx<0 || nx>CLASS_SIZE-1) continue;

                // 방문 여부 확인
                if(visited[ny][nx]) continue;
                visited[ny][nx] = true;

                // 탐색 대상 추가
                if(selected[ny][nx]) {
                    queue.offer(new Point(ny,nx));
                    currentCount++;
                }
            }
        }

        return currentCount;
    }

    // 자리 조합 메서드
    public static void solve(int order, int selectedCount, int SCount) {

        // 우위 조건 확인
        if(isNotSCount(selectedCount,SCount)) return;

        // 그룹이 형성된 경우
        if(selectedCount==GROUP_COUNT) {

            // 인접 여부 확인
            int currentGroup = 0;
            int currentCount = 0;

            // 방문 여부 배열 생성
            boolean[][] visited = new boolean[CLASS_SIZE][CLASS_SIZE];

            for(int rowIndex=0; rowIndex<CLASS_SIZE; rowIndex++) {
                for(int colIndex=0; colIndex<CLASS_SIZE; colIndex++) {
                    if(selected[rowIndex][colIndex] && !visited[rowIndex][colIndex]) {
                        currentGroup++;
                        currentCount = bfs(visited,rowIndex,colIndex);
                    }
                }
            }
            
            // 조건 확인
            if(currentGroup==1 && currentCount==GROUP_COUNT)
                answer++;
            return;
        }

        // ~ 25
        for(int index=order; index<STUDENT_COUNT; index++) {
            char student = room[index/CLASS_SIZE][index%CLASS_SIZE];
            selected[index/CLASS_SIZE][index%CLASS_SIZE] = true;
            if(isS(student)) solve(index+1,selectedCount+1,SCount+1);
            else solve(index+1,selectedCount+1,SCount);
            selected[index/CLASS_SIZE][index%CLASS_SIZE] = false;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 교실 배열 생성
        room = new char[CLASS_SIZE][CLASS_SIZE];

        // 교실 정보 입력
        for(int rowIndex=0; rowIndex<CLASS_SIZE; rowIndex++){
            String line = br.readLine();
            for(int colIndex=0; colIndex<CLASS_SIZE; colIndex++){
                room[rowIndex][colIndex] = line.charAt(colIndex);
            }
        }

        // 자리 조합
        answer = 0;
        selected = new boolean[CLASS_SIZE][CLASS_SIZE];
        solve(0,0,0);

        // 결과 출력
        System.out.println(answer);
    }
}