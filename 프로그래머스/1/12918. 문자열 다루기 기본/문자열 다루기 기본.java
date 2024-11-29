class Solution {
    
    // 4 or 6
    public static boolean isLenOk(String s) {
        
        if(s.length()==4 || s.length()==6)
            return true;
        
        return false;
    }
    
    // 0 ~ 9
    public static boolean isZeroToNine(String s) {
        
        // 범위
        int start = '0'-0;
        int end = '9'-0;
        
        for(int index=0; index<s.length(); index++) {
            if(s.charAt(index)<start || s.charAt(index)>end)
                return false;
        }
        
        return true;
    }
    
    public boolean solution(String s) {
        
        // 결과
        boolean answer = true;
        
        // 각 요소 확인
        answer = isLenOk(s) && isZeroToNine(s) ? true : false;
        
        return answer;
    }
}