import java.util.*;

class Element {
    private int point;
    private int num;
    
    public Element(int point, int num) {
        this.point = point;
        this.num = num;
    }
    
    public int getPoint() {
        return this.point;
    }
    
    public int getNum() {
        return this.num;
    }
}

class Solution {
    public int[] solution(int[] numbers) {
        
        // 결과 저장
        int[] answer = new int[numbers.length];
        
        // 스택
        Stack<Element> stack = new Stack<>();
        
        // 값 넣기
        stack.push(new Element(0,numbers[0]));
        
        for(int n=1; n<numbers.length; n++) {
            
            // 확인 값
            int curNum = numbers[n];
            
            // 현재 수가 비교 값보다 클 경우
            if(curNum>stack.peek().getNum()) {
                
                // 큰 수 저장 배열에 저장
                while(!stack.isEmpty()) {
                    
                    Element curElement = stack.peek();
                    int stackPoint = curElement.getPoint();
                    int stackNum = curElement.getNum();
                    
                    // 같거나 큰 값이 나온 경우
                    if(stackNum>=curNum)
                        break;
                    
                    // 수 저장
                    stack.pop();
                    answer[stackPoint] = curNum;
                }
            }
            
            // 스택에 값 넣기
            stack.push(new Element(n,curNum));
        }
        
        // 스택 요소 처리
        while(!stack.isEmpty()) {
            // -1 저장
            Element curStack = stack.pop();
            answer[curStack.getPoint()] = -1;
        }
        
        return answer;
    }
}