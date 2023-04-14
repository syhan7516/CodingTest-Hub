import java.util.*;

class Solution {
    public String solution(String new_id) {
        
        // 소문자 변환
        new_id = new_id.toLowerCase();
        
        // 불필요한 문자 제거
        String first = "";
        for(int c=0; c<new_id.length(); c++) {
            char alpha = new_id.charAt(c);
            // 정해진 문자만 사용
            if((alpha>=97&&alpha<=122)||(alpha>=48&&alpha<=57)||alpha=='-'||alpha=='.'||alpha=='_') {
                first += alpha;
            }
        }
        
        int secLen = 1;
        String second = "";
        second += first.charAt(0);
        for(int c=1; c<first.length(); c++) {
            // . 2번 이상 제거
            if(second.charAt(secLen-1)=='.' && first.charAt(c)=='.')
                continue;
            second += first.charAt(c);
            secLen += 1;
        }

        int thiLen = 0;
        String third = "";
        for(int c=0; c<second.length(); c++) {
            // 처음과 끝 . 제거 & 빈 문자열 대체
            char alpha = second.charAt(c);
            if((thiLen==0 && alpha=='.') || (alpha=='.' && c==second.length()-1))
                continue;
            if(alpha==' ')
                third += 'a';
            else
                third += alpha;
            
            thiLen += 1;
        }
        
        // 15자리 넘을 경우
        if(third.length()>15) {
            if(third.charAt(14)=='.')
                third = third.substring(0,14);
            else
                third = third.substring(0,15);
        }
        
        // 길이가 2이하인 경우
        if(third.length()<=2) {
            
            if(third.length()==0)
                third = "aaa";
            
            else {
                for(int n=0; n<=3-third.length(); n++) {
                    third += third.charAt(third.length()-1);
                }
            }
        }
       
        String answer = third;
        return answer;
    }
}