import java.util.*;

class Solution {
    public int solution(int n, int[] lost, int[] reserve) {
        
        // 체육복 보유 정보 배열 생성
        int count[] = new int[n+1];
        
        // 초기화
        Arrays.fill(count,1);
        
        // 체육복 여벌 정보 반영
        for(int index=0; index<reserve.length; index++)
            count[reserve[index]]++;
        
        // 체육복 잃어버린 사람 정보 반영
        for(int index=0; index<lost.length; index++)
            count[lost[index]]--;
        
        // 못빌린 사람 수
        int notBorrow = 0;
        
        // 대여 가능 여부 확인
        for(int index=count.length-1; index>0; index--) {
            
            // 체육복을 가진 사람
            if(count[index]>0) continue;
            
            // 체육복을 잃어버린 사람
            else {
                
                // 뒷사람 확인
                if(index!=n && count[index+1]>1) {
                    count[index+1]--;
                    continue;
                }
                
                // 앞사람 확인
                if(index!=1 && count[index-1]>1) {
                    count[index-1]--;
                    continue;
                }
                
                // 못빌린 사람
                notBorrow++;
            }
        }
        
        return n-notBorrow;
    }
}