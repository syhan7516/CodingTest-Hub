class Solution {
    
    // 이분 탐색 수행 메서드
    static long binarySearch(int times[], int n, long left, long right) {
        
        // 최솟값
        long result = Long.MAX_VALUE;
        
        while(left<=right) {
            
            // 중간 값 지정
            long mid = (left+right)/2;
            
            // 시간 확인
            long cnt = 0;
            
            for(int i=0; i<times.length; i++) {
                cnt += mid/times[i];
            }
            
            // 기준 값이 사람 수보다 크거나 같은 경우
            if(n<=cnt) {
                right = mid-1;
                result = Math.min(result,mid);
            }
            
            // 기준 값이 사람 수보다 작은 경우
            else left = mid+1;
        }
        
        return result;
    }
    
    public long solution(int n, int[] times) {
        
        // 이분 탐색 수행
        long answer = binarySearch(times,n,1,(long)1e9*(long)1e9);
        
        return answer;
    }
}