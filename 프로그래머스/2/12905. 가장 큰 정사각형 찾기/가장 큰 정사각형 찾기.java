class Solution
{
    public int solution(int [][]board) {
        
        // 최대 크기 저장 배열 생셩
        int map[][] = new int[board.length+1][board[0].length+1];
        
        // 크기 정보 입력
        for(int i=0; i<board.length; i++) {
            for(int j=0; j<board[i].length; j++) {
                map[i+1][j+1] = board[i][j];
            }
        }
        
        // 결과
        int answer = 0;
        
        // 크기 확인
        for(int i=1; i<map.length; i++) {
            for(int j=1; j<map[i].length; j++) {
                
                // 1이상인 경우
                if(map[i][j]!=0) {
                    map[i][j] = Math.min(map[i-1][j-1],Math.min(map[i-1][j],map[i][j-1]))+1;
                    answer = Math.max(answer,map[i][j]);
                }
            }
        }
        
        return answer * answer;
    }
}