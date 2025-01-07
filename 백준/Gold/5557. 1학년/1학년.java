import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    // 숫자 개수
    public static int numberCount;

    // 숫자 배열
    public static int numbers[];

    // 연산 수행 메서드
    public static long solve() {

        // 단계별 연산 횟수 저장 배열 생성
        long DP[][] = new long[numberCount+1][21];

        // 첫번째 숫자 처리
        DP[1][numbers[0]] = 1;

        // 단계 확인
        for(int stage=1; stage<numberCount; stage++) {

            // 0 ~ 20 연산 결과 확인
            for(int score=0; score<=20; score++) {

                // 연산 결과가 있는 경우
                if(DP[stage][score]>0) {
                    int plusValue = score+numbers[stage];
                    int minusValue = score-numbers[stage];

                    // 범위 확인
                    if(plusValue>=0 && plusValue<=20) DP[stage+1][plusValue] += DP[stage][score];
                    if(minusValue>=0 && minusValue<=20) DP[stage+1][minusValue] += DP[stage][score];
                }
            }
        }

        return DP[numberCount-1][numbers[numberCount-1]];
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        // 숫자 개수 입력
        st = new StringTokenizer(br.readLine());
        numberCount = Integer.parseInt(st.nextToken());

        // 숫자 배열 생성
        numbers = new int[numberCount];

        // 숫자 정보 입력
        st = new StringTokenizer(br.readLine());
        for(int index=0; index<numberCount; index++)
            numbers[index] = Integer.parseInt(st.nextToken());

        // 연산 수행, 결과 출력
        System.out.println(solve());
    }
}