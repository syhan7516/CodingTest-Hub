import java.util.*;

class Solution {
    public int solution(String[] babbling) {
        
        // 결과
        int answer = 0;
        
        // 가능한 발음 해시로 저장
        HashMap <String,Boolean> map = new HashMap<>();
        map.put("aya",true);
        map.put("ye",true);
        map.put("woo",true);
        map.put("ma",true);
        
        // 단어 확인
        for(int index=0; index<babbling.length; index++) {
            
            // 단어
            String letter = babbling[index];
            
            // 단어 확인
            int start = 0;
            int end = 0;
            
            // 최근 발음
            String lately = "";
            
            while(end<=letter.length()) {
                
                // 단어 자르기
                String cutLetter = letter.substring(start,end);
                
                // 단어가 존재하는 경우
                if(map.containsKey(cutLetter)) {
                    
                    // 최근 발음과 동일한 경우
                    if(lately.equals(cutLetter))
                        break;
                    
                    // 아닌 경우
                    else {
                        lately = cutLetter;
                        start = end;
                    }
                }
                
                // 존재하지 않는 경우
                else end++;
            }
            
            // 발음이 가능한 경우
            if(start==letter.length()) {
                answer++;
            }
        }
        
        return answer;
    }
}