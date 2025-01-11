import java.util.*;

class Solution {
    
    // 수열 합 저장 셋
    public static HashSet<Integer> sums;
    
    // 수열 합 구하기 메서드
    public static void solve(int size, int []elements) {
        
        // 합
        int sum = 0;
        
        // 더하기 위치 
        int point = size-1;
        
        // 시작 값 설정
        for(int index=0; index<size; index++)
            sum += elements[index];
        sums.add(sum);
        
        // 나머지 합 구하기
        for(int index=0; index<elements.length; index++) {
            
            // 가장 앞 숫자 제거
            sum -= elements[index];
            
            // 더할 숫자 위치 및 범위 조정
            point++;
            point = point==elements.length ? point-=elements.length : point;
            
            // 수열 합 갱신
            sum += elements[point];
            
            // 결과 추가
            sums.add(sum);
        }
    }
    
    public int solution(int[] elements) {
        
        // 수열 합 저장 셋 생성
        sums = new HashSet<>();
        
        // 크기 만큼 합 구하기
        for(int size=1; size<=elements.length; size++) 
            solve(size,elements);
        
        return sums.size();
    }
}