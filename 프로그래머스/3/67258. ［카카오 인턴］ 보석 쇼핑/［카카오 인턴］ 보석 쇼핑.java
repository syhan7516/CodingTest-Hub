import java.util.*;

class Solution {
    public int[] solution(String[] gems) {
        
        // 결과
        int answer[] = new int[2];
        
        // 보석 종류 집합
        HashSet<String> gemsSet = new HashSet<>();
        
        // 보석 열람 정보 맵
        HashMap<String, Integer> gemsMap = new HashMap<>();

        // 차례로 집합에 저장
        for (String s : gems) {
            gemsSet.add(s);
        }
        
        // 총 보석 개수
        int n = gems.length;
        
        // 길이 초기화
        int distance = Integer.MAX_VALUE;
        
        // 초기 범위 설정
        int left = 0;
        int right = 0;
        int start = 0;
        int end = 0;

        // 보석 확인
        while (true) {

            // 보석의 종류가 다 모인 경우
            if (gemsSet.size() == gemsMap.size()) {
                
                // 가장 앞 보석 빼기
                gemsMap.put(gems[left], gemsMap.get(gems[left])-1);

                // 보석의 개수가 0일 경우
                if (gemsMap.get(gems[left]) == 0) {
                    gemsMap.remove(gems[left]);
                }
                
                // 진열대 왼쪽 위치 갱신
                left++;
            } 
            
            // 모든 보석을 다 확인한 경우
            else if (right==n) break;
            
            // 다른 보석 더 확인
            else {
                
                // 다른 보석 정보 갱신
                gemsMap.put(gems[right], gemsMap.getOrDefault(gems[right], 0) + 1);
                right++;
            }

            // 보석의 종류가 다 모였을 경우
            if (gemsMap.size() == gemsSet.size()) {
                // 진열대 사이 거리 보석 개수 파악 후 갱신
                if (right-left < distance){
                    distance = right-left;
                    start = left+1;
                    end = right;
                }
            }

        }

        // 결과 저장
        answer[0] = start;
        answer[1] = end;

        return answer;
    }
}