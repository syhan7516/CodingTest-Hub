import java.util.*;

class Solution {
    
    // 결과
    public static int answer;
    
    // 선택된 숫자 배열
    public static int selected[];
    
    // 방문 여부 배열
    public static boolean visited[];
    
    // 완성된 숫자 모음 셋
    public static HashSet<Integer> set;
    
    // 숫자 나열하기 메서드
    static void solve(String numbers, int idx, int cnt) {
        
        // 종료 조건
        if(idx==cnt) {
            
            // 숫자 확인
            StringBuilder sb = new StringBuilder();
            for(int i=0; i<selected.length; i++)
                sb.append(numbers.charAt(selected[i]));
            
            // 숫자 변환
            int number = Integer.parseInt(sb.toString());
            
            // 1이거나, 이미 만들었던 경우
            if(number==1 || number==0 || set.contains(number)) return;
            set.add(number);
            
            // 소수 확인
            for(int i=2; i<number; i++) {
                if(number%i==0) return;
            }
            
            answer++;
            return;
        }
        
        // 숫자가 덜 선택된 경우
        for(int i=0; i<numbers.length(); i++) {
            
            // 아직 선택이 안된 숫자인 경우
            if(!visited[i]) {
                selected[idx] = i;
                visited[i] = true;
                solve(numbers,idx+1,cnt);
                visited[i] = false;
            }
        }
    }
    
    public int solution(String numbers) {
            
        // 셋 생성
        set = new HashSet<>();
        
        // 숫자 나열하기
        answer = 0;
        for(int i=1; i<=numbers.length(); i++) {
            selected = new int[i];
            visited = new boolean[numbers.length()];
            solve(numbers,0,i);
        }

        return answer;
    }
}