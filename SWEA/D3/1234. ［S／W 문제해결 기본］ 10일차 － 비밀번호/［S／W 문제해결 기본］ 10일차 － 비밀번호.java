import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int count = 1;

        while(true) {
            // 종료 조건
            if(count==11)
                break;

            // 비밀번호 확인을 위한 스택
            Stack<Character> stack = new Stack<>();

            st = new StringTokenizer(br.readLine());

            // 비밀번호 길이 입력
            int passwordLen = Integer.parseInt(st.nextToken());

            // 비밀번호 입력
            String password = st.nextToken();

            // 비밀번호 소거
            for(int p=0; p<password.length(); p++) {
                char pw = password.charAt(p);
                
                // 스택이 비었을 경우
                if(stack.isEmpty()) {
                    stack.push(pw);
                    continue;
                }
                
                // 입력하려는 수가 같은 경우
                else if(stack.peek()==pw) {
                    stack.pop();
                    continue;
                }
                stack.push(pw);
            }

            // 결과 저장
            char result[] = new char[stack.size()];
            for(int ans=result.length-1; ans>=0; ans--)
                result[ans] = stack.pop();
            sb.append("#"+count+" ");
            for(char element: result)
                sb.append(element);
            sb.append("\n");

            // 테스트 케이스 번호 증가
            count++;
        }
        // 결과 출력
        System.out.println(sb.toString());
    }
}