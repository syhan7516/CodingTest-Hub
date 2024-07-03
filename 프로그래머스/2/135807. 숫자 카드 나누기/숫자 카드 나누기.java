class Solution {
    
    // 최소공배수 구하기 메서드
    static int gcd(int a, int b) {
        
        // 작은 수 찾기
        if(a>b) {
            int tmp = a;
            a = b;
            b = tmp;
        }
        
        // 종료 조건
        if(b%a==0) return a;
        
        return gcd(a,b%a);
    }

    // 순회하며 확인하기 메서드
    static boolean check(int nums[], int gcd) {
        
        // 나눌 수 있는지 확인
        for(int i=0; i<nums.length; i++) {
            if(nums[i]%gcd==0) return false;
        }
        
        return true;
    }    
    
    public int solution(int[] arrayA, int[] arrayB) {
        
        // A 최소공배수 구하기
        int aGcd = arrayA[0];
        for(int i=0; i<arrayA.length; i++) {
            aGcd = gcd(aGcd,arrayA[i]);
        }
        
        // B 최소공배수 구하기
        int bGcd = arrayB[0];
        for(int i=0; i<arrayB.length; i++) {
            bGcd = gcd(bGcd,arrayB[i]);
        }
        
        // 결과
        int answer = 0;
        
        // 순회하면서 확인하기
        if(check(arrayA,bGcd)) answer = Math.max(answer,bGcd);
        if(check(arrayB,aGcd)) answer = Math.max(answer,aGcd);
        
        return answer;
    }
}