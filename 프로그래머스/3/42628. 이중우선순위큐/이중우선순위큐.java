import java.util.*;
import java.io.*;

class Solution {
    public int[] solution(String[] operations) {
        
        StringTokenizer st;
        
        // 결과
        int[] answer = new int[2];
        
        // 최소, 최대 우선 순위 큐 생성
        PriorityQueue<Integer> max = new PriorityQueue<>((a,b) -> b-a);
        PriorityQueue<Integer> min = new PriorityQueue<>();
        
        // 연산 확인
        for(int operationIndex=0; operationIndex<operations.length; operationIndex++) {
            
            // 연산 가져오기
            st = new StringTokenizer(operations[operationIndex]);
            
            // 연산자 정보 확인
            String operator = st.nextToken();
            
            // 삽입인 경우
            if("I".equals(operator)) {
                
                // 값 입력 및 큐에 저장
                int num = Integer.parseInt(st.nextToken());
                max.offer(num);
                min.offer(num);
            }
            
            // 삭제인 경우
            if("D".equals(operator)) {
                
                // 연산자 가져오기
                operator = st.nextToken();
                
                // 최솟값 삭제인 경우
                if("-1".equals(operator) && !min.isEmpty()) {
                    max.remove(min.poll());
                }
                
                // 최댓값 삭제인 경우
                if("1".equals(operator) && !max.isEmpty()) {
                    min.remove(max.poll());
                }
            }
        }
        
        // 결과 저장
        if(!min.isEmpty()) {
            answer[0] = max.peek();
            answer[1] = min.peek();
        }
        
        return answer;
    }
}