import java.util.*;

class Solution {
    boolean solution(String s) {
        
        // 결과
        boolean answer = true;
        
        // 스택
        Stack<Character> stack = new Stack<>();
        
        // 괄호 정보 확인
        for(int a=0; a<s.length(); a++) {
            
            // 현재 문자
            char c = s.charAt(a);
            
            // 여는 괄호일 경우 
            if(c=='(') {
                stack.push(c);
            }
            
            // 닫는 괄호일 경우
            else {
                // 스택이 비었는지 확인
                if(stack.isEmpty()) {
                    answer = false;
                    return answer;
                }
                else {
                    stack.pop();
                }
            }
        }
        
        // 스택이 비었는지 확인
        if(!stack.isEmpty())
            answer = false;
        
        return answer;
    }
}