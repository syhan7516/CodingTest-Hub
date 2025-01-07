class Solution {
    
    // 0개수 확인 메서드
    public static int getZeroCount(String s) {
        
        int count = 0;
        
        for(int index=0; index<s.length(); index++)
            if(s.charAt(index)=='0') count++;
        
        return count;
    }

    
    public int[] solution(String s) {
        
        // 0개수
        int zeroCount = 0;
        
        // 변환 수
        int changeCount = 0;
        
        while(!"1".equals(s)) {
            
            // 0개수
            int count = getZeroCount(s);
            zeroCount += count;
            
            // 변환
            s = Integer.toBinaryString(s.length()-count);
            changeCount++;
        }
        
        return new int[]{changeCount,zeroCount};
    }
}