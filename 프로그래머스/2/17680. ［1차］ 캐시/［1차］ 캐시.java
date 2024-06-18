import java.util.*;

class Solution {
    public int solution(int cacheSize, String[] cities) {
        
        // 캐싱 해시 생성
        HashMap<String, Boolean> map = new HashMap<>();
        
        // LRU 리스트 생성
        ArrayList<String> lru = new ArrayList<>();
        
        // 결과
        int answer = 0;
        
        // 캐싱 수행
        if(cacheSize==0) answer = cities.length*5;
        
        else {
            
            for(int i=0; i<cities.length; i++) {
                
                // 소문자 만들기
                String letter = cities[i].toLowerCase();
            
                // 캐싱이 되어있는 경우
                if(map.getOrDefault(letter,false)) {

                    // HIT
                    answer += 1;

                    // LRU 최신화
                    lru.remove(letter);
                    lru.add(letter);
                }
            
                // 캐싱이 되어있지 않은 경우
                else {

                    // 가득 찬 경우
                    if(lru.size()==cacheSize) {
                        map.remove(lru.get(0));
                        lru.remove(lru.get(0));
                    }

                    // MISS
                    answer += 5;

                    // LRU 최신화
                    lru.add(letter);

                    // 해시 최신화
                    map.put(letter,true);

                }
            }
        }
    
        return answer;
    }
}