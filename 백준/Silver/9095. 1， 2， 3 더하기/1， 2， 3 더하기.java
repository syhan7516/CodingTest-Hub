import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        // DP 배열 생성
        int DP[] = new int[11];

        // 기본 셋팅
        DP[1] = 1;
        DP[2] = 2;
        DP[3] = 4;

        // 방법 수 찾기
        for(int n=4; n<11; n++) {
            DP[n] = DP[n-3]+DP[n-2]+DP[n-1];
        }

        // 테스트 케이스 수 입력
        int caseNum = Integer.parseInt(br.readLine());

        // 각 케이스 수행
        for(int caseIdx=0; caseIdx<caseNum; caseIdx++) {

            // 숫자 입력
            int num = Integer.parseInt(br.readLine());

            // 결과 저장
            sb.append(DP[num]).append("\n");
        }

        // 결과 출력
        System.out.println(sb.toString());
    }
}