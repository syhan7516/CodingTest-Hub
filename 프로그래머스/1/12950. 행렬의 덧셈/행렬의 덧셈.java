class Solution {
    public int[][] solution(int[][] arr1, int[][] arr2) {
        
        // 결과
        int answer[][] = new int[arr1.length][arr1[0].length];
        
        // 배열 합
        for(int rowIndex=0; rowIndex<arr1.length; rowIndex++) {
            for(int colIndex=0; colIndex<arr1[rowIndex].length; colIndex++)
                answer[rowIndex][colIndex] = arr1[rowIndex][colIndex] + arr2[rowIndex][colIndex];
        }
        
        return answer;
    }
}