class Solution {
    public int solution(int[] numbers) {
        
        // 결과
        int answer = 0;
        
        // 숫자 존재 배열 생성
        boolean isExist[] = new boolean[10];
        
        // 숫자 존재 파악
        for(int number: numbers)
            isExist[number] = true;
        
        // 없는 숫자 확인
        for(int number=0; number<10; number++) {
            if(!isExist[number]) answer += number; 
        }
        
        return answer;
    }
}