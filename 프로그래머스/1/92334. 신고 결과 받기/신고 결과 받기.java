import java.util.*;

// 같은 사람이 같은 사람 -> 1번 처리

class Solution {
    public int[] solution(String[] id_list, String[] report, int k) {
        
        StringTokenizer st;
        
        // 신고 수신, 발신 정보 해시
        HashMap<String,Integer> map = new HashMap<>();
        
        // 신고한 사람 리스트 
        ArrayList<ArrayList<Integer>> list = new ArrayList<>();
        
        // 메일 수신 정보 배열
        int mail[] = new int[id_list.length];
        
        
        // 초기화
        for(int i=0; i<id_list.length; i++) {
            list.add(new ArrayList<>());
            map.put(id_list[i],i);
        }
        
        // 신고받은 횟수 배열
        int arr[] = new int[id_list.length];
        
        // 신고 정보 확인
        for(int i=0; i<report.length; i++) {
            
            // 신고 수신, 발신자 
            st = new StringTokenizer(report[i]);
            int from = map.get(st.nextToken());
            int to = map.get(st.nextToken());
            
            // 재신고 확인
            if(list.get(to).contains(from)) continue;
            
            // 수신자 : 발신자 추가
            list.get(to).add(from);
            
            // 수신자 : 신고 횟수 증가
            arr[to]++;
        }
        
        // 신고 횟수 확인
        for(int i=0; i<arr.length; i++) {
            
            // 신고 횟수가 기준 이상인 경우
            if(arr[i]>=k) {
                for(int user: list.get(i))
                    mail[user]++;
            }
        }
        
        // 결과
        int[] answer = mail;
    
        return answer;
    }
}