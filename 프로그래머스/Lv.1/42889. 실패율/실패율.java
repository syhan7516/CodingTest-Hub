import java.util.*;

class Fail implements Comparable<Fail> {
    int stageNum;
    double rate;
    
    public Fail(int stageNum, double rate) {
        this.stageNum = stageNum;
        this.rate = rate;
    }
    
    public int compareTo(Fail other) {
        if(this.rate>other.rate)
            return -1;
        
        if(this.rate==other.rate && this.stageNum<other.stageNum)
            return -1;
        
        return 1;
    }
}


class Solution {
    public int[] solution(int N, int[] stages) {
        
        // 실패율 우선 순위 큐
        PriorityQueue<Fail> fails = new PriorityQueue<>();
        
        // 스테이지별 사람 수, 클리어 수 배열
        int s[] = new int[N+2];
        int clear[] = new int[N+2];
        
        // 사용자 수
        int playerCnt = stages.length;
        
        // 현재 스테이지 인원 정보 확인
        for(int i=0; i<stages.length; i++) {
            s[stages[i]]++;
        }
        
        // 현재 스테이지 클리어 수 정보 확인
        int clearCnt = s[N+1];
        for(int i=s.length-2; i>0; i--) {
            clear[i] = clearCnt+s[i];
            clearCnt += s[i];
        }
        
        // 스테이지 확인
        for(int i=1; i<=N; i++) {
            
            if(clear[i]==0) fails.offer(new Fail(i,0));
            else fails.offer(new Fail(i,s[i]/(double)clear[i]));
        }
        
        // 결과
        int[] answer = new int[N];
        
        // 결과 입력
        int idx = 0;
        while(!fails.isEmpty()) {
            
            Fail f = fails.poll();
            
            answer[idx] = f.stageNum;
            
            idx++;
            
        }

        return answer;
    }
}