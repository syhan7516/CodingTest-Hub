import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader be = new BufferedReader(new InputStreamReader(System.in));

        // 결과
        int answer = 0;

        // 아이들 수 입력
        int saramCount = Integer.parseInt(be.readLine());

        // 아이들 위치, LIS 배열 생성
        int points[] = new int[saramCount];
        int DP[] = new int[saramCount];

        // 아이들 위치 정보 입력
        for(int index=0; index<saramCount; index++) {
            points[index] = Integer.parseInt(be.readLine());
        }

        // LIS 구하기
        for(int index=0; index<saramCount; index++) {

            // 현재 기준 길이
            int maxLen = 1;

            // 앞 길이 비교
            for(int point=index-1; point>=0; point--) {

                // 길이 확인
                if(points[index]>points[point]) {
                    maxLen = Math.max(maxLen,DP[point]+1);
                }
            }

            // 길이 저장
            DP[index] = maxLen;
            answer = Math.max(answer,DP[index]);
        }

        // 결과 출력
        System.out.println(saramCount-answer);
    }
}