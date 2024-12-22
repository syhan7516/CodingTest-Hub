import java.util.*;

class Solution {
    
    // 정답 개수
    public static int maxCount, firstIndex, secondIndex, thirdIndex;
    
    // 제출 배열
    public static int orms[][] = {{1,2,3,4,5},
                                 {2,1,2,3,2,4,2,5},
                                 {3,3,1,1,2,2,4,4,5,5}};
    
    // 정답 개수 배열
    public static int answerCount[];
    
    // 답 확인 메서드
    public static boolean isSolve(int order, int index, int answer) {
        
        // 수포자 답
        int point = index>=orms[order].length ? index%orms[order].length : index;
        
        // 답 확인
        if(orms[order][point]==answer)
            return true;
        
        return false;
    }
    
    public int[] solution(int[] answers) {
        

        // 정답 개수 배열 생성
        answerCount = new int[3];
        
        // 답 확인
        for(int index=0; index<answers.length; index++) {
            for(int orm=0; orm<orms.length; orm++) {
                if(isSolve(orm,index,answers[index])) {
                    answerCount[orm]++;
                    maxCount = Math.max(maxCount,answerCount[orm]);
                }
            }
        }
        
        // 확인
        ArrayList<Integer> saram = new ArrayList<>();
        for(int index=0; index<answerCount.length; index++) {            
            if(answerCount[index]==maxCount)
                saram.add(index+1);
        }
                
        // 결과
        int[] answer = new int[saram.size()];
        for(int index=0; index<answer.length; index++)
            answer[index] = saram.get(index);
        return answer;
    }
}