import java.util.*;

class Solution
{
    public int solution(int []A, int []B)
    {
        // 배열 정렬
        Arrays.sort(A);
        Arrays.sort(B);
        
        // 결과
        int answer = 0;
        
        // 배열 길이
        int arrLen = A.length;
        
        // 곱하기
        for(int idx=0; idx<arrLen; idx++) {
            answer += A[idx]*B[arrLen-idx-1];
        }
        
        return answer;
    }
}