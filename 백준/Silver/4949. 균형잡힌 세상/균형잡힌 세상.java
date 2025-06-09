import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {

    // 괄호 문자열
    public static String parenthesisLetters;

    // 괄호 저장 스택
    public static Stack<Character> stack;

    // 괄호 여부 확인 메서드
    public static boolean isNotParenthesis(char parenthesis) {
        return !(parenthesis=='(' || parenthesis==')' || parenthesis=='[' || parenthesis==']');
    }

    // 괄호 짝 여부 확인 메서드
    public static boolean isPaired(char parenthesis) {
        return (parenthesis==')' && stack.peek()=='(') || (parenthesis==']' && stack.peek()=='[');
    }

    // 괄호 문자열 확인 메서드
    public static String solve() {

        // 괄호 저장 스택 생성
        stack = new Stack<>();

        // 괄호 확인
        for(int letterIndex=0; letterIndex<parenthesisLetters.length(); letterIndex++) {

            // 확인 괄호
            char parenthesis = parenthesisLetters.charAt(letterIndex);

            // 괄호가 아닌 경우
            if(isNotParenthesis(parenthesis)) continue;

            // 여는 괄호인 경우
            if(parenthesis=='(' || parenthesis=='[') {
                stack.push(parenthesis);
            }

            // 닫는 괄호인 경우
            else {

                // 확인 괄호가 없는 경우
                if(stack.isEmpty()) return "no";

                // 짝이 맞는 경우
                if(isPaired(parenthesis)) {
                    stack.pop();
                }

                // 짝이 맞지 않는 경우
                else return "no";
            }
        }

        // 짝이 맞지 않아 남은 경우
        if(!stack.isEmpty()) return "no";

        // 짝이 다 맞는 경우
        return "yes";
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        // 각 괄호 문자열 확인
        while(!".".equals(parenthesisLetters=br.readLine())) {

            // 괄호 확인
            sb.append(solve()).append("\n");
        }

        // 결과 출력
        System.out.println(sb.toString());
    }
}