import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    // 문자열 변환 성공 여부
    public static boolean flag;

    // 문자열 변환 메서드
    public static void solve(String letter, String target) {

        // 길이가 동일한 경우
        if(letter.length()==target.length()) {

            // 두 문자열이 일치한 경우
            if(letter.equals(target))
                flag = true;
            return;
        }

        // 문자열 변환 수행

        // B 시작하는 경우
        if (target.charAt(0)=='B') 
            solve(letter, new StringBuilder(target.substring(1)).reverse().toString());

        // A 끝나는 경우
        if (target.charAt(target.length()-1)=='A') 
            solve(letter,target.substring(0,target.length()-1));
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 첫 문자열 입력
        String first = br.readLine();

        // 목표 문자열 입력
        String second = br.readLine();

        // 문자열 변환
        flag = false;
        solve(first,second);

        // 결과 출력
        if(flag) System.out.println(1);
        else System.out.println(0);
    }
}