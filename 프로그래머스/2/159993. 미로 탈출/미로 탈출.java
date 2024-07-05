import java.util.*;

// 노드 클래스
class Node {
    int y;
    int x;
    int door;
    
    public Node(int y, int x, int door) {
        this.y = y;
        this.x = x;
        this.door = door;
    }
}

class Solution {
    
    // 결과, 시작 위치, 맵 크기, 탈출 위치
    public static int answer, startY, startX, rowSize, colSize, exitY, exitX;
    
    // 미로 배열
    public static char map[][];
    
    // 방문 여부 배열
    public static int visited[][][];
    
    // 방향 벡터
    public static int dy[] = {0,1,0,-1};
    public static int dx[] = {1,0,-1,0};
    
    // 미로 탈출하기 메서드
    static void solve() {
        
        // 방문 여부 배열 생성
        visited = new int[2][rowSize][colSize];
        
        // 노드 관리 큐 생성
        Queue<Node> queue = new LinkedList<>();
        
        // 시작 노드 삽입
        queue.offer(new Node(startY,startX,0));
        visited[0][startY][startX] = 1;
        
        // 탐색 수행
        while(!queue.isEmpty()) {
            
            // 현재 노드
            Node current = queue.poll();
            
            // 종료 조건
            if(current.door==1 && current.y==exitY && current.x==exitX) {
                answer = visited[current.door][exitY][exitX]-1;
                return;
            }
            
            // 이동 가능한 곳 찾기
            for(int d=0; d<4; d++) {
                int ny = current.y+dy[d];
                int nx = current.x+dx[d];
                
                // 범위를 벗어난 경우
                if(ny<0 || ny>rowSize-1 || nx<0 || nx>colSize-1)
                    continue;
                
                // 이미 방문한 경우
                if(visited[current.door][ny][nx]!=0) continue;
                
                // 벽인 경우 
                if(map[ny][nx]=='X') continue;
                
                // 레버인 경우
                if(map[ny][nx]=='L') {
                    queue.offer(new Node(ny,nx,1));
                    visited[1][ny][nx] 
                        = visited[current.door][current.y][current.x]+1;
                }
                
                // 레버가 아닌 경우
                else {
                    queue.offer(new Node(ny,nx,current.door));
                    visited[current.door][ny][nx]
                        = visited[current.door][current.y][current.x]+1;
                }
            }
        }
    }
    
    public int solution(String[] maps) {
        
        // 크기 설정
        rowSize = maps.length;
        colSize = maps[0].length();
        
        // 미로 배열 생성
        map = new char[rowSize][colSize];
        
        // 미로 정보 입력
        for(int i=0; i<rowSize; i++) {
            for(int j=0; j<colSize; j++) {
                
                map[i][j] = maps[i].charAt(j);
                
                // 시작 지점일 경우
                if(map[i][j]=='S') {
                    startY = i;
                    startX = j;
                }
                
                // 종료 지점일 경우
                if(map[i][j]=='E') {
                    exitY = i;
                    exitX = j;
                }
            }
        }
        
        // 미로 탈출하기
        answer = -1;
        solve();
    
        return answer;
    }
}