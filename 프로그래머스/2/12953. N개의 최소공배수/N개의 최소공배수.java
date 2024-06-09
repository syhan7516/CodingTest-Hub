import java.util.*;

class Solution {
    
    // 최소 공배수 메서드
    public static int gcd(int a, int b) {
        
        if(a<b) {
            int c = a;
            a = b;
            b = c;
        }
        
        if(a%b==0) return b;
        
        return gcd(b,a%b);
    }
    
    public int solution(int[] arr) {
        
        // 결과
        int answer = 1;
        
        // 배열 요소 확인
        for(int i=0; i<arr.length; i++) {
            
            // 최소 공배수 구하기
            answer = answer*arr[i]/gcd(answer,arr[i]);
        }
        
        return answer;
    }
}