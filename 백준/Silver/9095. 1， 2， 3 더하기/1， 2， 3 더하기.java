import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    // 정수, 만들 수있는 가능한 방법 수
    public static int number, cnt;

    // 정수 만들기
    static void solve(int num) {

        // 정수와 같거나 큰 경우
        if(num>=number) {

            // 같은 경우
            if(num==number) {
                cnt++;
                return;
            }

            // 다른 경우
            else return;
        }

        // 1~3 더해보기
        for(int i=1; i<=3; i++) {
            solve(num+i);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        // 테스트 케이스 수 입력
        int caseNum = Integer.parseInt(br.readLine());

        // 케이스 수 만큼 수행
        for(int caseIdx=0; caseIdx<caseNum; caseIdx++) {

            // 정수 입력
            number = Integer.parseInt(br.readLine());

            // 정수 만들기
            cnt = 0;
            solve(0);

            // 결과 저장
            sb.append(cnt).append("\n");
        }

        // 결과 출력
        System.out.println(sb.toString());
    }
}