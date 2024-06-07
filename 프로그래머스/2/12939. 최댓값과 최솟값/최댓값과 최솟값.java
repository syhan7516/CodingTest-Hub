import java.util.*;

class Solution {
    public String solution(String s) {
        
        // 최소값 우선 순위 큐
        PriorityQueue<Integer> minQ = new PriorityQueue();

        // 최대값 우선 순위 큐
        PriorityQueue<Integer> maxQ = new PriorityQueue(
                Collections.reverseOrder()
        );
        
        // 숫자 삽입
        String letters[] = s.split(" ");
    
        for(String letter: letters) {
            
            // 숫자 변환
            int number = Integer.valueOf(letter);
            
            // 우선 순위 큐에 삽입
            minQ.add(number);
            maxQ.add(number);
        }
        
        // 결과 저장
        String answer = minQ.peek()+" "+maxQ.peek();
        
        return answer;
    }
}