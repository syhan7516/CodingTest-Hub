class Solution {
    public int solution(String s) {
        
        // 결과
        int answer = 0;
        
        // 기준 문자
        char target = ' ';
        
        // 확인 위치
        int start = 0;
        int end = 0;
        
        // 문자 개수
        int targetCount = 0;
        int alphaCount = 0;
        
        // 순서대로 확인
        while(end<s.length()) {
            
            // 기준 문자 설정
            if(start==end)
                target = s.charAt(start);
            
            // 현재 문자
            char alpha = s.charAt(end);
            
            // 문자 확인
            if(alpha==target) targetCount++;
            else alphaCount++;
            
            // 위치 갱신
            end++;
        
            // 개수가 동일한 경우
            if(targetCount==alphaCount) {
                
                // 문자열 자르기
                s = s.substring(end);
                
                // 초기화
                start = 0;
                end = 0;
                targetCount = 0;
                alphaCount = 0;
                answer++;
            }
        }
        
        // start, end 위치가 다른 경우
        if(start!=end) answer++; 
        
        return answer;
    }
}