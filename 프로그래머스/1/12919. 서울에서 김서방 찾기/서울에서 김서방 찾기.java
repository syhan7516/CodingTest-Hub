class Solution {
    public String solution(String[] seoul) {
        
        // 위치
        int point = -1;
        
        // Kim 찾기
        for(int letter=0; letter<seoul.length; letter++) {
            if(seoul[letter].equals("Kim")) {
                point = letter;
                break;
            }
        }
        
       // 결과
        String answer = "김서방은 " + point + "에 있다";
        
        return answer;
    }
}