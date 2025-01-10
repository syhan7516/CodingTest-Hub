import java.util.*;

class Solution {
    
    // 여는 괄호인지 확인하는 메서드
    public static boolean openLetter(char letter) {
        
        if(letter=='[' || letter=='(' || letter=='{')
            return true;
        
        return false;
    }
    
    // 짝 여부 확인 메서드
    public static boolean isPair(char letter1, char letter2) {
        
        if(letter1=='[' && letter2==']') return true;
        if(letter1=='{' && letter2=='}') return true;
        if(letter1=='(' && letter2==')') return true;
        
        return false;
    }
    
    // 괄호 확인
    public static boolean solve(List<Character> letters) {
        
        // 괄호 정보 스택 생성
        Stack<Character> stack = new Stack<>();
        
        // 확인
        for(int index=0; index<letters.size(); index++) {
            
            // 현재 괄호
            char letter = letters.get(index);
            
            // 여는 괄호인 경우
            if(openLetter(letter))
                stack.push(letter);
            
            // 닫는 괄호인 경우
            else {
                
                // 스택이 빈 경우
                if(stack.isEmpty())
                    return false;
                
                // 짝 여부 확인
                if(isPair(stack.peek(),letter))
                    stack.pop();
                else return false;
            }
        }
        
        // 스택에 원소가 존재하는 경우
        if(!stack.isEmpty())
            return false;
        
        return true;
    }
    
    public int solution(String s) {
        
        // 결과
        int answer = 0;
        
        // 괄호 배열
        char c[] = s.toCharArray();
        
        // 괄호 컬렉션 변환
        List<Character> letters = new ArrayList<>();
        for(char letter: c) letters.add(letter);
        
        // 리스트 돌리며 짝 여부 확인
        for(int rotate=0; rotate<letters.size(); rotate++) {
            if(solve(letters)) answer++;
            Collections.rotate(letters,1);
        }
        
        return answer;
    }
}