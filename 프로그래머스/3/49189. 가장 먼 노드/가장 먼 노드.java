import java.util.*;

class Solution {
    
    // 결과
    public static int answer;
    
    // 연결 관계 리스트
    public static ArrayList<ArrayList<Integer>> relation;
    
    // 방문 여부 배열
    public static boolean visited[];
    
    // 노드 탐색 메서드
    static void solve(int nodeCnt) {
        
        // 방문 여부 배열 생성
        visited = new boolean[nodeCnt+1];
        
        // 노드 관리 큐 생성
        Queue<Integer> queue = new LinkedList<>();
        
        // 시작 노드 삽입
        queue.offer(1);
        visited[1] = true;
        
        // 탐색 수행
        while(!queue.isEmpty()) {
            
            // 탐색 노드 개수
            int size = queue.size();
            
            // 결과 갱신
            answer = size;
            
            // 개수 만큼 탐색 수행
            while(size-->0) {
                
                // 현재 노드
                int node = queue.poll();

                // 연결 노드 확인
                for(int i=0; i<relation.get(node).size(); i++) {

                    // 확인 노드
                    int connectNode = relation.get(node).get(i);

                    // 이미 방문한 경우
                    if(visited[connectNode]) continue;

                    // 아닌 경우
                    queue.offer(connectNode);
                    visited[connectNode] = true;
                }
            }
        }
    }
    
    public int solution(int n, int[][] edge) {
        
        // 연결 관계 리스트 생성
        relation = new ArrayList<>();
        for(int i=0; i<=n; i++)
            relation.add(new ArrayList<>());
        
        // 연결 관계 리스트 정보 입력
        for(int i=0; i<edge.length; i++) {
            relation.get(edge[i][0]).add(edge[i][1]);
            relation.get(edge[i][1]).add(edge[i][0]);
        }
        
        // 노드 탐색 
        answer = 0;
        solve(n);
        
        return answer;
    }
}