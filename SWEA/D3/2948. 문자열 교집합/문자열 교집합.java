import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        // 테스트 케이스 수 입력
        int caseNum = Integer.parseInt(br.readLine());

        // 케이스 수만큼 수행
        for(int caseIdx=0; caseIdx<caseNum; caseIdx++) {

            // 각 집합의 문자 개수
            st = new StringTokenizer(br.readLine());
            int firSetCnt = Integer.parseInt(st.nextToken());
            int secSetCnt = Integer.parseInt(st.nextToken());

            // 각 집합 정보 입력
            st = new StringTokenizer(br.readLine());
            String firSet[] = new String[firSetCnt];
            for(int fir=0; fir<firSetCnt; fir++)
                firSet[fir] = st.nextToken();

            st = new StringTokenizer(br.readLine());
            String secSet[] = new String[secSetCnt];
            for(int sec=0; sec<secSetCnt; sec++)
                secSet[sec] = st.nextToken();

            // 각 집합 정렬
            Arrays.sort(firSet);
            Arrays.sort(secSet);

            // 비교
            int result = 0;
            int firPoint = 0;
            int secPoint = 0;

            while(true) {

                // 종료 조건
                if(firPoint>=firSet.length || secPoint>=secSet.length)
                    break;

                // 첫 번째 집합의 문자열이 더 큰 경우
                if(firSet[firPoint].compareTo(secSet[secPoint])>0)
                    secPoint++;

                // 두 번째 집합의 문자열 더 큰 경우
                else if(firSet[firPoint].compareTo(secSet[secPoint])<0)
                    firPoint++;

                // 두 집합의 문자열이 같은 경우
                else {
                    result++;
                    firPoint++;
                    secPoint++;
                }
            }

            // 결과 저장
            sb.append("#"+(caseIdx+1)+" "+result+"\n");
        }

        // 결과 출력
        System.out.println(sb.toString());
    }
}