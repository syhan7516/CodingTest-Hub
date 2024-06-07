import java.util.*;

class Solution {
    
    // 1개수 확인 메서드
    public static int check(int number) {
        
        // 2진수 변환
        String s = Integer.toBinaryString(number);
        
        // 1개수 확인
        int cnt = 0;
        for(int i=0; i<s.length(); i++) {
            if(s.charAt(i)=='1')
                cnt++;
        }
        
        return cnt;
    }
    
    public int solution(int n) {
        
        // 결과
        int answer = 0;
        
        // 기준 숫자 1개수
        int target = check(n);
        
        while(true) {
            
            // 수 증가
            n++;
            
            // 큰 수 1개수 확인
            if(target==check(n)) {
                answer = n;
                break;
            }
        }
    
        return answer;
    }
}