import java.util.*;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        
        // 배포 개수 저장 리스트 생성
        ArrayList<Integer> deploy = new ArrayList<>();
        
        // 시간
        int time = 0;
        
        // 일괄 처리 개수
        int count = 0;
        
        // 작업 순회
        for(int progress=0; progress<progresses.length; progress++) {
            
            // 현재 작업
            int job = progresses[progress];
            
            // 시간에 따른 작업 결과
            job += time*speeds[progress];
            
            // 작업이 완료된 경우
            if(job>=100) {
                count++;
                continue;
            }
            
            // 초기화
            deploy.add(count);
            count = 0;
        
            // 남은 작업
            int remainingWork = 100-job;
            
            // 시간 계산
            time += remainingWork%speeds[progress]==0 
                ? remainingWork/speeds[progress]
                : remainingWork/speeds[progress]+1;
            
            // 완료 작업 추가
            count++;
        }
        
        // 마지막 배포
        deploy.add(count);
        
        // 결과
        int[] answer = new int[deploy.size()-1];
        for(int index=1; index<deploy.size(); index++)
            answer[index-1] = deploy.get(index);
        
        return answer;
    }
}