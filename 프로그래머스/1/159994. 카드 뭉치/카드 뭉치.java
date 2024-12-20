class Solution {
    
    // 단어 존재 여부 확인 메서드
    public static boolean isExist(String letter, String[] cards, int index) {
        
        // 범위를 넘어선 경우
        if(index>=cards.length)
            return false;
        
        // 일치하는 경우
        if(letter.equals(cards[index]))
            return true;
        
        // 아닌 경우
        return false;
    }
    
    public String solution(String[] cards1, String[] cards2, String[] goal) {
        
        // 단어 확인 위치
        int aIndex = 0;
        int bIndex = 0;
        
        // 찾을 단어 순회
        for(int index=0; index<goal.length; index++) {
            
            // 카드 뭉치1 확인
            if(isExist(goal[index],cards1,aIndex)) {
                aIndex++;
                continue;
            }
            
            // 카드 뭉치2 확인
            if(isExist(goal[index],cards2,bIndex)) {
                bIndex++;
                continue;
            }
            
            return "No";
        }
        
        return "Yes";
    }
}