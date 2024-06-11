import java.util.*;

class Solution {
    public int solution(String s) {
        
        // 결과 
        int answer = 0;
        
        // 괄호 저장 리스트
        ArrayList<Character> bracket = new ArrayList<>();
        
        // 괄호 정보 저장
        for(int i=0; i<s.length(); i++) {
            bracket.add(s.charAt(i));
        }
        
        // 회전하며 확인하기
        for(int i=0; i<s.length(); i++) {
            
            // 회전
            Collections.rotate(bracket,-1);
            
            // 확인
            Stack<Character> st = new Stack<>();
            
            // 확인 결과
            boolean flag = true;
            
            // 괄호 짝 확인
            for(int j=0; j<bracket.size(); j++) {
                
                // 확인 괄호
                char c = bracket.get(j);
                
                // 여는 괄호인 경우
                if(c=='[' || c=='(' || c=='{') {
                    st.push(c);
                }
                
                // 닫는 괄호인 경우
                else {
                    
                    // 스택이 빈 경우
                    if(st.isEmpty()) {
                        flag = false;
                        break;
                    }
                    
                    // 짝이 맞는 경우
                    else if(
                        (st.peek()=='(' && c==')') ||
                        (st.peek()=='[' && c==']') ||
                        (st.peek()=='{' && c=='}')
                    ) st.pop();
                    
                    // 짝이 맞지 않는 경우
                    else {
                        flag = false;
                        break;
                    }
                }
            }
            
            // 괄호 짝을 다 맞춘 경우
            if(flag && st.isEmpty()) answer++;
        }
        
        return answer;
    }
}