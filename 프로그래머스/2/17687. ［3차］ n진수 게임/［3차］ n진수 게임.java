class Solution {
    public String solution(int n, int t, int m, int p) {

        // 문자열 저장
        StringBuilder sb = new StringBuilder();
        
        // 내가 말한 횟수
        int speakCnt = 0;
        
        // 현재 숫자
        int num = 0;
        
        // 턴 횟수
        int term = m*t;
        
        // 턴 만큼 진수 변환
        while(sb.length()<term) {
            
            // 진수 변환
            sb.append(Integer.toString(num,n).toUpperCase());
            
            // 숫자 증가
            num++;
        }
        
        // 현재 횟수
        int cnt = 0;
        String answer = "";
        while(cnt<t) {
            
            // 결과 저장
            answer += sb.charAt((m*cnt)+(p-1));
            
            // 턴 증가
            cnt++;
        }
        
        return answer;
    }
}