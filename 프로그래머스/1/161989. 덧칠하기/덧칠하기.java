class Solution {
    public int solution(int n, int m, int[] section) {
        
        // 결과
        int answer = 0;
        
        // 벽 배열 생성
        boolean wall[] = new boolean[200001];
        
        // 섹션 확인
        for(int index=0; index<section.length; index++) {
            
            // 구역
            int area = section[index];
            
            // 칠해지지 않은 경우
            if(!wall[area]) {
                int target = area+m;
                for(int draw=area; draw<target; draw++)
                    wall[draw] = true;
                
                answer++;
            }
        }
        
        return answer;
    }
}