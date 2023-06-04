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
    
    // 결과 리스트
    public static ArrayList<Integer> result;
    
    // 방문 여부 배열
    public static boolean visited[][];
    
    // 맵 사이즈
    public static int maxRow, maxCol;
    
    // 방향 벡터
    public static int dy[] = {0,1,0,-1};
    public static int dx[] = {1,0,-1,0};
    
    // bfs
    static int bfs(int row, int col, String[] maps) {
        
        // 가능한 일 수
        int count = 0;
        
        // 노드 저장 큐
        Queue<Node> queue = new LinkedList<>();
        
        // 첫 노드 처리
        count += maps[row].charAt(col)-'0';
        visited[row][col] = true;
        queue.offer(new Node(row,col));
        
        // 연결 노드 확인
        while(!queue.isEmpty()) {
            
            // 노드 꺼내기
            Node curNode = queue.poll();
            int curY = curNode.getY();
            int curX = curNode.getX();
            
            // 탐색 가능 노드 확인
            for(int dir=0; dir<4; dir++) {
                int nextY = curY+dy[dir];
                int nextX = curX+dx[dir];
                
                // 맵을 벗어난 경우
                if(nextY<0 || nextY>maxRow-1 || nextX<0 || nextX>maxCol-1)
                    continue;
                // 바다인 경우 또는 방문한 경우
                if(visited[nextY][nextX] || maps[nextY].charAt(nextX)=='X')
                    continue;
                
                // 섬일 경우
                count += maps[nextY].charAt(nextX)-'0';
                visited[nextY][nextX] = true;
                queue.offer(new Node(nextY,nextX));
            }
        }
        
        return count;
    }
    
    public int[] solution(String[] maps) {
        
        // 방문 여부 배열
        maxRow = maps.length;
        maxCol = maps[0].length();
        visited = new boolean[maxRow][maxCol];
        
        // 섬 개수
        int island = 0;
        
        // 결과 저장 리스트
        result = new ArrayList<>();
        
        // 지도에서 섬 찾기
        for(int a=0; a<maps.length; a++) {
            for(int b=0; b<maps[a].length(); b++) {
                // 섬인 경우
                char alpha = maps[a].charAt(b);
                if(alpha!='X' && !visited[a][b]) {
                    int count = bfs(a,b,maps);
                    // 머무를 수 있는 날 결과 저장
                    result.add(count);
                    island++;
                }
            }
        }
        
        // 결과
        int[] answer = {};
        
        // 섬이 없을 경우
        if(island==0) {
            answer = new int[1];
            answer[0] = -1;
        }
        
        // 섬이 있을 경우
        else {
            answer = new int[result.size()];
             for(int res=0; res<result.size(); res++)
                 answer[res] = result.get(res);
            // 오름차순 정렬
            Arrays.sort(answer);
        }
        
        return answer;
    }
}