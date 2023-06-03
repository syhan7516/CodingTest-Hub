import java.util.*;

class Solution {
    public long solution(int[] weights) {
    
        // 결과 변수
        long answer = 0;
        
        // 무게 정렬
        Arrays.sort(weights);
        
        // 각 무게 해시 저장
        HashMap<Double,Integer> pair = new HashMap<>();
        
        // 연산
        for(int w: weights) {
            double resWeights[] = {w*1.0,(w*2.0)/3.0,(w*1.0)/2.0,(w*3.0)/4.0};
            
            // 연산 결과 확인
            for(int resWeight=0; resWeight<4; resWeight++) {
                
                // 결과가 존재할 경우
                if(pair.containsKey(resWeights[resWeight])) {
                    answer += pair.get(resWeights[resWeight]);
                }
            }
            
            // 갱신
            pair.put((w*1.0), pair.getOrDefault((w*1.0),0)+1);
        }
        
        return answer;
    }
}