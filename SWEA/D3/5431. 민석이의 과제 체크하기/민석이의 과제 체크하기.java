import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {

    // 과제 제출 여부 배열
    public static boolean reportCheck[];

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        // 테스트 케이스 수 입력
        int caseNum = Integer.parseInt(br.readLine());
        // 케이스 수만큼 수행
        for(int caseIdx=0; caseIdx<caseNum; caseIdx++) {

            // 수강생 수, 제출 인원 수 입력
            st = new StringTokenizer(br.readLine());
            int studentCnt = Integer.parseInt(st.nextToken());
            int submitCnt = Integer.parseInt(st.nextToken());
            reportCheck = new boolean[studentCnt+1];

            // 제출 인원 입력
            st = new StringTokenizer(br.readLine());
            for(int idx=0; idx<submitCnt; idx++) {
                int student = Integer.parseInt(st.nextToken());
                reportCheck[student] = true;
            }

            // 제출 확인
            sb.append("#"+(caseIdx+1)+" ");
            for(int idx=1; idx<=studentCnt; idx++) {
                if(!reportCheck[idx])
                    sb.append(idx+" ");
            }
            sb.append("\n");
        }

        // 결과 출력
        System.out.println(sb.toString());
    }
}