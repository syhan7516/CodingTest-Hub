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

            // 목표 운동량 및 현재 운동량 입력
            st = new StringTokenizer(br.readLine());
            int minEx = Integer.parseInt(st.nextToken());
            int maxEx = Integer.parseInt(st.nextToken());
            int curEx = Integer.parseInt(st.nextToken());

            sb.append("#"+(caseIdx+1)+" ");

            // 운동량 초과한 경우
            if(curEx>maxEx)
                sb.append(-1);
            // 운동량 목표에 맞춘 경우
            else if(minEx<=curEx && curEx<=maxEx)
                sb.append(0);
            // 운동량 부족한 경우
            else
                sb.append(minEx-curEx);

            sb.append("\n");
        }

        // 결과 출력
        System.out.println(sb.toString());
    }
}