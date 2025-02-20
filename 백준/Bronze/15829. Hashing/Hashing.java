import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 문자열 개수 입력
        int letterLen = Integer.parseInt(br.readLine());

        // 문자열 입력
        String letter = br.readLine();

        // 결과
        BigInteger answer = new BigInteger("0");

        // 연산
        for (int index=0; index<letterLen; index++) {

            // 변환
            long num = letter.charAt(index)-'a'+1;

            // 자리 수 만큼 연산
            for (int position= 0; position<index; position++) {
                num *= 31;
                num %= 1234567891;
            }

            // 연산 결과
            BigInteger mock = new BigInteger(String.valueOf(num));
            answer = answer.add(mock);
            answer = answer.remainder(new BigInteger(String.valueOf(1234567891)));
        }

        // 결과 출력
        System.out.println(answer);
    }
}