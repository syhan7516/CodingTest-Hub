class Solution {
    
    // 결과
    public static int answer;
    
    // 숫자 더하고, 빼기 메서드
    public static void solve(int count, int target, int[] numbers, int sum) {
        
        // 연산을 다한 경우
        if(count==numbers.length) {
            
            // 타겟이된 경우
            if(sum==target) 
                answer++;
            
            return;
        }
        
        // 더하기
        solve(count+1,target,numbers,sum+numbers[count]);
        
        // 빼기
        solve(count+1,target,numbers,sum-numbers[count]);
    }
    
    public int solution(int[] numbers, int target) {
        
        // 숫자 더하고, 빼기
        answer = 0;
        solve(0,target,numbers,0);
        return answer;
    }
}