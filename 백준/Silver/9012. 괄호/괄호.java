import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {

    // 괄호 문자열
    public static String parenthesisLetters;

    // 괄호 저장 스택
    public static Stack<Character> stack;

    // 괄호 문자열 확인 메서드
    public static String solve() {

        // 괄호 저장 스택 생성
        stack = new Stack<>();

        // 괄호 확인
        for(int letterIndex=0; letterIndex<parenthesisLetters.length(); letterIndex++) {

            // 확인 괄호
            char parenthesis = parenthesisLetters.charAt(letterIndex);

            // '(' 경우
            if(parenthesis=='(') {
                stack.push(parenthesis);
            }

            // ')' 경우
            else {

                // 확인 괄호가 없는 경우
                if(stack.isEmpty()) return "NO";

                // 짝이 맞지 않는 경우
                if(stack.peek()==')') return "NO";

                // 짝이 맞는 경우
                stack.pop();
            }
        }

        // 짝이 맞지 않아 남은 경우
        if(!stack.isEmpty()) return "NO";

        // 짝이 다 맞는 경우
        return "YES";
    }


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        // 테스트 케이스 수 입력
        int caseCount = Integer.parseInt(br.readLine());

        // 케이스 수행
        for(int caseIndex=0; caseIndex<caseCount; caseIndex++) {

            // 괄호 문자열 입력
            parenthesisLetters = br.readLine();

            // 괄호 확인
            sb.append(solve()).append("\n");
        }

        // 결과 출력
        System.out.println(sb.toString());
    }
}