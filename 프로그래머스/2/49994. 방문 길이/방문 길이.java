import java.util.*;

// 좌표 클래스
class Point {
    int y;
    int x;
    
    public Point(int y, int x) {
        this.y = y;
        this.x = x;
    }
    
    public String toString(int y, int x) {
        return new StringBuilder()
            .append(this.y).append(this.x)
            .append(y).append(x).toString();
    }
}

class Solution {
    
    // 좌표 크기
    public static final int MAX_SIZE = 5;
    public static final int MIN_SIZE = -5;
    
    // 방향 벡터 (U,D,R,L)
    public static int dy[] = {1,-1,0,0};
    public static int dx[] = {0,0,1,-1};
    
    // 좌표 저장 해시 셋
    public static HashSet<String> points;
    
    // 방향 인덱스 확인 메서드
    public static int findOrderDirIndex(char order) {
        
        // U
        if(order=='U') return 0;
        
        // D
        if(order=='D') return 1;
        
        // R
        if(order=='R') return 2;
        
        // L
        else return 3;
    }
    
    public int solution(String dirs) {
        
        // 빌더
        StringBuilder sb;
        
        // 위치
        Point currentPoint = new Point(0,0);
        
        // 좌표 저장 해시 셋 생성
        points = new HashSet<>();
        
        // 명령어 확인
        for(int orderIndex=0; orderIndex<dirs.length(); orderIndex++) {
            
            // 명령
            char order = dirs.charAt(orderIndex);
            int orderDirIndex = findOrderDirIndex(order);
            
            // 명령 수행
            int nextY = currentPoint.y+dy[orderDirIndex];
            int nextX = currentPoint.x+dx[orderDirIndex];
            
            // 범위 확인
            if(nextY<MIN_SIZE || nextX<MIN_SIZE || nextY>MAX_SIZE || nextX>MAX_SIZE) continue;
            
            // 이동 좌표 저장
            Point nextPoint = new Point(nextY,nextX);
            points.add(currentPoint.toString(nextY,nextX));
            points.add(nextPoint.toString(currentPoint.y,currentPoint.x));
            
            // 이동
            currentPoint = nextPoint;
        }
        
        return points.size()/2;
    }
}