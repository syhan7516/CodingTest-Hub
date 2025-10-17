import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    // MOD
    public static final long MOD = 1000000007L;

    // 배수 구하기 메서드
    public static long solve(int len) {

        // 길이가 1인 경우
        if(len == 1) return 0;

        // DP 배열 생성
        long[][] DP = new long[3][len+1];

        // 초기 설정
        DP[0][2] = DP[1][2] = 1;

        // 확인
        for(int index=3; index<=len; index++){
            DP[0][index] = (DP[1][index-1] + DP[2][index-1]) % MOD;
            DP[1][index] = (DP[0][index-1] + DP[2][index-1]) % MOD;
            DP[2][index] = (DP[0][index-1] + DP[1][index-1]) % MOD;
        }

        return DP[0][len];
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 자리 수 입력
        int len = Integer.parseInt(br.readLine());

        // 결과 출력
        System.out.println(solve(len));
    }
}