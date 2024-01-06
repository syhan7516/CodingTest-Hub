import java.util.*;

class Solution {
    
    // 소수 확인 메서드
    static boolean getPrime(long check) {
        
        // 1, 2 처리
        if (check==1) return false;
        if (check==2) return true;
        
        // 나눠보기
        for (long i=2; i*i<=check; i++) {
            if(check%i==0) return false;
        }
        
        return true;
    }
    
    public int solution(int n, int k) {
        
        // 진수 변환
        String number = Long.toString(n, k);
        
        // 진수 분리하기
        String nums[] = number.split("0");
        
        // 개수
        int count = 0;
        
        // 소수 확인
        for (String data : nums) {
            
            // 공백인 경우
            if (data.isEmpty() || data.isBlank()) continue;
            
            // 소수 여부 구하기
            Long check = Long.parseLong(data);
            if (getPrime(check)) count++;
        }
        
        // 결과
        int answer = -1;
        
        // 결과 반환
        if(count!=0)
            answer = count;
        return count;
    }
}