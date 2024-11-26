class Solution {
    public String solution(String s) {
        
        // 중간 인덱스 구하기
        int midIndex = s.length()/2;
        
        // 결과 저장
        String answer = s.length()%2==0 
            ? s.substring(midIndex-1,midIndex+1) 
            : s.substring(midIndex,midIndex+1); 
        
        return answer;
    }
}