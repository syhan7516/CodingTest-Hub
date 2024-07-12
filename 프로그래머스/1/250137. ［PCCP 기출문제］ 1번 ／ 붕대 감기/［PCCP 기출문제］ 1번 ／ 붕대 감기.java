class Solution {
    
    // 회복 시작 시간, 결과
    public static int answer, start;
    
    // 전사 여부
    public static boolean flag;
    
    // 몬스터 공격 시도 메서드
    static void solve(int[] bandage, int health, int[] attack) {
        
        // 회복 지속 시간
        int healTime = attack[0]-start-1;
        
        // 추가 회복 수
        int term = healTime/bandage[0];
        
        // 총 회복량
        int heal = healTime*bandage[1] + term*bandage[2];
        
        // 체력에 반영
        answer = (answer+heal)<health ? answer+heal : health;
        
        // 몬스터 공격 반영
        if((answer-attack[1])<=0) {
            answer = -1;
            flag = true;
            return;
        }
        answer -= attack[1];
        
        // 회복 시작 시간 갱신
        start = attack[0];
    }
    
    public int solution(int[] bandage, int health, int[][] attacks) {
        
        // 결과
        answer = health;
        
        // 회복 시작 시간
        start = 0;
        
        // 전사 여부
        flag = false;
        
        // 몬스터 공격 순회
        for(int i=0; i<attacks.length; i++) {
            
            // 몬스터 공격 시도
            solve(bandage,health,attacks[i]);
            
            // 전사한 경우
            if(flag) break;
        }
        
        return answer;
    }
}