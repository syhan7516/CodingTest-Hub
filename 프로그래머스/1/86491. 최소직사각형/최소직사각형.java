class Solution {
    public int solution(int[][] sizes) {
        
        // 이전 가로, 세로 크기
        int prevMax = 0;
        int prevMin = 0;

        // 다른 명함 확인
        for (int i=0; i<sizes.length; i++) {
            int curMax = Math.max(sizes[i][0], sizes[i][1]);
            int curMin = Math.min(sizes[i][0], sizes[i][1]);

            prevMax = Math.max(curMax, prevMax);
            prevMin = Math.max(curMin, prevMin);
        }

        // 결과
        int answer = prevMax * prevMin;
        
        return answer;
    }
}