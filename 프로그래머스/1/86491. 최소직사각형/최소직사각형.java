class Solution {
    public int solution(int[][] sizes) {
        
        // 가로, 세로 가장 큰 크기
        int maxRow = 0;
        int maxCol = 0;
        
        // 크기 순회
        for(int card=0; card<sizes.length; card++) {
            
            // 가로보다 세로가 더 큰 경우
            if(sizes[card][0]<sizes[card][1]) {
                int mock = sizes[card][0];
                sizes[card][0] = sizes[card][1];
                sizes[card][1] = mock;
            }
            
            // 더 큰지 확인
            maxRow = Math.max(maxRow,sizes[card][0]);
            maxCol = Math.max(maxCol,sizes[card][1]);
            
        }

        return maxRow * maxCol;
    }
}