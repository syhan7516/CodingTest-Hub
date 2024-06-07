import java.util.*;

class Solution
{
    public int solution(int []A, int []B)
    {
        // 결과
        int answer = 0;

        // 배열 정렬
        Arrays.sort(A);
        Arrays.sort(B);
        
        // 수 곱하기
        for(int i=0; i<A.length; i++) {
            
            // 곱 결과 누적하기
            answer += A[i] * B[B.length-i-1];
        }
        
        return answer;
    }
}