import java.util.*;

class Solution {
    
    // 0 제거 메서드
    public static int deleteZero(String letter) {
        
        // 확인 개수
        int cnt = 0;
        
        // 문자열 확인
        for(int i=0; i<letter.length(); i++) {
            
            // 0인 경우 개수 증가
            if(letter.charAt(i)=='0')
                cnt++;
        }
        
        return cnt;
    }
    
    public int[] solution(String s) {
        
        // 제거 0 개수
        int rmZeroCnt = 0;
        
        // 진수 변환 수
        int transCnt = 0;
        
        // 문자열 확인
        while(true) {
            
            // 문자열이 1인 경우
            if(s.equals("1"))
                break;
            
            // 0 제거
            int cnt = deleteZero(s);
            rmZeroCnt += cnt;
            
            // 진수 변환
            s = Integer.toBinaryString(s.length()-cnt);
            transCnt++;
        }
        
        // 결과
        int[] answer = new int[2];
        answer[1] = rmZeroCnt;
        answer[0] = transCnt;
        
        return answer;
    }
}