class Solution {
    public int solution(int n, int[] money) {
        
        // DP 테이블 생성
        int DP[] = new int[n+1];

        // 초기 설정
        DP[0] = 1;

        // 동전 종류 만큼 순회
        for(int i=0; i<money.length; i++) {

            // 1 ~ 목표 금액까지 확인
            for(int j=1; j<=n; j++) {

                // 동전보다 작은 경우
                if(j-money[i]<0) continue;

                /// 연산 숫자보다 클 경우
                DP[j] += DP[j-money[i]];
            }
        }
        
        // 결과
        int answer = DP[n];
        
        return answer;
    }
}