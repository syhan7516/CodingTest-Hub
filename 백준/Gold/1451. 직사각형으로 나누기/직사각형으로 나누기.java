import java.util.*;
import java.io.*;

public class Main {

    // 가로, 세로
    public static int rowSize, colSize;
    // 결과
    public static long result;
    // 직사각형
    public static long square[][];
    // 연산을 위한 배열
    static long squareSum[][];

    // 연산 함수
    static long getOperation(int a, int b, int c, int d) {
        long operation = squareSum[c][d]-squareSum[c][b-1]-squareSum[a-1][d]+squareSum[a-1][b -1];
        return operation;
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        // 가로, 세로 입력
        st = new StringTokenizer(br.readLine());
        rowSize = Integer.parseInt(st.nextToken());
        colSize = Integer.parseInt(st.nextToken());

        // 직사각형
        square = new long[rowSize+1][colSize+1];

        // 직사각형 정보 입력
        for (int a=1; a<=rowSize; a++) {
            String line = " "+br.readLine();
            for (int b=1; b<=colSize; b++) {
                square[a][b] = line.charAt(b)-'0';
            }
        }

        // 연산 직사각형 배열
        squareSum = new long[rowSize+1][colSize+1];
        for (int a=1; a<=rowSize; a++) {
            for (int b=1; b<=colSize; b++) {
                squareSum[a][b] = squareSum[a-1][b]+squareSum[a][b-1]-squareSum[a-1][b-1]+(long)square[a][b];
            }
        }

        // 결과
        result = 0;

        // 1번 연산
        for (int a=1; a<=colSize-2; a++) {
            for (int b=a+1; b<=colSize-1 ; b++) {
                long first = getOperation(1,1,rowSize,a);
                long second = getOperation(1,a+1,rowSize,b);
                long third = getOperation(1,b+1,rowSize,colSize);

                // 최대값 갱신
                result = Math.max(result,first*second*third);
            }
        }

        // 2번 연산
        for (int a=1; a<=rowSize-2; a++) {
            for (int b=a+1; b<=rowSize-1; b++) {
                long first = getOperation(1,1,a,colSize);
                long second = getOperation(a+1,1,b,colSize);
                long third = getOperation(b+1,1,rowSize,colSize);

                // 최대값 갱신
                result = Math.max(result,first*second*third);
            }
        }

        // 3번, 4번, 5번, 6번 연산
        for (int a=1; a<=rowSize-1; a++) {
            for (int b=1; b<=colSize-1; b++) {

                // 3번
                long first = getOperation(1,1,rowSize,b);
                long second = getOperation(1,b+1,a,colSize);
                long third = getOperation(a+1,b+1,rowSize,colSize);

                // 최대값 갱신
                result = Math.max(result,first*second*third);

                // 4번
                first = getOperation(1,1,a,b);
                second = getOperation(a+1,1,rowSize,b);
                third = getOperation(1,b+1,rowSize,colSize);

                // 최대값 갱신
                result = Math.max(result,first*second*third);

                // 5번
                first = getOperation(1,1,a,colSize);
                second = getOperation(a+1,1,rowSize,b);
                third = getOperation(a+1,b+1,rowSize,colSize);

                // 최대값 갱신
                result = Math.max(result,first*second*third);

                // 6번
                first = getOperation(1,1,a,b);
                second = getOperation(1,b+1,a,colSize);
                third = getOperation(a+1,1,rowSize,colSize);

                // 최대값 갱신
                result = Math.max(result,first*second*third);
            }
        }

        // 결과 출력
        System.out.println(result);
    }
}