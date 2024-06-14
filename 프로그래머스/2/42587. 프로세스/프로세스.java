import java.util.*;

// 작업 클래스
class Job {
    int priority;
    int point;
    
    public Job(int priority, int point) {
        this.priority = priority;
        this.point = point;
    }
}

class Solution {
    public int solution(int[] priorities, int location) {
        
        // 결과
        int answer = 0;
        
        // 작업 관리 큐 생성
        Queue<Job> queue = new LinkedList<>();
        
        // 우선 순위 개수 저장 배열
        int rank[] = new int[10];
        
        // 시작점
        int max = -1;
        
        // 작업 삽입
        for(int i=0; i<priorities.length; i++) {
            queue.offer(new Job(priorities[i],i));
            rank[priorities[i]]++;
            max = Math.max(max,priorities[i]);
        }
        
        // 작업 수행
        while(true) {
            
            // 작업 꺼내기
            Job current = queue.poll();
            
            // 우선 순위 확인
            if(max==current.priority) {
                
                // 수행 횟수 증가
                answer++;
                
                // 원하는 작업인 경우
                if(current.point==location) 
                    break;
                
                // 우선 순위 갱신
                rank[max]--;
                if(rank[max]==0)
                    while(rank[max]==0) max--;
            }
            
            else {
                
                // 다시 넣기
                queue.offer(current);
            }
        }
        
        return answer;
    }
}