import java.io.*;

public class Main {

    // 횟수
    public static int count;

    // DP 배열
    public static long[] DP;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 횟수 입력
        count = Integer.parseInt(br.readLine());

        // DP 배열 생성
        DP = new long[count+1];

        // 확인
        for(int index=1; index<=count; index++) {
            DP[index] = DP[index-1] + 1;
            if(index > 6) {
                for(int point=3; point<=5; point++) {
                    DP[index] = Math.max(DP[index], DP[index-point] * (point-1));
                }
            }
        }

        // 결과 출력
        System.out.println(DP[count]);
    }
}