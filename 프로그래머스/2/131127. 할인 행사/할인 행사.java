import java.util.*;

class Solution {
    public int solution(String[] want, int[] number, String[] discount) {
        
        // 결과
        int answer = 0;
        
        // 원하는 물건 개수 목록 해시 생성
        HashMap<String,Integer> map = new HashMap<>();
        
        // 원하는 물품 현재 상태 리스트 생성
        ArrayList<String> status = new ArrayList<>();
        
        // 품목, 개수 저장
        for(int i=0; i<want.length; i++) {
            map.put(want[i],number[i]);
            status.add(want[i]);
        }
        
        // 초기 할인 일정 확인
        for(int i=0; i<10; i++) {
            
            // 원하는 품목이 있는 경우
            if(map.containsKey(discount[i])) {
                
                // 개수 감소
                map.put(discount[i],map.get(discount[i])-1);
                
                // 개수가 0인 경우 품목에서 제거
                if(map.get(discount[i])<=0 && status.contains(discount[i]))
                    status.remove(discount[i]);
            }
        }
        
        // 다 산 경우
        if(status.size()==0) answer++;
        
        // 나머지 할인 일정 확인
        for(int i=10; i<discount.length; i++) {
            
            // 제거 항목이 원하는 품목인 경우
            if(map.containsKey(discount[i-10])) {
                map.put(discount[i-10], map.get(discount[i-10])+1);
                if(map.get(discount[i-10])>0 && !status.contains(discount[i-10])) 
                    status.add(discount[i-10]);
            }
                
            // 원하는 품목이 있는 경우
            if(map.containsKey(discount[i])) {
                
                // 개수 감소
                map.put(discount[i],map.get(discount[i])-1);
                
                // 개수가 0이하인 경우
                if(map.get(discount[i])<=0 && status.contains(discount[i]))
                    status.remove(discount[i]);
            }
            
            // 다 산 경우
            if(status.size()==0) answer++;
        }
        
        return answer;
    }
}