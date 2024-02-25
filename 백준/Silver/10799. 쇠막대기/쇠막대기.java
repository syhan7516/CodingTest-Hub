import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 결과
        int answer = 0;

        // 문자열 입력
        char letters[] = br.readLine().toCharArray();

        // 스택
        Stack<Character> stack = new Stack<>();

        // 문자 확인
        for(int i=0; i<letters.length; i++) {

            // (
            if(letters[i]=='(')
                stack.push(letters[i]);

            // )
            else {

                // 이전 문자 확인
                if(letters[i-1]=='(') {
                    stack.pop();
                    answer += stack.size();
                }

                else {
                    stack.pop();
                    answer++;
                }
            }
        }

        // 결과 출력
        System.out.println(answer);
    }
}