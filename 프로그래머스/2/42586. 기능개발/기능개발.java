import java.util.*;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {

        // 걸리는 일 수, 이전 최대 작업 일 수
        int days, daysMax = 0;
    
        // 프로세스 스택, 배포 큐 생성
        Stack<Integer> st = new Stack<>();
        Queue<Integer> queue = new LinkedList<>();
        
        for(int i=0; i<progresses.length; i++) {
            
            // 완료까지 남은 작업
            int exist = 100-progresses[i];
            
            // 예상 일 수
            days = (exist%speeds[i])==0 ? exist/speeds[i] : exist/speeds[i]+1;
            
            // 스택이 빈 경우
            if(st.isEmpty()) {
                st.push(days);
                daysMax = days;
            }
            
            // 완료된 작업이 존재하는 경우
            else {
                
                // 현재 개발이 더 오래걸리는 경우
                if(days>daysMax) {
                    queue.offer(st.size());
                    st.clear();
                    daysMax = days;
                }
                
                st.push(days);
            }
        }
        
        // 배포할 작업이 남은 경우
        if(!st.isEmpty()) queue.offer(st.size());
        
        // 결과
        int[] answer = new int[queue.size()];
        
        int idx = 0;
        
        while(!queue.isEmpty())
            answer[idx++] = queue.poll();
            
        return answer;
    }
}