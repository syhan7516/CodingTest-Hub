class Solution {
    public int solution(int left, int right) {
        
        // 결과
        int answer = 0;
        
        // 약수 찾기
        for(int number=left; number<=right; number++) {
            
            // 약수 개수
            int count = 0;
            
            // 나눠보기
            for(int value=1; value<=number; value++) {
                
                // 나눠지는 경우
                if(number%value==0) count++;
            }
            
            // 결과 반영
            answer = count%2==0 ? answer+number : answer-number;
        }
        
        return answer;
    }
}