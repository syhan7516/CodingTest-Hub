import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class Main {

    // 결과, 가로, 세로 크기
    public static int answer, rowSize, colSize;

    // 보드
    public static int[][] board;

    // 범위 확인 메서드
    public static boolean isRange(int row, int col) {
        return row >= 0 && row < rowSize && col >= 0 && col < colSize;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        // 가로, 세로 입력
        st = new StringTokenizer(br.readLine());
        rowSize = Integer.parseInt(st.nextToken());
        colSize = Integer.parseInt(st.nextToken());

        // 보드 생성
        board = new int[rowSize][colSize];

        // 숫자 입력
        for (int rowIndex=0; rowIndex<rowSize; rowIndex++) {
            String line = br.readLine();
            for (int colIndex=0; colIndex<colSize; colIndex++) {
                board[rowIndex][colIndex] = line.charAt(colIndex) - '0';
            }
        }

        // 보드 순회
        answer = -1;
        for (int rowIndex=0; rowIndex<rowSize; ++rowIndex) {
            for (int colIndex=0; colIndex<colSize; ++colIndex) {

                // 행, 열 증감 값 설정
                for (int rowNum=-rowSize; rowNum<rowSize; rowNum++) {
                    for (int colNum=-colSize; colNum<colSize; colNum++) {

                        // 증감 값이 없을 경우
                        if (rowNum==0 && colNum==0) continue;

                        // 값, 대상
                        int value = 0;
                        int nextRow = rowIndex;
                        int nextCol = colIndex;

                        // 범위를 벗어나지 않을 경우 반복
                        while (isRange(nextRow, nextCol)) {

                            // 값 계산
                            value = 10 * value + board[nextRow][nextCol];

                            // 제곱수 확인
                            int firstNum = (int)Math.sqrt(value);
                            double secondNum = Math.sqrt(value);

                            // 동일한지 비교
                            if(firstNum == secondNum) {
                                answer = Math.max(answer, value);
                            }

                            // 증감
                            nextRow += rowNum;
                            nextCol += colNum;
                        }
                    }
                }
            }
        }

        // 결과 출력
        System.out.println(answer);
    }
}