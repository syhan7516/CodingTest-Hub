import java.util.*;

// 연산 클래스
class Calc implements Comparable<Calc>{
    int number;
    int cnt;
    
    public Calc(int number, int cnt) {
        this.number = number;
        this.cnt = cnt;
    }
    
    public int compareTo(Calc other) {
        return this.cnt - other.cnt;
    }
}

class Solution {
    public int solution(int x, int y, int n) {
        
        // 결과
        int answer = -1;
        
        // 연산 결과 여부 배열
        boolean visited[] = new boolean[y+1];
        
        // 연산 큐
        PriorityQueue<Calc> queue = new PriorityQueue<>();
        
        // 초기 설정
        queue.offer(new Calc(x,0));
        visited[0] = true;
        
        // 연산 수행
        while(!queue.isEmpty()) {
            
            // 현재 연산
            Calc c = queue.poll();
            
            // 종료 조건
            if(c.number==y) {
                answer = c.cnt;
                break;
            }
            
            // 연산
            if((c.number+n)<=y && !visited[c.number+n]) {
                queue.offer(new Calc(c.number+n,c.cnt+1));
                visited[c.number+n] = true;
            }
            if((c.number*2)<=y && !visited[c.number*2]) {
                queue.offer(new Calc(c.number*2,c.cnt+1));
                visited[c.number*2] = true;
            }
            if((c.number*3)<=y && !visited[c.number*3]) {
                queue.offer(new Calc(c.number*3,c.cnt+1));
                visited[c.number*3] = true;
            }
        }
        
        return answer;
    }
}