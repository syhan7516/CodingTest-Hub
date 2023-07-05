import java.util.*;

public class Solution {
    public int solution(int n) {
        
        // 결과
        int ans = 0;
        
        // 0까지 반복
        while(true) {
            
            // 종료 조건
            if(n==0)
                break;
            
            // 짝수인 경우
            if(n%2==0) n/=2;
            
            // 홀수인 경우
            else {
                n--;
                ans++;
            }
        }

        return ans;
    }
}