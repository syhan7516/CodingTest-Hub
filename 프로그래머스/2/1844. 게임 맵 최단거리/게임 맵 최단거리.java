import java.util.*;

class Node {
    
    int y;
    int x;
    int dist;
    
    public Node(int y, int x, int dist) {
        this.y = y;
        this.x = x;
        this.dist = dist;
    }
}

class Solution {

    // 방향 벡터
    public static int dy[] = {1,0,-1,0};
    public static int dx[] = {0,-1,0,1};
    
    public int solution(int[][] maps) {
        
        // 결과
        int answer = -1;
        
        // 맵 크기
        int n = maps.length;
        int m = maps[0].length;
        
        // 이동 가능한 노드 저장 큐
        Queue<Node> queue = new LinkedList<>();
        
        // 첫 노드 처리
        queue.offer(new Node(0,0,1));
        maps[0][0] = 0;
        
        // 탐색 시작
        while(!queue.isEmpty()) {
            
            // 현재 노드
            Node curNode = queue.poll();
            
            // 목적지에 도착한 경우
            if(curNode.y==n-1 && curNode.x==m-1) {
                answer = curNode.dist;
                break;
            }
            
            // 방향 확인
            for(int d=0; d<4; d++) {
                
                int ny = curNode.y+dy[d];
                int nx = curNode.x+dx[d];
                
                // 범위를 벗어난 경우
                if(ny<0 || ny>n-1 || nx<0 || nx>m-1)
                    continue;
                
                // 벽인 경우
                if(maps[ny][nx]==0)
                    continue;
                
                // 탐색 가능한 경우
                queue.offer(new Node(ny,nx,curNode.dist+1));
                maps[ny][nx] = 0;
            
            }
        }
        
        return answer;
    }
}