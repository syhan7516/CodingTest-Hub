import java.util.*;

class Solution {
    
    // 결과
    public static int answer;
    
    // 재료 리스트
    public static ArrayList<Integer> list;
    
    // 햄버거 만들기 메서드
    public static void solve() {
        
        // 재료 넣을 순서 배열
        int order[] = new int[]{1,2,3,1};
        
        // 재료 넣을 순서
        int point = 0;
        
        // 햄버거 제작 여부
        boolean flag = false;
        
        int index = 0;
        
        // 재료 확인
        while(list.size()>=4) {
            
            // 넣을 재료가 맞는 경우
            if(list.get(index)==order[point]) {
                
                // 햄버거 마지막 재료인 경우
                if(point==3) {
                    
                    // 위치 초기화
                    point = 0;
                    
                    // 재료 제거
                    index -= 3;
                    list.remove(index);
                    list.remove(index);
                    list.remove(index);
                    list.remove(index);
                    
                    // 재료 확인 위치 갱신
                    index = index<4 ? 0 : index-4;
                    
                    // 햄버거 제작 처리
                    flag = true;
                    answer++;
                }
                
                // 다음 넣을 재료 갱신
                else point++;
            }
            
            // 넣을 재료가 아닌 경우 (빵인 경우)
            else if(list.get(index)==1) 
                point = 1;
            
            // 넣을 재료가 아닌 경우 (빵 이외 재료인 경우)
            else point = 0;
            
            // 다음 확인 재료 갱신
            index++;
            
            // 순회를 완료한 경우
            if(index==list.size()) {
                
                // 햄버거가 제작된 경우
                if(flag) {
                    
                    // 초기화 처리
                    index = 0;
                    point = 0;
                    flag = false;
                }
                
                // 햄버거 미제작 경우
                else break;
            }
        }
    }
    
    public int solution(int[] ingredient) {
        
        // 재료 리스트 생성
        list = new ArrayList<>();
            
        // 재료 확인
        for(int index=0; index<ingredient.length; index++)
            list.add(ingredient[index]);
        
        // 햄버거 만들기
        answer = 0;
        solve();
        
        return answer;
    }
}