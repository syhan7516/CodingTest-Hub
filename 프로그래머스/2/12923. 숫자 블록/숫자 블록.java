class Solution {
    
    // 가장 큰 약수 구하기
    public static long solve(long number) {
        
        // 1인 경우
        if(number==1) 
            return 0;
        
        // 가장 큰 약수
        long max = 1;
        
        // 약수 구하기
        for(int i=2; i<=Math.sqrt(number); i++) {
            
            // 나누어 떨어지는지 확인
            if(number%i==0) {
                
                // 1000만을 넘을 경우 몫을 선택
                if(number/i>10000000) {
                    max = Math.max(max,i);
                    continue;
                }
                
                // 1000만을 넘지 않을 경우 나누는 수 선택
                else max = Math.max(max,number/i);
                
                break;
            }
        }
        
        return max;
    }
    
    public long[] solution(long begin, long end) {
        
        // 결과
        long[] answer = new long[(int)(end-begin)+1];
        
        // 블록 숫자 확인
        for(long i=begin; i<=end; i++) {
            
            // 위치
            int point = (int)(i-begin);
            
            // 약수 구하기
            answer[point] = solve(i);
        }
        
        return answer;
    }
}