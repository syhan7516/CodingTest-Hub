import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        // 테스트 케이스 수 입력
        int caseNum = Integer.parseInt(st.nextToken());
        // 케이스 수만큼 수행
        for(int caseIdx=0; caseIdx<caseNum; caseIdx++) {
            // 결과
            int result = 0;
            // 소득 합, 소득 평균
            int moneySum = 0;
            double moneyAvg;

            // 사람 수 입력
            int humanCnt = Integer.parseInt(br.readLine());
            int humanMoney[] = new int[humanCnt];

            // 사람의 소득 입력
            st = new StringTokenizer(br.readLine());
            for(int idx=0; idx<humanCnt; idx++) {
                humanMoney[idx] = Integer.parseInt(st.nextToken());
                moneySum += humanMoney[idx];
            }

            // 소득 평균
            moneyAvg = (double)moneySum/humanCnt;

            // 저소득층 확인
            for(int idx=0; idx<humanMoney.length; idx++) {
                if(humanMoney[idx]<=moneyAvg)
                    result += 1;
            }

            // 결과 출력
            System.out.println("#"+(caseIdx+1)+" "+result);
        }

    }
}