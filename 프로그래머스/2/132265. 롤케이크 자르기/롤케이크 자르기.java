import java.util.*;

class Solution {
    
    // 결과
    public static int answer;
    
    // 개수 배열
    public static int[] right;
    
    // 종류 셋
    public static HashSet<Integer> leftSet, rightSet;
    
    // 동일 여부 확인 메서드
    public static void isEquals() {
        answer = leftSet.size()==rightSet.size() ? answer+1 : answer;
    }
    
    // 초기 설정 메서드
    public static void init(int[] topping) {
        
        // 왼쪽
        leftSet.add(topping[0]);
        
        // 오른쪽
        for(int index=1; index<topping.length; index++) {
            right[topping[index]]++;
            rightSet.add(topping[index]);
        }
        
        // 종류 개수 확인
        isEquals();
    }
    
    // 종류 개수 확인 메서드
    public static void isZero(int kind) {
        if(right[kind]==0) rightSet.remove(kind);
    }
    
    // 케이크 자르기 메서드
    public static void solve(int[] topping) {
        
        // 자르는 위치
        int point = 1;
        
        // 토핑 확인
        while(point<topping.length) {
            
            // 왼쪽 토핑 추가
            int kind = topping[point];
            leftSet.add(kind);
            
            // 오른쪽 토핑 제거
            right[kind]--;
            isZero(kind);
            
            // 양쪽 토핑 개수 확인
            isEquals();
            
            // 위치 이동
            point++;
        }
    }
    
    public int solution(int[] topping) {
        
        // 결과
        answer = 0;
        
        // 배열 생성
        right = new int[1000001];
        
        // 종류 셋 생성
        leftSet = new HashSet<>();
        rightSet = new HashSet<>();
        
        // 시작 설정
        init(topping);
        
        // 케이크 자르기
        solve(topping);
        
        return answer;
    }
}