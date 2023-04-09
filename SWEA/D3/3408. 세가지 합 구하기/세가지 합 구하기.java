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

            // 자연수 입력
            long number = Long.parseLong(br.readLine());

            // S1, S2, S3 구하기
            long s1 = (1+number)*number/2;
            long s2 = s1*2-number;
            long s3 = s1*2;

            // 결과 저장
            sb.append("#"+(caseIdx+1)+" "+s1+" "+s2+" "+s3+"\n");
        }

        // 결과 출력
        System.out.println(sb.toString());
    }
}