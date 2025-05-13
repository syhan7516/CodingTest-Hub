import java.util.*;

class Solution {
    
    // 문자 길이
    public static final int WORD_LEN = 5;
    
    // 결과
    public static int answer;
    
    // 문자 저장 리스트
    public static ArrayList<String> words;
    
    // 선택 가능한 문자 배열
    public static String[] alpha = {"","A","E","I","O","U"};
    
    // 메서드
    static void solve(int selectedCount, String word) {
        
        // 문자가 다 선택된 경우
        if(selectedCount==WORD_LEN) {
            
            // 문자가 리스트에 포함되지 않은 경우
            if(!words.contains(word)) {
                
                // 저장
                words.add(word);
            }
            return;
        }
        
        // 알파벳 차례로 확인
        for(int alphaIndex=0; alphaIndex<alpha.length; alphaIndex++) {
            solve(selectedCount+1,word+alpha[alphaIndex]);
        }
    }
    
    public int solution(String word) {
        
        // 문자 저장 리스트 생성
        words = new ArrayList<>();
        
        // 완전 탐색 수행
        solve(0,"");
        
        // 문자 정렬
        Collections.sort(words);
        
        return words.indexOf(word);
    }
}