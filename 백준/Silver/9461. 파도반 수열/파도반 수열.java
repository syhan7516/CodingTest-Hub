import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        // 테스트 케이스 수 입력
        int caseNum = Integer.parseInt(br.readLine());

        // 케이스 수만큼 수행
        for(int caseIdx=0; caseIdx<caseNum; caseIdx++) {

            // DP 테이블 생성
            long DP[] = new long[101];
            DP[0] = DP[1] = DP[2] = DP[3] = 1;
            for(int d=4; d<=100; d++) {
                DP[d] = DP[d-2] + DP[d-3];
            }

            // N 입력
            int N = Integer.parseInt(br.readLine());

            // N 값 저장
            sb.append(DP[N]+"\n");
        }

        // 결과 출력
        System.out.println(sb.toString());
    }
}