import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    // 길이 결과, 두 문자열 길이
    public static int answer, letter1Len, letter2Len;

    // 문자열 결과, 두 문자열
    public static String answerLetter, letter1, letter2;

    // LCS 배열
    public static int[][] LCS;

    // LCS 길이 구하기 메서드
    public static int getLCSLen() {

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

        return LCS[letter1Len][letter2Len];
    }

    // LCS 문자열 구하기 메서드
    public static String getLCSLetter() {

        StringBuilder sb = new StringBuilder();

        // 확인
        int rowIndex = letter1Len;
        int colIndex = letter2Len;
        
        while(rowIndex>0 && colIndex>0) {

            // 문자 조회
            char alpha1 = letter1.charAt(rowIndex-1);
            char alpha2 = letter2.charAt(colIndex-1);

            // 문자가 일치하는 경우
            if(alpha1==alpha2) {
                sb.append(alpha1);
                rowIndex--;
                colIndex--;
            }

            // 문자가 다른 경우
            else {
                if(LCS[rowIndex-1][colIndex]>LCS[rowIndex][colIndex-1])
                    rowIndex--;

                else colIndex--;
            }
        }

        return sb.reverse().toString();
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 두 문자열 입력
        letter1 = br.readLine();
        letter2 = br.readLine();

        // 길이
        letter1Len = letter1.length();
        letter2Len = letter2.length();

        // LCS 배열 생성
        LCS = new int[letter1Len+1][letter2Len+1];

        // LCS 길이 구하기
        System.out.println(getLCSLen());

        // LCS 문자열 구하기
        System.out.println(getLCSLetter());
    }
}