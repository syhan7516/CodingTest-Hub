import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb;

        // 암호문 입력
        String secretLetter = br.readLine();
        sb = new StringBuilder(secretLetter);

        // 단어 개수 입력
        int wordCount = Integer.parseInt(br.readLine());

        // 단어 저장 배열 생성
        String words[] = new String[wordCount];

        // 단어 입력
        for(int index=0; index<wordCount; index++)
            words[index] = br.readLine();

        // 이동
        int move = 0;
        boolean result = true;
        while(move<=25 && result) {

            // 1칸씩 이동
            for(int index=0; index<secretLetter.length(); index++) {
                int value = secretLetter.charAt(index)-'a'+1;
                if(value>25) value -= 26;
                sb.setCharAt(index,(char)(value+'a'));
            }

            // 이동된 문자열 저장
            secretLetter = sb.toString();

            // 문자열 속 단어 확인
            for(int index=0; index<wordCount; index++) {
                if(secretLetter.contains(words[index])) {
                    result = false;
                    break;
                }
            }

            // 이동 수 증가
            move++;
        }

        // 결과 출력
        System.out.println(secretLetter);
    }
}