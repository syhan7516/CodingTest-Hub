import java.util.*;

class Solution {
    public String solution(String s) {
        
        // 숫자 분리
        String nums[] = s.split(" ");
        
        // 최소, 최대
        int maxNum = Integer.MIN_VALUE;
        int minNum = Integer.MAX_VALUE;
        
        // 숫자 비교
        for(int n=0; n<nums.length; n++) {
            int curN = Integer.parseInt(nums[n]);
            maxNum = Math.max(maxNum,curN);
            minNum = Math.min(minNum,curN);
        }
        
        // 결과
        String answer = minNum+" "+maxNum;
        return answer;
    }
}