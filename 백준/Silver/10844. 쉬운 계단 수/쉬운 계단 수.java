import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 길이 입력
        int numLen = Integer.parseInt(br.readLine());

        // 개수 저장 배열
        int DP[][] = new int[numLen+1][12];

        // 초기 설정
        for(int index=2; index<=10; index++)
            DP[1][index] = 1;

        // 개수 확인
        for(int len=2; len<=numLen; len++) {
            for(int num=1; num<=10; num++) {
                DP[len][num] = (DP[len-1][num-1]+DP[len-1][num+1])%1000000000;
            }
        }

        // 결과 출력
        int answer = 0;
        for(int index=1; index<=10; index++)
            answer = (answer+DP[numLen][index])%1000000000;
        System.out.println(answer);
    }
}