import java.util.*;

class Solution {
    
    // 옷 종류 개수 해시 맵
    public static HashMap<String,Integer> map;
    
    public int solution(String[][] clothes) {
        
        // 결과
        int answer = 1;
        
        // 옷 종류 개수 해시 맵 생성
        map = new HashMap<>();
        
        // 옷 종류 입력
        for(int index=0; index<clothes.length; index++) {
            map.put(clothes[index][1],map.getOrDefault(clothes[index][1],0)+1);
        }
        
        // 옷 종류 개수 확인
        for(int count: map.values())
            answer *= count+1;
        
        return answer-1;
    }
}