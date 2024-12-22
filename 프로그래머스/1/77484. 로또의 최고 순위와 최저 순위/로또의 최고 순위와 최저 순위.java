class Solution {
    
    // 존재 여부 배열
    public static boolean isExist[];
    
    // 순위 배열
    public static int rank[] = {6,6,5,4,3,2,1};
    
    public int[] solution(int[] lottos, int[] win_nums) {
        
        // 존재 여부 배열 생성
        isExist = new boolean[46];
        
        // 0개수
        int zeroCount = 6;
        
        // 없는 숫자 개수
        int notExistCount = 0;
        
        // 맞은 개수
        int agreementCount = 0;
        
        // 찍은 숫자 확인
        for(int number=0; number<lottos.length; number++) {
            isExist[lottos[number]] = true;
            if(lottos[number]!=0) zeroCount--;
        }
        
        // 로또 확인
        for(int number=0; number<win_nums.length; number++) {
            
            // 맞은 경우
            if(isExist[win_nums[number]]) agreementCount++;
        }
        
        // 순위
        int maxRank = rank[agreementCount+zeroCount];
        int minRank = rank[agreementCount];

        return new int[]{maxRank,minRank};
    }
}