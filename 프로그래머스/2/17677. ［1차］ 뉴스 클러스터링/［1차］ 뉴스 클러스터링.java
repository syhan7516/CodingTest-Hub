import java.util.*;

class Solution {
    public int solution(String str1, String str2) {
        
        // 결과
        int answer = 0;
        
        // 합, 교 개수
        int h = 0;
        int g = 0;
        
        // 문자열 저장 해시 맵
        HashMap<String,Integer> map = new HashMap<>();
        
        // 소문자로 변환
        str1 = str1.toLowerCase();
        str2 = str2.toLowerCase();
        
        // 문자열 자르기
        for(int i=0; i<str1.length()-1; i++) {
            
            // 자른 문자열
            String cut = str1.substring(i,i+2);
            
            // 문자인지 확인 (97~122)
            if(cut.charAt(0) < 97 || cut.charAt(0) > 122) continue;
            if(cut.charAt(1) < 97 || cut.charAt(1) > 122) continue;
            
            // 맵에 저장
            map.put(cut,map.getOrDefault(cut,0)+1);
            
            // 합집합 수 증가
            h++;
        }
        
        // 문자열 자르기
        for(int i=0; i<str2.length()-1; i++) {
            
            // 자른 문자열
            String cut = str2.substring(i,i+2);
            
            // 문자인지 확인 (97~122)
            if(cut.charAt(0) < 97 || cut.charAt(0) > 122) continue;
            if(cut.charAt(1) < 97 || cut.charAt(1) > 122) continue;
            
            // 교집합인 경우
            if(map.containsKey(cut) && map.get(cut)>0) {
                g++;
                map.put(cut,map.get(cut)-1);
            }
            
            // 겹치지 않을 경우
            else {
                System.out.println("h : "+cut);
                h++;
            }
        }
        
        // 임시 변수
        double result = 0;
        
        // 둘 다 0일 경우
        if(g==0 && h==0) result = 1;
    
        // 아닐 경우
        else result = (double)g/h;
        
        System.out.println(g+":"+h);
        
        answer = (int)(result*65536);

        return answer;
    }
}