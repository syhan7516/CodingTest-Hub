import java.util.*;

class Solution {
    
    // 결과, 현재 택배
    public static int answer, current;
    
    // 보조 컨테이너 벨트 스택
    public static Stack<Integer> stack;
    
    // 택배 옮기기 메서드
    public static boolean solve(int target) {
        
        // 목표 택배와 현재 택배가 일치하는 경우
        if(target==current) {
            answer++;
            current++;
            return true;
        }
        
        // 목표 택배가 더 작은 경우
        else if(target<current) {
            if(target==stack.peek()) {
                stack.pop();
                answer++;
                return true;
            }
            
            return false;
        }
        
        // 목표 택배가 더 큰 경우
        else {
            while(target>current) {
                stack.push(current);
                current++;
            }
            
            if(target==current) {
                answer++;
                current++;
                return true;
            }
            
            else return false;
        }
    }
    
    public int solution(int[] order) {
        
        // 스택 생성
        stack = new Stack<>();
        
        // 현재 택배
        current = 1;
        
        // 택배 옮기기
        for(int targetIndex=0; targetIndex<order.length; targetIndex++) {
            
            // 택배 순서 찾기
            if(!solve(order[targetIndex])) break;
        }
        
        return answer;
    }
}