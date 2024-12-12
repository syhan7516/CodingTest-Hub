import java.util.*;

class Solution {
    
    public int[] solution(String s) {
        
        // 결과 배열
        int[] answer = new int[s.length()];
        
        // 알파벳 위치 저장 배열 생성
        int points[] = new int[26];
        
        // 배열 초기화
        Arrays.fill(points,10000);
        
        // 문자열 확인
        for(int letter=0; letter<s.length(); letter++) {
            
            // 확인 문자
            char alpha = s.charAt(letter);
            
            // 위치 확인
            if(points[alpha-'a']==10000) {
                answer[letter] = -1;
                points[alpha-'a'] = letter;
            }
            
            else {
                int point = letter-points[alpha-'a'];
                answer[letter] = point;
                points[alpha-'a'] = letter;
            }
        }
        
        return answer;
    }
}