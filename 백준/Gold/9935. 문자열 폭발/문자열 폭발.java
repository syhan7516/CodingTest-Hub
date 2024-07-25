import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb;

        // 확인된 문자 관리 스택 생성
        Stack<Character> stack = new Stack<>();

        // 문자열 입력
        String letter = br.readLine();

        // 폭발 문자열 입력
        String boom = br.readLine();

        // 문자열 확인
        for(int i=0; i<letter.length(); i++) {

            // 문자 스택에 삽입
            stack.push(letter.charAt(i));

            // 폭발 문자열 길이 이상인 경우
            if(stack.size()>=boom.length()) {

                // 문자열 포함 여부
                boolean flag = true;

                // 스택에 폭발 문자열 포함 여부 확인
                for(int j=0; j<boom.length(); j++) {

                    // 문자 비교 결과 다른 경우
                    if(stack.get(stack.size()-boom.length()+j)!=boom.charAt(j)) {
                        flag = false;
                        break;
                    }
                }

                // 폭발 문자열을 포함한 경우
                if(flag) {
                    for(int j=0; j<boom.length(); j++)
                        stack.pop();
                }
            }
        }

        // 결과 확인
        if(stack.isEmpty()) System.out.println("FRULA");
        else {
            sb = new StringBuilder();
            for(char c: stack) sb.append(c);
            System.out.println(sb.toString());
        }
    }
}