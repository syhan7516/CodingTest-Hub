class Solution {
    public int solution(int[] bandage, int health, int[][] attacks) {
        
        // 결과
        int answer = health;
        
        // 이전 시간
        int time = 0;
        
        // 공격 시점 확인
        for(int t=0; t<attacks.length; t++) {
            
            // 시간 계산
            int timeDiff = attacks[t][0]-time-1;
            
            // 체력 회복
            answer += (timeDiff*bandage[1]);
            
            // 추가 회복
            if(timeDiff>=bandage[0])
                answer += (timeDiff/bandage[0]*bandage[2]);
            
            // 회복 체력이 최대를 넘어선 경우
            if(answer>health)
                answer = health;
            
            // 받은 피해 계산
            answer -= attacks[t][1];
            
            // 체력이 없는 경우
            if(answer<=0) {
                answer = -1;
                break;
            }
            
            // 시간 갱신
            time = attacks[t][0];
        }
        
        return answer;
    }
}