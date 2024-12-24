import java.util.*;

class Solution {
    public String solution(String s, String skip, int index) {
        
        StringBuilder sb = new StringBuilder();
        
        // skip 여부 해시
        HashMap<Character,Boolean> map = new HashMap<>();
        
        // skip 문자 확인
        for(int c=0; c<skip.length(); c++)
            map.put(skip.charAt(c),true);
        
        // s 문자 확인
        for(int c=0; c<s.length(); c++) {
            
            // 문자
            char current = s.charAt(c);
            
            // 옮긴 횟수
            int move = 0;
            
            // 옮기기
            while(move<index) {
                
                // 이동
                current++;
                
                // 범위 확인
                if(current>'z')
                    current = 'a';
                
                // skip 문자인 경우
                if(map.containsKey(current))
                    continue;
                
                // 아닌 경우
                else move++;
            }
            
            // 저장
            sb.append(current);
        }
        
        return sb.toString();
    }
}