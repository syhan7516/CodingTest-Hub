import java.io.*;
import java.util.*;

public class Main {
    // 최대값
    public static int MAX_VALUE = 1000100;

    // 결과, 거리, 크기
    public static int answer, distance, size;

    // 공간 배열
    public static int[][] area;

    // DP 배열
    static int[][][] DP;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        // 거리, 크기 입력
        st = new StringTokenizer(br.readLine());
        distance = Integer.parseInt(st.nextToken());
        size = Integer.parseInt(st.nextToken());

        // 배열 생성
        area = new int[distance][size];
        DP = new int[distance][size][3];

        // 공간 정보 입력
        for(int rowIndex=0; rowIndex<distance; rowIndex ++) {
            st = new StringTokenizer(br.readLine());
            for(int colIndex=0; colIndex<size; colIndex ++) {
                area[rowIndex][colIndex] = Integer.parseInt(st.nextToken());
                Arrays.fill(DP[rowIndex][colIndex], MAX_VALUE);
            }
        }

        // DP 초기값 설정
        for(int rowIndex=0; rowIndex<size; rowIndex ++) {
            for(int colIndex=0 ; colIndex<3 ; colIndex ++) {
                DP[0][rowIndex][colIndex] = area[0][rowIndex];
            }
        }

        // 확인
        for(int rowIndex=1; rowIndex<distance; rowIndex ++) {
            for(int colIndex=0; colIndex<size; colIndex ++) {

                // 왼쪽
                if(colIndex == 0) {

                    // 오른쪽 확인
                    DP[rowIndex][colIndex][1] = DP[rowIndex-1][colIndex][2] + area[rowIndex][colIndex];
                    // 왼쪽, 중간 확인
                    DP[rowIndex][colIndex][2] = Math.min(DP[rowIndex-1][colIndex+1][1], DP[rowIndex-1][colIndex+1][0]) + area[rowIndex][colIndex];
                }

                // 중간
                else if(colIndex < size-1) {
                    // 오른쪽 확인
                    DP[rowIndex][colIndex][2] = Math.min(DP[rowIndex-1][colIndex+1][1], DP[rowIndex-1][colIndex+1][0]) + area[rowIndex][colIndex];
                    // 중간 확인
                    DP[rowIndex][colIndex][1] = Math.min(DP[rowIndex-1][colIndex][0], DP[rowIndex-1][colIndex][2]) + area[rowIndex][colIndex];
                    // 왼쪽 확인
                    DP[rowIndex][colIndex][0] = Math.min(DP[rowIndex-1][colIndex-1][2], DP[rowIndex-1][colIndex-1][1]) + area[rowIndex][colIndex];
                }

                // 오른쪽
                else{
                    // 왼쪽 확인
                    DP[rowIndex][colIndex][0] = Math.min(DP[rowIndex-1][colIndex-1][1], DP[rowIndex-1][colIndex-1][2]) + area[rowIndex][colIndex];
                    // 중간 확인
                    DP[rowIndex][colIndex][1] = DP[rowIndex-1][colIndex][0] + area[rowIndex][colIndex];
                }
            }
        }

        // 결과 확인
        answer = Integer.MAX_VALUE;
        for(int rowIndex=0; rowIndex<size; rowIndex ++) {
            for(int colIndex=0; colIndex<3; colIndex ++)
                answer = Math.min(answer, DP[distance-1][rowIndex][colIndex]);
        }

        // 결과 출력
        System.out.println(answer);
    }
}