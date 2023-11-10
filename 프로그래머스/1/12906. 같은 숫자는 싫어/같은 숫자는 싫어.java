import java.util.*;

public class Solution {
    
    // 결과 리스트
    public static ArrayList<Integer> result;
    
    public int[] solution(int []arr) {
        
        // 결과 리스트 생성
        result = new ArrayList<>();
        
        // 배열 확인
        int curNum = arr[0]; 
        result.add(curNum);
        
        for(int i=1; i<arr.length; i++) {
            
            // 같은 숫자가 아닌 경우
            if(curNum!=arr[i]) {
                result.add(arr[i]);
                curNum = arr[i];
            }
        }
        
        // 결과 배열 생성
        int[] answer = new int[result.size()];
    
        // 결과 저장
        for(int i=0; i<result.size(); i++)
            answer[i] = result.get(i);

        return answer;
    }
}