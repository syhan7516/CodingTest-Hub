import java.util.*;

class Solution {
    public int solution(int[] elements) {
        
        // 결과
        int answer = 0;
        
        // 원소 개수
        int cnt = elements.length;
    
        // 부분 수열 합 셋
        HashSet<Integer> set = new HashSet<>();
        
        // 부분 수열 합 구하기
        for(int i=0; i<cnt; i++) {
            int current = elements[i];
            set.add(current);
            for(int j=1; j<cnt; j++) {
                int idx = i+j;
                if(idx>cnt-1) idx -= cnt;
                current += elements[idx];
                set.add(current);
            }
        }
        
        // 결과 반환
        answer = set.size();
        return answer;
    }
}