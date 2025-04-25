import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    // 약 개수
    public static int pillCount;

    // 약 경우의 수 저장 배열
    public static long[] DP;

    // 약 최대 개수
    public static final int MAX_PILL_COUNT = 30;

    // 약 경우의 수 구하는 메서드
    public static void solve() {

        // 약 개수별 경우의 수 저장 배열 생성
        DP = new long[MAX_PILL_COUNT+1];

        // 약 0개 - X
        DP[0] = 1;

        // 약 1개 - HW
        DP[1] = 1;

        // 약 2개 - HHWW, HWHW
        DP[2] = 2;

        // 약 30개까지 확인
        for(int pill=3; pill<=MAX_PILL_COUNT; pill++) {

            // 약 경우의 수
            long count = 0;

            // 점화식
            for(int index=0; index<pill; index++) {
                count += DP[index] * DP[pill-1-index];
            }

            // 저장
            DP[pill] = count;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        // 약 경우의 수 구하기
        solve();

        // 테스트 케이스 수행
        while (true) {

            // 약 개수 입력
            pillCount = Integer.parseInt(br.readLine());

            // 약이 없는 경우
            if(pillCount==0) break;

            // 결과 저장
            sb.append(DP[pillCount]).append("\n");
        }

        // 결과 출력
        System.out.println(sb.toString());
    }
}