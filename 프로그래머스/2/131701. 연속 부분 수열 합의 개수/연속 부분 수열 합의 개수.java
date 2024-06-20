import java.util.*;

class Solution {
    
    // 합 저장 셋
    static HashSet<Integer> set;
    
    // 각 개수마다 연속 부분 수열 합 구하기 메서드
    static void solve(int cnt, int[] elements) {
        
        // 합
        int sum = 0;
        
        // 초기 합 구하기
        for(int i=0; i<cnt; i++)
            sum += elements[i];
        set.add(sum);
        
        // 이후 합 구하기
        for(int i=0; i<elements.length-1; i++) {
            
            // 가장 앞 부분 빼기
            sum -= elements[i];
            
            // 인덱스가 범위를 넘은 경우
            if(cnt>=elements.length) 
                cnt -= elements.length; 
            
            // 다음 수 더하기
            sum += elements[cnt];
            set.add(sum);
            
            // 인덱스 증가
            cnt++;
        }
    }
    
    public int solution(int[] elements) {
        
        // 합 저장 셋 생성
        set = new HashSet<>();
        
        // 각 개수마다 연속 부분 수열 합 구하기
        for(int i=1; i<=elements.length; i++)
            solve(i,elements);
        
        // 결과
        int answer = set.size();
        
        return answer;
    }
}