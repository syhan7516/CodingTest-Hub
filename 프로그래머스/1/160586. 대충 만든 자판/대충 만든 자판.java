import java.util.*;

class Solution {
    
    // 키 최소 횟수 저장 배열
    public static int pressCount[];
    
    public int[] solution(String[] keymap, String[] targets) {
        
        // 결과
        int[] answer = new int[targets.length];
        
        // 키 최소 횟수 저장 배열 생성
        pressCount = new int[26];
        Arrays.fill(pressCount,101);
        
        // 키 확인
        for(int a=0; a<keymap.length; a++) {
            for(int b=0; b<keymap[a].length(); b++) {
                
                // 키
                int key = keymap[a].charAt(b)-'A';
                
                // 누름 횟수 비교, 갱신
                pressCount[key] = Math.min(pressCount[key],b+1);
            }
        }
        
        // 목표 문자열 확인
        for(int letter=0; letter<targets.length; letter++) {
            
            // 누름 횟수
            int count = 0;
            
            // 중간 멈춤 여부
            boolean flag = false;
            
            // 문자 확인
            for(int alpha=0; alpha<targets[letter].length(); alpha++) {
                
                // 키
                int key = targets[letter].charAt(alpha)-'A';
                
                // 존재하지 않는 경우    
                if(pressCount[key]==101) {
                    flag = true;
                    break;
                }
                
                // 키가 존재하는 경우
                else count += pressCount[key];
            }
            
            // 결과 저장
            answer[letter] = flag ? -1 : count;
        }
        
        return answer;
    }
}