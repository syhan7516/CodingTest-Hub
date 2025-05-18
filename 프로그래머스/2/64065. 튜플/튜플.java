import java.util.*;

class Solution {
    
    // 요소 최대 개수
    public static final int MAX_ELEMENT_COUNT = 100000;

    // 결과 배열
    public static int[] answer;

    // 요소 리스트
    public static ArrayList<Integer> elements;

    // 튜플 리스트
    public static ArrayList<String> tupleList;

    // 요소 방문 여부 배열
    public static boolean[] visited;
    
    // 결과 저장 메서드
    public static void saveResult() {
        
        // 결과 배열 생성
        answer = new int[elements.size()];
        
        // 결과 저장
        for(int index=0; index<elements.size(); index++) {
            answer[index] = elements.get(index);
        }
    }
    
    // 문자열 재구성 메서드
    public static void reconstructString(String letters) {
        
        // 문자열 양쪽 제거
        letters = letters.substring(1,letters.length()-1);

        // 문자열 튜플로 분리
        StringTokenizer st = new StringTokenizer(letters,"{}");
        while(st.hasMoreTokens()) {

            // 확인 대상 튜플
            String tuple = st.nextToken();

            // , 넘기기
            if(",".equals(tuple)) continue;

            // 튜플인 경우
            else tupleList.add(tuple);
        }
    }
    
    // 튜플 요소 추출하기 메서드
    public static void extractTupleAndElement() {
        
        // 각 튜플 확인
        for(int tupleIndex=0; tupleIndex<tupleList.size(); tupleIndex++) {

            // 확인 튜플 각 요소로 분리
            String[] letters = tupleList.get(tupleIndex).split(",");

            // 분리된 요소 확인
            for(int letterIndex=0; letterIndex<letters.length; letterIndex++) {
                int num = Integer.parseInt(letters[letterIndex]);
                if(!visited[num]) {
                    visited[num] = true;
                    elements.add(num);
                }
            }
        }
    }
    
    public int[] solution(String s) {    
        
        // 요소 리스트 생성
        elements = new ArrayList<>();

        // 튜플 리스트 생성
        tupleList = new ArrayList<>();

        // 요소 방문 여부 배열 생성
        visited = new boolean[MAX_ELEMENT_COUNT+1];

        // 문자열 재구성
        reconstructString(s);

        // 튜플 길이 기준으로 정렬
        tupleList.sort((a, b) -> a.length() - b.length());

        // 튜플 요소 추출하기
        extractTupleAndElement();

        // 결과 저장
        saveResult();
        
        return answer;
    }
}