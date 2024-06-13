import java.util.*;

// 숫자 클래스
class Num {
    int num;
    int idx;
    
    public Num(int idx, int num) {
        this.idx = idx;
        this.num = num;
    }
}

class Solution {
    public int[] solution(int[] numbers) {

        // 결과        
        int[] answer = new int[numbers.length];
        
        // 스택 생성
        Stack<Num> st = new Stack<>();
        
        // 숫자 확인
        for(int i=0; i<numbers.length; i++) {
            
            // 스택이 빈 경우
            if(st.isEmpty())
                st.push(new Num(i,numbers[i]));
            
            // 그 외
            else {
                // 스택 요소보다 작거나 같은 경우
                if(numbers[i]<=st.peek().num)
                    st.push(new Num(i,numbers[i]));
                
                // 스택 요소보다 큰 경우
                else {
                    
                    while(true) {
                        
                        // 종료 조건
                        if(st.isEmpty() || numbers[i]<=st.peek().num) 
                            break;
                        
                        // 스택 요소 꺼내기
                        Num n = st.pop();
                        
                        // 결과 입력
                        answer[n.idx] = numbers[i];
                    }
                    
                    // 스택에 요소 넣기
                    st.push(new Num(i,numbers[i]));
                }
            }
        }
        
        // 스택 요소 전부 꺼내기
        while(!st.isEmpty()) {
            
            // 스택 요소 꺼내기
            Num n = st.pop();
            
            // 결과 입력
            answer[n.idx] = -1;
        }
        
        return answer;
    }
}