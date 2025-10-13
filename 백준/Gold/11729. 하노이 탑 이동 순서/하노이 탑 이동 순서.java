import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    // 원판 개수, 움직인 횟수
    public static int boardCount, moveCount;

    // 움직임 저장 빌더
    public static StringBuilder sb = new StringBuilder();

    // 옮기기 메서드
    public static void move(int count, int point1, int point2) {

        // 이동
        if(count > 1) move(count-1, point1, 6-point1-point2);

        // 이동 저장
        sb.append(point1).append(" ").append(point2).append("\n");

        // 움직인 횟수 증가
        moveCount += 1;

        // 이동
        if(count > 1)
            move(count-1, 6-point1-point2, point2);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 원판 개수 입력
        boardCount = Integer.parseInt(br.readLine());

        // 옮기기
        moveCount = 0;
        move(boardCount, 1, 3);

        // 결과 출력
        System.out.println(moveCount);
        System.out.println(sb.toString());
    }
}