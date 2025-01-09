class Solution {
    
    // 최소공배수 구하기 메서드
    public static int getGCB(int a, int b) {
        
        // 큰 수, 작은 수 설정
        if(a<b) {
            int mock = a;
            a = b;
            b = mock;
        }
        
        // 작은 값이 0인 경우
        if(b==0) return a;
        
        // 최대공약수 구하기
        return getGCB(b,a%b);
    }
    
    public int solution(int[] arr) {
        
        // 초기 값
        int current = 1;
        
        // 두 수씩 최대공약수 구한 후 최소공배수 구하기
        for(int index=0; index<arr.length; index++) {
            int gcb = getGCB(current,arr[index]);
            current = current*arr[index]/gcb;
        }
        
        return current;
    }
}