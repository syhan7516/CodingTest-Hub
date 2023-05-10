import java.util.*;

// 위치 클래스
class Node {
    private int y;
    private int x;
    private int cost;
    
    public Node(int y, int x, int cost) {
        this.y = y;
        this.x = x;
        this.cost =cost;
    }
    
    public int getY() {
        return this.y = y;
    }
    
    public int getX() {
        return this.x = x;
    }
    
    public int getCost() {
        return this.cost = cost;
    }
}

class Solution {
    
    // 방향 벡터
    public static int dy[] = {0,1,0,-1};
    public static int dx[] = {1,0,-1,0};
        
    // 거리 확인
    static boolean bfs(char room[][], int row, int col) {
        Queue<Node> point = new LinkedList<>();
        boolean visited[][] = new boolean[5][5];
        point.offer(new Node(row,col,0));
        visited[row][col] = true;
        
        while(!point.isEmpty()) {
            // 현재 위치
            Node curNode = point.poll();
            int curY = curNode.getY();
            int curX = curNode.getX();
            int curCost = curNode.getCost();
            
            // 더 이상 탐색이 필요없을 경우
            if(curCost>=3)
                return true;
        
            // 주위 확인
            for(int dir=0; dir<4; dir++) {
                int nextY = curY+dy[dir];
                int nextX = curX+dx[dir];
                // 범위 확인
                if(nextY<0 || nextY>4 || nextX<0 || nextX>4)
                    continue;
                // 방문 여부 확인, 파티션 여부
                if(visited[nextY][nextX] || room[nextY][nextX]=='X')
                    continue;
                
                // 사람인 경우
                if(curCost<2 && room[nextY][nextX]=='P')
                    return false;
                
                // 경로 저장
                visited[nextY][nextX] = true;
                point.offer(new Node(nextY,nextX,curCost+1));
            }
        }
        
        return true;
    }
    
    
    // 방 확인
    static boolean checkRoom(String place[]) {
        // 방 만들기
        char room[][] = new char[5][5];
        for(int a=0; a<5; a++) {
            String line = place[a];
            for(int b=0; b<5; b++) {
                room[a][b] = line.charAt(b);
            }
        }
        
        // 방 확인
        for(int a=0; a<5; a++) {
            for(int b=0; b<5; b++) {
                // 사람인 경우
                if(room[a][b]=='P') {
                    if(!bfs(room,a,b))
                        return false;
                }
            }
        }
        return true;
    }
    
    public int[] solution(String[][] places) {
        // 결과 
        int[] answer = new int[5];
        
        // 대기실 둘러보기
        for(int r=0; r<5; r++) {
            // 정상적인 경우
            if(checkRoom(places[r]))
                answer[r] = 1;
            
            // 비정상적인 경우
            else 
                answer[r] = 0;
        }
        
        return answer;
    }
}