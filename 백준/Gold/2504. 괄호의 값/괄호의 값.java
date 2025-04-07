import java.io.*;
import java.util.Stack;
 
public class Main {
 
    public static void main(String[] args) throws IOException {
 
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String words = br.readLine(); // 입력받을 괄호 값
        Stack<Character> stack = new Stack<>();
 
        int answer = 0, tmp = 1; // tmp: 누적으로 곱셈 계산을 할당하기 위한 변수, answer: 괄호가 닫히면 tmp에서 곱해진 값을 더함
        boolean isError = false;
 
        for (int i = 0; i < words.length(); i++) {
            if (words.charAt(i) == '(') {
                stack.push('(');
                tmp *= 2;
            }
            else if (words.charAt(i) == ')') {
                if (stack.isEmpty() || stack.peek() != '(') { // 괄호 짝이 안맞는 경우
                    isError = true;
                    break;
                }
                else {
                    if (words.charAt(i - 1) == '(') answer += tmp; // 괄호 짝이 맞는 경우
                    stack.pop();
                    tmp /= 2; // 분배법칙으로 모든 항에 골고루 곱하기 위함
                }
            }
            else if ( words.charAt(i) == '[') {
                stack.push('[');
                tmp *= 3;
            }
            else if (words.charAt(i) == ']') {
                if (stack.isEmpty() || stack.peek() != '[') {
                    isError = true;
                    break;
                }
                else {
                    if ( words.charAt(i - 1) == '[') answer += tmp;
                    stack.pop();
                    tmp /= 3;
                }
            }
        }
 
        if (isError || !stack.isEmpty()) {
            bw.write("0");
        }
        else bw.write(String.valueOf(answer));
 
        bw.flush();
        bw.close();
    }
}