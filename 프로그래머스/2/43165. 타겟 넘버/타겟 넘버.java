class Solution {
    
    // 결과
    public static int answer;
    
    // 완전 탐색
    static void solve(int numbers[], int target, int idx, int sum) {

        // 연산을 다한 경우
        if(idx==numbers.length) {
            
            // 원하는 값과 동일한 경우
            if(sum==target)
                answer++;
            
            return;
        }
        
        // 연산을 덜한 경우
        solve(numbers,target,idx+1,sum+numbers[idx]);
        solve(numbers,target,idx+1,sum-numbers[idx]);
        
    }
    
    public int solution(int[] numbers, int target) {
        
        // 결과
        answer = 0;
        
        // 완전 탐색 수행
        solve(numbers,target,0,0);
        
        return answer;
    }
}