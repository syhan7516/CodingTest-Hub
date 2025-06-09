import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Main {

    // 결과, 단어 개수
    public static int answer, wordCount;

    // 단어
    public static String word;

    // 단어 확인 메서드
    public static void solve() {

        // 이전 문자 저장 리스트 생성
        ArrayList<Character> beforeLetters = new ArrayList<>();

        // 이전 문자
        char beforeLetter = ' ';

        // 단어의 문자 확인
        for(int wordIndex=0; wordIndex<word.length(); wordIndex++) {

            // 현재 문자
            char currentLetter = word.charAt(wordIndex);

            // 이전 문자와 다른 경우
            if(currentLetter!=beforeLetter) {

                // 현재 문자가 이전에 존재했던 경우
                if(beforeLetters.contains(currentLetter)) return;

                // 이전에 없었던 경우
                beforeLetters.add(currentLetter);
                beforeLetter = currentLetter;
            }
        }

        // 그룹 단어 개수 증가
        answer++;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 단어 개수 입력
        wordCount = Integer.parseInt(br.readLine());

        // 각 단어 확인
        for(int letterIndex=0; letterIndex<wordCount; letterIndex++) {

            // 단어 입력
            word = br.readLine();

            // 단어 확인
            solve();
        }

        // 결과 출력
        System.out.println(answer);
    }
}