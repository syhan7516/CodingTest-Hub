import java.util.*;

class Solution {
    
    public int solution(int[] nums) {
        
        // 포켓몬 종류 셋
        HashSet<Integer> poketSet = new HashSet<>();
        
        // 포켓몬 확인
        for(int i=0; i<nums.length; i++) 
            poketSet.add(nums[i]);
            
        // 가져도되는 포켓몬 수
        int cnt = nums.length/2;
            
        // 결과
        int answer = 0;
        
        // 포켓몬 종류가 내가 가져도되는 포켓몬 수보다 많을 경우
        if(poketSet.size()>cnt)
            answer = cnt;
        
        // 아닌 경우
        else 
            answer = poketSet.size();
            
        return answer;
    }
}