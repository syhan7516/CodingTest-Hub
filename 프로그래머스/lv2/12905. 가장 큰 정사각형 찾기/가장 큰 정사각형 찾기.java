class Solution
{
    public int solution(int [][]board)
    {
        
        // 결과
        int answer = 0;
        
        // 표 정보
        int rowLen = board.length;
        int colLen = board[0].length;
        
        // 해당 자리에서 만들기 가능한 개수 저장 배열
        int DP[][] = new int[rowLen+1][colLen+1];
        
        // 각 위치에서 확인
        for(int a=1; a<=rowLen; a++) {
            for(int b=1; b<=colLen; b++) {
                if(board[a-1][b-1]==1) {
                    DP[a][b] = Math.min(Math.min(DP[a][b-1],DP[a-1][b]),DP[a-1][b-1])+1;
                    answer = Math.max(answer,DP[a][b]);
                }
            }
        }
            

        return answer*answer;
    }
}