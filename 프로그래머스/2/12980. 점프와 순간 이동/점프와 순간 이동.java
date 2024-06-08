import java.util.*;

public class Solution {
    public int solution(int n) {
        
        // 결과
        int ans = 1;
        
        // 이동
        while(true) {
            
            // 종료 조건
            if(n==1) break;
            
            // 순간이동이 가능한 경우
            if(n%2==0) n/=2;
            
            // 순간이동이 불가능한 경우
            else {
                n--;
                n/=2;
                ans++;
            }
        }
        
        return ans;
    }
}