class Solution {
    public int[] solution(int brown, int yellow) {
        
        // 결과
        int[] answer = new int[2];
        
        // 총 카펫 수
        int total = brown + yellow;
        
        // 약수 구하기
        for (int a=3; a<total; a++) {
            
            int b = total/a;
            
            // 약수이면서 3이상 
            if (total%a==0 && b>=3) {
                
                // 가로, 세로, 중간
                int row = Math.min(a,b);
                int col = Math.max(a,b);
                int center = (col - 2) * (row - 2);
                
                if (center == yellow) {
                    answer[0] = col;
                    answer[1] = row;
                    return answer;
                }
            }
        }
        
        return answer;
    }
}