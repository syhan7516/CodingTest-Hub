import java.util.*;

class Solution {
    public long solution(int n, int[] works) {
        
        // 우선 순위 큐 생성
        PriorityQueue<Integer> queue = new PriorityQueue<>(Collections.reverseOrder());
        
        // 큐에 삽입
        for(int i=0; i<works.length; i++)
            queue.offer(works[i]);
        
        // 제안된 시간만큼 야근 수행
        while(!queue.isEmpty()) {
            
            // 종료 조건
            if(n==0) break;
            
            // 야근
            int work = queue.poll();
            work--;
            
            // 시간이 남은 경우
            if(work>0) queue.offer(work);
            
            // 제안된 시간 감소
            n--;
        }
        
        // 결과
        long answer = 0;
        while(!queue.isEmpty())
            answer += (Math.pow(queue.poll(),2));
        
        return answer;
    }
}