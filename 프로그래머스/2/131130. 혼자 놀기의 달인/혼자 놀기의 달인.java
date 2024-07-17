import java.util.*;

class Solution {
    
    // 결과, 상자 연 횟수
    public static int answer, openCnt;
    
    // 상자 개수 저장 우선 순위 큐
    public static PriorityQueue<Integer> boxCnt;
    
    // 상자 방문 여부 배열
    public static boolean visited[];
    
    // 상자 열기 메서드
    public static void solve(int cards[], int idx) {
        
        // 다음 상자를 열 수 있는 경우
        if(!visited[idx]) {
            visited[idx] = true;
            openCnt++;
            solve(cards,cards[idx-1]);
        }
        
        // 열지 못하는 경우
        else boxCnt.offer(openCnt);
    }
    
    public int solution(int[] cards) {
        
        // 결과
        answer = 0;
        
        // 상자 개수 저장 우선 순위 큐
        boxCnt = new PriorityQueue<>(Collections.reverseOrder());
        
        // 상자 방문 여부 배열 생성
        visited = new boolean[cards.length+1];
        
        // 카드 확인
        for(int i=0; i<cards.length; i++) {
            
            // 이미 확인한 상자가 아닌 경우
            if(!visited[i+1]) {
                
                // 확인 처리
                visited[i+1] = true;
                
                // 상자 연 횟수
                openCnt = 1;
                
                // 상자 열기
                solve(cards,cards[i]);
            }
        }
        
        // 점수 계산
        if(boxCnt.size()==1) answer = 0;
        else answer = boxCnt.poll() * boxCnt.poll();
        
        return answer;
    }
}