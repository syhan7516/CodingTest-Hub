class Solution {
    public String solution(String s) {
        
        // 결과
        String answer = "";
    	
    	// 공백 기준 배열화
    	String letters[] = s.split(" ");
    	
        // 각 문자열 처리
    	for(int l=0; l<letters.length; l++) {
    		String letter = letters[l];
    		
    		// 공백인 경우
    		if(letters[l].length()==0) {
    			answer += " ";
    		} 
            
    		// 아닌 경우
    		else {
    			
                // 첫 문자 대문자 변경
    			answer += letter.substring(0, 1).toUpperCase();
    			
                // 나머지 문자 소문자 변경
    			answer += letter.substring(1, letter.length()).toLowerCase();
    			
                // 공백 추가
    			answer += " ";
    		}
    		
    	}
    	
    	// 마지막이 공백인 경우
    	if(s.substring(s.length()-1, s.length()).equals(" ")) {
    		return answer;
    	}
    	
    	// 아닌 경우
        else {
            answer = answer.substring(0, answer.length()-1);
            return answer;
        }
    }
}