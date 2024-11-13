import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    // 최대 섭취 개수, 가능량
    public static final int MAX_KCAL = 100000;
    public static final int MAX_COFFEE = 101;

    // 커피 개수, 목표 칼로리 수
    public static int coffeeCount, targetkcal;

    // 커피 칼로리 정보 배열
    public static int kcals[];

    // 섭취량 정보 배열
    public static int DP[];

    // 커피 마시기 메서드
    public static void solve() {

        // 초기화
        Arrays.fill(DP,MAX_COFFEE);
        DP[0] = 0;

        // 커피 순회
        for(int coffee=0; coffee<coffeeCount; coffee++) {

            // 기준 칼로리
            int currentKcal = kcals[coffee];

            // 칼로리 비교
            for(int kcal=targetkcal; kcal>=0; kcal--) {

                // 해당 커피를 마시기 전
                int preKcal = kcal-currentKcal;

                // 마시기 전 칼로리가 0이상이며, 해당 수치까지 만들 수 있는 경우
                if(preKcal>=0 && DP[preKcal] != MAX_COFFEE) {
                    DP[kcal] = Math.min(DP[kcal],DP[preKcal]+1);
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        // 커피 개수, 칼로리 수 입력
        st = new StringTokenizer(br.readLine());
        coffeeCount = Integer.parseInt(st.nextToken());
        targetkcal = Integer.parseInt(st.nextToken());

        // 섭취량 정보 배열 생성
        DP = new int[MAX_KCAL+1];

        // 커피 칼로리 정보 배열 생성
        kcals = new int[coffeeCount];

        // 칼로리 정보 입력
        st = new StringTokenizer(br.readLine());
        for(int coffee=0; coffee<coffeeCount; coffee++)
            kcals[coffee] = Integer.parseInt(st.nextToken());

        // 커피 마시기
        solve();

        // 결과 출력
        if(DP[targetkcal]==MAX_COFFEE) System.out.println(-1);
        else System.out.println(DP[targetkcal]);
    }
}