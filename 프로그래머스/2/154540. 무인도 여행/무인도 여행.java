import java.util.*;

// 구역 클래스
class Point {
    int row;
    int col;
    
    public Point(int row, int col) {
        this.row = row;
        this.col = col;
    }
}

class Solution {
    
    // 지도 크기
    public static int rowSize, colSize;
    
    // 지도 배열 
    public static int map[][];
    
    // 결과 저장 리스트
    public static ArrayList<Integer> result;
    
    // 방향 벡터
    public static int dy[] = {0,1,0,-1};
    public static int dx[] = {1,0,-1,0};
    
    // 무인도 탐색 메서드
    static int solve(int row, int col) {
        
        // 머물 수 있는 날 
        int day = 0;
        
        // 탐색 구역 저장 큐 생성
        Queue<Point> queue = new LinkedList<>();
        
        // 시작 노드 삽입
        queue.offer(new Point(row,col));
        day += map[row][col];
        map[row][col] = 0;
        
        // 탐색 수행
        while(!queue.isEmpty()) {
            
            // 현재 위치
            Point current = queue.poll();
            
            // 이동 가능한 구역 확인
            for(int d=0; d<4; d++) {
                int ny = current.row+dy[d];
                int nx = current.col+dx[d];
                
                // 범위를 넘어선 경우
                if(ny<0 || ny>rowSize-1 || nx<0 || nx>colSize-1)
                    continue;
                
                // 바다이거나 이미 방문한 경우
                if(map[ny][nx]==0) continue;
                
                queue.offer(new Point(ny,nx));
                day += map[ny][nx];
                map[ny][nx] = 0;
            }
        }
        
        return day;
    }
    
    public int[] solution(String[] maps) {
        
        // 지도 배열 생성
        map = new int[maps.length][maps[0].length()];
        
        // 지도 정보 입력
        for(int i=0; i<maps.length; i++) {
            for(int j=0; j<maps[i].length(); j++) {
                char c = maps[i].charAt(j);
                if(c=='X') map[i][j] = 0;
                else map[i][j] = c-'0';
            }
        }
        
        // 결과 저장 리스트 생성
        result = new ArrayList<>();
        
        // 지도 탐색
        rowSize = map.length;
        colSize = map[0].length;
        for(int i=0; i<map.length; i++) {
            for(int j=0; j<map[i].length; j++) {
                
                // 미방문인 경우 무인도 탐색
                if(map[i][j]!=0) {
                    int cnt = solve(i,j);
                    result.add(cnt);
                }
            }
        }
        
        // 결과
        int[] answer;
        
        // 무인도가 없는 경우
        if(result.size()==0) answer = new int[]{-1};
        
        // 존재하는 경우
        else {
            Collections.sort(result);
            answer = new int[result.size()];
            for(int i=0; i<result.size(); i++)
                answer[i] = result.get(i);
        }
        
        return answer;
    }
}