import java.io.*;
import java.util.*;

public class Main {

    // MOD
    public static final int MOD = 100000;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        // 크기 입력
        st = new StringTokenizer(br.readLine());
        int colSize = Integer.parseInt(st.nextToken());
        int rowSize = Integer.parseInt(st.nextToken());

        // DP 배열 생성 - 방향,
        int[][][][] DP = new int[colSize+1][rowSize+1][2][2];

        // 초기 설정
        for(int index=1; index<=colSize; index++) {
            DP[index][1][0][0] = 1;
        }

        for(int index=1; index<=rowSize; index++) {
            DP[1][index][1][0] = 1;
        }

        // 확인
        for(int colIndex=2; colIndex<=colSize; colIndex++) {
            for(int rowIndex=2; rowIndex<=rowSize; rowIndex++) {
                DP[colIndex][rowIndex][1][0] = (DP[colIndex][rowIndex-1][1][1] + DP[colIndex][rowIndex-1][1][0]) % MOD;
                DP[colIndex][rowIndex][1][1] = DP[colIndex][rowIndex-1][0][0] % MOD;
                DP[colIndex][rowIndex][0][0] = (DP[colIndex-1][rowIndex][0][0] + DP[colIndex-1][rowIndex][0][1]) % MOD;
                DP[colIndex][rowIndex][0][1] = DP[colIndex-1][rowIndex][1][0];
            }
        }

        // 결과 저장
        int answer = (DP[colSize][rowSize][0][0] + DP[colSize][rowSize][0][1] + DP[colSize][rowSize][1][0] + DP[colSize][rowSize][1][1]) % MOD;

        // 결과 출력
        System.out.println(answer);
    }
}