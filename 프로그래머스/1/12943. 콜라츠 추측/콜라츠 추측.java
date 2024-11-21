class Solution {
    public int solution(long num) {
        
        // 결과
        int answer = 0;
    
        // 연산 수행
        while(num!=1 && answer<=500) {
            
            // 짝수인 경우
            if(num%2==0)
                num = num/2;
            
            // 홀수인 경우
            else num = num*3+1;
            
            // 연산 횟수 증가
            answer++;
            
        }
        
        // 결과 저장
        answer = num==1 ? answer : -1;
        
        return answer;
    }
}