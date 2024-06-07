import java.util.*;

class Solution {
    boolean solution(String s) {
        boolean answer = true;
        
        // 괄호 저장을 위한 스택
        Stack<Character> st = new Stack<>();
        
        // 괄호 확인
        for(int i=0; i<s.length(); i++) {
            
            // 확인 대상 문자
            char letter = s.charAt(i);
            
            // '(' 경우
            if(letter=='(') {
                st.push(letter);
            }
            
            // ')' 경우
            else {
                
                // 대칭 괄호가 없거나 대칭이 아닌 경우
                if(st.isEmpty() || st.peek()==')') 
                    answer = false;
                
                // 대칭 괄호가 존재하는 경우
                else st.pop();
            }
        }
        
        // 스택에 괄호가 남은 경우
        if(st.size()!=0)
            answer = false;
        
        return answer;
    }
}