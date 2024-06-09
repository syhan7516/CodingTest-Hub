class Solution {
    public long solution(int n) {
    
        // 가지 수 저장 배열
        long DP[] = new long[2001];
        
        // 초기 값
        DP[0] = 1;
        DP[1] = 1;
        
        // 멀리 뛰기
        for(int i=2; i<=2000; i++) {
            DP[i] = (DP[i-1]+DP[i-2]) % 1234567;
        }
        
        // 결과
        long answer = DP[n];
        
        return answer;
    }
}