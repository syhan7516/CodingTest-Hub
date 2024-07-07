import java.util.*;

class Solution {
    public int solution(int[][] data, int col, int row_begin, int row_end) {
        
        // 정렬
        Arrays.sort(data, (a,b) -> b[0]-a[0]);
        Arrays.sort(data, (a,b) -> a[col-1]-b[col-1]);
                
        // 결과
        int answer = 0;
        
        // 해시 수행
        for(int i=row_begin; i<=row_end; i++) {
            
            // 행 연산 결과
            int calc = 0;
            
            // 행 연산 수행
            for(int j=0; j<data[i-1].length; j++) {
                calc += data[i-1][j]%i;
            }
            
            // 결과 반영
            answer = answer^calc;
        }
        
        return answer;
    }
}