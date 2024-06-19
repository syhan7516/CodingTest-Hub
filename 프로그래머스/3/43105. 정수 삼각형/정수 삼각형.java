class Solution {
    public int solution(int[][] triangle) {
        
        // MAX 합 저장 배열 생성
        int DP[][] = new int[triangle.length][triangle.length+1];
        
        // MAX 합 저장 배열 초기화
        DP[0][1] = triangle[0][0];
        
        // 결과
        int answer = 0;
        
        // 각 층 MAX 합 구하기
        for(int i=1; i<triangle.length; i++) {
            for(int j=1; j<i+2; j++) {
                DP[i][j] = Math.max(DP[i-1][j-1],DP[i-1][j])+triangle[i][j-1];
                answer = Math.max(answer, DP[i][j]);
            }
        }
        
        return answer;
    }
}