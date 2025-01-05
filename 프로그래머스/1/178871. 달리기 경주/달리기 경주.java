import java.util.*;

class Solution {    
    
    // 추월 메서드
    public static String swap(String[] players, int rank) {
        
        String mock = players[rank-1];
        players[rank-1] = players[rank];
        players[rank] = mock;
        return players[rank];
    }
    
    public String[] solution(String[] players, String[] callings) {
        
        // 순위 저장 해시 생성
        HashMap<String,Integer> map = new HashMap<>();
        
        // 순위 정보 입력
        for(int index=0; index<players.length; index++) {
            map.put(players[index],index);
        }
        
        // 추월 정보 확인
        for(int index=0; index<callings.length; index++) {
            
            String name = callings[index];
            int rank = map.get(name);
            
            // 추월
            String target = swap(players,rank);
            
            // 순위 정보 갱신
            map.put(name,map.get(name)-1);
            map.put(target,map.get(target)+1);
        }
        
        return players;
    }
}