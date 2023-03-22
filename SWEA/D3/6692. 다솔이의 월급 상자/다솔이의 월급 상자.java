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

            // 확률 수 입력
            int caseCnt = Integer.parseInt(br.readLine());

            // 확률 정보 입력
            double totalMoney = 0;
            for(int c=0; c<caseCnt; c++) {
                st = new StringTokenizer(br.readLine());
                // 확률과 월급 입력
                double percent = Double.parseDouble(st.nextToken());
                int money = Integer.parseInt(st.nextToken());
                totalMoney += (percent*10) * money;
            }

            // 평균 월급
            double monthMoney = totalMoney/10;

            // 결과 출력
            System.out.println("#"+(caseIdx+1)+" "+monthMoney);
        }
    }
}