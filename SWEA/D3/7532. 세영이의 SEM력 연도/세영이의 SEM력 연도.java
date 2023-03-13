import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        // 테스트 케이스 수 입력
        int caseNum = Integer.parseInt(br.readLine());
        // 테스트 케이스 수만큼 수행
        for(int caseIdx=0; caseIdx<caseNum; caseIdx++) {

            // S, E, M 입력
            st = new StringTokenizer(br.readLine());
            int sun = Integer.parseInt(st.nextToken());
            int earth = Integer.parseInt(st.nextToken());
            int moon = Integer.parseInt(st.nextToken());

            // S, E, M 확인
            int s=0, e=0, m=0, cnt=0;
            while(true) {

                // 연도를 만족할 경우
                if(sun==s && earth==e && moon==m)
                    break;

                // 아닌 경우
                cnt += 1;
                s += 1;
                e += 1;
                m += 1;

                // 돌아오는 경우
                if(s>365)
                    s = 1;
                if(e>24)
                    e = 1;
                if(m>29)
                    m = 1;
            }

            // 결과 출력
            System.out.println("#"+(caseIdx+1)+" "+cnt);
        }
    }
}
