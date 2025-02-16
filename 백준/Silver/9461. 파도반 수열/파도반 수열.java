import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        // 수열 배열 생성
        long DP[] = new long[101];

        // 수열 만들기
        DP[1] = DP[2] = DP[3] = 1;
        DP[4] = DP[5] = 2;
        for(int index=6; index<101; index++)
            DP[index] = DP[index-5] + DP[index-1];

        // 테스트 케이스 수 입력
        int caseCount = Integer.parseInt(br.readLine());

        // 케이스 수행
        for(int caseIndex=0; caseIndex<caseCount; caseIndex++) {

            // 수 입력
            int number = Integer.parseInt(br.readLine());

            // 결과 저장
            sb.append(DP[number]).append("\n");
        }

        // 결과 출력
        System.out.println(sb.toString());
    }
}