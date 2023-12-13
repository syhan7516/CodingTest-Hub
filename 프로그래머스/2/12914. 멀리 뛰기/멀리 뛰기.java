import java.util.*;

class Solution {
    public long solution(int n) {

        // 방법 수 정보 배열
        long DP[] = new long[2001];

        // 기본 값 저장
        DP[1] = 1;
        DP[2] = 2;
        DP[3] = 3;
        DP[4] = 5;

        // 방법 수 저장
        for(int i=5; i<2001; i++) {
            DP[i] = (DP[i-1]+DP[i-2]) % 1234567;
        }
        
        // 결과
        return DP[n];
    }
}