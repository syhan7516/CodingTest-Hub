import java.util.*;

class Solution
{
    public int solution(String s)
    {
        // 이전 문자 저장 스택
        Stack<Character> st = new Stack<>();
        
        // 문자 확인
        for(int i=0; i<s.length(); i++) {
            
            // 확인 문자
            char c = s.charAt(i);
            
            // 스택인 비거나 이전 문자와 다른 경우
            if(st.isEmpty() || st.peek()!=c)
                st.push(c);
            
            // 이전 문자와 같은 경우
            else st.pop();
        }
        
        // 결과
        int answer = st.isEmpty() ? 1 : 0; 

        return answer;
    }
}