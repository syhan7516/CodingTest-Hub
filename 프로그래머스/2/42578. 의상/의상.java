import java.util.*;

class Solution {
    public int solution(String[][] clothes) {
        
        // 의상 종류 개수 저장 해시 생성
        HashMap<String,Integer> map = new HashMap<>();
        
        // 의상 종류별 개수 확인
        for(int i=0; i<clothes.length; i++) {
            
            // 저장
            map.put(clothes[i][1],map.getOrDefault(clothes[i][1],0)+1);
        }
        
        // 의상 조합하기
        int cnt = 1;
        for(String kind: map.keySet()) {
            cnt *= map.get(kind)+1;
        }
            
        // 결과
        int answer = cnt-1;
        return answer;
    }
}