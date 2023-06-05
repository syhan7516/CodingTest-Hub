import java.util.*;

// 노드 클래스
class Node {
    private int y;
    private int x;
    
    public Node(int y, int x) {
        this.y = y;
        this.x = x;
    }
    
    public int getY() {
        return this.y;
    }
    
    public int getX() {
        return this.x;
    }
}

class Solution {
    
    // 방향 벡터
    public static int dy[] = {0,1,0,-1};
    public static int dx[] = {1,0,-1,0};
    
    // bfs
    static int bfs(int row, int col, int[][] maps) {
        
        // 가로, 세로 크기
        int rowSize = maps.length;
        int colSize = maps[0].length;
        
        // 경로 저장 큐
        Queue<Node> queue = new LinkedList<>();
        
        // 시작점
        queue.offer(new Node(row,col));
        maps[row][col] += 1;
        
        // 탐색
        while(!queue.isEmpty()) {
            
            // 현재 노드
            Node curNode = queue.poll();
            int curY = curNode.getY();
            int curX = curNode.getX();
            
            // 네 방향 확인
            for(int dir=0; dir<4; dir++) {
                int nextY = curY+dy[dir];
                int nextX = curX+dx[dir];
                
                // 범위 확인
                if(nextY<0 || nextY>rowSize-1 || nextX<0 || nextX>colSize-1)
                    continue;
                // 벽 확인 & 방문한 경우
                if(maps[nextY][nextX]==0 || maps[nextY][nextX]!=1)
                    continue;
                
                // 탐색 가능한 노드 처리    
                maps[nextY][nextX] += maps[curY][curX];
                
                // 도착지점에 도착했을 경우
                if(nextY==rowSize-1 && nextX==colSize-1)
                    return maps[nextY][nextX];
                
                queue.offer(new Node(nextY,nextX));
            }
        }
        
        return 0;
    }
    
    public int solution(int[][] maps) {
        
        // 미로 탐색
        int answer = bfs(0,0,maps);
        
        return answer-1;
    }
}