import java.util.*;

class Solution {
    public int solution(int[][] targets) {
        
        // 결과
        int answer = 0;
        
        // 정렬 (긴e, 짧s)
        Arrays.sort(targets, (a,b) -> a[0]-b[0]);
        
        // 요격 시스템 위치
        int start = 0;
        int end = 0;
        
        // A 공격 확인
        for(int i=0; i<targets.length; i++) {
            
            // A 공격 위치
            int s = targets[i][0];
            int e = targets[i][1];
            
            // 이미 설치된 요격 시스템 범위 안에 들어오는 경우
            if(start<=s && end>s) {
                
                // 더 작은 범위로 갱신
                start = Math.max(start,s);
                end = Math.min(end,e);
            }
            
            // 범위 내에 들어오지 않는 경우
            else {
                
                // 새로운 요격 시스템 설치
                start = s;
                end = e;
                answer++;
            }
        }
        
        return answer;
    }
}