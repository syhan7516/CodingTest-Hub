class Solution {
    
    // 최대 수익
    public static int resMoney, resService;
    
    // 이모티콘 할인 배열
    public static int sale[];
    
    // 할인 비율 배열
    public static int rate[] = {10,20,30,40};
    
    // 이모티콘 할인 비율 설정 메서드
    static void solve(int cnt, int users[][], int emoticons[]) {
        
        // 할인 설정이 완료된 경우
        if(cnt==emoticons.length) {
            
            // 서비스 가입자 수, 판매 가격
            int service = 0;
            int price = 0;
            
            // 회원 확인
            for(int i=0; i<users.length; i++) {
                
                // 회원이 사용한 돈
                int money = 0;
                
                // 이모티콘 확인
                for(int j=0; j<emoticons.length; j++) {
                    
                    // 할인 비율이 적은 경우
                    if(users[i][0]>sale[j]) continue;
                    
                    // 할인 비율이 많은 경우
                    money += emoticons[j]-((emoticons[j]/100)*sale[j]);
                }
                
                // 만약 사용한 돈이 범위를 넘었을 경우
                if(users[i][1]<=money) service++;
                // 넘지 않았을 경우
                else price += money;
            }
            
            // 수익 갱신
            if(resService<service) {
                resService = service;
                resMoney = price;
            }
            
            else if(resService==service)
                resMoney = Math.max(resMoney,price);
            
            return;
        }
        
        
        for(int i=0; i<4; i++) {
            sale[cnt] = rate[i];
            solve(cnt+1,users,emoticons);
        }
            
    }
    
    
    public int[] solution(int[][] users, int[] emoticons) {
        
        // 이모티콘 할인 배열 생성
        sale = new int[emoticons.length];
        
        // 최대 수익 변수
        resMoney = 0;
        resService = 0;
        
        // 이모티콘 할인 비율 설정
        solve(0,users,emoticons);
        
        // 결과 저장
        int[] answer = {resService,resMoney};
        
        return answer;
    }
}