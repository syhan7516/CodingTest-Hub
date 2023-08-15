import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

    // 퀸 개수, 결과
    public static int queenCnt, result;

    // 행
    public static int lines[];

    // 퀸을 놓을 수 있는지 확인하는 메서드
    static boolean isPossibility(int col) {

        for(int i=0; i<col; i++) {

            // 행 확인
            if(lines[col]==lines[i])
                return false;

            // 대각선 확인
            if(Math.abs(col-i)==Math.abs(lines[col]-lines[i]))
                return false;
        }

        return true;
    }

    // 퀸 놓기 메서드
    static void solve(int cnt) {

        // 퀸을 다 놓은 경우
        if(cnt==queenCnt) {
            result++;
            return;
        }

        // 퀸 놓을 자리 확인
        for(int i=0; i<queenCnt; i++) {
            lines[cnt] = i;

            // 놓을 수 있는 경우
            if(isPossibility(cnt)) {
                solve(cnt+1);
            }
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 사이즈 크기, 퀸의 개수 입력
        queenCnt = Integer.parseInt(br.readLine());

        // 행 확인 배열 생성
        lines = new int[queenCnt];

        // 기본 설정
        result = 0;

        // 퀸 놓기
        solve(0);

        // 결과 츨력
        System.out.println(result);
    }
}