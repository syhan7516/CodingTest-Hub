import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Stack<Character> stack = new Stack<>();
        StringBuilder sb = new StringBuilder();

        // 문자열 입력
        String letters = br.readLine();
        // 폭파 문자열
        String findLetters = br.readLine();

        for(int idx=0; idx<letters.length(); idx++) {
            char element = letters.charAt(idx);
            stack.push(element);

            // 폭팔 문자열만큼 길이가 들어온다면 확인
            if(stack.size()>=findLetters.length()) {
                // 결과 여부 확인 플래그
                boolean flag = true;
                int stackSize = stack.size();
                int findLettersLen = findLetters.length();
                for(int c=0; c<findLettersLen; c++) {
                    // 비교
                    if(stack.get(stackSize-findLettersLen+c)!=findLetters.charAt(c)) {
                        flag = false;
                        break;
                    }
                }

                // 만약 폭팔 문자열을 확인할 경우
                if(flag==true) {
                    for(int c=0; c<findLettersLen; c++) {
                        stack.pop();
                    }
                }
            }
        }

        // 결과값 저장
        for(char c: stack)
            sb.append(c);

        // 결과 확인
        if(sb.length()==0)
            System.out.println("FRULA");
        else
            System.out.println(sb.toString());
    }
}
