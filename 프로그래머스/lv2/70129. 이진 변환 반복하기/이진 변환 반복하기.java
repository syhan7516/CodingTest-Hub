class Solution {
    public int[] solution(String s) {

        // 결과
        int[] answer = new int[2];

        // 문자열 길이가 1일 떄까지 반복
        while(s.length()>1) {

            // 1개수 변수
            int oneCnt = 0;

            // 문자열 확인
            for(int l=0; l<s.length(); l++) {

                // 0인 경우
                if(s.charAt(l)=='0') 
                    // 0제거 개수 증가
                    answer[1]++;

                // 아닌 경우
                else oneCnt++;
            }

            // 개수 이진수로 변환
            s = Integer.toBinaryString(oneCnt);
            
            // 변환 횟수 증가
            answer[0]++;
        }

        return answer;
    }
}