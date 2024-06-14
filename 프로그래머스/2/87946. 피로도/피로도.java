class Solution {
    
    // 결과
    public static int answer;
    
    // 던전 탐험 순서 배열
    public static int order[];
    
    // 던전 탐험 순서 선택 여부 배열
    public static boolean visited[];
    
    // 던전 탐험 순서 정하기 메서드
    static void solve(int idx, int[][] dungeons, int k) {
        
        // 다 정한 경우
        if(idx==order.length) {
            
            // 조건 피로도
            int tired = k;
            
            // 던전 클리어 횟수
            int clear = 0;
            
            // 던전 탐험 수행
            for(int i=0; i<order.length; i++) {
                
                // 피로도 조건이 맞지 않는 경우
                if(tired<dungeons[order[i]][0]) {
                    answer = Math.max(answer,clear);
                    return;
                }
                
                // 피로도 조건이 맞는 경우
                tired -= dungeons[order[i]][1];
                clear++;
            }
            
            // 최대 값 갱신
            answer = Math.max(answer,clear);
            
            return;
        }
        
        // 덜 정한 경우
        for(int i=0; i<order.length; i++) {
            
            // 미방문 던전인 경우
            if(!visited[i]) {
                order[idx] = i;
                visited[i] = true;
                solve(idx+1,dungeons,k);
                visited[i] = false;
            }
        }
    }
    
    public int solution(int k, int[][] dungeons) {
        
        // 던전 탐험 순서 배열 생성
        order = new int[dungeons.length];
        
        // 던전 탐험 순서 선택 여부 배열 생성
        visited = new boolean[dungeons.length];
        
        // 던전 탐험 순서 정하기
        answer = 0;
        solve(0,dungeons,k);
        
        return answer;
    }
}