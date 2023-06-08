import java.util.*;

// 좌표 클래스
class Point implements Comparable<Point> {
    private int start;
    private int end;
    
    public Point(int start, int end) {
        this.start = start;
        this.end = end;
    }
    
    public int getStart() {
        return this.start;
    }
    
    public int getEnd() {
        return this.end;
    }
    
    public int compareTo(Point other) {
        if(this.end<other.end)
            return -1;
        
        else if(this.end==other.end) {
            if(this.start<other.start)
                return -1;
        }
        
        return 1;
    }
}

class Solution {
    public int solution(int[][] targets) {
        
        // 좌표 정렬을 위한 우선 순위 큐
        PriorityQueue<Point> priQ = new PriorityQueue<>();
        
        // 타겟 정렬
        for(int t=0; t<targets.length; t++) {
            int start = targets[t][0];
            int end = targets[t][1];
            priQ.offer(new Point(start,end));
        }
        
        // 결과 저장 변수
        int answer = 0;
        int s = 0;
        int e = 0;
        
        // 미사일 쏘기
        while(!priQ.isEmpty()) {
            
            // 좌표 꺼내기
            Point curPoint = priQ.poll();
            int curStart = curPoint.getStart();
            int curEnd = curPoint.getEnd();
            
            // 첫 좌표인 경우
            if(s==0 && e==0) {
                s = curStart;
                e = curEnd-1;
                answer++;
            }
            
            // 좌표가 겹치는 경우
            else if(e>=curStart && e<=curEnd) continue;
        
            // 좌표가 겹치지않는 경우
            else {
                s = curStart;
                e = curEnd-1;
                answer++;
            }
        }
        
        return answer;
    }
}