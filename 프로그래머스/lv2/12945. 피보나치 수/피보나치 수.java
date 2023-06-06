import java.util.*;

class Solution {
    public int solution(int n) {
        
        // 피보나치 결과 배열
        int DP[] = new int[1000001];
        
        // 기본 셋팅
        DP[0] = 0;
        DP[1] = 1;
        
        // 피보나치 구하기
        for(int idx=2; idx<1000001; idx++) {
            // 결과 저장
            DP[idx] = (DP[idx-1]+DP[idx-2])%1234567;
        }
            
        // 결과
        int answer = DP[n];
        return answer;
    }
}