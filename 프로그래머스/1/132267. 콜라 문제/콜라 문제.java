class Solution {
    public int solution(int a, int b, int n) {
        
        // 결과
        int answer = 0;
        
        while(a<=n) {
            
            // 남은 병수
            int emptyCount = n%a;
            
            // 얻은 병수
            int changeCount = n/a*b;
            answer += changeCount;
            
            // 교환 후 빈 병수
            emptyCount += changeCount;
            n = emptyCount;
        }
        
        return answer;
    }
}