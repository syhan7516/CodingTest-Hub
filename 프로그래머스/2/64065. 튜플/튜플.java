import java.util.*;

class Solution {  
    
    // 결과 배열
    public static int[] answer;
    
    // 튜플 배열
    public static String[] tupleArray;
    
    // 요소 저장 해시 셋
    public static HashSet<String> elements;
    
    // 결과 저장 메서드
    public static void saveResult() {
        
        // 결과 저장 인덱스
        int answerIndex = 0;
        
        // 결과 저장 배열 생성
        answer = new int[tupleArray.length];
        
        // 튜플 확인 및 요소 저장
        for(String tuple: tupleArray) {
            for(String element: tuple.split(",")) {
                if(elements.add(element)) {
                    answer[answerIndex++] = Integer.parseInt(element);
                }
            }
        }
    }
    
    public int[] solution(String s) {    
        
        // 요소 저장 해시 셋 생성
        elements = new HashSet<>();

        // 문자열 재구성
        tupleArray 
            = s.replaceAll("[{]"," ").replaceAll("[}]"," ").trim().split(" , ");

        // 길이 기준으로 튜플 정렬
        Arrays.sort(tupleArray,(a,b)->a.length()-b.length());

        // 결과 저장
        saveResult();
        
        return answer;
    }
}