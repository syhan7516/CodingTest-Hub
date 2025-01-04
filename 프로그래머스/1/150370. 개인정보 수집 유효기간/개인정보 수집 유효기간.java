import java.util.*;

class Solution {
    
    // 파기 대상 리스트
    public static ArrayList<Integer> targets;
    
    // 유효 기간 정보 해시
    public static HashMap<Character,Integer> map;
    
    // 유효 기간 초기화 메서드
    public static void termInit(String[] terms) {
        
        // 유효 기간 정보 해시 생성
        map = new HashMap<>();
        
        // 유효 기간 정보 확인
        StringTokenizer st;
        for(int term=0; term<terms.length; term++) {
            st = new StringTokenizer(terms[term]);
            char name = st.nextToken().charAt(0);
            int duration = Integer.parseInt(st.nextToken());
            map.put(name,duration);
        }
    }
    
    // 파기 여부 확인 메서드
    public static boolean isRemove(String today, String information) {
        
        // 정보 분리
        String date[] = information.substring(0,10).split("\\.");
        int term = map.get(information.charAt(11));
        
        // 기간 비교
        int years = term/12 + Integer.parseInt(date[0]);
        int months = term%12 + Integer.parseInt(date[1]);
        int days = Integer.parseInt(date[2]);
        
        // 기간 범위 확인
        if(months>12) {
            months -= 12;
            years++;
        }
        
        // 오늘 날짜 분리
        int todayToInt[] = Arrays.stream(today.split("\\.")).mapToInt(Integer::parseInt).toArray();
        
        // 년
        if(years>todayToInt[0]) return false;
        
        else if(years<todayToInt[0]) return true;
        
        // 월 (년이 동일)
        else if(months>todayToInt[1]) return false;
        
        else if(months<todayToInt[1]) return true;
        
        // 일 (년, 월 동일)
        else if(days>todayToInt[2]) return false;
        
        else if(days<todayToInt[2]) return true;
        
        else return true;
    }
    
    // 개인 정보 검증 메서드
    public static void validatePrivacies(String today, String[] privacies) {
        
        // 파기 대상 리스트 생성
        targets = new ArrayList<>();
        
        // 개인 정보 확인
        for(int privacie=0; privacie<privacies.length; privacie++) {
            
            // 파기 여부
            if(isRemove(today,privacies[privacie]))
                targets.add(privacie+1);
        }
    }
    
    public int[] solution(String today, String[] terms, String[] privacies) {
        
        // 유효 기간 초기화
        termInit(terms);
        
        // 개인 정보 검증
        validatePrivacies(today,privacies);
        
        return targets.stream().mapToInt(Integer::intValue).toArray();
    }
}