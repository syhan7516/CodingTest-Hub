import java.util.*;

class Solution {
    public int solution(int[] queue1, int[] queue2) {
        int answer = -1;
        
        // 큐 크기
        int size = queue1.length;
        
        // 큐의 합
        long sum = 0;
        long first = 0;
        long second = 0;
        
        // 큐 생성
        Queue<Integer> Q1 = new LinkedList<>();
        Queue<Integer> Q2 = new LinkedList<>();
        
        // 큐 요소 저장
        for(int i=0; i<size; i++) {
            
            Q1.offer(queue1[i]);
            Q2.offer(queue2[i]);
            
            first += queue1[i];
            second += queue2[i];
        }
        
        sum = (first+second)/2;
        
        int cnt = 0;
        int num = 0;
        
        size = (size)*4;
        
        while(first!=second) {
            
            if(size==0) break;
            
            if(first==second) break;
            
            else if(first<second) {
                num = Q2.poll();
                second -= num;
                first += num;
                Q1.offer(num);
            }
            else {
                num = Q1.poll();
                first -= num;
                second += num;
                Q2.offer(num);
            }
            
            cnt++;
            size--;
        }
        
        if(first==second) answer = cnt;
        
        return answer;
    }
}