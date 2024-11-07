import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    // 결과
    public static long answer;

    // 심사대 수, 사람 수
    public static int pointCount, saramCount;

    // 심사 시간 배열
    public static int pointTimes[];

    // 심시 시간 확인 메서드
    public static void solve() {

        // 범위 설정
        long left = 1;
        long right = (long)1e9 * (long)1e9;

        // 시간 확인
        while(left<=right) {

            // 기준 시간 설정 및 인원 초기화
            long mid = (left+right)/2;
            long passCount = 0;

            // 심사 가능한 인원 확인
            for(int pointTime=0; pointTime<pointCount; pointTime++) {
                passCount += mid/pointTimes[pointTime];

                // 범위를 넘는 경우
                if(passCount>=saramCount) break;
            }


            // 통과 인원 확인
            if(passCount>=saramCount) {
                answer = mid;
                right = mid-1;
            }

            else left = mid+1;
        }

    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        // 심사대, 사람 수 입력
        st = new StringTokenizer(br.readLine());
        pointCount = Integer.parseInt(st.nextToken());
        saramCount = Integer.parseInt(st.nextToken());

        // 심사 시간 배열 생성
        pointTimes = new int[pointCount];

        // 심사 시간 입력
        for(int pointTime=0; pointTime<pointCount; pointTime++)
            pointTimes[pointTime] = Integer.parseInt(br.readLine());

        // 심사 시간 확인
        answer = Long.MAX_VALUE;
        solve();

        // 결과 출력
        System.out.println(answer);
    }
}