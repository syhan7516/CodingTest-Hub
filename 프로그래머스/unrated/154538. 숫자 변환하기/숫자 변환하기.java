import java.util.*;

class Solution {
    public int solution(int x, int y, int n) {
        
        // 결과 개수
        int answer = 0;
        
        // 결과 배열
        int result[] = new int[y+1];
        Arrays.fill(result,Integer.MAX_VALUE);
        
        // 초기 설정
        result[x] = 0;
        
        // 연산 수행
        for(int a=x; a<y+1; a++) {
            
            // 연산 배열
            int operation[] = {a+n,a*2,a*3};
            
            // 값이 존재할 경우
            if(result[a]!=Integer.MAX_VALUE) {
                
                // 연산 수행
                for(int b=0; b<3; b++) {
                    
                    // 범위 검사
                    int num = operation[b];
                    
                    // 범위를 넘을 경우
                    if(num>y) continue;
                    
                    // 결과 배열 갱신
                    result[num] = Math.min(result[num],result[a]+1);
                }
            }
        }
        
        // 결과 저장
        if(result[y]==Integer.MAX_VALUE) answer = -1;
        else answer = result[y];
        
        return answer;
    }
}