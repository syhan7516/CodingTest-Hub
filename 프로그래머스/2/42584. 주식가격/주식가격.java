import java.util.*;

// 주식 클래스
class Stock {
    int idx;
    int num;

    
    public Stock(int idx, int num) {
        this.num = num;
        this.idx = idx;
    }
}

class Solution {
    public int[] solution(int[] prices) {
        
        // 결과
        int answer[] = new int[prices.length];
        
        // 스택 생성
        Stack<Stock> st = new Stack<>();
        
        // 주식 확인
        for(int i=0; i<prices.length; i++) {
            
            // 스택이 빈 경우
            if(st.isEmpty() || prices[i]>=st.peek().num) {
                st.push(new Stock(i,prices[i]));
            }
            
            // 아닌 경우 (가격이 떨어진 경우)
            else {
                
                while(!st.isEmpty()) {
                    
                    // 종료 조건
                    if(prices[i]>=st.peek().num) break;
                    
                    // 스택에서 꺼내기
                    Stock stock = st.pop();
                    
                    // 결과에 입력
                    answer[stock.idx] = i-stock.idx;
                }
                
                // 스택에 추가
                st.push(new Stock(i,prices[i]));
            }
        }
        
        // 스택 모두 꺼내기
        while(!st.isEmpty()) {
            
            // 스택에서 꺼내기
            Stock stock = st.pop();
            
            // 결과에 입력
            answer[stock.idx] = prices.length-1-stock.idx;
        }
        
        return answer;
    }
}