import java.util.*;

class Solution {
    public int[] solution(int[] arr, int divisor) {
        
        // 나누어 떨어지는 정수 리스트 생성
        ArrayList<Integer> divisorResult = new ArrayList<>();
        
        // 나누기
        for(int number: arr) {
            if(number%divisor==0) divisorResult.add(number);
        }
        
        // 정렬
        Collections.sort(divisorResult);
        
        // 결과
        int answer[] = {};
        
        // 결과 저장
        if(divisorResult.size()==0) 
            answer = new int[]{-1};
        
        else {
            answer = new int[divisorResult.size()];
            for(int index=0; index<divisorResult.size(); index++)
            answer[index] = divisorResult.get(index);
        }
            
        return answer;
    }
}