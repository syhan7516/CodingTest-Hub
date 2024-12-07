class Solution {
    public int solution(int[] number) {
        
        // 결과
        int answer = 0;
        
        // 학생 순회
        for(int first=0; first<number.length-2; first++) {
            for(int second=first+1; second<number.length-1; second++) {
                for(int third=second+1; third<number.length; third++) {
                    
                    // 합
                    int sum = number[first]+number[second]+number[third];
                    
                    // 삼총사인 경우
                    if(sum==0) answer++;
                }
            }
        }
    
        return answer;
    }
}