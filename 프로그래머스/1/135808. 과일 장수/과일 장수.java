import java.util.*;

class Solution {
    public int solution(int k, int m, int[] score) {
        
        // 결과
        int answer = 0;
        
        // 우선 순위 큐 생성
        PriorityQueue<Integer> scores = new PriorityQueue<>((a,b) -> b-a);
        
        // 사과 넣기
        for(int index=0; index<score.length; index++)
            scores.offer(score[index]);
        
        // 상자에 담기
        int count = 0;
        int minScore = 10;
        
        while(!scores.isEmpty()) {
            
            // 사과 선택
            int apple = scores.poll();
            count++;
            minScore = Math.min(minScore,apple);
            
            // 개수를 다 채운 경우
            if(count==m) {
                answer += minScore*m;
                count = 0;
                minScore = 10;
            }
        }
        
        return answer;
    }
}