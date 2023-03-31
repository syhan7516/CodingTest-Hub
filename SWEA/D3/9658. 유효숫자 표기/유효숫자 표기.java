import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        // 테스트 케이스 수 입력
        int caseNum = Integer.parseInt(br.readLine());

        // 케이스 수만큼 반복
        for(int caseIdx=0; caseIdx<caseNum; caseIdx++) {

            // 숫자 입력
            char numChar[] = br.readLine().toCharArray();

            // 숫자만들기
            int number = Integer.parseInt(numChar[0] + "" + numChar[1]);

            // 반올림 자리 숫자 확인
            if(numChar[2]-'0'>=5)
                number += 1;

            // 최종 숫자 자리 확인 및 변환
            String numLetter = number+"";

            // 기본 길이
            int numLen = 0;
            numLen = numChar.length-1;
            
            // 기본 길이를 넘어섰을 경우
            if(numLetter.length()>=3)
                numLen = numChar.length;

            // 결과 저장
            sb.append("#"+(caseIdx+1)+" "+numLetter.charAt(0)+"."+numLetter.charAt(1)+"*10^"+numLen+"\n");
        }

        // 결과 출력
        System.out.println(sb.toString());
    }
}