class Solution {
    public String solution(int n) {
        
        StringBuilder sb = new StringBuilder();

        // 주어진 숫자만큼 수행
        for(int count=1; count<=n; count++) {
            if(count%2==0) sb.append("박");
            else sb.append("수");
        }
            
        return sb.toString();
    }
}