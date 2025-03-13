import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

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

    // 결과 값
    public static final String SUCCESS_VALUE = "happy";
    public static final String FAILURE_VALUE = "sad";

    // 이동 가능한 거리
    public static final int POSSIBLE_MOVE = 1000;

    // 가게 개수, 시작점, 도착점
    public static int storeCount, startY, startX, endY, endX;

    // 가게 위치 배열
    public static Point[] points;

    // 방문 여부 배열
    public static boolean[] visited;

    // 위치 저장 큐
    public static Queue<Point> queue;

    // 거리 차이 확인 메서드
    public static int calculationDistance(int y1, int y2, int x1, int x2) {
        return Math.abs(y1-y2)+Math.abs(x1-x2);
    }

    // 목표 지점에 도달 가능 여부 확인 메서드
    public static boolean isMoveToDestination(int y, int x) {
        return calculationDistance(endY,y,endX,x) <= POSSIBLE_MOVE;
    }

    // 탐색 메서드
    public static String solve() {

        // 위치 저장 큐 생성
        queue = new LinkedList<>();

        // 방문 여부 배열 생성
        visited = new boolean[storeCount];

        // 시작점 처리
        queue.offer(new Point(startY,startX));

        // 이동
        while(!queue.isEmpty()) {

            // 현재 위치
            Point point = queue.poll();

            // 목표 지점에 도달 가능한 경우
            if(isMoveToDestination(point.y,point.x))
                return SUCCESS_VALUE;

            // 이동 가능한 가게 위치 확인
            for(int index=0; index<storeCount; index++) {

                // 이미 방문한 경우
                if(visited[index]) continue;

                // 거리 차이
                int distance = calculationDistance(point.y,points[index].y,point.x,points[index].x);

                // 1000m 넘는 경우
                if(distance>POSSIBLE_MOVE) continue;

                // 탐색 대상 추가
                visited[index] = true;
                queue.offer(new Point(points[index].y,points[index].x));
            }
        }

        return FAILURE_VALUE;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        // 테스트 케이스 수 입력
        int caseCount = Integer.parseInt(br.readLine());

        // 케이스 수행
        for(int caseIndex=0; caseIndex<caseCount; caseIndex++) {

            // 가게 개수 입력
            storeCount = Integer.parseInt(br.readLine());

            // 가게 위치 정보 저장 배열 생성
            points = new Point[storeCount];

            // 시작점 입력
            st = new StringTokenizer(br.readLine());
            startY = Integer.parseInt(st.nextToken());
            startX = Integer.parseInt(st.nextToken());

            // 가게 위치 입력
            for(int index=0; index<storeCount; index++) {
                st = new StringTokenizer(br.readLine());
                int y = Integer.parseInt(st.nextToken());
                int x = Integer.parseInt(st.nextToken());
                points[index] = new Point(y, x);
            }

            // 도착점 입력
            st = new StringTokenizer(br.readLine());
            endY = Integer.parseInt(st.nextToken());
            endX = Integer.parseInt(st.nextToken());

            // 탐색
            sb.append(solve()).append("\n");
        }

        // 결과 출력
        System.out.println(sb.toString());
    }
}