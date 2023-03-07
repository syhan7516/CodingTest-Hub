import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 테스트 케이스 수 입력
        int caseNum = Integer.parseInt(br.readLine());
        // 케이스 수만큼 수행
        for(int caseIdx=0; caseIdx<caseNum; caseIdx++) {
            // N 입력
            int N = Integer.parseInt(br.readLine());
            // 넓이 구하기
            int result = N * N;
            // 결과 출력
            System.out.println("#"+(caseIdx+1)+" "+result);
        }
    }
}