import java.util.*;

class Solution {
    
    public int solution(int n, int[] lost, int[] reserve) {
        
        // 결과
        int answer = n-lost.length;
        
        // 정렬
        Arrays.sort(lost);
        Arrays.sort(reserve);
        
        // 본인 체육복이 도난 당한 경우
        for(int i=0; i<lost.length; i++) {
            for(int j=0; j<reserve.length; j++) {
                if(lost[i] == reserve[j]) {
                    answer++;
                    lost[i] = -1;
                    reserve[j] = -1;
                    break;
                }
            }
        }
        
        // 다른 사람 체육복이 도난 당한 경우
        for(int i=0; i<lost.length; i++) {
            for(int j=0; j<reserve.length; j++) {
                if(lost[i]+1 == reserve[j] || lost[i]-1 == reserve[j]) {
                    answer++;
                    reserve[j] = -1;
                    break;
                }
            }
        }
        
        return answer;
    }
}