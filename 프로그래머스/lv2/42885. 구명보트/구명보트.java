import java.util.*;

class Solution {
    public int solution(int[] people, int limit) {
        
        // 결과
        int answer = 0;
        
        // 정렬
        Arrays.sort(people);
        
        // 초기화
        int idx = 0;
        
        // 몸무게 확인
        for (int p=people.length-1; p>=idx; p--) {
            
            // 큰 사람, 작은 사람 합이 보트에 탈 수 있는 경우
            if(people[p]+people[idx]<=limit) {
                idx++;
                answer++;
            }
            
            // 아닌 경우
            else {
                answer++;
            }
        }
        
        return answer;
    }
}