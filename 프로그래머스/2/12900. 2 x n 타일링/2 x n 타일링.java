class Solution {
    public int solution(int n) {

        // 개수 저장 배열
        int DP[] = new int[n+1];
        
        // 초기 설정
        DP[1] = 1;
        DP[2] = 2;
        
        // 개수 채우기
        for(int i=3; i<=n; i++) {
            DP[i] = (DP[i-1]+DP[i-2])%1000000007;
        }
        
        int answer = DP[n];
        return answer;
    }
}