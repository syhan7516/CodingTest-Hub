import java.util.*;

class Solution {
    public int[] solution(int[] numbers) {
        
        // 숫자 결과 여부 배열 생성
        boolean sums[] = new boolean[201];
        
        // 숫자 결과 개수
        int count = 0;
            
        // 숫자 확인
        for(int first=0; first<numbers.length-1; first++) {
            for(int second=first+1; second<numbers.length; second++) {
                
                // 두 수의 합
                int sum = numbers[first]+numbers[second];
                
                // 숫자 결과가 없는 경우
                if(!sums[sum]) {
                    sums[sum] = true;
                    count++;
                }
            }
        }
        
        // 결과
        int[] answer = new int[count];
        
        // 저장 위치
        int index=0;
        
        // 숫자 결과 배열 확인
        for(int number=0; number<201; number++) {
            
            // 결과가 존재하는 경우
            if(sums[number]) {
                answer[index] = number;
                index++;
            }
        }
        
        return answer;
    }
}