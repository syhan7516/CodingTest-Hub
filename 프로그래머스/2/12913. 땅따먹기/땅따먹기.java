class Solution {
    int solution(int[][] land) {
        
        // 최대값 저장 배열
        int DP[][] = new int[land.length][4];
        
        // 초기 값 설정
        DP[0][0] = land[0][0];
        DP[0][1] = land[0][1];
        DP[0][2] = land[0][2];
        DP[0][3] = land[0][3];
        
        // 땅따먹기 수행
        for(int i=1; i<land.length; i++) {
            DP[i][0] = Math.max(Math.max(DP[i-1][1],DP[i-1][2]),DP[i-1][3])+land[i][0];
            DP[i][1] = Math.max(Math.max(DP[i-1][0],DP[i-1][2]),DP[i-1][3])+land[i][1];
            DP[i][2] = Math.max(Math.max(DP[i-1][0],DP[i-1][1]),DP[i-1][3])+land[i][2];
            DP[i][3] = Math.max(Math.max(DP[i-1][0],DP[i-1][1]),DP[i-1][2])+land[i][3];
        }
        
        // 결과 
        int answer = 0;
        for(int i=0; i<4; i++)
            answer = Math.max(answer,DP[land.length-1][i]);

        return answer;
    }
}