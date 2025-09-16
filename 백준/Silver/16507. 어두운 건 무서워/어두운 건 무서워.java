import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    // 가로, 세로, 질의 수
    public static int rowSize, colSize, orderCount;

    // 보드, 누적합 배열
    public static int[][] board, prefixSum;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        // 가로, 세로, 질의 수 입력
        st = new StringTokenizer(br.readLine());
        rowSize = Integer.parseInt(st.nextToken());
        colSize = Integer.parseInt(st.nextToken());
        orderCount = Integer.parseInt(st.nextToken());

        // 배열 생성
        board = new int[rowSize+1][colSize+1];
        prefixSum = new int[rowSize+1][colSize+1];

        // 보드 정보 입력
        for(int rowIndex=1; rowIndex<=rowSize; rowIndex++){
            st = new StringTokenizer(br.readLine());
            for(int colIndex=1; colIndex<=colSize; colIndex++){
                board[rowIndex][colIndex] = Integer.parseInt(st.nextToken());
                prefixSum[rowIndex][colIndex]
                        = prefixSum[rowIndex-1][colIndex] + prefixSum[rowIndex][colIndex-1] - prefixSum[rowIndex-1][colIndex-1] + board[rowIndex][colIndex];
            }
        }

        // 질의 정보 입력
        for(int order=0; order<orderCount; order++){
            st = new StringTokenizer(br.readLine());
            int y1 = Integer.parseInt(st.nextToken());
            int x1 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());
            int count = (y2-y1+1) * (x2-x1+1);
            int sum = prefixSum[y2][x2] - prefixSum[y1-1][x2] - prefixSum[y2][x1-1] + prefixSum[y1-1][x1-1];
            sb.append(sum/count).append("\n");
        }

        // 결과 출력
        System.out.println(sb.toString());
    }
}