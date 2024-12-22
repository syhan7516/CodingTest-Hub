import java.util.*;

class Solution {
    
    // 소수 배열
    public static boolean primes[];
    
    // 소수 확인 메서드
    public static void primeSolve() {
        
        // 소수 배열 생성
        primes = new boolean[3001];
        
        // 0, 1 처리
        primes[0] = true;
        primes[1] = true;
        
        // 차례로 확인
        for(int num=2; num<3001; num++) {
            
            // 해당 수가 소수인 경우
            if(!primes[num]) {
                
                // 배수 처리
                for(int index=num+num; index<3001; index+=num)
                    primes[index] = true;
            }
        }
    }
    
    public int solution(int[] nums) {
        
        // 결과
        int answer = 0;
        
        // 소수 확인
        primeSolve();
        
        // 숫자 고르기
        for(int first=0; first<nums.length-2; first++) {
            for(int second=first+1; second<nums.length-1; second++) {
                for(int third=second+1; third<nums.length; third++) {
                    int value = nums[first]+nums[second]+nums[third];
                    if(!primes[value]) answer++;
                }
            }
        }

        return answer;
    }
}