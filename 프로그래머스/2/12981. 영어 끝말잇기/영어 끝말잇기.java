import java.util.*;

class Solution {
    public int[] solution(int n, String[] words) {
        
        // 결과
        int[] answer = {0,0};
        
        // 결과 여부
        boolean flag = false;
        
        // 단어 저장 해시
        HashMap<String,Boolean> check = new HashMap<>();
        
        // 첫 단어 저장
        check.put(words[0],true);
        
        // 단어 확인
        for(int i=1; i<words.length; i++) {
    
            // 이전 마지막 문제와 일치하는지 확인
            if(words[i-1].charAt(words[i-1].length()-1)!=words[i].charAt(0)
              || check.get(words[i])!=null) {
                
                // 결과 저장
                answer[0] = (i+1)%n==0 ? n : (i+1)%n;
                answer[1] = (i+1)%n==0 ? (i+1)/n : (i+1)/n+1;
                
                break;
            }
            
            check.put(words[i],true);
        }
        
        return answer;
    }
}