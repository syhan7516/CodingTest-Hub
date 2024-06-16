import java.util.*;

class Solution {
    public boolean solution(String[] phone_book) {
        
        // 결과
        boolean answer = true;
        
        // 정렬
        Arrays.sort(phone_book);
        
        // 확인
        for(int i=0; i<phone_book.length-1; i++) {
            
            // 접두사인 경우
            if(phone_book[i+1].startsWith(phone_book[i])) {
                answer = false;
                break;
            }
        }
        
        return answer;
    }
}