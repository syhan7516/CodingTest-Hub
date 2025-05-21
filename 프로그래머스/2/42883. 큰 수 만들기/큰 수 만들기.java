import java.util.*;

class Solution {
    
    // 분류된 숫자 개수
    public static int count;
    
    // 스택 
    public static Stack<Character> stack;
    
    // 스택 값 초과 여부 확인 메서드
    public static boolean isMoreThanStackNum(char num) {
        return num>stack.peek();
    }
    
    // 정해진 개수 미만 여부 확인 메서드
    public static boolean isLessThanTargetCount(int targetCount) {
        return count<targetCount;
    }
    
    // 스택 확인 메서드
    public static boolean validateStatus(char num, int targetCount) {
        return !stack.isEmpty() 
            && isMoreThanStackNum(num) 
            && isLessThanTargetCount(targetCount);
    }
    
    public String solution(String number, int k) {
        
        // 빌더
        StringBuilder sb = new StringBuilder();
        
        // 스택 생성
        stack = new Stack<>();
        
        // 숫자 각 자리 수 확인
        for(int numIndex=0; numIndex<number.length(); numIndex++) {
            
            // 숫자
            char num = number.charAt(numIndex);
            
            // 스택 확인
            while(validateStatus(num,k)) {
                stack.pop();
                count++;
            }
            
            // 스택에 숫자 추가
            stack.push(num);
        }
        
        // 남은 개수만큼 뒤에서 숫자 제거
        while(count<k) {
            stack.pop();
            count++;
        }
        
        // 결과 저장
        for(char num: stack) sb.append(num);
        
        return sb.toString();
    }
}