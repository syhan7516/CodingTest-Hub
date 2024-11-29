class Solution {
    public long solution(int price, int money, int count) {
        
        // 요금 구하기
        long answer = 0;
        
        for(int num=1; num<=count; num++)
            answer += price*num;
        
        // 결과
        answer = answer<=money ? 0 : answer-money;

        return answer;
    }
}