import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    // 정수
    public static int number;

    // 0,1 개수 정보 배열
    public static long DP[][];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        // 0,1 개수 정보 배열 생성
        DP = new long[41][2];

        // 배열 초기 값
        DP[0][0] = 1;
        DP[1][1] = 1;
        DP[2][0] = 1;
        DP[2][1] = 1;

        // 0,1 개수 정보 구하기
        for(int i=3; i<=40; i++) {
            DP[i][0] = DP[i-1][0] + DP[i-2][0];
            DP[i][1] = DP[i-1][1] + DP[i-2][1];
        }

        // 테스트 케이스 수 입력
        int caseNum = Integer.parseInt(br.readLine());

        // 케이스 수 만큼 수행
        for(int caseIdx=0; caseIdx<caseNum; caseIdx++) {

            // 정수 입력
            number = Integer.parseInt(br.readLine());

            // 결과 저장
            sb.append(DP[number][0]).append(" ").append(DP[number][1]).append("\n");
        }

        // 결과 출력
        System.out.println(sb.toString());
    }
}