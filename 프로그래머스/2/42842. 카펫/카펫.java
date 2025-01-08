class Solution {
    public int[] solution(int brown, int yellow) {
        
        // 결과
        int answer[] = new int[2];
        
        // 노란색 칸 크기 확인
        for(int index=1; index*index<=yellow; index++) {
            
            // 크기 조정이 가능한 경우
            if(yellow%index==0) {
                
                // 가로, 세로 크기
                int row = index;
                int col = yellow/index;
                
                // 개수 확인
                int count = (col+2)*2+(row*2)+yellow; 
                
                // 개수가 일치하는 경우
                if(count==brown+yellow) {
                    answer[0] = col+2;
                    answer[1] = row+2;
                }
            }
        }
        
        return answer;
    }
}