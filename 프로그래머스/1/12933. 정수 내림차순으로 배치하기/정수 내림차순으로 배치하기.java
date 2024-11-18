import java.util.*;

class Solution {
    public long solution(long n) {
        
        // 숫자 자르기
        char numbers[] = String.valueOf(n).toCharArray();
        
        // 정렬
        Arrays.sort(numbers);
        
        // 뒷자리부터 저장
        StringBuilder sb = new StringBuilder();
        for(int i=numbers.length-1; i>=0; i--)
            sb.append(numbers[i]);
        
        // 정수화
        long answer = Long.parseLong(sb.toString());
        
        return answer;
    }
}