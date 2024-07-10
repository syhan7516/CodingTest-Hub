class Solution {
    
    // 수열 중 가장 큰 값 가져오기 메서드
    static int getMaxNumber(int[] sequence) {
        
        // 가장 큰 값
        int max = sequence[0];
        
        // 수열 확인
        for(int i=1; i<sequence.length; i++) {
            max = Math.max(max,sequence[i]);
        }
        
        return max;
    }
    
    // 최대 연속 부분 수열 합 구하기 메서드
    static long solve(int[] sequence, int calc[]) {
        
        // 누적합
        long prefix = 0;
        
        // 최댓값
        long max = 0;
        
        // 수열 확인
        for(int i=0; i<sequence.length; i++) {
            
            // 합
            prefix += (sequence[i]*calc[i]);
            
            // 음수가 되는 경우
            if(prefix<0) prefix = 0;
            
            // 아닌 경우
            else max = Math.max(max,prefix);
        }
        
        // 최대값이 0인 경우
        if(max==0) getMaxNumber(sequence);
        
        return max;
    }
    
    public long solution(int[] sequence) {
        
        // 결과
        long answer = 0;
        
        // 펄스 수열 생성
        int a[] = new int[sequence.length];
        int b[] = new int[sequence.length];
        
        // 펄수 수열 초기화
        a[0] = -1;
        b[0] = 1;
        for(int i=1; i<sequence.length; i++) {
            a[i] = a[i-1] * (-1);
            b[i] = b[i-1] * (-1);
        }
        
        // 최대 연속 부분 수열 합 구하기
        long first = solve(sequence,a);
        long second = solve(sequence,b);
        
        // 결과
        answer = Math.max(first,second);
        
        return answer;
    }
}