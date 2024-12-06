import java.util.*;

class Solution {
    public int solution(int n) {
        
        // 3진법 저장 빌더 생성
        StringBuilder sb = new StringBuilder();
        
        // 3진법 변환 후 저장
        sb.append(Integer.toString(n,3));
        
        // 거꾸로 변환
        sb.reverse();    
        
        // 10진법으로 변환
        return Integer.parseInt(sb.toString(),3);
    }
}