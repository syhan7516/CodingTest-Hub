class Solution {
    public int solution(int n) {
        
        // 결과
        int answer = 0;
        
        // 약수 더해보기
        for(int number=1; number<=n; number++) {
            
            // 약수인 경우
            if(n%number==0) answer += number;
        }
        
        
        return answer;
    }
}