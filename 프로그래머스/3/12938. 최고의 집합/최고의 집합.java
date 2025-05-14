import java.util.*;

class Solution {
    
    // 기본 원소 값 구하기 메서드
    public static int calculateBaseNum(int sum, int count) {
        return sum/count;
    }
    
    // 나머지가 아닌 여부 확인 메서드
    public static boolean isNotModZero(int sum, int count) {
        return sum%count!=0;
    }
    
    public int[] solution(int n, int s) {
        
        // 최고의 집합이 존재하지 않는 경우
        if(n>s) return new int[]{-1};
        
        // 최고의 집합 배열 생성
        int[] answer = new int[n];
        
        // 원소 기본 값
        int baseNum = calculateBaseNum(s,n);
        
        // 기본 값으로 채우기
        Arrays.fill(answer,baseNum);
        
        // 목표 합이 개수로 나누어 떨어지지 않은 경우
        if(isNotModZero(s,n)) {
            
            // 나머지 수만큼 각 요소에 더해주기
            int exist = s%n;
            for(int count=0; count<exist; count++) {
                answer[count]++;
            }
        }
        
        // 오름차순 정렬
        Arrays.sort(answer);
           
        return answer;
    }
}