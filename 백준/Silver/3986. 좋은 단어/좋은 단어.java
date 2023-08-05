import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 결과
        int result = 0;

        // 단어 개수 입력
        int vocaCnt = Integer.parseInt(br.readLine());

        // 단어 입력 및 확인
        for (int i=0; i<vocaCnt; i++) {
            
            // 단어 입력
            String line = br.readLine();
            
            // 단어 길이가 홀수인 경우
            if (line.length()%2!=0) continue;
            
            // 스택 선언, 생성 및 할당
            Stack<Character> stack = new Stack<>();

            // 단어 확인
            for (int j=0; j<line.length(); j++) {
                
                // 확인 문자
                char alpha = line.charAt(j);
                
                // 스택이 비었을 경우
                if (stack.isEmpty()) 
                    stack.push(alpha);
                
                // 아닌 경우
                else {
                    
                    // 이전 단어와 같을 경우
                    if(stack.peek()==alpha)
                        stack.pop();
                    
                    // 다를 경우
                    else {
                        stack.push(alpha);
                    }
                }
            }
            
            // 확인 후 스택이 비었을 경우
            if(stack.isEmpty()) 
                result++;
        }
        
        // 결과 출력
        System.out.println(result);
    }
}