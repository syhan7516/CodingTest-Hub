import java.util.*;

class Solution {
    
    // 숫자 집합 정보 배열
    public static int parent[];
    
    // union
    static void union(int a, int b) {
        
        // 대표 번호 찾기
        a = find(a);
        b = find(b);
        
        // 더 작은 수 정하기
        if(a>b) {
            int tmp = a;
            a = b;
            b = tmp;
        }
        
        parent[b] = a;
    }
    
    // find
    static int find(int node) {
        
        // 자기 자신일 경우
        if(parent[node]==node)
            return node;
        
        // 대표 번호 찾기
        return parent[node] = find(parent[node]);
    }
    
    public int solution(int n, int[][] computers) {
        
        // 숫자 집합 정보 배열 생성
        parent = new int[computers.length];
        
        // 초기화
        for(int i=0; i<parent.length; i++)
            parent[i] = i;
        
        // 네트워크 확인
        for(int i=0; i<computers.length; i++) {
            for(int j=0; j<computers[i].length; j++) {
                
                // 자기 자신이거나 연결안된 경우
                if(i==j || computers[i][j]==0) continue;
                
                // 동일 네트워크 처리
                union(i,j);
            }
        }
        
        // 네트워크 확인
        HashSet<Integer> set = new HashSet<>();
        for(int i=0; i<parent.length; i++) {
            find(i);
            set.add(parent[i]);
        }
        
        // 결과
        int answer = set.size();
        
        return answer;
    }
}