import java.util.*;

class Solution {
    public String solution(String s) {
        
        // 최소, 최대 우선 순위 큐 생성
        PriorityQueue<Integer> min = new PriorityQueue<>();
        PriorityQueue<Integer> max = new PriorityQueue<>(Collections.reverseOrder());
        
        // 값 넣기
        StringTokenizer st = new StringTokenizer(s," ");
        while(st.hasMoreTokens()) {
            String letter = st.nextToken();
            min.offer(Integer.parseInt(letter));
            max.offer(Integer.parseInt(letter));
        }
        
        
        String answer = min.poll()+" "+max.poll();
        return answer;
    }
}