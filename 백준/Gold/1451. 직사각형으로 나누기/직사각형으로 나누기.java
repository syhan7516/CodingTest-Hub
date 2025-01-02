import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    // 결과
    public static long answer;

    // 가로, 세로 크기
    public static int rowSize, colSize;

    // 사각형 배열
    public static int[][] square;

    // 누적합 배열
    public static long[][] prefixSum;

    // 임시 배열
    public static long[] mock;
    public static int[] divide;

    public static long findSum(int x1, int y1, int x2, int y2) {
        
        if(x1==0 && y1==0) {
            return prefixSum[y2][x2];
        } 
        else if(x1==0) {
            return prefixSum[y2][x2]-prefixSum[y1-1][x2];
        } 
        else if(y1==0) {
            return prefixSum[y2][x2]-prefixSum[y2][x1-1];
        }

        return prefixSum[y2][x2]-prefixSum[y2][x1-1]-prefixSum[y1-1][x2]+prefixSum[y1-1][x1-1];
    }

    public static void divideRow(int count, int index) {
        if(count>=2) {
            mock[0] = findSum(0,0,colSize-1,divide[0]-1);
            mock[1] = findSum(0,divide[0],colSize-1,divide[1]-1);
            mock[2] = findSum(0,divide[1],colSize-1,rowSize-1);
            answer = Math.max(answer,mock[0]*mock[1]*mock[2]);
            return;
        }

        for (int point=index; point+1<rowSize; point++) {
            divide[count] = point+1;
            divideRow(count+1,point+1);
        }
    }

    public static void divideCol(int count, int index) {
        if(count>=2) {
            mock[0] = findSum(0,0,divide[0]-1,rowSize-1);
            mock[1] = findSum(divide[0],0,divide[1]-1,rowSize-1);
            mock[2] = findSum(divide[1],0,colSize-1,rowSize-1);
            answer = Math.max(answer,mock[0]*mock[1]*mock[2]);
            return;
        }

        for (int point=index; point+1<colSize; point++) {
            divide[count] = point+1;
            divideCol(count+1,point+1);
        }
    }

    public static void dividePoint() {
        for (int rowIndex=1; rowIndex<=rowSize-1; rowIndex++) {
            for (int colIndex=1; colIndex<=colSize-1; colIndex++) {
                
                // ㅗ
                mock[0] = findSum(0,0,colIndex-1,rowIndex-1);
                mock[1] = findSum(colIndex,0,colSize-1,rowIndex-1);
                mock[2] = findSum(0,rowIndex,colSize-1,rowSize-1);
                answer = Math.max(answer,mock[0]*mock[1]*mock[2]);

                // ㅜ
                mock[0] = findSum(0,0,colSize-1,rowIndex-1);
                mock[1] = findSum(0,rowIndex,colIndex-1,rowSize-1);
                mock[2] = findSum(colIndex,rowIndex,colSize-1,rowSize-1);
                answer = Math.max(answer,mock[0]*mock[1]*mock[2]);

                // ㅏ
                mock[0] = findSum(0,0,colIndex-1,rowSize-1);
                mock[1] = findSum(colIndex,0,colSize-1,rowIndex-1);
                mock[2] = findSum(colIndex,rowIndex,colSize-1,rowSize-1);
                answer = Math.max(answer,mock[0]*mock[1]*mock[2]);

                // ㅓ
                mock[0] = findSum(0,0,colIndex-1,rowIndex-1);
                mock[1] = findSum(0,rowIndex,colIndex-1,rowSize-1);
                mock[2] = findSum(colIndex,0,colSize-1,rowSize-1);
                answer = Math.max(answer,mock[0]*mock[1]*mock[2]);
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        // 가로, 세로 크기 입력
        st = new StringTokenizer(br.readLine());
        rowSize = Integer.parseInt(st.nextToken());
        colSize = Integer.parseInt(st.nextToken());

        // 배열 생성
        square = new int[rowSize][colSize];
        prefixSum = new long[rowSize][colSize];
        mock = new long[3];

        // 사각형 정보 입력
        for(int rowIndex=0; rowIndex<rowSize; rowIndex++) {
            String line = br.readLine();
            for(int colIndex=0; colIndex<colSize; colIndex++) {
                square[rowIndex][colIndex] = line.charAt(colIndex)-'0';

                //
                if (rowIndex==0 && colIndex==0) {
                    prefixSum[0][0] = square[0][0];
                }
                else if(rowIndex==0) {
                    prefixSum[0][colIndex] = prefixSum[0][colIndex-1]+square[rowIndex][colIndex];
                }
                else if(colIndex==0) {
                    prefixSum[rowIndex][0] = prefixSum[rowIndex-1][0]+square[rowIndex][colIndex];
                }
            }
        }

        // 누적합 구하기
        for (int rowIndex=1; rowIndex<rowSize; rowIndex++) {
            for (int colIndex=1; colIndex<colSize; colIndex++) {
                prefixSum[rowIndex][colIndex] 
                        = prefixSum[rowIndex][colIndex-1]
                        +prefixSum[rowIndex-1][colIndex]
                        -prefixSum[rowIndex-1][colIndex-1]
                        +square[rowIndex][colIndex];
            }
        }
        
        answer = 0;
        divide = new int[2];
        divideRow(0, 0);
        divideCol(0, 0);
        dividePoint();

        // 결과 출력
        System.out.println(answer);
    }
}