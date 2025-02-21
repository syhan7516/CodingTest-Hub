import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    // MOD
    public static final int MOD = 15746;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        // 집 개수 입력
        int houseCount = Integer.parseInt(br.readLine());

        // 비용 저장 배열 생성
        int values[][] = new int[houseCount+1][3];

        // 비용 입력
        for(int index=1; index<=houseCount; index++) {
            st = new StringTokenizer(br.readLine());
            values[index][0] = Integer.parseInt(st.nextToken());
            values[index][1] = Integer.parseInt(st.nextToken());
            values[index][2] = Integer.parseInt(st.nextToken());
        }

        // 비용 합 저장 배열 생성
        int DP[][] = new int[1001][3];
        DP[1][0] = values[1][0];
        DP[1][1] = values[1][1];
        DP[1][2] = values[1][2];

        // 비용 합 구하기
        for(int index=2; index<=houseCount; index++) {
            DP[index][0] = Math.min(DP[index-1][1],DP[index-1][2])+values[index][0];
            DP[index][1] = Math.min(DP[index-1][0],DP[index-1][2])+values[index][1];
            DP[index][2] = Math.min(DP[index-1][0],DP[index-1][1])+values[index][2];
        }

        // 결과 저장
        int answer = Integer.MAX_VALUE;
        for(int index=0; index<3; index++) {
            answer = Math.min(answer,DP[houseCount][index]);
        }

        // 결과 출력
        System.out.println(answer);
    }
}