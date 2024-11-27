class Solution {
    public int solution(int[] a, int[] b) {
        
        // 결과
        int answer = 0;
        
        // 내적 구하기
        for(int index=0; index<a.length; index++)
            answer += a[index]*b[index];
        
        return answer;
    }
}