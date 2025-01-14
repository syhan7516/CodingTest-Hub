import java.util.*;

// 프로세스 클래스
class Process {
    int processNum;
    int order;
    
    public Process(int processNum, int order) {
        this.processNum = processNum;
        this.order = order;
    }
}

class Solution {
    
    // 프로세스 저장 큐
    public static Queue<Process> queue;
    
    // 우선 순위 저장 큐
    public static PriorityQueue<Integer> orders;
    
    public int solution(int[] priorities, int location) {
        
        // 결과
        int answer = 0;
        
        // 프로세스 저장 큐, 우선 순위 큐 생성
        queue = new LinkedList<>();
        orders = new PriorityQueue<>(Collections.reverseOrder());
        
        // 작업 저장
        for(int index=0; index<priorities.length; index++) {
            queue.offer(new Process(index,priorities[index]));
            orders.offer(priorities[index]);
        }
        
        // 횟수
        int count = 0;
        
        // 현재 우선 순위
        int orderNum = orders.poll();
        
        // 작업 수행
        while(!queue.isEmpty()) {
            
            // 확인 작업
            Process process = queue.poll();
            
            // 우선 순위와 현재 우선 순위가 동일한 경우
            if(process.order==orderNum) {
                orderNum = orders.isEmpty() ? -1 : orders.poll();
                count++;
                
                // 찾는 위치와 동일한 경우
                if(process.processNum==location) {
                    answer = count;
                    break;
                }
            }
            
            // 다시 추가
            else queue.offer(process);
        }
        
        return answer;
    }
}