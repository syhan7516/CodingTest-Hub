import java.util.*;

class Solution {
    
    public int[] solution(int[] array, int[][] commands) {
        
        // 결과 배열 생성
        int[] answer = new int[commands.length];
        
        // 각 케이스 확인
        for(int t=0; t<commands.length; t++) {
            
            // 확인할 배열
            int curArr[] = Arrays.copyOfRange(array, commands[t][0]-1, commands[t][1]);
            
            // 배열 정렬
            Arrays.sort(curArr);
            
            // K번째 뽑기
            answer[t] = curArr[commands[t][2]-1];
            
        }
        
        return answer;
    }
}