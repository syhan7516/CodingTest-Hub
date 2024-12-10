import java.util.*;

class Solution {
    public int[] solution(int[] array, int[][] commands) {
        
        // 결과
        int answer[] = new int[commands.length];
        
        // 명령 순회
        for(int command=0; command<commands.length; command++) {
            
            // 명령 정보
            int start = commands[command][0]-1;
            int end = commands[command][1];
            int point = commands[command][2]-1;
            
            // 자르기
            int arr[] = Arrays.copyOfRange(array,start,end);
            
            // 정렬
            Arrays.sort(arr);
            
            // 값 저장
            answer[command] = arr[point];        
        }
        
        return answer;
    }
}