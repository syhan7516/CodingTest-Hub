import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    // 최대 숫자
    public static final int MAX_VALUES = 1299709;

    // 숫자
    public static int number;

    // 소수 여부 배열
    public static boolean[] isPrime;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        // 소수 여부 배열 생성
        isPrime = new boolean[MAX_VALUES+1];

        // 소수 구하기
        isPrime[0] = isPrime[1] = true;
        for(int num=2; num*num<=MAX_VALUES; num++) {
            if(!isPrime[num]) {
                for(int dividNum=num*2; dividNum<=MAX_VALUES; dividNum+=num) {
                    isPrime[dividNum] = true;
                }
            }
        }

        // 테스트 케이스 수 입력
        int caseCount = Integer.parseInt(br.readLine());

        // 케이스 수행
        for(int caseNum=1; caseNum<=caseCount; caseNum++) {

            // 숫자 입력
            number = Integer.parseInt(br.readLine());

            // 소수 확인
            if(isPrime[number]) {
                int startNum = number;
                int endNum = number;
                while(true) {
                    if(!isPrime[--startNum]) break;
                }
                while(true) {
                    if(!isPrime[++endNum]) break;
                }
                sb.append(endNum - startNum);
            }
            else sb.append(0);
            sb.append("\n");
        }

        // 결과 출력
        System.out.println(sb.toString());
    }
}