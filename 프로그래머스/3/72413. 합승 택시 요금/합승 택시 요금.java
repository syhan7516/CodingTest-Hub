import java.util.*;

class Solution {
    
    // 최단 경로 배열
    public static int path[][];
    
    // 최단 경로 구하기 메서드
    public static int solve(int n, int s, int a, int b) {
        
        // 모든 경로 확인
        for(int k=1; k<=n; k++) {
            for(int i=1; i<=n; i++) {
                for(int j=1; j<=n; j++) {
                    path[i][j] = Math.min(path[i][j],path[i][k]+path[k][j]);
                    path[j][i] = path[i][j];
                }
            }
        }
        
        // s -> a -> b 최단 경로
        return path[s][a]+path[a][b];
    }
    
    public int solution(int n, int s, int a, int b, int[][] fares) { 
        
        // 최단 경로 저장 배열 생성
        path = new int[n+1][n+1];
        
        // 최단 경로 배열 초기화
        for(int i=1; i<=n; i++) {
            for(int j=1; j<=n; j++) {
                if(i==j) path[i][j] = 0;
                else {
                    path[i][j] = 200000001;
                    path[j][i] = 200000001;
                } 
            }
        }
       
        // 경로 정보 저장
        for(int i=0; i<fares.length; i++) {
            int start = fares[i][0];
            int end = fares[i][1];
            int dist = fares[i][2];
            path[start][end] = dist;
            path[end][start] = dist;
        }
        
        // 최단 경로 구하기
        int answer = solve(n,s,a,b);
        
        // 경유 지점 확인
        for(int i=1; i<=n; i++)
            answer = Math.min(answer,path[s][i]+path[i][a]+path[i][b]);

        return answer;
    }
}