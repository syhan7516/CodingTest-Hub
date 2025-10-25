import java.io.*;
import java.util.*;

public class Main {

    // 주기, 종류 개수
    public static int days, kindCount;

    // 디저트, DP 배열
    public static int[][] dessert, DP;

    public static int solve(int day, int before) {

        // 마지막 날인 경우
        if(day == days) return 0;

        // 만족감이 존재하는 경우
        if(DP[before][day] != -1) return DP[before][day];

        // 만족감 확인
        int score = 0;
        for(int kind=0; kind<kindCount; kind++) {
            if(day != 0 && kind == before) {
                score = Math.max(score ,solve(day + 1, kind) + dessert[kind][day]/2);
            }
            else {
                score = Math.max(score ,solve(day + 1, kind) + dessert[kind][day]);
            }
        }
        
        return DP[before][day] = score;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        // 주기, 종류 개수 입력
        st = new StringTokenizer(br.readLine());
        days = Integer.parseInt(st.nextToken());
        kindCount = Integer.parseInt(st.nextToken());

        // 배열 생성
        dessert = new int[kindCount][days];
        DP = new int[kindCount][days];

        // 디저트별 주기 입력
        for(int kind=0; kind<kindCount; kind++) {
            st = new StringTokenizer(br.readLine());
            Arrays.fill(DP[kind], -1);

            for(int day=0; day<days; day++) {
                dessert[kind][day] = Integer.parseInt(st.nextToken());
            }
        }

        // 결과 출력
        System.out.println(solve(0, 0));
    }
}