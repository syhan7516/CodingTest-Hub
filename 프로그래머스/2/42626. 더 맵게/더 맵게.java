import java.util.*;

class Solution {
    public int solution(int[] scoville, int K) {
        
        // 결과
        int answer = 0;
        
        // 우선 순위 큐 생성
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        
        // 큐에 삽입
        for(int i=0; i<scoville.length; i++)
            queue.offer(scoville[i]);
        
        // 음식 섞기
        while(true) {
            
            // 종료 조건
            if(queue.peek()>=K) break;
            if(queue.size()==1 && queue.peek()<K) {
                answer = -1;
                break;
            }
            
            // 섞을 요소 꺼내기
            int a = queue.poll();
            int b = queue.poll();
            
            // 섞기
            queue.offer(a+(b*2));
            
            // 섞은 횟수 증가
            answer++;
        }
        
        return answer;
    }
}