import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

    // 결과 저장
    public static StringBuilder sb = new StringBuilder();

    // 자리 수
    public static int numLen;

    // 첫 번째 자리에 가능한 숫자
    public static String firNum[] = {"2","3","5","7"};

    // 소수 확인 메서드
    static boolean getIsPrime(int number) {

        // 소수 확인
        for(int n=2; n*n<=number; n++) {

            // 소수가 아닌 경우
            if(number%n==0) return false;
        }

        // 소수인 경우
        return true;
    }

    // 신기한 소수 찾기 메서드
    static void solve(int cnt, String number) {

        // 자리 수에 도달한 경우
        if(cnt==numLen) {
            sb.append(number).append("\n");
            return;
        }

        // 아닌 경우
        for(int n=0; n<10; n++) {

            // 만든 숫자
            String newNum = number+n;

            // 숫자 소수 확인
            if(getIsPrime(Integer.parseInt(newNum)))
                solve(cnt+1,newNum);
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 자리 수 입력
        numLen = Integer.parseInt(br.readLine());

        // 신기한 소수 찾기
        for(int n=0; n<4; n++) {
            solve(1,firNum[n]);
        }

        // 결과 출력
        System.out.println(sb.toString());
    }
}
