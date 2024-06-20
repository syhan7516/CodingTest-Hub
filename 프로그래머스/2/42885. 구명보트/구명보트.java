import java.util.*;

class Solution {
    public int solution(int[] people, int limit) {
        
        // 결과
        int answer = 0;
        
        // 정렬
        Arrays.sort(people);
        
        // 줄 세우기 위한 덱
        ArrayDeque<Integer> queue = new ArrayDeque<>();
        
        // 덱에 데이터 삽입
        for(int i=0; i<people.length; i++)
            queue.add(people[i]);

        // 구명 보트 태우기
        while(!queue.isEmpty()) {
            
            // 한 명 남은 경우
            if(queue.size()==1) break;
            
            // 현재 무게 
            int weight = queue.peek()+queue.peekLast();
            
            // 무게가 동일하거나 작은 경우
            if(weight<=limit) 
                queue.poll();
            
            queue.pollLast(); 
            
            // 구명보트 수 증가
            answer++;
        }
        
        // 덱에 사람이 남은 경우
        if(queue.size()==1) answer++;
        
        return answer;
    }
}