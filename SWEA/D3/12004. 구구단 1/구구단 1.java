import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        // 테스트 케이스 수 입력
        int caseNum = Integer.parseInt(st.nextToken());
        // 케이스 수만큼 반복
        for(int caseIdx=0; caseIdx<caseNum; caseIdx++) {
            // 결과
            String result = "No";

            // 숫자 입력
            st = new StringTokenizer(br.readLine());
            int number = Integer.parseInt(st.nextToken());

            // 가능 여부 판단
            for(int a=1; a<=9; a++) {
                for(int b=1; b<=9; b++) {
                    if(number == a*b)
                        result = "Yes";
                }
            }

            // 결과 출력
            System.out.println("#"+(caseIdx+1)+" "+result);
        }
    }
}