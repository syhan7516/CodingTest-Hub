import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        // 테스트 케이스 수 입력
        int caseNum = Integer.parseInt(br.readLine());
        // 케이스 수만큼 수행
        for(int caseIdx=0; caseIdx<caseNum; caseIdx++) {
            // 숫자 입력
            long N = Long.parseLong(br.readLine());
            // 세제곱근 찾기
            long number = (long)Math.floor(Math.cbrt(N));
            
            // 세제곱근 확인
            long result = -1;
            if(number*number*number == N)
                result = number;

            // 결과 확인
            System.out.println("#"+(caseIdx+1)+" "+result);
        }
    }
}