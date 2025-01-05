import java.util.*;

class Solution {    
    
    // 시작 위치, 범위
    public static int moveY, moveX, rowSize, colSize;
    
    // 방향 해시
    public static HashMap<Character,Integer> dirMap;
    
    // 방향 벡터
    public static int dy[] = {0,1,0,-1};
    public static int dx[] = {1,0,-1,0};
    
    // 이동하기 메서드
    public static int[] solve(String[] park, String[] routes) {
        
        // 이동 확인
        for(int index=0; index<routes.length; index++) {
            
            // 방향, 거리
            int direct = dirMap.get(routes[index].charAt(0));
            int distance = routes[index].charAt(2)-'0';
            
            // 임시 위치
            int mockY = moveY;
            int mockX = moveX;
            
            // 이동 가능 여부
            boolean flag = true;
            
            // 이동해보기
            for(int move=0; move<distance; move++) {
                mockY += dy[direct];
                mockX += dx[direct];
                
                // 범위 확인, 장애물인 경우
                if(mockY<0 || mockX<0 || mockY>rowSize || mockX>colSize || park[mockY].charAt(mockX)=='X') {
                    flag = false;
                    break;
                }
            }
            
            // 이동 가능한 경우
            if(flag) {
                moveY = mockY;
                moveX = mockX;
            }
        }
        
        // 반환
        return new int[]{moveY,moveX};
    }
    
    public int[] solution(String[] park, String[] routes) {
        
        // 공원 범위 확인
        rowSize = park.length-1;
        colSize = park[0].length()-1;
        
        // 시작 위치 확인
        for(int rowIndex=0; rowIndex<park.length; rowIndex++) {
            for(int colIndex=0; colIndex<park[rowIndex].length(); colIndex++) {
                if(park[rowIndex].charAt(colIndex)=='S') {
                    moveY = rowIndex;
                    moveX = colIndex;
                }
            }
        }
        
        // 방향 해시 생성 및 초기화
        dirMap = new HashMap<>();
        dirMap.put('E',0);
        dirMap.put('S',1);
        dirMap.put('W',2);
        dirMap.put('N',3);
        
        // 이동하기
        return solve(park,routes);
    }
}