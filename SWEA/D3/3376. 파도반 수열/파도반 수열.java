import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        // DP 테이블
        long DP[] = new long[101];

        // 기본 셋팅
        DP[1] = DP[2] = DP[3] = 1;
        DP[4] = DP[5] = 2;

        // 각 삼각형 변의 길이 구하기
        for(int n=6; n<=100; n++)
            DP[n] = DP[n-1] + DP[n-5];

        // 테스트 케이스 수 입력
        int caseNum = Integer.parseInt(br.readLine());

        // 케이스 수만큼 수행
        for(int caseIdx=0; caseIdx<caseNum; caseIdx++) {

            // 자연수 입력
            int number = Integer.parseInt(br.readLine());

            // 결과 저장
            sb.append("#"+(caseIdx+1)+" "+DP[number]+"\n");
        }

        // 결과 출력
        System.out.println(sb.toString());
    }
}