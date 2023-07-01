class Solution {
    public int solution(int[][] triangle) {
        
        // 결과
        int answer = 0;
        
        // 삼각형 크기
        int triangleSize = triangle.length;
        
        // 최댓값 저장 배열
        int DP[][] = new int[triangleSize][triangleSize];
        
        // 기본 셋팅
        DP[0][0] = triangle[0][0];

        // 최댓값 구하기
        for (int a=1; a<triangleSize; a++) {
            
            // 가장 왼쪽 처리
            DP[a][0] = triangle[a][0]+DP[a-1][0];

            // 중간 처리
            for (int b=1; b<=a; b++) {
                DP[a][b] = triangle[a][b]+Math.max(DP[a-1][b],DP[a-1][b-1]);
            }

            // 가장 마지막 처리
            DP[a][a] = triangle[a][a]+DP[a-1][a-1];
        }

        // 마지막 줄 확인
        for (int idx=0; idx<triangleSize; idx++) {
            answer = Math.max(answer,DP[triangleSize-1][idx]);
        }

        return answer;
    }
}