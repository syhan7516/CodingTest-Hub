import java.util.*;

class Solution {
    
    // 분리된 원소 저장 리스트
    public static ArrayList<String> A, B;

    // 특수 문자, 숫자, 공백 등 포함 여부 메서드
    public static boolean hasSpecialCharacters(String letter) {
        if(letter.charAt(0)<'A' || letter.charAt(0)>'Z') return true;
        if(letter.charAt(1)<'A' || letter.charAt(1)>'Z') return true;
        return false;
    }

    // 문자열 분리 메서드
    public static ArrayList<String> separateStringToList(String word) {
        
        ArrayList<String> elements = new ArrayList<>();

        // 두 문자씩 잘라서 확인
        for(int wordIndex=0; wordIndex<word.length()-1; wordIndex++) {
            
            String letter = word.substring(wordIndex,wordIndex+2).toUpperCase();
            
            // 특수 문자, 숫자, 공백 등 포함된 경우
            if(hasSpecialCharacters(letter)) continue;
            
            // 요소 추가
            elements.add(letter);
        }

        return elements;
    }

    // 차집합 개수 구하기 메서드
    public static int getDifferenceCount() {

        ArrayList<String> C = new ArrayList<>(A);

        // B 집합 요소 삭제
        for(String element: B) {
            C.remove(element);
        }

        return C.size();
    }

    // 교집합 개수 구하기 메서드
    public static int getInterSectionCount(int differenceCount) {
        return A.size() - differenceCount;
    }

    // 합집합 개수 구하기 메서드
    public static int getUnionCount(int differenceCount) {
        return B.size() + differenceCount;
    }

    // 유사도 구하기 메서드
    public static int getSimilarity(int interSectionCount, int unionCount) {

        // 둘 다 공집합인 경우
        if(A.isEmpty() && B.isEmpty()) {
            return 65536;
        }

        // 아닌 경우
        else {

            double answer = (double)interSectionCount/unionCount;

            return (int)Math.floor(answer*65536);
        }
    }
    
    public int solution(String str1, String str2) {
        
        A = new ArrayList<>(separateStringToList(str1.toUpperCase()));
        B = new ArrayList<>(separateStringToList(str2.toUpperCase()));

        // 차집합 개수 구하기
        int differenceCount = getDifferenceCount();

        // 교집합 개수 구하기
        int intersectionCount = getInterSectionCount(differenceCount);

        // 합집합 개수 구하기
        int unionCount = getUnionCount(differenceCount);

        // 결과 출력
        return getSimilarity(intersectionCount,unionCount);
    }
}