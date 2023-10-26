class Solution {
    
    // 결과
    public static int result, answer;
    
    // 찾은 여부
    public static boolean flag;
    
    // 문자 종류
    public static char[] kinds = {'A','E','I','O','U'};
    
    // 사전 확인 메서드
    static void solve(int cnt, String voca, String word) {
        
        // 범위를 넘은 경우
        if(cnt>5) {
            result--;
            return;
        }
        
        // 종료 조건
        if(voca.equals(word)) {
            answer = result;
            return;
        }
        
        // 사전 확인
        for(int i=0; i<5; i++) {
            result++;
            solve(cnt+1,voca+kinds[i],word);
        }
    }
    
    public int solution(String word) {
    
        // 순번, 결과
        result = 0;
        answer = 0;
        
        // 사전 확인
        solve(0,"",word);
        
        return answer;
    }
}