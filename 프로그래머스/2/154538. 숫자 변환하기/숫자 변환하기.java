import java.util.*;

class Calc {
    int count;
    int value;
    
    public Calc(int count, int value) {
        this.count = count;
        this.value = value;
    }
}

class Solution {
    public int solution(int x, int y, int n) {
        
        // 결괴
        int answer = -1;
        
        // 방문 여부 배열 생성
        boolean visited[] = new boolean[y+1];
        
        // 큐 생성
        Queue<Calc> queue = new LinkedList<>();
        
        // 초기 설정
        queue.offer(new Calc(0,x));
        visited[x] = true;
        
        // 연산 수행
        while(!queue.isEmpty()) {
        
            // 확인 값
            Calc calc = queue.poll();
            
            // 목표 값에 도달한 경우
            if(calc.value==y) {
                answer = calc.count;
                break;
            }
            
            // 연산 확인
            if(calc.value+n<=y && !visited[calc.value+n]) {
                queue.offer(new Calc(calc.count+1,calc.value+n));
                visited[calc.value+n] = true;
            }
            
            if(calc.value*2<=y && !visited[calc.value*2]) {
                queue.offer(new Calc(calc.count+1,calc.value*2));
                visited[calc.value*2] = true;
            }
            
            if(calc.value*3<=y && !visited[calc.value*3]) {
                queue.offer(new Calc(calc.count+1,calc.value*3));
                visited[calc.value*3] = true;
            }
        }
        
        
        return answer;
    }
}