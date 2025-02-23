import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 계단 개수 입력
        int count = Integer.parseInt(br.readLine());

        // 계단 배열 생성
        int stage[] = new int[count+1];

        // 각 계단 점수 입력
        for(int index=1; index<=count; index++) {
            stage[index] = Integer.parseInt(br.readLine());
        }

        if(count==1) {

            // 결과 출력
            System.out.println(stage[1]);
        }

        else {

            // 계단 점수 배열 생성
            int DP[] = new int[301];
            Arrays.fill(DP,-1);
            DP[0] = 0;
            DP[1] = stage[1];
            DP[2] = DP[1] + stage[2];

            // 계단 오르기
            for(int index=3; index<=count; index++) {
                DP[index] = Math.max(DP[index-3]+stage[index-1],DP[index-2]) + stage[index];
            }

            // 결과 출력
            System.out.println(DP[count]);
        }
    }
}