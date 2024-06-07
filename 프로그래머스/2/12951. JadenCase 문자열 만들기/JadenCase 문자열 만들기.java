import java.util.*;
import java.io.*;

class Solution {
    public String solution(String s) {
        
        // 결과
        StringBuilder sb = new StringBuilder();
        
        // 첫 문자 확인 여부
        boolean flag = true;
        
        // 문자열 확인
        for(int i=0; i<s.length(); i++) {
            
            // 확인 문자
            char c = s.charAt(i);
            
            // 공백이거나 숫자인 경우
            if(c==' ' || (c>=48 && c<=57)) {
                sb.append(c);
                if(c==' ') flag = true;
                else flag = false;
            }
            
            // 알파벳인 경우 
            else {
                
                // 첫 알파벳인 경우
                if(flag) {
                    if(c>='a' && c<='z') sb.append((char)(c-32));
                    else sb.append(c);
                    flag = false;
                }
                
                // 아닌 경우
                else {
                    if(c>='A' && c<='Z') sb.append((char)(c+32));
                    else sb.append(c);
                }
            }
        }
        
        return sb.toString();
    }
}