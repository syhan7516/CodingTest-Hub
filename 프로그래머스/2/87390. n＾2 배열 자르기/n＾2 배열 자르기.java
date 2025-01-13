import java.util.*;

class Solution {
    public int[] solution(int n, long left, long right) {
        
        // 값 저장 리스트 생성
        ArrayList<Integer> nums = new ArrayList<>();
        
        // 순회
        for(long index=left; index<=right; index++) {
            
            // 위치
            int row = (int)(index/n);
            int col = (int)(index%n);
            
            // 값
            int value = Math.max(row,col)+1;
            nums.add(value);
        }
        
        // 결과
        int answer[] = new int[nums.size()];
        for(int index=0; index<nums.size(); index++)
            answer[index] = nums.get(index);
        
        return answer;
    }
}