import java.util.*;

class Solution {
    public int[] solution(String[] name, int[] yearning, String[][] photo) {
        
        // 결과 
        int[] answer = new int[photo.length];
        
        // 그리움 저장 해시
        HashMap<String,Integer> missScore = new HashMap<>();

        // 그리움 정보 저장
        for(int n=0; n<name.length; n++) {
            missScore.put(name[n],yearning[n]);
        }
        
        // 사진 둘러보기
        for(int p=0; p<photo.length; p++) {
        
            // 그리움 점수 매기기
            for(String curName: photo[p]) {
                if(missScore.containsKey(curName))
                    answer[p] += missScore.get(curName);
            }
        }
        
        return answer;
    }
}