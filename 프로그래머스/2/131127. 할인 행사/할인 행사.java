import java.util.*;

class Solution {
    
    // 인덱스 매칭 해시 맵
    public static HashMap<String,Integer> names;
    
    // 행사 그룹 해시 셋
    public static HashSet<String> foods;
    
    // 개수 배열
    public static String count[];
    
    public int solution(String[] want, int[] number, String[] discount) {
        
        // 결과
        int answer = 0;
        
        // 개수 정보 해시 맵 생성
        names = new HashMap<>();
        
        // 행사 그룹 해시 셋 생성
        foods = new HashSet<>();
        
        // 개수 배열 생성
        count = new String[want.length];
        
        // 인덱스 정보 입력
        for(int index=0; index<want.length; index++)
            names.put(want[index],index);
        
        // 10개 물건 처리
        for(int index=0; index<10; index++) {
            
            // 등록된 상품인 경우
            if(names.containsKey(discount[index])) {
                
                // 인덱스 확인
                int point = names.get(discount[index]);
                
                // 개수 감소
                number[point]--;
                
                // 개수가 0인 경우
                if(number[point]==0) {
                    
                    // 상품 추가
                    foods.add(discount[index]);
                }
                
                // 상품이 모두 모인 경우
                if(foods.size()==want.length)
                    answer++;
            }
        }
            
        // 이 외 물건 처리
        for(int index=10; index<discount.length; index++) {

            // 최근 날짜 상품이 등록된 상품인 경우
            if(names.containsKey(discount[index])) {
                
                // 인덱스 위치 확인
                int point = names.get(discount[index]);
                
                // 개수 감소
                number[point]--;
                
                // 개수가 0인 경우
                if(number[point]==0)
                    
                    // 상품 추가
                    foods.add(discount[index]);
            }

            // 가장 오래된 날짜 상품이 등록된 상품인 경우
            if(names.containsKey(discount[index-10])) {
                
                // 인덱스 위치 확인
                int point = names.get(discount[index-10]);
                
                // 개수 증가
                number[point]++;
                
                // 개수가 0을 넘는 경우
                if(number[point]>0) 
                    
                    // 상품 목록에서 제거
                    foods.remove(discount[index-10]);
            }

            // 상품이 모두 모인 경우
            if(foods.size()==want.length)
                answer++;
        }
        
        return answer;
    }
}