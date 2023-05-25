import java.util.*;

class Solution {
    public int[] solution(int[] sequence, int k) {
        
        // 결과 인덱스
        int resultLen = Integer.MAX_VALUE;
        int resultStart = Integer.MAX_VALUE;
        int resultEnd = Integer.MAX_VALUE;
        // 현재 합
        int intervalSum = 0;
        // 현재 끝 위치 
        int end = 0;
        
        // 수열의 합 구하기
        for(int start=0; start<sequence.length; start++) {
            
            // 구하려는 값보다 작을 때까지 포인터 증가
            while(intervalSum<k && end<sequence.length) {
                intervalSum += sequence[end];
                end++;
            }
            
            // 구하려는 값과 같을 경우
            if(intervalSum==k) {
                // 새로 구한 길이가 더 짧은 경우
                if(resultLen>end-start+1) {
                    resultStart = start;
                    resultEnd = end-1;
                    resultLen = end-start+1;
                }
            }
            
            // 현재 가리키는 앞쪽 포인터 값만큼 감소
            intervalSum -= sequence[start];
        }
        
        // 결과 저장
        int[] answer = {resultStart,resultEnd};
        return answer;
    }
}