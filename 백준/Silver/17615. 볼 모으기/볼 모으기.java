import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    // 결과, 볼 전체 개수, R 개수, B 개수
    public static int answer, totalBallCount, redBallCount, blueBallCount;

    // 볼
    public static String balls;

    // 볼 개수 확인 메서드
    public static void checkBallCount(String balls) {

        // 볼 순회
        for(int ball=0; ball<balls.length(); ball++) {

            // 기준 볼
            char currentBall = balls.charAt(ball);

            // 빨간 공인 경우
            if(currentBall=='R') redBallCount++;

            // 파란 공인 경우
            else blueBallCount++;
        }
    }

    // 볼 왼쪽으로 모두 옮기는 최소 횟수 구하기 메서드
    public static int ballsMoveToLeftCount(char colorBall, int ballCount) {

        // 왼쪽으로 몰려있는 볼 개수
        int leftBallCount = 0;

        // 볼 순회
        for(int ball=0; ball<balls.length(); ball++) {

            // 원하는 볼 색깔일 경우
            if(balls.charAt(ball)==colorBall)
                leftBallCount++;

            // 아닌 경우
            else break;
        }

        return ballCount-leftBallCount;
    }

    // 볼 오른쪽으로 모두 옮기는 최소 횟수 구하기 메서드
    public static int ballsMoveToRightCount(char colorBall, int ballCount) {

        // 오른쪽으로 몰려있는 볼 개수
        int rightBallCount = 0;

        // 볼 순회
        for(int ball=balls.length()-1; ball>=0; ball--) {

            // 원하는 볼 색깔일 경우
            if(balls.charAt(ball)==colorBall)
                rightBallCount++;

                // 아닌 경우
            else break;
        }

        return ballCount-rightBallCount;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 결과
        answer = 500001;

        // 볼 개수 입력
        totalBallCount = Integer.parseInt(br.readLine());

        // 볼 입력
        balls = br.readLine();

        // 볼 개수 확인
        checkBallCount(balls);

        // R 왼쪽으로 모두 옮기는 경우
        answer = Math.min(answer,ballsMoveToLeftCount('R',redBallCount));

        // R 오른쪽으로 모두 옮기는 경우
        answer = Math.min(answer,ballsMoveToRightCount('R',redBallCount));

        // B 왼쪽으로 모두 옮기는 경우
        answer = Math.min(answer,ballsMoveToLeftCount('B',blueBallCount));

        // B 오른쪽으로 모두 옮기는 경우
        answer = Math.min(answer,ballsMoveToRightCount('B',blueBallCount));

        // 결과 출력
        System.out.println(answer);
    }
}