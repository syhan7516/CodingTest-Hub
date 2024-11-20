class Solution {
    public long solution(int a, int b) {
        
        // 결과
        long answer = 0;
        
        // 큰 수 확인
        if(a>b) {
            int mock = a;
            a = b;
            b = mock;
        }
        
        // 사이 수 더하기
        for(int number=a; number<=b; number++)
            answer += number;
        
        return answer;
    }
}