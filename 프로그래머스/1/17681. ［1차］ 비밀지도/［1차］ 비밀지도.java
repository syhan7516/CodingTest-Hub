class Solution {
    
    public String[] solution(int n, int[] arr1, int[] arr2) {
        
        // 결과
        String[] answer = new String[n];
        
        // 배열 확인
        for(int i=0; i<n; i++) {
            
            // or 연산 후 진수 변환
            String transNum = Long.toString(arr1[i]|arr2[i],2);
            
            // 길이가 짧았을 경우
            if(transNum.length()!=n) {
                int size = n-transNum.length();
                for(int k=0; k<size; k++)
                    transNum = "0"+transNum;
            }
            
            // 변환 문자열
            String t = "";
            
            // 문자열 변환
            for(int j=0; j<transNum.length(); j++) {
                
                if(transNum.charAt(j)=='1')
                    t += '#';
                
                else t += " ";
            }
            
            // 행 저장
            answer[i] = t;
        }
        
        // 결과 반환
        return answer;
    }
}