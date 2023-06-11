class Solution {
    public int solution(int n) {
        
        // 결과
        int answer = 0;
        
        // 포인터 설정
        int point = 0;
        int numSum = 0;
        
        // 숫자 확인
        for(int start=1; start<=n; start++) {
            
            // 합이 같거나, 클 때까지 반복
            while(point<=n && numSum<n) {
                numSum += point;
                point++;
            }
            
            // 숫자가 같을 경우
            if(numSum==n) {
                answer++;
            }
            
            numSum -= start;
        }
        
        return answer;
    }
}