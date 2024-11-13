import java.util.*;

public class Solution {
    public int solution(int n) {
        
        // 결과
        int answer = 0;
        
        // 자릿수 더하기
        while(true) {
            
            // 맨 마지막 자릿수 더하기
            answer += n%10;
            
            // 자릿수 줄이기
            n /= 10;
            
            // 없는 경우
            if(n==0) break;
            
        }

        return answer;
    }
}