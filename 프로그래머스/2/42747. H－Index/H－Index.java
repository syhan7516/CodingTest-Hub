import java.util.*;

class Solution {
    
    // 결과
    public static int answer;
    
    // H-index 찾기 메서드
    static void solve(int[] citations, int start, int end) {
        
        // 
        while(start<=end) {
            
            // 확인 값
            int mid = (start+end)/2;
            
            // 이상, 이하 값
            int a = 0;
            int b = 0;
            
            // 논문 정보 확인
            for(int i=citations.length-1; i>=0; i--) {
                if(mid<=citations[i]) a++;
                if(mid>=citations[i]) b++;
            }
            
            // 
            if(mid<=a && mid>=b) {
                answer = mid;
                start = mid+1;
            }
            
            else 
                end = mid-1;
        }
    }
    
    public int solution(int[] citations) {
    
        // 논문별 인용 횟수 정렬
        Arrays.sort(citations);
        
        // 결과
        answer = 0;
        
        // H-index 찾기
        solve(citations,0,10000);
        
        return answer;
    }
}