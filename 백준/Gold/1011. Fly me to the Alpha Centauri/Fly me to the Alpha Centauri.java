import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

// 위치 클래스
class Point {
    int area;
    int previousMove;
    int moveCount;

    public Point(int area, int previousMove, int moveCount) {
        this.area = area;
        this.previousMove = previousMove;
        this.moveCount = moveCount;
    }
}

public class Main {

    // 이동 수행 메서드
    public static long solve(int startPoint, int endPoint) {

        // 이동 횟수
        int moveCount = 0;

        // 시작점과 도착점 거리 차이
        int diffenceDistance = endPoint-startPoint;

        // 최대 이동 거리
        int maxMoveDistance = (int)Math.sqrt(diffenceDistance);

        // 최대 이동 거리의 제곱
        int powMaxMoveDistance = maxMoveDistance*maxMoveDistance;

        // 최대 이동 거리의 제곱과 거리 차이가 동일한 경우
        if(powMaxMoveDistance==diffenceDistance)
                moveCount = maxMoveDistance*2-1;

        // 최대 이동 거리의 제곱에서 최대 거리를 더 간 거리와 거리 차이보다 같거나 클 경우
        else if(powMaxMoveDistance+maxMoveDistance>=diffenceDistance)
                moveCount = maxMoveDistance*2;

        // 그 외
        else moveCount = maxMoveDistance*2+1;

        return moveCount;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        // 테스트 케이스 수 입력
        int caseCount = Integer.parseInt(br.readLine());

        // 케이스 수행
        for(int caseIndex=0; caseIndex<caseCount; caseIndex++) {

            // 시작, 끝 지점 입력
            st = new StringTokenizer(br.readLine());
            int startPoint = Integer.parseInt(st.nextToken());
            int endPoint = Integer.parseInt(st.nextToken());

            // 이동 수행
            sb.append(solve(startPoint,endPoint)).append("\n");
        }

        // 결과 출력
        System.out.println(sb.toString());
    }
}