import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {

    // 빌더
    public static StringBuilder sb;

    // 문장
    public static String sentense;

    // 문자 저장 스택
    public static Stack<Character> stack;

    // 단어 뒤집기 메서드
    public static void reverseWord() {

        while(!stack.isEmpty()) {
            sb.append(stack.pop());
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuilder();

        // 문장 입력
        sentense = br.readLine();

        // 스택 생성
        stack = new Stack<>();

        // 태그 여부
        boolean flag = false;

        // 문장 확인
        for(int letterIndex=0; letterIndex<sentense.length(); letterIndex++) {

            // 확인 문자
            char currentLetter = sentense.charAt(letterIndex);

            // '<' 경우
            if(currentLetter=='<') {
                if(!stack.isEmpty()) {
                    reverseWord();
                }

                flag = true;
                sb.append('<');
            }

            // '>' 경우
            else if(currentLetter=='>') {
                flag = false;
                sb.append('>');
            }

            // 공백인 경우
            else if(currentLetter==' ') {

                // 태그 내부인 경우
                if(flag) sb.append(' ');

                // 태그 외부인 경우
                else {
                    if(!stack.isEmpty()) {
                        reverseWord();
                        sb.append(' ');
                    }
                }
            }

            // 문자나 숫자인 경우
            else {

                // 태그 내부인 경우
                if(flag) sb.append(currentLetter);

                // 태그 외부인 경우
                else stack.push(currentLetter);
            }
        }

        // 스택에 문자가 존재하는 경우
        if(!stack.isEmpty()) {
            reverseWord();
        }

        // 결과 출력
        System.out.println(sb.toString());
    }
}