import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        // 테스트 케이스 수 입력
        int caseNum = Integer.parseInt(br.readLine());

        // 케이스 수 만큼 수행
        for(int caseIdx=0; caseIdx<caseNum; caseIdx++) {

            // 괄호 문자열 입력
            String letters = br.readLine();

            // 괄호 짝 확인
            Stack<Character> stack = new Stack<>();
            boolean flag = true;
            for(int c=0; c<letters.length(); c++) {
                char letter = letters.charAt(c);

                // ( 인 경우
                if(letter=='(')
                    stack.push('(');

                // ) 인 경우
                else {
                    if(!stack.isEmpty())
                        stack.pop();
                    else {
                        flag = false;
                        break;
                    }
                }
            }

            // VPS 확인 여부
            if(stack.isEmpty() && flag)
                sb.append("YES"+"\n");
            else
                sb.append("NO"+"\n");
        }

        // 결과 출력
        System.out.println(sb.toString());
    }
}