import java.util.*;

// 위치 클래스
class Point {
    int y;
    int x;
    
    public Point(int y, int x) {
        this.y = y;
        this.x = x; 
    }
}

class Solution {
    
    // 결과, 크기
    public static int answer, rowSize, colSize;
    
    // 방향 벡터
    public static int dy[] = {0,1,0,-1};
    public static int dx[] = {1,0,-1,0};
    
    // 석유량 획득 배열
    public static int result[];
    
    // 석유 탐색 메서드
    static void solve(int land[][], int row, int col) {
        
        // 최대, 최소 세로 크기
        int minCol = col;
        int maxCol = col;
        
        // 위치 탐색을 위한 큐 생성
        Queue<Point> queue = new LinkedList<>();
        
        // 시작 위치 삽입
        queue.offer(new Point(row,col));
        land[row][col] = 2;
        
        // 석유량
        int cnt = 2;
        
        // 석유 탐색
        while(!queue.isEmpty()) {
            
            // 현재 위치
            Point current = queue.poll();
            
            // 방향 탐색
            for(int d=0; d<4; d++) {
                int ny = current.y+dy[d];
                int nx = current.x+dx[d];
                
                // 범위를 벗어난 경우
                if(ny<0 || ny>rowSize-1 || nx<0 || nx>colSize-1) continue;
                
                // 벽이거나 방문한 경우
                if(land[ny][nx]!=1) continue;
                
                // 석유이면서 미방문인 경우
                cnt++;
                land[ny][nx] = cnt;
                queue.offer(new Point(ny,nx));
                minCol = Math.min(minCol,nx);
                maxCol = Math.max(maxCol,nx);
            }
        }
        
        // 결과 배열에 반영
        for(int i=minCol; i<=maxCol; i++)
            result[i] += cnt-1;
    }

    public int solution(int[][] land) {
        
        // 결과
        answer = 0;
        
        // 크기 설정
        rowSize = land.length;
        colSize = land[0].length;
        
        // 석유량 획득 배열
        result = new int[colSize];
            
        for(int i=0; i<rowSize; i++) {
            for(int j=0; j<colSize; j++) {
                
                // 미방문 위치인 경우
                if(land[i][j]==1) {

                    // 석유 확인
                    solve(land,i,j);
                }
            }
        }
        
        // 최대 석유량 확인
        for(int i=0; i<colSize; i++) {
            answer = Math.max(answer,result[i]);
        }
        
        return answer;
    }
}