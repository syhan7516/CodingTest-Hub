import java.io.BufferedReader;
import java.io.InputStreamReader;
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

            // A, B, C, D 입력
            st = new StringTokenizer(br.readLine());
            double A = Integer.parseInt(st.nextToken());
            double B = Integer.parseInt(st.nextToken());
            double C = Integer.parseInt(st.nextToken());
            double D = Integer.parseInt(st.nextToken());

            // 승률 계산
            double alice = A/B * 100;
            double bob = C/D * 100;

            // 승자 확인
            sb.append("#"+(caseIdx+1)+" ");
            if(alice > bob)
                sb.append("ALICE"+"\n");
            else if(bob > alice)
                sb.append("BOB"+"\n");
            else
                sb.append("DRAW"+"\n");
        }

        // 결과 출력
        System.out.println(sb.toString());
    }
}