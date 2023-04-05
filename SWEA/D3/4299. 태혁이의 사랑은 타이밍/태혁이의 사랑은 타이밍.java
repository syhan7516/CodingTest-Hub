import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        // 기준 시간 계산
        int promiseTime = (11*24*60) + (11*60) + 11;

        // 테스트 케이스 수 입력
        int caseNum = Integer.parseInt(br.readLine());

        // 케이스 수만큼 수행
        for(int caseIdx=0; caseIdx<caseNum; caseIdx++) {

            sb.append("#"+(caseIdx+1)+" ");

            // 시간 입력
            int nowTime = 0;
            st = new StringTokenizer(br.readLine());
            int day = Integer.parseInt(st.nextToken());
            int hour = Integer.parseInt(st.nextToken());
            int min = Integer.parseInt(st.nextToken());

            // 시간 계산
            nowTime = (day*24*60) + (hour*60) + min;

            // 결과 저장
            if(promiseTime>nowTime)
                sb.append(-1+"\n");
            else
                sb.append((nowTime-promiseTime)+"\n");
        }

        // 결과 저장
        System.out.println(sb.toString());
    }
}