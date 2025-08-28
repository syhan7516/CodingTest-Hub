import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        // 테스트 케이스 수 입력
        int caseCount = Integer.parseInt(br.readLine());

        // 케이스 수행
        for(int caseNum=0; caseNum<caseCount; caseNum++) {
            
            // 배열 크기, 명령 횟수 입력
            st = new StringTokenizer(br.readLine());
            int size = Integer.parseInt(st.nextToken());
            int orderCount = Integer.parseInt(st.nextToken());

            // 배열 생성
            int[][] board = new int[size][size];
            
            // 가로 합, 세로 합 배열 생성
            int[] prefixSumRow = new int[size];
            int[] prefixSumCol = new int[size];

            // 배열 정보 입력
            for(int rowIndex=0; rowIndex<size; rowIndex++) {
                st = new StringTokenizer(br.readLine());
                for(int colIndex=0; colIndex<size; colIndex++) {
                    int num = Integer.parseInt(st.nextToken());
                    board[rowIndex][colIndex] = num;
                    prefixSumRow[rowIndex] += num;
                    prefixSumCol[colIndex] += num;
                }
            }

            // 명령 확인
            for(int orderIndex=0; orderIndex<orderCount; orderIndex++) {
                st = new StringTokenizer(br.readLine());
                int startY = Integer.parseInt(st.nextToken())-1;
                int startX = Integer.parseInt(st.nextToken())-1;
                int endY = Integer.parseInt(st.nextToken())-1;
                int endX = Integer.parseInt(st.nextToken())-1;
                int value = Integer.parseInt(st.nextToken());

                // 합 적용
                for(int rowIndex=startY; rowIndex<=endY; rowIndex++) {
                    prefixSumRow[rowIndex] += (endX-startX+1) * value;
                }

                // 합 적용
                for(int colIndex=startX; colIndex<=endX; colIndex++) {
                    prefixSumCol[colIndex] += (endY-startY+1) * value;
                }
            }

            // 결과 저장
            for(int rowIndex=0; rowIndex<size; rowIndex++) {
                sb.append(prefixSumRow[rowIndex]+" ");
            }
            sb.append('\n');
            
            for(int colIndex=0; colIndex<size; colIndex++) {
                sb.append(prefixSumCol[colIndex]+" ");
            }
            sb.append('\n');
        }
        
        // 결과 출력    
        System.out.println(sb);
    }
}