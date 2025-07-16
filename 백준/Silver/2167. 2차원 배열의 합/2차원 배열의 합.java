import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    // 가로, 세로 크기, 질의 개수
    public static int rowSize, colSize, orderCount;

    // 보드 배열
    public static int[][] board;

    // 누적합 배열
    public static long[][] prefixSum;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        // 가로, 세로 크기 입력
        st = new StringTokenizer(br.readLine());
        rowSize = Integer.parseInt(st.nextToken());
        colSize = Integer.parseInt(st.nextToken());

        // 보드 배열 생성
        board = new int[rowSize+1][colSize+1];

        // 누적합 배열 생성
        prefixSum = new long[rowSize+1][colSize+1];

        // 보드 정보 입력
        for(int rowIndex=1; rowIndex<=rowSize; rowIndex++) {
            st = new StringTokenizer(br.readLine());
            for(int colIndex=1; colIndex<=colSize; colIndex++) {
                int num = Integer.parseInt(st.nextToken());
                board[rowIndex][colIndex] = num;
                prefixSum[rowIndex][colIndex] =
                        prefixSum[rowIndex][colIndex-1] + prefixSum[rowIndex-1][colIndex] - prefixSum[rowIndex-1][colIndex-1] + num;
            }
        }

        // 질의 개수 입력
        orderCount = Integer.parseInt(br.readLine());

        // 질의 입력
        for(int order=0; order<orderCount; order++) {
            st = new StringTokenizer(br.readLine());
            int startRow = Integer.parseInt(st.nextToken());
            int startCol = Integer.parseInt(st.nextToken());
            int endRow = Integer.parseInt(st.nextToken());
            int endCol = Integer.parseInt(st.nextToken());
            long sum = prefixSum[endRow][endCol] - prefixSum[startRow-1][endCol] - prefixSum[endRow][startCol-1] + prefixSum[startRow-1][startCol-1];
            sb.append(sum).append("\n");
        }

        // 결과 출력
        System.out.println(sb.toString());
    }
}
