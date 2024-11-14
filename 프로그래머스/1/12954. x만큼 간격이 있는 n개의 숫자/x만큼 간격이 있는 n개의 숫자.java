class Solution {
    public long[] solution(int x, int n) {
        
        // 결과
        long[] answer = new long[n];
        
        // 배수 개수만큼 구하기
        for(int count=1; count<=n; count++)
            answer[count-1] = (long)x*count;
        
        return answer;
    }
}