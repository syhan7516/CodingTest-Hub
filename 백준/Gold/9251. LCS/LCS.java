import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 두 문자열 입력
        String letter1 = br.readLine();
        String letter2 = br.readLine();

        // 길이
        int letter1Len = letter1.length();
        int letter2Len = letter2.length();

        // LCS 배열 생성
        int LCS[][] = new int[letter1Len+1][letter2Len+1];

        // 확인
        for(int first=0; first<letter1Len; first++) {

            // 확인 문자
            char alpha = letter1.charAt(first);

            // 문자열 확인
            for(int second=0; second<letter2Len; second++) {

                // 동일한 경우
                if(alpha==letter2.charAt(second)) {
                    LCS[first+1][second+1] = LCS[first][second]+1;
                }

                // 다른 경우
                else LCS[first+1][second+1] = Math.max(LCS[first][second+1],LCS[first+1][second]);
            }
        }

        // 결과 출력
        System.out.println(LCS[letter1Len][letter2Len]);
    }
}