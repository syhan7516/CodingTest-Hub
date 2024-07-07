import java.util.*;

// 노드 클래스
class Node {
    int row;
    int col;
    int cnt;
    
    public Node(int row, int col, int cnt) {
        this.row = row;
        this.col = col;
        this.cnt = cnt;
    }
}

class Solution {
    
    // 크기, 시작 지점, 목표 지점, 결과
    public static int rowSize, colSize, startY, startX, endY, endX, answer;
    
    // 맵
    public static char map[][];
    
    // 방문 여부 배열
    public static boolean visited[][];
    
    // 방향 벡터
    public static int dy[] = {0,1,0,-1};
    public static int dx[] = {1,0,-1,0};
    
    // 탐색 수행
    static void solve() {
        
        // 방문 여부 배열 생성
        visited = new boolean[rowSize][colSize];
        
        // 탐색 노드관리 큐 생성
        Queue<Node> queue = new LinkedList<>();
        
        // 시작점 삽입
        queue.offer(new Node(startY,startX,0));
        visited[startY][startX] = true;
        
        // 탐색 수행
        while(!queue.isEmpty()) {
            
            // 현재 노드
            Node current = queue.poll();
            
            // 도착 지점인 경우
            if(current.row==endY && current.col==endX) {
                answer = current.cnt;
                return;
            }
            
            // 가능 방향 확인
            for(int d=0; d<4; d++) {
                
                int ny = current.row;
                int nx = current.col;
                
                while(true) {
                    
                    // 범위를 벗어나거 방해물인 경우
                    if(ny<0 || ny>rowSize-1 || nx<0 || nx>colSize-1 
                       || map[ny][nx]=='D') {
                        ny -= dy[d];
                        nx -= dx[d];
                        break;
                    }
                    
                    // 이동
                    ny += dy[d];
                    nx += dx[d];
                }
                
                // 이미 방문한 경우
                if(visited[ny][nx]) continue;
                
                // 탐색할 노드 추가
                queue.offer(new Node(ny,nx,current.cnt+1));
                visited[ny][nx] = true;
            }
        }
    }
    
    public int solution(String[] board) {
        
        // 크기 설정
        rowSize = board.length;
        colSize = board[0].length();
        
        // 맵 생성
        map = new char[rowSize][colSize];
        
        // 맵 입력
        for(int i=0; i<rowSize; i++) {
            for(int j=0; j<colSize; j++) {
                map[i][j] = board[i].charAt(j);
                
                // 시작 지점인 경우
                if(map[i][j]=='R') {
                    startY = i;
                    startX = j;
                }
                
                // 도착 지점인 경우
                if(map[i][j]=='G') {
                    endY = i;
                    endX = j;
                }
            }
        }
        
        // 탐색 수행
        answer = -1;
        solve();
        
        return answer;
    }
}