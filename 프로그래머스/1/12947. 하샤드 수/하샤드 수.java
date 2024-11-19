class Solution {
    public boolean solution(int x) {
        
        // 초기 설정
        int number = x;
        int sum = 0;
        
        // 각 자리 수 더하기
        while(true) {
            sum += number%10;
            number/=10;
            if(number==0) break;
        }
        
        // 하샤드 판단
        boolean answer = x%sum==0 ? true : false;
        return answer;
    }
}