import java.util.*;

class Solution {
    public int solution(int n) {
        
        // 결과
        int answer = 0;
        
        // 비교 누적 값
        int sum = 0;
        
        // 최근 더한 값
        int point = 0;
    
        // 연속한 자연수 표현 찾기   
        for(int i=0; i<=n; i++) {
            
            sum -= i;
            
            // 값 더하기
            while(sum<n) {
                point++;
                sum += point;
            }
            
            // 목표 값과 동일한 경우
            if(sum==n) answer++;
        }
        
        return answer;
    }
}