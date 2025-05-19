import java.util.*;

class Solution {
    public String solution(int[] numbers) {
        
        // 빌더 생성
        StringBuilder sb = new StringBuilder();
        
        // 숫자를 문자열로 변환
        String[] numToStringArray
            = Arrays.stream(numbers)
            .mapToObj(String::valueOf)
            .toArray(String[]::new);
            
        // 가장 큰 수를 만들며 정렬
        Arrays.sort(numToStringArray,(a,b) -> (b+a).compareTo(a+b));
        
        // 가장 큰 수가 0인 경우
        if("0".equals(numToStringArray[0])) return "0";
        
        // 결과 저장
        Arrays.stream(numToStringArray).forEach(sb::append);
        
        return sb.toString();
    }
}