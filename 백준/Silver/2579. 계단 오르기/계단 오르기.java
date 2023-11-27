import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    // 계단의 수
    public static int stairCnt;

    // 계단 점수 정보 배열
    public static int score[];

    // 계단 누적 점수 정보 배열
    public static int DP[];

    // 구하기
    static void solve() {

        // 배열 초기 값 셋팅
        DP[0] = 0;
        DP[1] = score[1];
        DP[2] = score[2]+score[1];

        // 나머지 값 구하기
        for(int i=3; i<=stairCnt; i++) {
            DP[i] = Math.max(DP[i-2],DP[i-3]+score[i-1])+score[i];
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 계단 수 입력
        stairCnt = Integer.parseInt(br.readLine());

        // 배열 생성
        score = new int[10001];
        DP = new int[10001];

        // 계단 점수 입력
        for(int i=1; i<=stairCnt; i++)
            score[i] = Integer.parseInt(br.readLine());

        // 계단 오르기
        solve();

        // 결과 출력
        System.out.println(DP[stairCnt]);
    }
}