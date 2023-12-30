import java.util.*;

class Solution {
    public String solution(String[] survey, int[] choices) {
        
        // 결과
        String answer = "";
        
        // 유형 배열
        char kinds[][] = {{'R','T'},{'C','F'},{'J','M'},{'A','N'}};
        
        // 유형 점수 배열
        int score[] = {0,3,2,1,0,1,2,3};
        
        // 유형 누적 점수 배열
        int sum[] = new int[26];
        
        // 질문 확인
        for(int i=0; i<survey.length; i++) {
            
            // 비동의 유형
            char no = survey[i].charAt(0);
            // 동의 유형
            char ok = survey[i].charAt(1);
            // 선택
            int select = choices[i];
            
            // 점수 추가
            if(select==4) continue;
            
            else if(select>=1 && select<=3) {
                sum[(no-'A')] += score[select];
            }
            
            else {
                sum[(ok-'A')] += score[select];
            }
        }
        
        // 유형 결과 확인
        for(int i=0; i<4; i++) {
            
            // 지표의 유형
            char a = kinds[i][0];
            char b = kinds[i][1];
            
            // 유형 점수 확인
            if(sum[a-'A']>=sum[b-'A']) {
                answer += a;
            }
        
            else {
                answer += b;
            }
        }
        
        return answer;
    }
}