import java.util.*;

class Solution {
    public String[] solution(String[] strings, int n) {
        
        // 기본 정렬
        Arrays.sort(strings);
        
        // 기준 정렬
        Arrays.sort(strings, (a,b) -> a.charAt(n)-b.charAt(n));
        
        return strings;
    }
}