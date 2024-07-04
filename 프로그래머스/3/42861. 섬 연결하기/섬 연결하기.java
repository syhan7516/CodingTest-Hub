import java.util.*;

// 간선 클래스
class Edge implements Comparable<Edge> {
    int start;
    int end;
    int value;
    
    public Edge(int start, int end, int value) {
        this.start = start;
        this.end = end;
        this.value = value;
    }
    
    public int compareTo(Edge other) {
        return this.value - other.value;
    }
}

class Solution {
    
    // 대표 번호 배열
    public static int parent[];
    
    // 간선 비용 우선 순위 큐
    public static PriorityQueue<Edge> queue;
    
    // find
    static int find(int node) {
        
        // 종료 조건
        if(parent[node]==node)
            return node;
        
        return parent[node] = find(parent[node]);
    }
    
    // union
    static void union(int a, int b) {
        
        // 대표 번호 찾기
        a = find(a);
        b = find(b);
        
        // 대표 번호 갱신
        if(a<b) parent[b] = a;
        else parent[a] = b;
    }
    
    // 섬 연결하기 메서드
    static int solve(int n) {
        
        // 연결된 섬 개수
        int cnt = 1;
        
        // 비용
        int values = 0;
        
        // 간선 확인
        while(!queue.isEmpty()) {
            
            // 종료 조건
            if(cnt==n) return values;
            
            // 현재 확인 간선
            Edge current = queue.poll();
            
            // 만약 연결이 안된 상태인 경우
            if(find(current.start)!=find(current.end)) {
                
                // 연결
                union(current.start, current.end);
                values += current.value;
                cnt++;
            }
        }
        
        return values;
    }
    
    public int solution(int n, int[][] costs) {
        
        // 간선 비용 우선 순위 큐 생성
        queue = new PriorityQueue<>();
        
        // 연결 관계 정보 입력
        for(int i=0; i<costs.length; i++) {
            queue.offer(new Edge(costs[i][0],costs[i][1],costs[i][2]));
        }
        
        // 대표 번호 배열 생성
        parent = new int[n];
        for(int i=0; i<n; i++)
            parent[i] = i;
        
        // 섬 연결하기
        int answer = solve(n);
        
        return answer;
    }
}