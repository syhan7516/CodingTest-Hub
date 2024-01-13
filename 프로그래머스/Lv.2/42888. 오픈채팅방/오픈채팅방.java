import java.util.*;

class Solution {
    public String[] solution(String[] record) {
        
        StringTokenizer st;
        
        // 아이디, 닉네임 저장 해시
        HashMap<String, String> user = new HashMap<>();
        
        // 입, 출 횟수
        int cnt = 0;
        
        // 레코드 확인
        for(int i=0; i<record.length; i++) {
            
            st = new StringTokenizer(record[i]);
            
            String s = st.nextToken();
            String id = st.nextToken();
            
            // 입장
            if(s.equals("Enter")) {
                user.put(id,st.nextToken());
                cnt++;
            }
            
            // 변경
            else if(s.equals("Change")) {
                user.put(id,st.nextToken());
            }
            
            // 퇴장
            else cnt++;
        }
        
        // 결과
        int idx = 0;
        String[] answer = new String[cnt];
        
        for(int i=0; i<record.length; i++) {
            
            st = new StringTokenizer(record[i]);
            
            String s = st.nextToken();
            String id = st.nextToken();
            
            // 닉네임을 변경한 경우
            if(s.equals("Change")) continue;
            
            // 들어온 경우
            if(s.equals("Enter")) {
                answer[idx] = user.get(id)+"님이 들어왔습니다.";
            }
            
            // 나간 경우
            else {
                answer[idx] = user.get(id)+"님이 나갔습니다.";
            }
            
            idx++;
        }
        
        
        return answer;
    }
}