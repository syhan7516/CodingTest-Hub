import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    // MOD
    public static final int MOD = 9901;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 동물원 크기 입력
        int size = Integer.parseInt(br.readLine());

        // 동물원 생성
        int DP[][] = new int[size+1][3];

        // 초기 설정
        DP[1][0] = DP[1][1] = DP[1][2] = 1;

        // 동물원 확인
        for(int index=2; index<=size; index++) {

            // 해당 위치에 사자를 놓지 않는 경우
            DP[index][0] = (DP[index-1][0]+DP[index-1][1]+DP[index-1][2])%MOD;

            // 1 위치에 사자를 놓는 경우
            DP[index][1] = (DP[index-1][0]+DP[index-1][2])%MOD;

            // 2 위치에 사자를 놓는 경우
            DP[index][2] = (DP[index-1][0]+DP[index-1][1])%MOD;
        }

        // 결과 출력
        int answer = (DP[size][0]+DP[size][1]+DP[size][2])%MOD;
        System.out.println(answer);
    }
}