import java.util.*;

class Solution {
    
    // 최대 연산 횟수
    public static int maxOperationCount;
    
    // 큐 원소 합
    public static long firstQueueSum, secondQueueSum;
    
    // 원소 저장 큐
    public static Queue<Integer> firstQueue, secondQueue;
    
    // 두 큐의 합 같게 하기 메서드
    public static int solve() {
        
        // 최대 연산 횟수 설정
        maxOperationCount = firstQueue.size()+secondQueue.size()+1;
        
        // 현재 연산 횟수
        int currentOperationCount = 0;
        
        // 두 큐의 합이 동일한 경우
        if(firstQueueSum==secondQueueSum) {
            return currentOperationCount;
        }
        
        // 연산 수행
        while(currentOperationCount<=maxOperationCount 
              && !firstQueue.isEmpty() && !secondQueue.isEmpty()) {
            
            // 두 큐의 합 비교
            if(firstQueueSum>secondQueueSum) {
                int firstQueueElement = firstQueue.poll();
                secondQueue.offer(firstQueueElement);
                firstQueueSum -= firstQueueElement;
                secondQueueSum += firstQueueElement;
            }
            
            else {
                int secondQueueElement = secondQueue.poll();
                firstQueue.offer(secondQueueElement);
                secondQueueSum -= secondQueueElement;
                firstQueueSum += secondQueueElement;
            }
            
            // 연산 횟수 증가
            currentOperationCount++;
            
            // 두 큐의 합이 동일한 경우
            if(firstQueueSum==secondQueueSum) {
                return currentOperationCount;
            }
        }
        
        return -1;
    }
    
    
    public int solution(int[] queue1, int[] queue2) {
        
        // 원소 저장 큐 생성
        firstQueue = new LinkedList<>();
        secondQueue = new LinkedList<>();
        
        // 각 원소 큐에 저장
        for(int queueIndex=0; queueIndex<queue1.length; queueIndex++) {
            
            // 첫 번째 큐에 삽입 및 합하기
            firstQueue.offer(queue1[queueIndex]);
            firstQueueSum += queue1[queueIndex];
            
            // 두 번째 큐에 삽입 및 합하기
            secondQueue.offer(queue2[queueIndex]);
            secondQueueSum += queue2[queueIndex];
        }
        
        // 두 큐의 합 같게 하기
        return solve();
    }
}