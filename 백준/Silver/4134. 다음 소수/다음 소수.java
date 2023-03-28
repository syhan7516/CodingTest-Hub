import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.math.BigInteger;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 케이스 수 입력
        int caseNum = Integer.parseInt(br.readLine());

        // 케이스 수만큼 수행
        for(int caseIdx=0; caseIdx<caseNum; caseIdx++) {

            // 정수 입력
            BigInteger nextPrimeNumber = new BigInteger(br.readLine());

            // 현재 숫자 소수 판별
            if(nextPrimeNumber.isProbablePrime(10))
                System.out.println(nextPrimeNumber);

            // 아닌 경우 다음 소수 찾기
            else
                System.out.println(nextPrimeNumber.nextProbablePrime());
        }
    }
}