import java.util.*;

class Solution {
    public int[] solution(long n) {
        
        // 문자열 변환 후 처리
        StringBuilder sb = new StringBuilder();
    
        // 문자 배열화
        char numbers[] = sb.append(n).reverse().toString().toCharArray();
    
        // 정수 배열화
        int answer[] = new int[numbers.length];
        for(int number=0; number<numbers.length; number++)
            answer[number] = numbers[number]-'0';
        
        return answer;
    }
}