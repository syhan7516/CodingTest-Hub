import java.util.*;

class Solution {
    
    // 이름 저장 집합 배열
    public static HashSet<String>[] set;
    
    // 인덱스 저장 해시
    public static HashMap<String,Integer> map;
    
    public int[] solution(String[] id_list, String[] report, int k) {
        
        StringTokenizer st;
        
        // 결과
        int answer[] = new int[id_list.length];
        
        // 이름 저장 집합 배열 생성
        set = new HashSet[id_list.length];
        for(int index=0; index<id_list.length; index++)
            set[index] = new HashSet<>();
        
        // 인덱스 저장 해시 생성
        map = new HashMap<>();
        
        // 이름 순회
        for(int index=0; index<id_list.length; index++)
            map.put(id_list[index],index);
        
        // 신고 확인
        for(int index=0; index<report.length; index++) {
            st = new StringTokenizer(report[index]);
            String from = st.nextToken();
            String to = st.nextToken();
            
            // 신고 대상 사람이 명단에 있는 경우
            if(map.containsKey(to)) {
                set[map.get(to)].add(from);
            }
        }
        
        // 메일 확인
        Arrays.stream(set).filter(group -> group.size()>=k)
            .forEach(group -> group.forEach(member -> answer[map.get(member)]++));
        
        // 결과
        return answer;
    }
}