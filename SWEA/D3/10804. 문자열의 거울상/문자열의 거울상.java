import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 테스트 케이스 수 입력
        int caseNum = Integer.parseInt(br.readLine());
        // 케이스 수만큼 수행
        for(int caseIdx=0; caseIdx<caseNum; caseIdx++) {

            // 결과
            String result = "";

            // 문자열 입력
            String letters = br.readLine();

            // 문자열 변환
            for(int idx=letters.length()-1; idx>=0; idx--) {
                char alpha = letters.charAt(idx);
                if(alpha=='b')
                    result += 'd';
                else if(alpha=='d')
                    result += 'b';
                else if(alpha=='p')
                    result += 'q';
                else
                    result += 'p';
            }

            // 결과 출력
            System.out.println("#"+(caseIdx+1)+" "+result);
        }
    }
}