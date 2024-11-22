class Solution {
    public int solution(int[] absolutes, boolean[] signs) {
        
        // 결과
        int answer = 0;
        
        // 숫자 확인
        for(int index=0; index<absolutes.length; index++) {
            answer = signs[index] ? answer+absolutes[index] : answer-absolutes[index];
        }
        
        return answer;
    }
}