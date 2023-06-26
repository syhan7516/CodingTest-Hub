import java.util.*;

class Solution {
    public int solution(int[] citations) {
        
        // 결과
        int answer = 0;
        
        // 인용 정보 정렬
        Arrays.sort(citations);
        
        // 인용 정보 확인
        for(int idx=0; idx<citations.length; idx++) {
            
            // 논문 개수
            int cnt = citations.length-idx;
                
            // 인용 수가 논문 수보다 같거나 클 경우 
            if(citations[idx]>=cnt) {
                answer = cnt;
                break;
            }
        }
        
        return answer;
    }
}