import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        // 가로, 세로 크기 입력
        st = new StringTokenizer(br.readLine());
        int rowSize = Integer.parseInt(st.nextToken());
        int colSize = Integer.parseInt(st.nextToken());

        // 보드 생성
        int[][] board = new int[rowSize+1][colSize+1];

        // 누적합 보드 생성
        int[][] prefixSum = new int[rowSize+1][colSize+1];

        // 보드 정보 입력
        for(int rowIndex=1; rowIndex<=rowSize; rowIndex++) {
            st = new StringTokenizer(br.readLine());
            for(int colIndex=1; colIndex<=colSize; colIndex++) {
                board[rowIndex][colIndex] = Integer.parseInt(st.nextToken());
                prefixSum[rowIndex][colIndex] =
                        prefixSum[rowIndex-1][colIndex] + prefixSum[rowIndex][colIndex-1]
                                - prefixSum[rowIndex-1][colIndex-1] + board[rowIndex][colIndex];
            }
        }

        // 질의 개수 입력
        int orderCount = Integer.parseInt(br.readLine());

        // 질의 정보 입력
        for(int index=0; index<orderCount; index++) {
            st = new StringTokenizer(br.readLine());
            int startY = Integer.parseInt(st.nextToken());
            int startX = Integer.parseInt(st.nextToken());
            int endY = Integer.parseInt(st.nextToken());
            int endX = Integer.parseInt(st.nextToken());
            int sum = prefixSum[endY][endX] - prefixSum[startY-1][endX] - prefixSum[endY][startX-1] + prefixSum[startY-1][startX-1];
            sb.append(sum).append("\n");
        }

        // 결과 출력
        System.out.println(sb.toString());
    }
}