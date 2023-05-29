import java.util.*;

class Solution {
    
    // 시작 위치
    public static int y, x;
    // 가로, 세로 크기
    public static int rowSize, colSize;
    // 방향
    public static char dir[] = {'E','S','W','N'};
    public static int dy[] = {0,1,0,-1};
    public static int dx[] = {1,0,-1,0};
    
    // 시작 위치 구하기
    static void getStart(String[] park) {
        for(int row=0; row<rowSize; row++) {
            for(int col=0; col<colSize; col++) {
                if(park[row].charAt(col)=='S') {
                    y = row;
                    x = col;
                    return;
                }
            }
        }
    }
    
    // 방향 확인 함수
    static void move(String park[], char direct, int dist) {
        
        // 방향 체크
        for(int d=0; d<4; d++) {
            if(direct==dir[d]) {

                // 방향 만큼 거리 이동
                int nextY = y;
                int nextX = x;
                
                for(int m=0; m<dist; m++) {
                    nextY = nextY+dy[d];
                    nextX = nextX+dx[d];
                    
                    // 공원을 벗어나는지 확인
                    if(nextY<0 || nextY>rowSize-1 || nextX<0 || nextX>colSize-1)
                        return;

                    // 장애물을 만나는지 확인
                    if(park[nextY].charAt(nextX)=='X')
                        return;
                }
                        
                // 이동 저장
                y = nextY;
                x = nextX;
            }
        }
    }
    
    public int[] solution(String[] park, String[] routes) {
        
        // 가로, 세로 크기
        rowSize = park.length;
        colSize = park[0].length();
        
        // 시작 위치 찾기
        getStart(park);
        
        // 공원 산책
        for(int r=0; r<routes.length; r++) {
            char direct = routes[r].charAt(0);
            int dist = routes[r].charAt(2)-'0';
        
            // 방향 확인
            move(park,direct,dist);
        }
        
        // 결과 저장
        int[] answer = {y,x};
        return answer;
    }
}