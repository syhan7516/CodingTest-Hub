import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        // 나눌 수
        int divid = 1000000009;

        // 생성 가능 수 저장 배열 생성
        long DP[] = new long[1000001];

        // 기본 값
        DP[1] = 1;
        DP[2] = 2;
        DP[3] = 4;
        DP[4] = 7;

        // 나머지 구하기
        for(int i=5; i<=1000000; i++) {
            DP[i] = (DP[i-1]+DP[i-2]+DP[i-3]) % divid;
        }

        // 테스트 케이스 수 입력
        int caseNum = Integer.parseInt(br.readLine());

        // 케이스 수 만큼 수행
        for(int caseIdx=0; caseIdx<caseNum; caseIdx++) {

            // 정수 입력
            int number = Integer.parseInt(br.readLine());

            // 결과 저장
            sb.append(DP[number]).append("\n");
        }

        // 결과 출력
        System.out.println(sb);
    }
}