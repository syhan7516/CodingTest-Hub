import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 첫째 줄에, 테스트 케이스의 개수 T (1 ≤ T ≤ 20)이 주어진다. 각 테스트 케이스는 한 줄로 이루어져 있고, N이 주어진다.

public class Main {

    // MOD
    public static final int MOD = 100999;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        // 케이스 수 입력
        int caseCount = Integer.parseInt(br.readLine());

        // 케이스 숫자 저장 배열 생성
        int[] numbers = new int[caseCount];

        // 케이스 입력
        int maxNumber = 0;
        for (int index=0; index<caseCount; index++) {
            numbers[index] = Integer.parseInt(br.readLine());
            maxNumber = Math.max(maxNumber, numbers[index]);
        }

        // DP 배열 생성
        int[] DP = new int[maxNumber+1];

        // 초기 설정
        DP[0] = 1;

        // 숫자 확인
        for(int numIndex=1; numIndex<=maxNumber; numIndex++) {
            for(int checkNumIndex=maxNumber; checkNumIndex>=numIndex; checkNumIndex--) {
                DP[checkNumIndex] = (DP[checkNumIndex] + DP[checkNumIndex - numIndex]) % MOD;
            }
        }

        // 결과 저장
        for(int index=0; index<caseCount; index++) {
            sb.append(DP[numbers[index]]).append("\n");
        }

        // 결과 출력
        System.out.println(sb.toString());
    }
}