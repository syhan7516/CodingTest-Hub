import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {

    // 원판 개수, 목표 원판, 이동 횟수
    public static int plateCount, targetPlate, moveCount;

    // 원판 위치 배열
    public static int[] points;

    // 탑
    public static Stack<Integer>[] tops;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        // 원판 개수 입력
        plateCount = Integer.parseInt(br.readLine());

        // 원판 위치 저장 배열 생성
        points = new int[plateCount+1];

        // 탑 생성
        tops = new Stack[3];
        for(int index=0; index<tops.length; index++) {
            tops[index] = new Stack<>();
        }

        // 원판 정보 입력
        st = new StringTokenizer(br.readLine());
        for(int index=1; index<=plateCount; index++) {
            int point = Integer.parseInt(st.nextToken());
            points[index] = 1;
            tops[1].add(point);
        }

        // 원판 옮기기
        targetPlate = plateCount;

        while(targetPlate > 0) {

            // 목표 원판 위치 확인
            int point = points[targetPlate];

            // 목표 원판 찾기
            int movePoint = point == 1 ? 2 : 1;
            while(tops[point].peek() != targetPlate) {
                int plate = tops[point].pop();
                tops[movePoint].add(plate);
                points[plate] = movePoint;
                moveCount++;
                sb.append(point).append(" ").append(movePoint).append("\n");
            }

            // 찾은 원판 옮기기
            tops[point].pop();
            moveCount++;
            sb.append(point).append(" ").append(3).append("\n");
            targetPlate--;
        }

        // 결과 출력
        System.out.println(moveCount);
        System.out.println(sb.toString());
    }
}