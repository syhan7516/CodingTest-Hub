class Solution {
    public long solution(long n) {
        
        // 결과
        long answer = 0;
        
        // 대상
        int current = 1;
        
        while(true) {
            
            // 제곱 수
            long number = (long)current*current;
            
            // n과 일치하는 경우
            if(n==number) {
                current++;
                answer = (long)current * current;
                break;
            }
            
            // 아닌 경우
            else {
                
                // n보다 작은 경우
                if(n>number) current++;
                
                // n보다 큰 경우
                else {
                    answer = -1;
                    break;
                }
            }
        }
        
        return answer;
    }
}