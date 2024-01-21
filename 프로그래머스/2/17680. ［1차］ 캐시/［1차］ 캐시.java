import java.util.*;

class Solution {
    public int solution(int cacheSize, String[] cities) {
        
        // LRU 리스트 생성
        ArrayList<String> list = new ArrayList<>();
        
        // 결과
        int answer = 0;
        
        // 캐시가 0인 경우
        if(cacheSize==0)
            answer = 5*cities.length;
        
        // 아닌 경우
        else {
            
            // 캐시 수행
            for(int i=0; i<cities.length; i++) {
                
                String findCity = cities[i].toLowerCase();

                // 도시가 존재하는 경우
                if(list.contains(findCity)) {
                    list.remove(findCity);
                    answer += 1;
                }

                // 그 외의 경우
                else {

                    // 캐시가 꽉 찬 경우
                    if(list.size()==cacheSize) {
                        list.remove(list.get(0));   
                    }
                    
                    answer += 5;
                }

                list.add(findCity);
            }
        }
    
        return answer;
    }
}