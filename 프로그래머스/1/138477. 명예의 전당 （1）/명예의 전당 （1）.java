import java.util.*;

class Solution {
    public int[] solution(int k, int[] score) {
        
        // 명예의 전당 점수를 저장할 우선순위 큐 생성
        PriorityQueue<Integer> scores = new PriorityQueue<>();
        
        // 매일 발표되는 최하위 점수를 저장할 리스트
        ArrayList<Integer> minScores = new ArrayList<>();
        
        for (int dailyScore : score) {
            
            // 명예의 전당에 점수 추가
            scores.offer(dailyScore);
            
            // 자리 수 보다 많은 경우
            if(scores.size()>k)
                scores.poll();
            
            // 최하위 점수
            minScores.add(scores.peek());
        }
        
        // 결과
        return minScores.stream().mapToInt(Integer::intValue).toArray();
    }
}