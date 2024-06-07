import java.util.*;

class Solution {
    
    public int solution(int n) {
        
        // DP 배열 생성
        int DP[] = new int[n+1];
        
        // 초기 값 설정
        DP[0] = 0;
        DP[1] = 1;
        
        // 피보나치 구하기
        for(int i=2; i<=n; i++) {
            DP[i] = (DP[i-1]+DP[i-2])%1234567;
        }
        
        // 결과
        int answer = DP[n];
        
        return answer;
    }
}