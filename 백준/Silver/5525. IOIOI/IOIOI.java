import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    // MOD
    public static final int MOD = 15746;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // IO 정보 입력
        int IO = Integer.parseInt(br.readLine());

        // 문자열 길이 입력
        int letterLen = Integer.parseInt(br.readLine());

        // 문자열 입력
        String letter = br.readLine();

        // 문자열 확인
        int answer = 0;
        int count = 0;
        for(int index=1; index<letterLen-1; index++) {

            // IOI
            if(letter.charAt(index-1) == 'I' && letter.charAt(index) == 'O' && letter.charAt(index+1) == 'I')  {

                // OI 수 증가
                count++;

                // 원하는 길이인 경우
                if(count==IO) {
                    count--;
                    answer++;
                }

                index++;
            }

            else count = 0;
        }

        // 결과 출력
        System.out.println(answer);
    }
}