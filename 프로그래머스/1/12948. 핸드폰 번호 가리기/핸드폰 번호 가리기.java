import java.util.*;

class Solution {
    public String solution(String phone_number) {
        
        StringBuilder sb = new StringBuilder();
        
        // 뒷자리 추가
        sb.append(phone_number.substring(phone_number.length()-4));
        
        // * 개수
        int starCount = phone_number.length()-sb.length();
        
        // 앞자리 추가
        for(int count=0; count<starCount; count++)
            sb.insert(0,"*");
        
        return sb.toString();
    }
}