class Solution {
    public String solution(int[] food) {
        
        StringBuilder sb = new StringBuilder();
        
        // 음식 순회
        for(int index=1; index<food.length; index++) {
            
            // 배치 개수
            int count = food[index]/2;
            
            // 배치
            for(int f=0; f<count; f++)
                sb.append(index);
        }
        
        // 물 놓기
        sb.append(0);
        
        // 음식 순회
        for(int index=food.length-1; index>=0; index--) {
            
            // 배치 개수
            int count = food[index]/2;
            
            // 배치
            for(int f=0; f<count; f++)
                sb.append(index);
        }
        
        return sb.toString();
    }
}