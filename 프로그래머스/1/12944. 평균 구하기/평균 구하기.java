class Solution {
    public double solution(int[] arr) {
        
        // 결과
        double answer = 0;
        
        // 배열 순회
        for(int number: arr)
            answer += number;
        
        // 평균 구하기
        answer /= arr.length;
        
        return answer;
    }
}