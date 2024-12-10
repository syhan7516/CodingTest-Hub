import java.util.*;

class Solution {
    
    // 문자 변환하기 메서드
    public static char solve(char letter, int moveCount) {
        
        // 공백인 경우
        if(letter==' ')
            return letter;
        
        // 소문자인 경우
        if(letter>='a' && letter<='z') {
            letter += moveCount;
            if(letter>122) letter -= 26;
            return letter;
        }
        
        // 대문자인 경우
        if(letter>='A' && letter<='Z') {
            letter += moveCount;
            if(letter>90) letter -= 26;
            return letter;
        }    
        
        return ' ';
    }
    
    public String solution(String s, int n) {
        
        StringBuilder sb = new StringBuilder();
        
        // 문자열 확인
        for(int index=0; index<s.length(); index++) {
            
            // 확인 문자
            char letter = s.charAt(index);
            
            // 변환 문자
            sb.append(solve(letter,n));
        }
        
        return sb.toString();
    }
}