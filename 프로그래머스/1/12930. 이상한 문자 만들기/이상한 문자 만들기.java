import java.util.*;

class Solution {
    
    // 소문자인가?
    public static char isSmall(char letter) {
        
        if(letter>='a' && letter<='z')
            return (char)(letter-32);
        
        return letter;
    }
    
    
    // 대문자인가?
    public static char isBig(char letter) {
        
        if(letter>='A' && letter<='Z')
            return (char)(letter+32);
        
        return letter;
    }
    
    public String solution(String s) {
        
        StringBuilder sb = new StringBuilder();
        
        // 위치 
        int point = 0;
        
        // 문자 확인
        for(int index=0; index<s.length(); index++) {
            
            // 문자
            char letter = s.charAt(index);
            
            // 공백인 경우
            if(letter==' ') point = 0;
            
            // 문자인 경우
            else {
                
                // 위치가 짝수인 경우
                if(point%2==0) {
                    letter = isSmall(letter);
                }
                
                // 위치가 홀수인 경우
                else {
                    letter = isBig(letter);
                }
                
                // 위치 증가
                point++;
            }
            
            // 문자 저장
            sb.append(letter);
        }

        return sb.toString();
    }
}