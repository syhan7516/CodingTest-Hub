import java.util.*;

class Solution {
    public String[] solution(String[] players, String[] callings) {
        
        // 등수 정보 해시
        HashMap<String,Integer> maraton = new HashMap<>();
        
        // 등수 등록
        for(int p=0; p<players.length; p++) {
            maraton.put(players[p],p+1);
        }
        
        // 이름 부르기
        for(int c=0; c<callings.length; c++) {
            // 이름 가져오기
            String name = callings[c];
            // 해당 이름 순위
            int curNameRank = maraton.get(name);
            // 추월하기
            String swap = players[curNameRank-1];
            players[curNameRank-1] = players[curNameRank-2];
            players[curNameRank-2] = swap;
            // 순위 변경
            maraton.put(name,curNameRank-1);
            maraton.put(players[curNameRank-1],curNameRank);
        }
        
        // 결과 저장
        String[] answer = {};
        answer = players;
        
        return answer;
    }
}