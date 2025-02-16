import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        // 테스트 케이스 수 입력
        int caseCount = Integer.parseInt(br.readLine());

        // 케이스 수행
        for(int caseIndex=0; caseIndex<caseCount; caseIndex++) {

            // 정답 문자열 입력
            String result = br.readLine();

            // 점수
            int score = 0;
            int currentScore = 0;

            // 정답 확인
            for(int index=0; index<result.length(); index++) {

                // 결과 확인
                char letter = result.charAt(index);

                // 맞은 경우
                if(letter=='O') {
                    currentScore++;
                    score += currentScore;
                }

                // 틀린 경우
                else currentScore = 0;
            }

            // 결과 저장
            sb.append(score).append("\n");
        }

        // 결과 출력
        System.out.println(sb.toString());
    }
}