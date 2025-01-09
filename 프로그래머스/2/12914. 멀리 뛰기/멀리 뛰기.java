class Solution {
    public long solution(int n) {
        
        // 이동 가능 수 배열
        long DP[] = new long[n+1];
        
        // 초기 0칸, 1칸 설정
        DP[1] = 1;
        DP[0] = 1;
        
        // 2칸부터 확인
        for(int index=2; index<=n; index++)
            DP[index] = (DP[index-1]+DP[index-2])%1234567;
        
        return DP[n];
    }
}