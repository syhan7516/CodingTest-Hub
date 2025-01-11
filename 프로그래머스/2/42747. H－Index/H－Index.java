import java.util.*;

class Solution {
    
    // 결과
    public static int answer;
    
    // H-index 찾기 메서드
    static void solve(int[] citations, int start, int end) {
        
        // 이진 탐색 수행
        while(start<=end) {
            
            // 확인 값
            int mid = (start+end)/2;
            
            // 이상, 이하 값
            int above = 0;
            int below = 0;
            
            // 논문 정보 확인
            for(int index=0; index<citations.length; index++) {
                if(mid<=citations[index]) above++;
                if(mid>=citations[index]) below++;
            }
            
            // 조건에 맞는 경우
            if(mid<=above && mid>=below) {
                answer = mid;
                start = mid+1;
            }
            
            // 조건에 맞지 않는 경우
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