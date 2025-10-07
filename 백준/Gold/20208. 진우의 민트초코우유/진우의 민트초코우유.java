import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

class Point {
    int row;
    int col;

    public Point(int row, int col) {
        this.row = row;
        this.col = col;
    }
}

public class Main {

    // 결과, 크기, 체력, 회복
    public static int answer, size, hp, milk;

    // 집 위치
    public static int homeRowPosition, homeColPosition;

    // 마을 배열
    public static int[][] town;
    
    // 방문 여부 배열
    public static boolean[] visited;

    // 방향 벡터
    public static int[] dy = {0,1,0,-1};
    public static int[] dx = {1,0,-1,0};

    // 우유 위치 저장 리스트
    public static ArrayList<Point> points;

    // 우유 방문 순서 배열
    public static int[] orders;

    // 우유 수거 메서드
    public static void checkForMilkOrders() {

        // 초기 설정
        int currentHp = hp;
        int currentRowPosition = homeRowPosition;
        int currentColPosition = homeColPosition;
        int milkCount = 0;

        // 우유 수거
        for(int orderIndex=0; orderIndex<orders.length; orderIndex++) {

            // 확인 우유
            Point milkPoint = points.get(orders[orderIndex]);

            // 거리 구하기 - 확인 우유 위치까지 거리, 현재 위치에서 집까지 거리
            int distance = Math.abs(currentRowPosition - milkPoint.row) + Math.abs(currentColPosition - milkPoint.col);
            int distanceFromHome = Math.abs(homeRowPosition - milkPoint.row) + Math.abs(homeColPosition - milkPoint.col);

            // 현재 위치에서 우유 수거가 가능한 경우
            if(currentHp >= distance) {
                milkCount++;
                currentHp -= distance;
                currentHp += milk;

                // 우유 수거 후 귀가 가능 여부 확인
                if(currentHp >= distanceFromHome) {
                    answer = Math.max(answer, milkCount);
                }

                // 이동
                currentRowPosition = milkPoint.row;
                currentColPosition = milkPoint.col;
            }

            // 이동 불가능한 경우 집으로 귀가
            else return;
        }
    }

    // 우유 순서 정하기 메서드
    public static void solve(int count) {

        // 순서를 모두 정한 경우
        if(count == points.size()) {

            // 우유 수거
            checkForMilkOrders();
            return;
        }

        // 순서 정하기
        for(int index=0; index<points.size(); index++) {

            // 이미 순서가 정해진 우유의 경우
            if(visited[index]) continue;

            // 순서 확정
            visited[index] = true;
            orders[count] = index;
            solve(count + 1);
            visited[index] = false;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        // 크기, 체력, 회복 입력
        st = new StringTokenizer(br.readLine());
        size = Integer.valueOf(st.nextToken());
        hp = Integer.valueOf(st.nextToken());
        milk = Integer.valueOf(st.nextToken());

        // 마을 배열 생성
        town = new int[size][size];

        // 우유 위치 저장 리스트 생성
        points = new ArrayList<>();

        // 마을 정보 입력
        for(int rowIndex=0; rowIndex<size; rowIndex++) {
            st = new StringTokenizer(br.readLine());
            for(int colIndex=0; colIndex<size; colIndex++) {
                town[rowIndex][colIndex] = Integer.parseInt(st.nextToken());

                // 집인 경우
                if(town[rowIndex][colIndex] == 1) {
                    homeRowPosition = rowIndex;
                    homeColPosition = colIndex;
                }

                // 우유인 경우
                if(town[rowIndex][colIndex]==2) {
                    points.add(new Point(rowIndex,colIndex));
                }
            }
        }

        // 방문 여부 배열 생성
        visited = new boolean[points.size()];

        // 우유 방문 순서 배열 생성
        orders = new int[points.size()];

        // 순서 정하기
        solve(0);

        // 결과 출력
        System.out.println(answer);
    }
}