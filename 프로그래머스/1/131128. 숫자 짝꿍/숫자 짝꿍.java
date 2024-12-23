import java.util.*;

class Solution {
    
    // 가장 큰 정수 판단 메서드
    public static String solve(ArrayList<Integer> pair) {
        
        StringBuilder sb = new StringBuilder();
        
        // 짝꿍이 없는 경우
        if(pair.size()==0)
            return sb.append(-1).toString();
        
        // 존재하는 경우
        for(int number: pair)
            sb.append(number);
        return sb.charAt(0)=='0' ? "0" : sb.toString();
    }
    
    public String solution(String X, String Y) {
        
        // 숫자 존재 여부 배열 생성
        int count[] = new int[10];
        
        // 짝궁 리스트 생성
        ArrayList<Integer> pair = new ArrayList<>();
        
        // X 확인
        for(int index=0; index<X.length(); index++) {
            
            // 수
            int number = X.charAt(index)-'0';
            
            // 개수 갱신
            count[number]++;
        }
        
        // Y 확인
        for(int index=0; index<Y.length(); index++) {
            
            // 수
            int number = Y.charAt(index)-'0';
            
            // 개수 확인
            if(count[number]>0) {
                count[number]--;
                pair.add(number);
            }
        }
        
        // 내림차순으로 정렬
        Collections.sort(pair,Collections.reverseOrder());
        
        return solve(pair);
    }
}