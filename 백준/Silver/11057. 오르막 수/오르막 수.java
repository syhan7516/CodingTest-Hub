import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 길이 입력
        int numLen = Integer.parseInt(br.readLine());

        // 개수 배열 생성
        int DP[][] = new int[numLen+1][11];
        for(int index=1; index<=10; index++) {
            DP[1][index] = 1;
        }

        // 개수 구하기
        for(int len=2; len<=numLen; len++) {
            for(int num=1; num<=10; num++) {
                for(int small=1; small<=num; small++) {
                    DP[len][num] = (DP[len][num]+DP[len-1][small]) % 10007;
                }
            }
        }

        // 결과 저장
        int answer = 0;
        for(int index=1; index<=10; index++) {
            answer = (answer+DP[numLen][index]) % 10007;
        }

        // 결과 출력
        System.out.println(answer);
    }
}