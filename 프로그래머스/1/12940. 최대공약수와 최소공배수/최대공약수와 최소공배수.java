class Solution {
    
    // 최소공배수 구하기 메서드
    public static int getGCB(int a, int b) {
        
        // 나눈 나머지가 0인 경우
        if(b==0) return a;
        
        return getGCB(b,a%b);
    }
    
    
    public int[] solution(int n, int m) {
        
        // 큰 수 확인
        if(n<m) {
            int mock = n;
            n = m ;
            m = mock;
        }
        
        // 결과 구하기
        int min = getGCB(n,m);
        int max = n*m/min;        
        
        return new int[] {min,max};
    }
}