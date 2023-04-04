import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 정사각형의 개수 입력
        int squareCnt = Integer.parseInt(br.readLine());

        // 직사각형 모양 배열
        boolean square[][] = new boolean[squareCnt+1][squareCnt+1];

        // 직사각형 만들기
        int count = 0;
        for(int row=1; row<=squareCnt; row++) {
            for(int col=1; col<=squareCnt; col++) {
                int squareSize = row * col;

                // 만든 직사각형의 크기가 범위를 넘을 경우
                if(squareSize>squareCnt)
                    break;

                // 처음 만들어본 직사각형일 경우
                if(!square[row][col] && !square[col][row]) {
                    count += 1;
                    square[row][col] = true;
                    square[col][row] = true;
                }
            }
        }

        // 결과 출력
        System.out.println(count);
    }
}