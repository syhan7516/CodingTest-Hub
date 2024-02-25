import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        // 테스트 케이스 수 입력
        int caseNum = Integer.parseInt(br.readLine());

        // 케이스 수 만큼 수행
        for(int caseIdx=1; caseIdx<=caseNum; caseIdx++) {

            // 체크 현황
            int visited = 0;

            // 목표 값
            int total = (1<<10)-1;

            // 배수
            int idx = 1;

            // 완료 여부
            boolean flag = false;

            // 숫자 입력
            int number = Integer.parseInt(br.readLine());

            while(true) {

                // 숫자 확인
                char numbers[] = String.valueOf(number*idx).toCharArray();

                for(int i=0; i<numbers.length; i++) {
                    int n = numbers[i]-'0';
                    visited = visited | (1<<n);

                    // 체크가 완료된 경우
                    if(visited==total) {
                        sb.append("#").append(caseIdx).append(" ").append(number*idx).append("\n");
                        flag = true;
                        break;
                    }
                }

                // 완료된 경우
                if(flag) break;

                // 배수 증가
                idx++;
            }
        }

        // 결과 출력
        System.out.println(sb.toString());
    }
}