import java.util.*;

// 노드 클래스
class Node {
    int y;
    int x;
    int cnt;
    
    public Node(int y, int x, int cnt) {
        this.y = y;
        this.x = x;
        this.cnt = cnt;
    }
}

class Solution {
    
    // 결과
    public static int answer;
    
    // 방향 벡터
    public static int dy[] = {0,1,0,-1};
    public static int dx[] = {1,0,-1,0};
    
    public int solution(int[][] maps) {
        
        // 노드 저장 큐 생성
        Queue<Node> queue = new LinkedList<>();
        
        // 시작 노드 저장
        queue.offer(new Node(0,0,1));
        maps[0][0] = -1;
        
        // 위치 이동
        answer = -1;
        while(!queue.isEmpty()) {
            
            // 현재 노드
            Node current = queue.poll();
            
            // 위치에 도달한 경우
            if(current.y==maps.length-1 && current.x==maps[0].length-1) {
                answer = current.cnt;
                break;
            }
            
            // 이동 가능한 곳 확인
            for(int d=0; d<4; d++) {
                
                // 이동할 곳
                int ny = current.y + dy[d];
                int nx = current.x + dx[d];
                
                // 범위 확인
                if(ny<0 || ny>maps.length-1 || nx<0 || nx>maps[0].length-1)
                    continue;
                
                // 이미 방문한 곳 또는 벽인지 확인
                if(maps[ny][nx]==0 || maps[ny][nx]==-1)
                    continue;
                
                // 큐에 추가
                queue.offer(new Node(ny,nx,current.cnt+1));
                maps[ny][nx] = -1;
            }
        }
        
        return answer;
    }
}