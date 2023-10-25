import java.util.*;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        
        // 결과 리스트
        ArrayList<Integer> result = new ArrayList<>();
        
        // 우선 순위 작업 포인터
        int point = 0;
        
        while(true) {
            
            // 종료 조건
            if(point>=progresses.length) break;
            
            // 진행
            for(int i=point; i<progresses.length; i++) 
                progresses[i] += speeds[i];
            
            // 우선 순위 작업 확인
            int cnt = 0;
            for(int i=point; i<progresses.length; i++) {
                
                // 작업이 미완료인 경우
                if(progresses[i]<100) break;
                
                // 완료인 경우
                cnt++;
            }
            
            // 개수 추가
            if(cnt>0) result.add(cnt);
            
            // 포인터 변경
            point += cnt;
        }
        
        // 결과 배열
        int[] answer = new int[result.size()];
        for(int i=0; i<result.size(); i++)
            answer[i] = result.get(i);
        
        return answer;
    }
}