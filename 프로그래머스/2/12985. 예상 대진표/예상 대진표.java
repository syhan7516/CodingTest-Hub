import java.util.*;

class Solution
{
    public int solution(int n, int a, int b)
    {
        // 결과
        int answer = 0;
        
        // 확인
        while(true) {
            
            // 종료 조건
            if(a==b) break;
            
            // 2로 나누기
            a = a%2==0? a/2 : (a+1)/2;
            b = b%2==0? b/2 : (b+1)/2;
            
            // 라운드 증가
            answer++;
        }
        
        return answer;
    }
}