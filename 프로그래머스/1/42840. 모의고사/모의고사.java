import java.util.*;

class Solution {
    public int[] solution(int[] answers) {
        
        // 1번
        int one[] = {1,2,3,4,5};
        // 2번
        int two[] = {2,1,2,3,2,4,2,5};
        // 3번
        int three[] = {3,3,1,1,2,2,4,4,5,5};
        
        // 정답 수
        int aOne = 0;
        int aTwo = 0;
        int aThree = 0; 

        // 결과
        ArrayList<Integer> res = new ArrayList<>();
        
        // 채점
        for(int i=0; i<answers.length; i++) {
            if(one[i%5]==answers[i]) aOne++;
            if(two[i%8]==answers[i]) aTwo++;
            if(three[i%10]==answers[i]) aThree++;
        }
        
        // 가장 높은 점수 확인
        int best = Math.max(Math.max(aOne,aTwo),aThree);
        
        // 세 명 점수 확인
        if(aOne==best) res.add(1);
        if(aTwo==best) res.add(2);
        if(aThree==best) res.add(3);
        
        // 결과 저장
        int[] answer = new int[res.size()];
        for(int i=0; i<res.size(); i++)
            answer[i] = res.get(i);
        
        return answer;
    }
}