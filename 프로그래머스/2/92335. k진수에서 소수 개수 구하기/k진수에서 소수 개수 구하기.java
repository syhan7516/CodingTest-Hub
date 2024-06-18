import java.util.*;

class Solution {
    
    // 소수 확인 메서드
    static boolean isPrime(long number) {
        
        // 1인 경우
        if(number==1) 
            return false;
        
        // 아닌 경우
        long n = 2;
        while(true) {
            
            // 종료 조건
            if(n*n>number) break;
            
            // 나누어지는 경우
            if(number%n==0)
                return false;
            
            // 나누는 수 증가
            n++;
        }
        
        return true;
    }
    
    public int solution(int n, int k) {
        
        // 결과
        int answer = 0;
        
        // k진수화
        String letter = Integer.toString(n,k);
        
        // 숫자 분리
        String letters[] = letter.split("0");
        
        // 숫자 확인
        for(int i=0; i<letters.length; i++) {
            
            // 공백인 경우
            if(letters[i].trim().equals("")) continue;
            
            // 숫자인 경우
            if(isPrime(Long.parseLong(letters[i]))) answer++;
        }
        
        return answer;
    }
}