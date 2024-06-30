class Solution {
    
    // 경로 배열
    public static int path[][];
    
    public int solution(int m, int n, int[][] puddles) {
        
        // 경로 배열 생성
        path = new int[n+1][m+1];
        
        // 잠긴 구역 입력
        for(int i=0; i<puddles.length; i++)
            path[puddles[i][1]][puddles[i][0]] = -1;
        
        // 경로 탐색
        path[0][1] = 1;
        for(int i=1; i<=n; i++) {
            for(int j=1; j<=m; j++) {
                
                // 물에 잠긴 구역인 경우
                if(path[i][j]==-1) {
                    path[i][j] = 0;
                    continue;
                }
                
                // 현재 위치 최단 경로 갱신
                path[i][j] = (path[i][j-1] + path[i-1][j]) % 1000000007;
            }
        }
        
        // 결과
        int answer = path[n][m];
        
        return answer;
    }
}