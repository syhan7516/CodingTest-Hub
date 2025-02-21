import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    // MOD
    public static final int MOD = 15746;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 문자 길이 입력
        int letterLen = Integer.parseInt(br.readLine());

        // 가능한 경우의 수 저장 배열 생성
        int DP[] = new int[1000001];
        DP[1] = 1;
        DP[2] = 2;

        // 경우의 수 구하기 메서드
        for(int len=3; len<=letterLen; len++) {
            DP[len] = (DP[len-1]+DP[len-2]) % MOD;
        }

        // 결과 출력
        System.out.println(DP[letterLen]);
    }
}