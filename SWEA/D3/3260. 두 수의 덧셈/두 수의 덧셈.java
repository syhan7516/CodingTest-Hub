import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.StringTokenizer;

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        // 테스트 케이스 수 입력
        int caseNum = Integer.parseInt(br.readLine());

        // 케이스 수만큼 수행
        for(int caseIdx=0; caseIdx<caseNum; caseIdx++) {

            // 두 양수 입력
            st = new StringTokenizer(br.readLine());
            BigInteger firNum = new BigInteger(st.nextToken());
            BigInteger secNum = new BigInteger(st.nextToken());

            // 두 수 더하기
            sb.append("#"+(caseIdx+1)+" "+firNum.add(secNum)+"\n");
        }

        // 결과 출력
        System.out.println(sb.toString());
    }
}