import java.util.*;

class Solution {
    public int solution(int k, int[] tangerine) {
        
        // 결과
        int answer = 0;
        
        // 귤 종류 개수 저장 해시, 개수 우선 순위 큐 생성
        HashMap<Integer,Integer> map = new HashMap<>();
        PriorityQueue<Integer> queue = new PriorityQueue<>((a,b) -> b-a);
        
        // 귤 개수 정보 확인
        for(int index=0; index<tangerine.length; index++)
            map.put(tangerine[index],map.getOrDefault(tangerine[index],0)+1);
        
        // 귤 넣기
        for(int key: map.keySet())
            queue.offer(map.get(key));
        
        // 귤 고르기
        while(!queue.isEmpty() && k>0) {
            k -= queue.poll();
            answer++;
        }
        
        return answer;
    }
}