import java.util.*;

class Solution {
    public int[] solution(String msg) {
        
        // 문자열 저장 해시 맵 생성
        HashMap<String, Integer> map = new HashMap<>();
        
        // 색인 리스트 생성
        ArrayList<Integer> list = new ArrayList<>();
        
        // 사전 초기화
        for(int i=0; i<26; i++)
            map.put(String.valueOf((char)('A'+i)),i+1);
        
        // 단어 인덱스
        int mapIdx = 27;
        
        // 검색 인덱스
        int searchIdx = 0;
        
        // 저장 길이
        int size = 0;
        
        // 압축하기
        while(searchIdx!=msg.length()) {
            
            // 검색 단어
            String word = String.valueOf(msg.charAt(searchIdx));
            
            // 가장 긴 문자열 검색
            for(int i=1; searchIdx+i<=msg.length(); i++) {
                
                // 압축한 문자열
                String letter = msg.substring(searchIdx,searchIdx+i);
                
                // 문자열이 존재하는 경우
                if(map.containsKey(letter)) {
                    word = letter;
                    
                    // 끝까지 도달한 경우
                    if(searchIdx+i==msg.length()) {
                        list.add(map.get(word));
                        size = i;
                        break;
                    }
                }
                
                // 문자열이 존재하지 않는 경우
                else {
                    map.put(letter,mapIdx++);
                    list.add(map.get(word));
                    size = i-1;
                    break;
                }
            }
            
            // 검색 인덱스 증가
            searchIdx += size;
        }
        
        // 결과
        int[] answer = new int[list.size()];
        for(int i=0; i<list.size(); i++)
            answer[i] = list.get(i);

        return answer;
    }
}