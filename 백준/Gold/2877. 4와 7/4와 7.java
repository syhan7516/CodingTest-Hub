import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        // 0, 1로 변환
        String bitForfourOrSeven = Integer.toBinaryString(Integer.parseInt(br.readLine())+1);

        // 0 -> 4, 1 -> 7로 변환
        bitForfourOrSeven = bitForfourOrSeven.replace('0','4').replace('1', '7');

        // 결과 저장
        for(int index=1;index<bitForfourOrSeven.length(); index++) {
            sb.append(bitForfourOrSeven.charAt(index));
        }

        // 결과 출력
        System.out.println(sb.toString());
    }
}