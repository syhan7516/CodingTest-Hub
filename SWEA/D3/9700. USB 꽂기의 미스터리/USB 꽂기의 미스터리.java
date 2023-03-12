import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        // 테스트 케이스 수 입력
        int caseNum = Integer.parseInt(br.readLine());
        // 케이스 수만큼 수행
        for(int caseIdx=0; caseIdx<caseNum; caseIdx++) {
            // 확률 입력
            st = new StringTokenizer(br.readLine());
            double fir = Double.parseDouble(st.nextToken());
            double sec = Double.parseDouble(st.nextToken());
            //  확률 계산
            double s1 = (1-fir) * sec;
            double s2 = fir * (1-sec) * sec;

            // 결과 출력
            System.out.print("#"+(caseIdx+1)+" ");
            if(s1 < s2)
                System.out.println("YES");
            else
                System.out.println("NO");
        }
    }
}