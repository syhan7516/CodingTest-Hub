import java.util.*;

class Solution {
    public int[] solution(int brown, int yellow) {
        
        // 결과
        int[] answer = new int[2];
        
        // 가로, 세로
        int row = 0;
        int col = 0;
        
        // 비율
        int rate = 1;
        
        // 비율에 맞춰 확인
        while(true) {
            
            // 나누어 떨어지는 경우
            if(yellow%rate==0) {
                
                // 가로, 세로 길이 정의
                row = yellow/rate;
                col = rate;
                
                // 비율 따른 갈색 개수 
                int brownCnt = (row+2)*2 + (col*2);
                
                // 갈색 개수가 동일한 경우
                if(brownCnt==brown) {
                    answer[0] = row+2;
                    answer[1] = col+2;
                    break;
                }
            }
            
            // 비율 증가
            rate++;
        }

        return answer;
    }
}