class Solution {
    
    // 영단어 정보 배열
    String engToNum[] = {"zero","one","two","three","four","five","six","seven","eight","nine"};
    
    public int solution(String s) {
        int answer = 0;
        
        for(int e=0; e<10; e++) {
            // 영어가 포함되는 경우
            if(s.contains(engToNum[e])) {
                s = s.replaceAll(engToNum[e],String.valueOf(e));
            }
        }
        
        // 결과 저장
        answer = Integer.parseInt(s);
        
        return answer;
    }
}