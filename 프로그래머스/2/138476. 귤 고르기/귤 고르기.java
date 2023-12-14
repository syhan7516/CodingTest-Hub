import java.util.*;

// 귤 정보 클래스
class Tanger implements Comparable<Tanger> {
    int kind;
    int cnt;
    
    public Tanger(int kind, int cnt) {
        this.kind = kind;
        this.cnt = cnt;
    }
    
    public int compareTo(Tanger other) {
        if(this.cnt > other.cnt) return -1;
        return 1;
    }
}

class Solution {
    public int solution(int k, int[] tangerine) {
        
        // 결과
        int answer = 0;
        
        // 귤 담을 해시 생성
        HashMap<Integer,Integer> map = new HashMap<>();
        
        // 각 귤의 개수 확인
        for(int i=0; i<tangerine.length; i++) {
            int kind = tangerine[i];
            map.put(kind,map.getOrDefault(kind,0)+1);
        }
        
        // 귤 정보 저장 우선 순위 큐 생성
        PriorityQueue<Tanger> priQ = new PriorityQueue<>();
        
        // 귤 개수 별로 저장
        for(int key: map.keySet()) {
            priQ.offer(new Tanger(key,map.get(key)));
        }
        
        // 귤 꺼내기
        int cnt = 0;
        while(cnt<k) {
            
            // 꺼낸 귤 종류 정보
            Tanger current = priQ.poll();
            
            // 개수 포함
            cnt += current.cnt;
            
            // 종류 포함
            answer++;
        }
        
        // 결과 반환
        return answer;
    }
}