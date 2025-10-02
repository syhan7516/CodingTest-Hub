import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        // 가로, 세로 크기 입력
        st = new StringTokenizer(br.readLine());
        int rowSize = Integer.parseInt(st.nextToken());
        int colSize = Integer.parseInt(st.nextToken());

        // 공간 배열 생성
        int[][] area = new int[rowSize][colSize];

        // 행, 열 누적합 배열 생성
        int[] prefixSumRow = new int[rowSize];
        int[] prefixSumCol = new int[colSize];

        // 공간 정보 입력
        for(int rowIndex=0; rowIndex<rowSize; rowIndex++) {
            st = new StringTokenizer(br.readLine());
            for(int colIndex=0; colIndex<colSize; colIndex++) {
                area[rowIndex][colIndex] = Integer.parseInt(st.nextToken());
            }
        }

        // 행 합 계산
        for(int rowIndex=0; rowIndex<rowSize; rowIndex++) {
            int sum = 0;
            for(int colIndex=0; colIndex<colSize; colIndex++) {
                sum += area[rowIndex][colIndex];
            }

            // 행 누적합 저장
            prefixSumRow[rowIndex] = sum;
        }

        // 열 합 계산
        for(int colIndex=0; colIndex<colSize; colIndex++) {
            int sum = 0;
            for(int rowIndex=0; rowIndex<rowSize; rowIndex++) {
                sum += area[rowIndex][colIndex];
            }

            // 열 누적합 저장
            prefixSumCol[colIndex] = sum;
        }

        // 결과 초기화 - 음수 가치 존재
        int answer = Integer.MIN_VALUE;

        // 확인
        for(int firstRowIndex=0; firstRowIndex<rowSize; firstRowIndex++) {
            for(int secondRowIndex=firstRowIndex+1; secondRowIndex<rowSize; secondRowIndex++) {
                for(int firstColIndex=0; firstColIndex<colSize; firstColIndex++) {
                    for(int secondColIndex=firstColIndex+1; secondColIndex<colSize; secondColIndex++) {

                        // 중복 지점 제거
                        int duplicatePoint = area[firstRowIndex][firstColIndex] + area[firstRowIndex][secondColIndex] + area[secondRowIndex][firstColIndex] + area[secondRowIndex][secondColIndex];

                        // 값 갱신
                        int value = prefixSumRow[firstRowIndex] + prefixSumRow[secondRowIndex] + prefixSumCol[firstColIndex] + prefixSumCol[secondColIndex]
                                - duplicatePoint + ((secondRowIndex - firstRowIndex-1) * (secondColIndex - firstColIndex-1));
                        answer = Math.max(answer, value);
                    }
                }
            }
        }

        // 결과 출력
        System.out.println(answer);
    }
}