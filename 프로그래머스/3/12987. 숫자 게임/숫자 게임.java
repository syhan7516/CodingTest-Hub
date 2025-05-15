import java.util.*;

class Solution {    
    public int solution(int[] A, int[] B) {
        
        // 결과
        int answer = 0;
        
        // 오름차순 정렬
        Arrays.sort(A);
        Arrays.sort(B);
        
        // 인덱스 위치
        int aIndex = 0;
        int bIndex = 0;
        
        // 비교
        while(aIndex<A.length && bIndex<B.length) {
            
            // 비교 대상 설정
            int a = A[aIndex];
            int b = B[bIndex];
            
            // B팀 선수가 더 높은 경우
            if(a<b) {
                aIndex++;
                answer++;
            }
            
            // B팀 다음 선수 설정
            bIndex++;
        }
        
        return answer;
    }
}