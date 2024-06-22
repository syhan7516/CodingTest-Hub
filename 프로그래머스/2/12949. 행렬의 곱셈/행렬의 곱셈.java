class Solution {
    public int[][] solution(int[][] arr1, int[][] arr2) {
        
        // 결과
       int[][] answer = new int[arr1.length][arr2[0].length];
        
        // 행렬 곱셈 수행
        for(int i=0; i<arr1.length; i++) {
            for(int j=0; j<arr2[0].length; j++) {
                int t = 0;  
                for(int k=0; k<arr2.length; k++) {
                    t += (arr1[i][k]*arr2[k][j]);
                }
                
                // 결과 저장
                answer[i][j] = t; 
            }
        }
        
        return answer;
    }
}