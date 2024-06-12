class Solution {
    public int[] solution(int n, long left, long right) {
        
        // 인덱스 위치
        long check = left;
        int index = 0;
        
        // 결과 배열 크기
        int size = (int)(right-left)+1;
        
        // 결과
        int[] answer = new int[size];
        
        // 위치 숫자 확인
        while(true) {
            
            // 종료 조건
            if(check>right) break;
                
            // 인데스화
            int i = (int)(check/n);
            int j = (int)(check%n);
            
            // 둘의 숫자가 같은 경우
            if(i==j) 
                answer[index++] = i+1;

            // 둘의 숫자가 다른 경우
            else {
                answer[index++] = i<j ? j+1 : i+1;
            }
            
            check++;
        }
        
        return answer;
    }
}