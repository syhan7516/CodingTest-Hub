class Solution {
    public long solution(int r1, int r2) {

        // 결과
        long answer = 0;

        // 1 ~ r2 
        for(int i=1; i<=r2; i++) {
            
            // 테두리 체크
            long min = (int)Math.ceil(Math.sqrt(1.0*r1*r1-1.0*i*i));
            long max = (int)Math.floor(Math.sqrt(1.0*r2*r2-1.0*i*i));
        
            answer += max-min+1;
        }
        
        return answer*4;
    }
}