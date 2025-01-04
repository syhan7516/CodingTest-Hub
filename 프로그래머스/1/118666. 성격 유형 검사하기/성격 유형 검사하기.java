import java.util.*;

class Solution {
    
    // 지표 값 저장 해시
    public static HashMap<Character,Integer> map;
    
    // 해시 초기화 메서드
    public static void mapInit() {
        
        // 지표 값 저장 해시 생성
        map = new HashMap<>();
        
        // 해시 초기화
        map.put('R',0);
        map.put('T',0);
        map.put('C',0);
        map.put('F',0);
        map.put('J',0);
        map.put('M',0);
        map.put('A',0);
        map.put('N',0);
    }
    
    // 값 처리 메서드
    public static void scoreCalculator(char target1, char target2, int value) {
        
        // 값 처리
        switch(value) {

            case 1:
                map.put(target1,map.get(target1)+3);
                break;
            case 2:
                map.put(target1,map.get(target1)+2);
                break;
            case 3:
                map.put(target1,map.get(target1)+1);
                break;
            case 4:
                break;
            case 5:
                map.put(target2,map.get(target2)+1);
                break;
            case 6:
                map.put(target2,map.get(target2)+2);
                break;
            case 7:
                map.put(target2,map.get(target2)+3);
                break;
        }
    }
    
    // 유형 비교 메서드
    public static char find(char a, char b) {
        
        if(map.get(a)>=map.get(b))
            return a;
        else return b;
    }
    
    // 유형 확인 메서드
    public static String typeCalculator() {
        
        StringBuilder sb = new StringBuilder();
        sb.append(find('R','T'));
        sb.append(find('C','F'));
        sb.append(find('J','M'));
        sb.append(find('A','N'));
        return sb.toString();
    }
    
    public String solution(String[] survey, int[] choices) {        
        
        // 해시 초기화
        mapInit();
        
        // 질문 확인
        for(int index=0; index<survey.length; index++) {
            
            // 지표 대상
            char target1 = survey[index].charAt(0);
            char target2 = survey[index].charAt(1);
            
            // 지표 선택 값
            int value = choices[index];
            
            // 값 처리
            scoreCalculator(target1, target2, value);
        }
        
        // 유형 확인
        return typeCalculator();
    }
}