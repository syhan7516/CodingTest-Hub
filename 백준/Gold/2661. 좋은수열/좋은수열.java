import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    // 숫자 길이
    public static int numberLen;

    // 숫자 범위
    public static String range[] = {"1","2","3"};

    // 검증 메서드
    public static boolean validation(String targetLetters) {

        // 검증 범위 설정
        int validLen = targetLetters.length()/2;

        // 검증 수행
        for (int l=1; l<=validLen; l++) {

            // 비교 대상
            String compare1 = targetLetters.substring(targetLetters.length()-l);
            String compare2 = targetLetters.substring(targetLetters.length()-2*l,targetLetters.length()-l);

            // 비교 수행
            if(compare1.equals(compare2))
                return false;
        }

        return true;
    }

    // 숫자 만들기 메서드
    public static void solve(int len, String letters) {

        // 숫자를 다 만든 경우
        if(len==numberLen) {
            System.out.printf(letters);
            System.exit(0);
        }

        // 숫자 만들기
        for (int r=0; r<3; r++) {

            // 검증
            if(!validation(letters+range[r])) continue;

            // 숫자 합치기
            solve(len+1, letters+range[r]);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 숫자 길이 입력
        numberLen = Integer.parseInt(br.readLine());

        // 숫자 만들기
        solve(0,"");
    }
}