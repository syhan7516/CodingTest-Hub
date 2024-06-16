import java.util.*;

class Solution {
    public int solution(int[] topping) {
        
        // 결과
        int answer = 0;
        
        // 개수 저장 배열
        int leftTopping[] = new int[10001];
        int rightTopping[] = new int[10001];
        
        // 토핑 종류 저장 셋
        HashSet<Integer> leftSet = new HashSet<>();
        HashSet<Integer> rightSet = new HashSet<>();
        
        // 초기 시작 토핑
        leftTopping[topping[0]]++;
        leftSet.add(topping[0]);
        
        for(int i=1; i<topping.length; i++) {
            rightTopping[topping[i]]++;
            rightSet.add(topping[i]);
        }
        
        // 종류가 동일한 경우
        if(leftSet.size()==rightSet.size())
            answer++;
        
        // 케이크 자르기 수행
        int idx = 1;
        while(true) {
            
            // 종료 조건
            if(idx==topping.length-1) 
                break;
            
            // 왼쪽 토핑 추가
            leftTopping[topping[idx]]++;
            leftSet.add(topping[idx]);
            
            // 오른쪽 토핑 제거
            rightTopping[topping[idx]]--;
            if(rightTopping[topping[idx]]==0)
                rightSet.remove(topping[idx]);
            
            // 개수가 동일한 경우
            if(leftSet.size()==rightSet.size())
            answer++;
            
            // 왼쪽 크기 증가
            idx++;
        }
        
        return answer;
    }
}