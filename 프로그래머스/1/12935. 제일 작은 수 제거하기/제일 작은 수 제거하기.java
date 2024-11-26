import java.util.*;

class Solution {
    public int[] solution(int[] arr) {
        
        // 가장 작은 수 확인
        int minNumber = Integer.MAX_VALUE;
        for(int number: arr)
            minNumber = Math.min(minNumber,number);
        
        // 배열 크기 확인
        if(arr.length==1)
            return new int[]{-1};
        
        // 결과 배열 생성
        int[] answer = new int[arr.length-1];
        
        // 결과 저장
        int insertIndex = 0;
        int getIndex = 0;
        while(insertIndex<answer.length) {
            
            // 가장 작은 수인 경우
            if(arr[getIndex]==minNumber) {
                getIndex++;
                continue;
            }
            
            // 숫자 저장
            answer[insertIndex++] = arr[getIndex++];
        }
        
        return answer;
    }
}