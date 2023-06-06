import java.util.*;

class Solution {
    
    // 1개수 확인 함수
    static int solve(int num) {
        
        // 개수
        int cnt = 0;
        
        while(true) {
            
            // 종료 조건
            if(num==0)
                break;
            
            if(num%2==1) 
                cnt++;
            
            num/=2;
        }
        
        return cnt;
    }
    
    public int solution(int n) {
        
        // 결과
        int answer = 0;
        
        // n의 2진법 1개수 구하기
        int firCnt = solve(n);
        
        // n+1부터 최대값까지 확인
        for(int a=n+1; a<1000001; a++) {
            
            int secCnt = solve(a);
            
            // 1의 개수가 동일한 수일 경우
            if(firCnt==secCnt) {
                answer = a;
                break;
            }
        }

        return answer;
    }
}