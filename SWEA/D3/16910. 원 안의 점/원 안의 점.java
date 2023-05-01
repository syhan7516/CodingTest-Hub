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

            // N 입력
            int N = Integer.parseInt(br.readLine());
            N = N*N;

            // 결과
            int result = 0;

            // 격자점 찾기
            for(int a=-200; a<=200; a++) {
                for(int b=-200; b<=200; b++) {

                    // 식 대입
                    int A = a*a;
                    int B = b*b;
                    if((A+B)<=N) result++;
                }
            }

            // 결과 저장
            sb.append("#"+(caseIdx+1)+" "+result+"\n");
        }

        // 결과 출력
        System.out.println(sb.toString());
    }
}