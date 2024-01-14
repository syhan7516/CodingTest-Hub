import java.util.*;

class Solution {
    
    // 결과, 행, 열
    public static int answer, rowCnt, colCnt;
    
    // 후보키 선택 여부 배열
    public static boolean[] visited;
    
    // 후보키 리스트
    public static ArrayList<String> candidate;
    
    // 후보키 구하기 메서드
    static void solve(int idx, int cnt, int range, String[][] relation) {
        
        // 다 선택한 경우
        if(cnt==range) {
            
            // 선택된 컬럼 리스트
            ArrayList<Integer> columns = new ArrayList<>();
            
            // 생성 키
            String key = "";
            
            // 컬럼 확인
            for(int i=0; i<visited.length; i++) {
                
                // 선택된 경우
                if(visited[i]) {
                    key += String.valueOf(i);
                    columns.add(i);
                }
            }
            
            // 선택된 컬럼 기준 데이터 정보 해시
            Map<String, Boolean> keyStr = new HashMap<>();
            
            // DB 확인
            for (int i=0; i<rowCnt; i++) {
                
                // 선택된 컬럼 기준으로 데이터 합치기
                String data = "";
                for(int number : columns) {
                    data += relation[i][number];
                }

                // 합친 데이터가 이미 존재하는 경우
                if (keyStr.containsKey(data)) return;
                
                // 없는 경우
                else keyStr.put(data, true);
            }
            
            // 후보키 추가
            for (String checkStr : candidate) {
                
                // 포함 개수
                int inCludeCnt = 0;
                for(int i=0; i<key.length(); i++){
                    String colNum = key.charAt(i)+"";
                    if(checkStr.contains(colNum)) inCludeCnt++;
                }
                
                // 다 포함된 경우
                if (inCludeCnt==checkStr.length()) return;
            }
            
            candidate.add(key);

            return;
        }
        
        for (int i=idx; i<visited.length; i++) {
            
            // 이미 선택된 경우
            if (visited[i]) continue;

            // 아닌 경우
            visited[i] = true;
            solve(i, cnt+1, range, relation);
            visited[i] = false;
        }
    }

    public int solution(String[][] relation) {
        
        // 결과
        answer = 0;
        
        // 후보키 리스트 생성
        candidate = new ArrayList<>();
        
        // 행, 열 수 입력
        rowCnt = relation.length;
        colCnt = relation[0].length;

        // 후보키 구하기
        for (int i=0; i<colCnt; i++) {
            visited = new boolean[colCnt];
            solve(0, 0, i+1, relation);
        }
        
        // 결과 저장
        answer = candidate.size();
        
        return answer;
    }
}