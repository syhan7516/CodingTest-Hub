import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 정수 입력
        int number = Integer.parseInt(br.readLine());

        // 이친수 배열 생성
        long DP[] = new long[91];

        // 이친수 기본 정보 저장
        DP[1] = 1;
        DP[2] = 1;
        DP[3] = 2;

        // 이친수 정보 구하기
        for(int i=4; i<91; i++) {
            DP[i] = DP[i-1]+DP[i-2];
        }

        // 결과 출력
        System.out.println(DP[number]);
    }
}