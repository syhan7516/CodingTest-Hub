import java.util.*;

class Solution {
    public int solution(int k, int[] tangerine) {
        
        // 개수 저장 해시
        HashMap<Integer,Integer> map = new HashMap<>();
        
        // 귤 개수 우선 순위 큐
        PriorityQueue<Integer> priQ = new PriorityQueue<>(Collections.reverseOrder());
        
        // 귤 개수 확인
        for(int i=0; i<tangerine.length; i++) {
            map.put(tangerine[i],map.getOrDefault(tangerine[i],0)+1);
        }
        
        // 개수 정보 큐에 삽입
        for(int cnt: map.values())
            priQ.offer(cnt);
        
        // 뽑은 개수
        int cnt = 0;
        
        // 결과
        int answer = 0;
        
        // 개수가 많은 순으로 뽑기
        while(true) {
            
            // 종료 조건
            if(cnt>=k) break;
            
            // 뽑기
            cnt += priQ.poll();
            answer++;
        }

        return answer;
    }
}