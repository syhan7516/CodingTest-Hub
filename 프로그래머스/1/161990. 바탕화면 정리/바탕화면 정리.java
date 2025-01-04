class Solution {
    public int[] solution(String[] wallpaper) {
        
        // 좌표 값
        int minRow = 51;
        int minCol = 51;
        int maxRow = -1;
        int maxCol = -1;
        
        
        // 바탕화면 순회
        for(int rowIndex=0; rowIndex<wallpaper.length; rowIndex++) {
            for(int colIndex=0; colIndex<wallpaper[rowIndex].length(); colIndex++) {
                
                // 파일인 경우
                if(wallpaper[rowIndex].charAt(colIndex)=='#') {
                    minRow = Math.min(minRow,rowIndex);
                    minCol = Math.min(minCol,colIndex);
                    maxRow = Math.max(maxRow,rowIndex);
                    maxCol = Math.max(maxCol,colIndex);
                }
            }
        }

        return new int[]{minRow,minCol,maxRow+1,maxCol+1};
    }
}