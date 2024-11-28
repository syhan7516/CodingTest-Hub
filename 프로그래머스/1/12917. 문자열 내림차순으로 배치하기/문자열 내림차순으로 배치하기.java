import java.util.*;

class Solution {
    public String solution(String s) {
        
        // 문자 배열화
        char alpha[] = s.toCharArray();
        
        // 정렬
        Arrays.sort(alpha);
        
        // 결과 저장
        StringBuilder sb = new StringBuilder();
        for(int index=alpha.length-1; index>=0; index--) 
            sb.append(alpha[index]);
        
        return sb.toString();
    }
}