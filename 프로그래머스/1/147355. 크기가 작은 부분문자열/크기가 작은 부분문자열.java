class Solution {
    public int solution(String t, String p) {
        
        // 결과
        int answer = 0;

        // 문자열 순회
        for(int index=0; index<=t.length()-p.length(); index++) {
            
            // 크기 비교
            if(t.substring(index,index+p.length()).compareTo(p)<=0)
                answer++;
            
        }
        
        return answer;
    }
}