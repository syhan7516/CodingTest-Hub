class Solution {
    public int solution(int n) {
        
        int DP[] = new int[n+1];
        DP[0] = 0;
        DP[1] = 1;
        
        for(int index=2; index<=n; index++)
            DP[index] = (DP[index-1]+DP[index-2])%1234567;
        
        return DP[n];
    }
}