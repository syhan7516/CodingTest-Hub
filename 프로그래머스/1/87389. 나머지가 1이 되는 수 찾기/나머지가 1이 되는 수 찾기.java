class Solution {
    public int solution(int n) {
        
        // 결과
        int answer = 0;
        
        // 나눠보기
        for(int number=1; number<n; number++) {
            
            // 나머지가 1인 경우
            if(n%number==1) {
                answer = number;
                break;
            }
        }
        
        return answer;
    }
}