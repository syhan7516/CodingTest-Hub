import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    // 문자열 만들기 메서드
    public static String makeLetters(int kind, StringBuilder letters) {

        for(int index=0; index<kind; index++)
            letters.append("IO");

        return letters.append("I").toString();
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        // 결과
        int answer = 0;

        // 찾으려는 문자열 종류 입력
        int kind = Integer.parseInt(br.readLine());

        // 확인 문자열 길이 입력
        int compareLetterLength = Integer.parseInt(br.readLine());

        // 확인 문자열 입력
        String compareLetters = br.readLine();

        // 문자열 만들기
        String target = makeLetters(kind, new StringBuilder());

        // 문자열 비교
        int range = compareLetterLength-target.length();

        for(int index=0; index<=range; index++) {
            String compareLetter = compareLetters.substring(index,index+target.length());

            if(target.equals(compareLetter))
                answer++;
        }

        // 결과 출력
        System.out.println(answer);
    }
}