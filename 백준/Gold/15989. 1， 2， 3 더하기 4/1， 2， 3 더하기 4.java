import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        // DP 테이블 생성
        int DP[] = new int[10001];

        // 초기 설정
        DP[0] = 1;

        // 1 ~ 3
        for(int i=1; i<=3; i++) {

            // 1 ~ 10000
            for(int j=1; j<=10000; j++) {

                // 연산 숫자보다 작은 경우
                if(j-i<0) continue;

                /// 연산 숫자보다 클 경우
                DP[j] += DP[j-i];
            }
        }

        // 테스트 케이스 입력
        int caseNum = Integer.parseInt(br.readLine());

        // 케이스 수 만큼 수행
        for(int t=0; t<caseNum; t++) {

            // 숫자 입력
            int number = Integer.parseInt(br.readLine());

            // 결과 저장
            sb.append(DP[number]).append("\n");
        }

        // 결과 출력
        System.out.println(sb.toString());
    }
}